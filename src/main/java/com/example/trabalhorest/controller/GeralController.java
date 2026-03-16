package com.example.trabalhorest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabalhorest.model.Cliente;
import com.example.trabalhorest.model.Pedido;
import com.example.trabalhorest.model.Produto;
import com.example.trabalhorest.repository.ClienteRepository;
import com.example.trabalhorest.repository.PedidoRepository;
import com.example.trabalhorest.repository.ProdutoRepository;

@RestController
@RequestMapping({ "/geral" })
public class GeralController {
	private ProdutoRepository produtorep;
	private ClienteRepository clienterep;
	private PedidoRepository  pedidorep;

	GeralController(ProdutoRepository restRepository1, ClienteRepository restRepository2, PedidoRepository restRepository3) {
		this.produtorep = restRepository1;
		this.clienterep = restRepository2;
		this.pedidorep  = restRepository3;
	}

	//Listar todos
	@GetMapping
	public List<?> findAll() {
		
		List<Produto> listaProdutos = produtorep.findAll();
		List<Cliente> listaClientes = clienterep.findAll();
		List<Pedido> listaPedidos = pedidorep.findAll();
		
	    List<Object> geral = new ArrayList<Object>();
	    
	    geral.addAll(listaProdutos);
	    geral.addAll(listaClientes);
	    geral.addAll(listaPedidos);
	    
	    return geral;
		
	}

}