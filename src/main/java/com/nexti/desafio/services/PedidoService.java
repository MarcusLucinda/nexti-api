package com.nexti.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexti.desafio.models.Pedido;
import com.nexti.desafio.models.Produto;
import com.nexti.desafio.repos.PedidoRepository;
import com.nexti.desafio.repos.ProdutoRepository;

@Service
@Transactional
public class PedidoService {

	@Autowired
	PedidoRepository pedRepo;
	@Autowired
	ProdutoRepository prodRepo;

	public Pedido create(Pedido pedido) {
		pedido = getTotal(pedido);
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
		pedRepo.update(pedido.getId(), pedido.getCliente(), pedido.getTotal(), pedido.getDataCompra());
		return findById(pedido.getId());
	}

	public List<Pedido> listAll(){
		return pedRepo.findAll();
	}

	public void delete(Pedido pedido) {
		pedRepo.deleteAllPedidos(pedido.getId());
		pedRepo.delete(pedido);
	}

	public Pedido addProdutos(Pedido pedidoAtt) {
		Pedido pedido = findById(pedidoAtt.getId());
		List<Produto> produtos = pedidoAtt.getProdutos();
		for (Produto produto : produtos) {
			try {
				pedRepo.addProducts(pedido.getId(), produto.getId());
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		pedido = findById(pedido.getId());
		pedido = getTotal(pedido);
		return pedido;
	}
	
	public Pedido delProdutos(Pedido pedidoAtt) {
		Pedido pedido = findById(pedidoAtt.getId());
		List<Produto> produtos = pedidoAtt.getProdutos();
		for (Produto produto : produtos) {
			try {
				pedRepo.delProducts(pedido.getId(), produto.getId());
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		pedido = findById(pedido.getId());
		pedido = getTotal(pedido);
		return pedido;
	}

	public Pedido getTotal(Pedido pedido) {
		Double total = 0.0;
		if(pedido.getProdutos() != null) {
			for (Produto produto : pedido.getProdutos()) {
				produto = prodRepo.getById(produto.getId());
				total += produto.getPreco();
			}
		}
		pedido.setTotal(total);
		return pedido;
	}
}
