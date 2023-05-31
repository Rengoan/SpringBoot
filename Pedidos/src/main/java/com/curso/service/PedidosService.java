package com.curso.service;

import java.util.List;

import com.curso.model.Pedido;

public interface PedidosService {

	List<Pedido> pedidos();

	Pedido buscarPedido(int codigo);

	void altaPedido(Pedido pedido);


	List<Pedido> eliminarPedido(int codigo);
}
