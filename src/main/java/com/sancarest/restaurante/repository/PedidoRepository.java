package com.sancarest.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sancarest.restaurante.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	Pedido findByIdUsuario(String idUsuario);
}
