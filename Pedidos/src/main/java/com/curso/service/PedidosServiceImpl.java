package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.curso.dao.PedidoDao;
import com.curso.model.Pedido;

@Service
public class PedidosServiceImpl implements PedidosService {

	@Autowired
	PedidoDao dao;

	@Override
	public List<Pedido> pedidos() {

		return dao.findAll();
	}

	@Override
	public Pedido buscarPedido(int codigo) {

		return dao.findById(codigo).orElse(null);
	}

	@Override
	public void altaPedido(Pedido pedido) {

		dao.save(pedido);

	}

	@Override
	public void actualizarPedido(Pedido pedido) {

		dao.save(pedido);

	}

	@Override
	public List<Pedido> eliminarPedido(int codigo) {

		dao.deleteById(codigo);
		return dao.findAll();
	}

}
