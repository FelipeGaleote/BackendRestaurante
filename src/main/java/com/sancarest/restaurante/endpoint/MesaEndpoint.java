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
import com.sancarest.restaurante.responses.BaseResponse;
import com.sancarest.restaurante.responses.CreatedResponse;
import com.sancarest.restaurante.responses.FailedResponse;
import com.sancarest.restaurante.responses.RetrievedTablesResponse;
import com.sancarest.restaurante.responses.UpdatedResponse;

@RestController
@RequestMapping("/mesa")
public class MesaEndpoint {
	
	@Autowired
	MesaRepository repository;
	
	@PostMapping
	public BaseResponse adicionarMesa() {
		try {
			Mesa mesa = repository.save(new Mesa("Dísponivel"));
			return new CreatedResponse("Mesa cadastrada com sucesso",mesa.getId());
		} catch (Exception e) {
			return new FailedResponse("Falha ao cadastrar mesa");
		}
		
	}
	
	@GetMapping
	public BaseResponse informarMesas(){
		try {
			List<Mesa> tables = repository.findAll();
			return new RetrievedTablesResponse("Mesas recuperadas com sucesso", tables);
		} catch (Exception e) {
			return new FailedResponse("Falha ao recuperar mesas");
		}
		
	}
	
	@PutMapping
	public BaseResponse atualizarMesa(@RequestBody Mesa mesa) {
		try {
			Mesa mesaAtualizada = repository.save(mesa);
			return new UpdatedResponse("Mesa atualizada com sucesso", mesaAtualizada.getId());
		} catch (Exception e) {
			return new FailedResponse("Falha ao atualizar mesa");
		}
		
	}
	
	

}
