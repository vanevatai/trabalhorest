package com.example.trabalhorest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabalhorest.model.Cliente;
import com.example.trabalhorest.repository.ClienteRepository;

@RestController
@RequestMapping({ "/clientes" })
public class ClienteController {
	private ClienteRepository repository;

	ClienteController(ClienteRepository restRepository) {
		this.repository = restRepository;
	}

	//Listar específico
	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	//Criar nova entrada
	@PostMapping
	public Cliente create(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}

	//Deletar entrada
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}