package com.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Coche;
import com.curso.service.CocheService;

@RestController
public class CochesController {

	@Autowired
	CocheService service;

	// http://localhost:8080/coche/nbastidor
	@GetMapping(value = "coche/{nbastidor}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Coche> buscarCoche(@PathVariable String nbastidor) { // Le pasas la variable con PathVariable

		return service.buscarCoche(nbastidor);
	}

	// http://localhost:8080/coche
	@GetMapping(value = "coche", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Coche> coches() {

		return service.coches();
	}

	// http://localhost:8080/coche
	@PostMapping(value = "coche", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaCoche(@RequestBody Coche coche) {

		service.altaCoche(coche);

	}

	// http://localhost:8080/coche
	@PutMapping(value = "coche", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarCoche(@RequestBody Coche coche) {

		service.actualizarCoche(coche);

	}

	// http://localhost:8080/coche/nbastidor
	@DeleteMapping(value = "coche/{nbastidor}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Coche> eliminarCoche(@PathVariable String nbastidor) {

		return service.eliminarCoche(nbastidor);
	}
}
