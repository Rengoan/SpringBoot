package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.ProductosDao;
import com.curso.model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService {

	@Autowired
	ProductosDao dao;

	@Override
	public List<Producto> productos() {

		return dao.findAll();
	}

	@Override
	public Producto buscarProducto(int codigo) {

		return dao.findById(codigo).orElse(null);
	}

	@Override
	public Producto buscarProductoNombre(String nombre) {

		return dao.findByName(nombre);
	}

	@Override
	public void altaProducto(Producto producto) {

		dao.save(producto);

	}

	@Override
	public void actualizarProducto(Producto producto, int codigoProducto, int stock) {
		dao.findById(codigoProducto).orElse(null);
		producto.setStock(stock);

		dao.save(producto);

	}

	@Override
	public List<Producto> eliminarProducto(int codigo) {

		dao.deleteById(codigo);
		return dao.findAll();

	}

}
