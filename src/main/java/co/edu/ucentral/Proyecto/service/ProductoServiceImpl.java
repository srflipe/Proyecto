package co.edu.ucentral.Proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.Proyecto.model.Producto;
import co.edu.ucentral.Proyecto.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public List<Producto> listar() {
		return repository.findAll();
	}

	@Override
	public void guardarProducto(Producto equipoComputo) {
		repository.save(equipoComputo);

	}

	@Override
	public Producto buscarProductoPorId(Long id) {
		Optional<Producto> optional = repository.findById(id);
		if(optional.isPresent())
			return optional.get();
		return null;
	}

	@Override
	public void eliminarProducto(Long id) {
		repository.deleteById(id);

	}

}
