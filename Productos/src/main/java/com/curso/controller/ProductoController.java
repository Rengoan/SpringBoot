package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Producto;
import com.curso.service.ProductosService;

@RestController
public class ProductoController {

	@Autowired
	ProductosService service;

	// http://localhost:8080/producto/codigoproducto
	@GetMapping(value = "producto/{codigoproducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Producto buscarProducto(@PathVariable int codigoproducto) { // Le pasas la variable con PathVariable

		return service.buscarProducto(codigoproducto);
	}

	// http://localhost:8080/producto/buscar/producto
	@GetMapping(value = "producto/buscar/{producto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Producto buscarProductoN(@PathVariable String producto) { // Le pasas la variable con PathVariable

		return service.buscarProductoNombre(producto);
	}

	// http://localhost:8080/producto
	@GetMapping(value = "producto", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos() {

		return service.productos();
	}

	// http://localhost:8080/producto/nuevo
	@PostMapping(value = "producto/nuevo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaCurso(@RequestBody Producto p) {

		service.altaProducto(p);

	}

	// http:/localhost:8080/producto/{codigoProducto}/{stock}
	@PutMapping(value = "producto/{codigoProducto}/{stock}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> actualizarProducto(@PathVariable int codigoProducto, @PathVariable int stock) {
		return service.actualizarProducto(codigoProducto, stock);
	}

	// http://localhost:8080/producto/codigoproducto
	@DeleteMapping(value = "producto/{codigoproducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> eliminarCurso(@PathVariable int codigoproducto) {

		return service.eliminarProducto(codigoproducto);
	}
	
	// http://localhost:8080/producto/buscarp/codigoproducto
		@GetMapping(value = "producto/buscarp/{codigoproducto}", produces = MediaType.APPLICATION_JSON_VALUE)
		public double obtenerPrecio(@PathVariable int codigoproducto) { // Le pasas la variable con PathVariable

			return service.obtenerPrecioProducto(codigoproducto);
		}

}
