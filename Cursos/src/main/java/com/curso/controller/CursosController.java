package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursoService;

@RestController
public class CursosController {
	@Autowired
	CursoService service;

	// http://localhost:8080/curso/codcurso
	@GetMapping(value = "curso/{codcurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable int codcurso) { // Le pasas la variable con PathVariable

		return service.buscarCurso(codcurso);
	}

	// http://localhost:8080/curso
	@GetMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos() {

		return service.cursos();
	}

	// http://localhost:8080/curso
	@PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaCurso(@RequestBody Curso curso) {

		service.altaCurso(curso);

	}

	// http://localhost:8080/coche/c/h
	@PutMapping(value = "curso/{c}/{h}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarCurso(@PathVariable int c, @PathVariable int h) {

		service.actualizarCurso(c, h);

	}

	// http://localhost:8080/curso/codcurso
	@DeleteMapping(value = "curso/{codcurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCurso(@PathVariable int codcurso) {

		return service.eliminarCurso(codcurso);
	}

	// http://localhost:8080/curso/min/max
	@GetMapping(value = "curso/{min}/{max}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarMinMax(@PathVariable("min") double min, @PathVariable("max") double max) {

		return service.cursoMinMax(min, max);
	}

}
