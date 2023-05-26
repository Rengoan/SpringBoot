package com.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coches")
public class Coche {

	@Id
	private String nbastidor;
	private String matricula;
	private String marca;
	private String modelo;
	private int km;
	private String color;
	private boolean disponibilidad;

	/**
	 * @param nBastido
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param km
	 * @param color
	 */
	public Coche(String nbastidor, String matricula, String marca, String modelo, int km, String color,
			boolean disponibilidad) {
		super();
		this.nbastidor = nbastidor;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.km = km;
		this.color = color;
		this.disponibilidad = disponibilidad;
	}

	/**
	 * 
	 */
	public Coche() {
		super();
	}

	/**
	 * @return the nBastido
	 */
	public String getnBastidor() {
		return nbastidor;
	}

	/**
	 * @param nBastido the nBastido to set
	 */
	public void setnBastidor(String nbastidor) {
		this.nbastidor = nbastidor;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @return the disponibilidad
	 */
	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	/**
	 * @param disponibilidad the disponibilidad to set
	 */
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the km
	 */
	public int getKm() {
		return km;
	}

	/**
	 * @param km the km to set
	 */
	public void setKm(int km) {
		this.km = km;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Coche [nBastido=" + nbastidor + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ ", km=" + km + ", color=" + color + ", disponibilidad=" + disponibilidad + "]";
	}

}
