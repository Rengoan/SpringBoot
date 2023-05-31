package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Producto;

public interface ProductosDao extends JpaRepository<Producto, Integer> {
	
	@Query("SELECT c FROM Producto c WHERE c.producto = :producto")
	Producto findByName(String producto);
	
	

}
