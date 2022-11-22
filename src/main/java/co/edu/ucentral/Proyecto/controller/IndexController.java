package co.edu.ucentral.Proyecto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.ucentral.Proyecto.model.Role;
import co.edu.ucentral.Proyecto.model.Usuario;
import co.edu.ucentral.Proyecto.service.RoleService;
import co.edu.ucentral.Proyecto.service.UsuarioService;

@Controller
public class IndexController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping({"/index"})
	public String index(Authentication authentication, HttpSession session, Model model) {
		String username = authentication.getName();
		if(session.getAttribute("usuario")==null) {
			Usuario usuario = usuarioService.buscarUsuarioPorUsername(username);
			usuario.setPassword(null);
			session.setAttribute("usuario", usuario);
		}
		return "index";
	}
	
	@GetMapping("/signup")
	public String registro(Usuario usuario) {
		return "formRegistro";
	}
	
	@PostMapping("/signup")
	public String guardarUsuario(Usuario usuario) {
		usuario.setEnabled(true);
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		Role role = roleService.buscarRolePorId(1L);
		usuario.agregarRole(role);
		usuarioService.guardarUsuario(usuario);
		return "index";
	}
}
