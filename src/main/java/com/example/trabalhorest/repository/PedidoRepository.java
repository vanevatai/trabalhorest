package com.example.trabalhorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trabalhorest.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long>{

}
