package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Pedido;
import com.curso.service.PedidosService;

@RestController
public class PedidosController {

	@Autowired
	PedidosService service;

	// http://localhost:7000/pedido/idPedido
	@GetMapping(value = "pedido/{idPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pedido buscarPedido(@PathVariable int idPedido) { // Le pasas la variable con PathVariable

		return service.buscarPedido(idPedido);
	}

	// http://localhost:7000/pedidos
	@GetMapping(value = "pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> pedidos() {

		return service.pedidos();
	}

	// http://localhost:7000/pedido/nuevo
	@PostMapping(value = "pedido/nuevo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaPedido(@RequestBody Pedido p) {

		service.altaPedido(p);

	}

	// http://localhost:7000/pedido/idPedido
	@DeleteMapping(value = "pedido/{idPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> eliminarPedido(@PathVariable int idPedido) {

		return service.eliminarPedido(idPedido);
	}
}
