package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CochesDao;
import com.curso.model.Coche;

@Service
public class CocheServiceImpl implements CocheService {
	@Autowired
	CochesDao dao;
	
	
	@Override
	public List<Coche> coches() {

		return dao.findAll();
	}

	@Override
	public Optional<Coche> buscarCoche(String nbastidor) {

		return dao.findById(nbastidor);
	}

	@Override
	public void altaCoche(Coche coche) {

		dao.save(coche);

	}

	@Override
	public void actualizarCoche(Coche coche) {

		dao.save(coche);

	}

	@Override
	public List<Coche> eliminarCoche(String nbastido) {
		
		dao.deleteById(nbastido);
		return dao.findAll();
	}

}
