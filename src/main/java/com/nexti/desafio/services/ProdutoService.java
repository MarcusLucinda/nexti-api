package com.nexti.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexti.desafio.models.Produto;
import com.nexti.desafio.repos.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	ProdutoRepository pr;
	
	public Produto create(Produto produto) {
		produto = pr.save(produto);
		return produto;
	}
	
	public Produto findById(Long id) {
		return pr.findById(id).get();
	}
	
	public Produto update(Produto produtoAtt) {
		Produto produto = findById(produtoAtt.getId());
		if(produtoAtt.getNome() != null) {
			produto.setNome(produtoAtt.getNome());
		}
		if(produtoAtt.getDescricao() != null) {
			produto.setDescricao(produtoAtt.getDescricao());
		}
		if(produtoAtt.getPreco() != null) {
			produto.setPreco(produtoAtt.getPreco());
		}
		if(produtoAtt.getQtd() != null) {
			produto.setQtd(produtoAtt.getQtd());
		}
		pr.update(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQtd());
		return findById(produto.getId());
	}
	
	public List<Produto> listAll(){
		return pr.findAll();
	}
	
	public void delete(Produto produto) {
		pr.delete(produto);
	}
	
}
