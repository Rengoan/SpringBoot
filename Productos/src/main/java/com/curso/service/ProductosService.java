package com.curso.service;

import java.util.List;

import com.curso.model.Producto;

public interface ProductosService {

	List<Producto> productos();

	Producto buscarProducto(int codigo);
	
	public double obtenerPrecioProducto(int codigo);

	Producto buscarProductoNombre(String nombre);

	void altaProducto(Producto producto);

	public List<Producto> actualizarProducto(int codigoProducto, int stock);

	List<Producto> eliminarProducto(int codigo);

}
