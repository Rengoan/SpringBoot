package com.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	private int codigoProducto;
	private String producto;
	private double precioUnitario;
	private int stock;

	/**
	 * @param codigoProducto
	 * @param producto
	 * @param precioUnitario
	 * @param stock
	 */
	public Producto(int codigoProducto, String producto, double precioUnitario, int stock) {
		super();
		this.codigoProducto = codigoProducto;
		this.producto = producto;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
	}

	/**
	 * 
	 */
	public Producto() {
		super();
	}

	/**
	 * @return the codigoProducto
	 */
	public int getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * @param codigoProducto the codigoProducto to set
	 */
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * @return the precioUnitario
	 */
	public double getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

}
