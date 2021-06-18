package com.nexti.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexti.desafio.models.Produto;
import com.nexti.desafio.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService ps;
	
	@PostMapping("/incluir")
	public Produto incluir(@RequestBody Produto produto) {
		return ps.create(produto);
	}
	
	@GetMapping("/listar")
	public List<Produto> listar(){
		return ps.listAll();
	}
	
	@PutMapping("/atualizar")
	public Produto atualizar(@RequestBody Produto produto) {
		return ps.update(produto);
	}
	
	@DeleteMapping("excluir")
	public void excluir(@RequestBody Produto produto) {
		ps.delete(produto);
	}
}
