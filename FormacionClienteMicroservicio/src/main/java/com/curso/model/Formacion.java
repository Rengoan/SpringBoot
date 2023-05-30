package com.curso.model;

public class Formacion {

	private String curso;
	private int asignaturas;
	private double precio;

	/**
	 * @param nombre
	 * @param asignaturas
	 * @param precio
	 */
	public Formacion(String curso, int asignaturas, double precio) {
		super();
		this.curso = curso;
		this.asignaturas = asignaturas;
		this.precio = precio;
	}

	/**
	 * 
	 */
	public Formacion() {
		super();
		
	}

	/**
	 * @return the nombre
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * @param curso the nombre to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * @return the asignaturas
	 */
	public int getAsignaturas() {
		return asignaturas;
	}

	/**
	 * @param asignaturas the asignaturas to set
	 */
	public void setAsignaturas(int asignaturas) {
		this.asignaturas = asignaturas;
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
