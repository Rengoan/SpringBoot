package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.CursoInfo;
import com.curso.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {

	@Autowired
	RestTemplate template;
	private String url = "http://localhost:8080/";

	@Override
	public List<Formacion> formacionExistentes() {

		List<Formacion> formacionExistentes = new ArrayList<>();
		ResponseEntity<CursoInfo[]> response = template.exchange(url + "curso", HttpMethod.GET, null,
				CursoInfo[].class);

		if (response.getStatusCode().is2xxSuccessful()) {
			CursoInfo[] cursos = response.getBody();

			if (cursos != null) {
				for (CursoInfo curso : cursos) {
					int asignaturas = (curso.getDuracion() >= 50) ? 10 : 5;
					Formacion formacion = new Formacion(curso.getNombre(), asignaturas, curso.getPrecio());
					formacionExistentes.add(formacion);
				}
			}
		}

		return formacionExistentes;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Formacion> nuevoCurso(Formacion f) {
//		// Verificar si el curso ya existe por su nombre
		boolean cursoExistente = formacionExistentes().stream()
				.anyMatch(form -> form.getCurso().equalsIgnoreCase(f.getCurso()));

		if (cursoExistente) {
			// Si el curso ya existe, devolver la lista de formaciones existentes
			return formacionExistentes();
		} else {
		

			CursoInfo curso = new CursoInfo(f.getCurso(),f.getAsignaturas()*10,f.getPrecio());
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<CursoInfo> requestEntity = new HttpEntity<>(curso, headers);

			ResponseEntity<Void> response = template.exchange(url + "curso/nuevo", HttpMethod.POST, requestEntity,
					Void.class);

			if (response.getStatusCode().is2xxSuccessful()) {
				// Si el curso se crea exitosamente, se actualiza la lista de formaciones
				// existentes
				return formacionExistentes();
			} else {
				throw new RuntimeException(
						"La solicitud no fue exitosa. Código de estado: " + response.getStatusCodeValue());
			}
		}
	}

	

}