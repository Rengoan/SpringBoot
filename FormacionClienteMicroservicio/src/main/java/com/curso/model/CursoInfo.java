package com.curso.model;

/**
 * Clase auxiliar para almacenar los datos de curso
 * 
 * @author sinensia Juan Luis España
 *
 */
public class CursoInfo {
	
	private int codcurso;
	private String nombre;
	private int duracion;
	private double precio;

	
	
	/**
	 * @param codcurso
	 * @param nombre
	 * @param duracion
	 * @param precio
	 */
	public CursoInfo(int codcurso, String nombre, int duracion, double precio) {
		super();
		this.codcurso = codcurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	
	/**
	 * @param nombre
	 * @param duracion
	 * @param precio
	 */
	public CursoInfo(String nombre, int duracion, double precio) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	/**
	 * @return the codcurso
	 */
	public int getCodcurso() {
		return codcurso;
	}

	/**
	 * @param codcurso the codcurso to set
	 */
	public void setCodcurso(int codcurso) {
		this.codcurso = codcurso;
	}

	/**
	 * 
	 */
	public CursoInfo() {
		super();
	}

//	public static CursoInfo obtenerInformacionCurso(String url) {
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<CursoInfo> response = restTemplate.exchange(url, HttpMethod.GET, null, CursoInfo.class);
//
//		if (response.getStatusCode().is2xxSuccessful()) {
//			return response.getBody();
//		} else {
//			throw new RuntimeException(
//					"La solicitud no fue exitosa. Código de estado: " + response.getStatusCodeValue());
//		}
//	}
	// getters y setters

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}