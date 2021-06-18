package com.nexti.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexti.desafio.models.Pedido;
import com.nexti.desafio.models.Produto;
import com.nexti.desafio.repos.PedidoRepository;

@Service
@Transactional
public class PedidoService {

	@Autowired
	PedidoRepository pedRepo;
	
	public Pedido create(Pedido pedido) {
		Double total = 0.0;
		if(pedido.getProdutos() != null) {
			for (Produto produto : pedido.getProdutos()) {
				total += produto.getPreco();
			}
		}
		pedido.setTotal(total);
		pedido = pedRepo.save(pedido);
		return pedido;
	}
	
	public Pedido findById(Long id) {
		return pedRepo.findById(id).get();
	}
	
	public Pedido update(Pedido pedidoAtt) {
		Pedido pedido = findById(pedidoAtt.getId());
		if(pedidoAtt.getCliente() != null) {
			pedido.setCliente(pedidoAtt.getCliente());
		}
		if(pedidoAtt.getDataCompra() != null) {
			pedido.setDataCompra(pedidoAtt.getDataCompra());
		}
		return pedido;
	}
	
	public List<Pedido> listAll(){
		return pedRepo.findAll();
	}
	
	public void delete(Pedido pedido) {
		pedRepo.delete(pedido);
	}
}
