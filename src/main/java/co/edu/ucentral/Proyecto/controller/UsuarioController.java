package co.edu.ucentral.Proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ucentral.Proyecto.model.Producto;
import co.edu.ucentral.Proyecto.model.Role;
import co.edu.ucentral.Proyecto.model.Usuario;
import co.edu.ucentral.Proyecto.service.ProductoService;
import co.edu.ucentral.Proyecto.service.RoleService;
import co.edu.ucentral.Proyecto.service.UsuarioService;

@Controller
@RequestMapping(value="/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	
	@Autowired
	private ProductoService equipoService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/index")
	public String listar(Model model) {
		List<Usuario> lista = service.listar();
		model.addAttribute("usuarios", lista);
		return "usuarios/index";
	}
	
	@GetMapping("/crear")
	public String crearUsuario(Usuario usuario, Model model) {
		List<Role> listar = roleService.listar();
		model.addAttribute("roles", listar);
		return "usuarios/formUsuario";
	}
	
	@PostMapping("/guardar")
	public String guardarUsuario(Usuario usuario) {
		service.guardarUsuario(usuario);
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/buscar/{id}")
	public String buscarUsuario(@PathVariable Long id, Model model ) {
		Usuario usuario= service.buscarUsuarioPorId(id);
		model.addAttribute("usuario", usuario);
		List<Producto> listae = equipoService.listar();
		model.addAttribute("equipoComputos", listae);
		return "usuarios/formUsuario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable Long id){
		service.eliminarUsuario(id);
		return "redirect:/usuarios/index";
	}

}
