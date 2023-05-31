package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.CursoInfo;
import com.curso.model.Formacion;
/**
 * Implementacion de la interfaz
 * 
 * @author sinensia Juan Luis España
 *
 */
@Service
public class FormacionServiceImpl implements FormacionService {

	@Autowired
	RestTemplate template;
	private String url = "http://localhost:8080/";

	/**
	 * Devuelve todas las formaciones que existen en un ArrayList.
	 * 
	 * @return Lista de formaciones existentes.
	 */
	@Override
	public List<Formacion> formacionExistentes() {

		List<Formacion> formacionExistentes = new ArrayList<>();

		// Realiza una solicitud GET al servicio web para obtener la lista de cursos.
		ResponseEntity<CursoInfo[]> response = template.exchange(url + "curso", HttpMethod.GET, null,
				CursoInfo[].class);

		if (response.getStatusCode().is2xxSuccessful()) {
			CursoInfo[] cursos = response.getBody();

			if (cursos != null) {
				for (CursoInfo curso : cursos) {
					// Calcula el número de asignaturas en función de la duración del curso.
					int asignaturas = (curso.getDuracion() >= 50) ? 10 : 5;
					// Crea un objeto de formación con los datos del curso y lo agrega a la lista de formaciones existentes.
					Formacion formacion = new Formacion(curso.getNombre(), asignaturas, curso.getPrecio());
					formacionExistentes.add(formacion);
				}
			}
		}

		return formacionExistentes;
	}

	/**
	 * Crea un nuevo curso a partir de un objeto de formación y devuelve un ArrayList con las formaciones existentes.
	 * Si el curso ya existe, simplemente devuelve la lista actual de formaciones existentes.
	 * 
	 * @param f Objeto de formación que representa el nuevo curso.
	 * @return Lista de formaciones existentes después de crear el nuevo curso.
	 */
	@Override
	public List<Formacion> nuevoCurso(Formacion f) {
		// Verificar si el curso ya existe por su nombre
		boolean cursoExistente = formacionExistentes().stream()
				.anyMatch(form -> form.getCurso().equalsIgnoreCase(f.getCurso()));

		if (cursoExistente) {
			// Si el curso ya existe, devolver la lista de formaciones existentes
			return formacionExistentes();
		} else {
			// Crear un nuevo objeto CursoInfo con los datos de la formación y realizar una solicitud POST para crear el curso en el servicio web.
			CursoInfo curso = new CursoInfo(f.getCurso(), f.getAsignaturas() * 10, f.getPrecio());
			template.postForLocation(url + "curso/nuevo", curso);
		}

		return formacionExistentes();
	}

}
