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

import com.nexti.desafio.models.Pedido;
import com.nexti.desafio.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoService pedServ;
	
	@PostMapping("/incluir")
	public Pedido incluir(@RequestBody Pedido pedido) {
		return pedServ.create(pedido);
	}
	
	@GetMapping("/listar")
	public List<Pedido> listar(){
		return pedServ.listAll();
	}
	
	@PutMapping("/atualizar")
	public Pedido atualizar(@RequestBody Pedido pedidoAtt) {
		return pedServ.update(pedidoAtt);
	}
	
	@DeleteMapping("/excluir")
	public void excluir(@RequestBody Pedido pedido) {
		pedServ.delete(pedido);
	}
}
