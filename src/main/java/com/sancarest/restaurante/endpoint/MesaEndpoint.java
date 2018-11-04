package com.sancarest.restaurante.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sancarest.restaurante.model.Mesa;
import com.sancarest.restaurante.repository.MesaRepository;

@RestController
@RequestMapping("/mesa")
public class MesaEndpoint {
	
	@Autowired
	MesaRepository repository;
	
	@PostMapping
	public void adicionarMesa() {
		repository.save(new Mesa("Dísponivel"));
	}

}
