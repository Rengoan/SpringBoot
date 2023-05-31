package com.curso.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.PedidoDao;
import com.curso.model.Pedido;

@Service
public class PedidosServiceImpl implements PedidosService {

	@Autowired
	PedidoDao dao;
	@Autowired
	RestTemplate restTemplate;
	private String url = "http://localhost:8080/";

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

		pedido.setFechaPedido(new Date());
		pedido.setTotal(pedido.getUnidades() * obtenerPrecio(pedido.getCodigoProducto()));
		dao.save(pedido);
		actualizarStock(pedido.getCodigoProducto(), pedido.getUnidades());

		dao.save(pedido);

	}

	@Override
	public List<Pedido> eliminarPedido(int codigo) {

		dao.deleteById(codigo);
		return dao.findAll();
	}

	private double obtenerPrecio(int codigoproducto) {
		return Double
				.parseDouble(restTemplate.getForObject(url + "producto/buscarp/{codigoproducto}", String.class, codigoproducto));
	}

	private void actualizarStock(int codigoProducto, int unidades) {
		restTemplate.put(url + "producto/{codigoProducto}/{stock}", null, codigoProducto, unidades);
	}
}
