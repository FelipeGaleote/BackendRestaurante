package com.sancarest.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sancarest.restaurante.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	List<Item> findByIdPedido(long idPedido);

}