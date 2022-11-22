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
import co.edu.ucentral.Proyecto.service.ProductoService;

@Controller
@RequestMapping(value="/productos")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@GetMapping("/index")
	public String listar(Model model) {
		List<Producto> lista = service.listar();
		model.addAttribute("productos", lista);
		return "productos/index";
	}
	
	@GetMapping("/crear")
	public String crearEquipoComputo(Producto producto) {
		return "productos/formProducto";
	}
	
	@PostMapping("/guardar")
	public String guardarProducto(Producto producto) {
		service.guardarProducto(producto);
		return "redirect:/productos/index";
	}
	
	@GetMapping("/buscar/{id}")
	public String buscarEquipoComputo(@PathVariable Long id, Model model ) {
		Producto producto= service.buscarProductoPorId(id);
		model.addAttribute("producto", producto);
		return "productos/formProducto";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarEquipoComputo(@PathVariable Long id){
		service.eliminarProducto(id);
		return "redirect:/productos/index";
	}
}
