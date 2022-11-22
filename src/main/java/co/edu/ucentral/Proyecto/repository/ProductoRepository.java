package co.edu.ucentral.Proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.Proyecto.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
