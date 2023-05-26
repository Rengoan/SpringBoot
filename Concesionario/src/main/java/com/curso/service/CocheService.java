package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.Coche;



public interface CocheService {

	List<Coche> coches();
	Optional<Coche> buscarCoche(String nbastidor);
	void altaCoche(Coche coche);
	void actualizarCoche(Coche coche);
	List<Coche> eliminarCoche(String nbastidor);
}
