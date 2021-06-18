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

import com.nexti.desafio.models.Cliente;
import com.nexti.desafio.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService cs;

	@PostMapping("/incluir")
	public Cliente incluir(@RequestBody Cliente cliente) {
		return cs.create(cliente);
	}
	
	@GetMapping("/listar")
	public List<Cliente> listar(){
		return cs.listAll();
	}
	
	@PutMapping("/atualizar")
	public Cliente atualizar(@RequestBody Cliente clienteAtt) {
		return cs.update(clienteAtt);
	}
	
	@DeleteMapping("/excluir")
	public void excluir(@RequestBody Cliente cliente) {
		cs.delete(cliente);
	}
	
}
