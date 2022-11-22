package co.edu.ucentral.Proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.Proyecto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
}
