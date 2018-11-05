package com.sancarest.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sancarest.restaurante.model.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Integer>{
	List<Mesa> findAllByOrderByIdAsc();
}
