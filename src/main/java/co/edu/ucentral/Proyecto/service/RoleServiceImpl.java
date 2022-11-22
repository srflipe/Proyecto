package co.edu.ucentral.Proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.Proyecto.model.Role;
import co.edu.ucentral.Proyecto.repository.RoleReposotory;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleReposotory repository;
	
	@Override
	public List<Role> listar() {
		return repository.findAll();
	}

	@Override
	public void guardarRole(Role role) {
		repository.save(role);
	}

	@Override
	public Role buscarRolePorId(Long id) {
		Optional<Role> optional = repository.findById(id);
		if(optional.isPresent())
			return optional.get();

		return null;
	}

	@Override
	public void eliminarRole(Long id) {
		repository.deleteById(id);
	}

}
