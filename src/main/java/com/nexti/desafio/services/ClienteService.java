package com.nexti.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexti.desafio.models.Cliente;
import com.nexti.desafio.repos.ClienteRepository;

@Service
@Transactional
public class ClienteService {

	@Autowired
	ClienteRepository cr;
	
	public Cliente create(Cliente cliente) {
		cliente = cr.save(cliente);
		return cliente;
	}
	
	public Cliente findById(Long id) {
		return cr.findById(id).get();
	}
	
	public Cliente update(Cliente clienteAtt) {
		Cliente cliente = findById(clienteAtt.getId());
		if(clienteAtt.getNome() != null) {
			cliente.setNome(clienteAtt.getNome());
		}
		if(clienteAtt.getCpf() != null) {
			cliente.setCpf(clienteAtt.getCpf());
		}
		if(clienteAtt.getDataNascimento() != null) {
			cliente.setDataNascimento(clienteAtt.getDataNascimento());
		}
		cr.update(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento());
		return cr.findById(cliente.getId()).get();
	}
	
	public List<Cliente> listAll() {
		return cr.findAll();
	}
	
	public void delete(Cliente cliente) {
		cr.delete(cliente);
	}
	
}
