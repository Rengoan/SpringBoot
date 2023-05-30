package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursoService {

	List<Curso> cursos();

	Curso buscarCurso(int codigo);
	
	List<Curso> buscarCursoNombre(String nombre);

	void altaCurso(Curso curso);

	void actualizarCurso(int c , int h);

	List<Curso> eliminarCurso(int codigo);
	
	List<Curso> cursoMinMax(double min, double max);
}
