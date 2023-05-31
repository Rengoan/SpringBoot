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
	public List<Producto> actualizarProducto(int codigoProducto, int stock) {
		Producto p = new Producto();
		p = dao.findById(codigoProducto).orElse(null);
		p.setStock(stock);
		dao.save(p);

		return dao.findAll();

	}

	@Override
	public List<Producto> eliminarProducto(int codigo) {

		dao.deleteById(codigo);
		return dao.findAll();

	}

	@Override
	public double obtenerPrecioProducto(int codigo) {
	    Producto producto = dao.findById(codigo).orElse(null);
	    if (producto != null) {
	        return producto.getPrecioUnitario();
	    } else {
	        return 0.0; // O un valor predeterminado en caso de que el producto no exista
	    }
	}

}
