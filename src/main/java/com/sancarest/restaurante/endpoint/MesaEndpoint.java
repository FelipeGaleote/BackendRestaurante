package com.sancarest.restaurante.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping
	public List<Mesa> informarMesas(){
		return repository.findAllByOrderByIdAsc();
	}
	
	@PutMapping
	public void atualizarMesa(@RequestBody Mesa mesa) {
		repository.save(mesa);
	}
	
	

}
