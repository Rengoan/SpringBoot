package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursosDao;
import com.curso.model.Curso;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursosDao dao;

	@Override
	public List<Curso> cursos() {

		return dao.findAll();
	}

	@Override
	public Curso buscarCurso(int codigo) {

		return dao.findById(codigo).orElse(null);
	}

	@Override
	public void altaCurso(Curso curso) {

		dao.save(curso);

	}

	@Override
	public void actualizarCurso(int c, int h) {

		Curso curso = dao.findById(c).orElseThrow();
		curso.setDuracion(h);

		dao.save(curso);

	}

	@Override
	public List<Curso> eliminarCurso(int codigo) {

		dao.deleteById(codigo);
		return dao.findAll();
	}

	@Override
	public List<Curso> cursoMinMax(double min, double max) {

		return dao.findBy(min, max);
	}

}
