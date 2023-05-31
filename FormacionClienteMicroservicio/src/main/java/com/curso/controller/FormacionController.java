package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;
/**
 * Clase controladora
 * 
 * @author sinensia Juan Luis España
 *
 */
@RestController
public class FormacionController {

	@Autowired
	FormacionService service;

	/**
	 * Endpoint para obtener la lista de formaciones existentes.
	 * 
	 * @return Lista de formaciones existentes en formato JSON.
	 */
	@GetMapping(value = "formacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> formaciones() {
		return service.formacionExistentes();
	}

	/**
	 * Endpoint para dar de alta un nuevo curso.
	 * 
	 * @param f Objeto de formación que representa el nuevo curso en formato JSON.
	 * @return Lista de formaciones existentes después de crear el nuevo curso en formato JSON.
	 */
	@PostMapping(value = "formacion", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> alta(@RequestBody Formacion f) {
		return service.nuevoCurso(f);
	}

}

