package co.edu.ucentral.Proyecto.service;

import java.util.List;

import co.edu.ucentral.Proyecto.model.Producto;

public interface ProductoService {

	public List<Producto> listar();
	public void guardarProducto(Producto producto);
	public Producto buscarProductoPorId(Long id);
	public void eliminarProducto(Long id);
}
