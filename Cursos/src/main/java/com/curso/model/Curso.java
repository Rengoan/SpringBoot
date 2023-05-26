package com.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

	@Id
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
	public Curso(int codcurso, String nombre, int duracion, double precio) {
		super();
		this.codcurso = codcurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	/**
	 * 
	 */
	public Curso() {
		super();
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

	@Override
	public String toString() {
		return "Curso [codcurso=" + codcurso + ", nombre=" + nombre + ", duracion=" + duracion + ", precio=" + precio
				+ "]";
	}

}
