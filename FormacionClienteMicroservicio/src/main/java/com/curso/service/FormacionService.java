package com.curso.service;

import java.util.List;

/**
 * Interfaz donde declaramos los metodos que vamos a usar
 * 
 * @author sinensia Juan Luis España
 *
 */
import com.curso.model.Formacion;

public interface FormacionService {

	
	List<Formacion> formacionExistentes();
	public List<Formacion> nuevoCurso(Formacion f);


}
