package com.sancarest.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sancarest.restaurante.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	List<Item> findByIdPedido(long idPedido);
	
	@Transactional
	@Modifying
	@Query("UPDATE Item SET finalizado = ?2 WHERE id = ?1")
	void save(long idItem, boolean estado);

}
