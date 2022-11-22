package co.edu.ucentral.Proyecto.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password,enabled from usuarios where username=?")
		.authoritiesByUsernameQuery("select u.username, r.nombre from usuario_roles ur "+
		        "inner join usuarios u on  u.id = ur.usuario_id " +
				"inner join roles r on r.id = ur.role_id "+
				"where u.username = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/images/**").permitAll()
		.antMatchers("/solicitudes/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
		.antMatchers("/departamentos/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/equipos/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/usuarios/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/","/buscar","/signup","/locale").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().permitAll();
	}
}
