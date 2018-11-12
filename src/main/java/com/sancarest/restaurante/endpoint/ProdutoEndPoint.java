package com.sancarest.restaurante.endpoint;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sancarest.restaurante.model.*;
import com.sancarest.restaurante.repository.ProdutoRepository;
import com.sancarest.restaurante.responses.BaseResponse;
import com.sancarest.restaurante.responses.CreatedResponse;
import com.sancarest.restaurante.responses.FailedResponse;
import com.sancarest.restaurante.responses.RetrievedProductsResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("produto")
@Api("Endpoint de produtos")
@CrossOrigin(origins="*")
public class ProdutoEndPoint {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@PostMapping()
	@ApiOperation(value = "Cadastra um produto e retorna seu id")
	public BaseResponse cadastrarProduto(@RequestBody Produto produto) {
		try {
			Produto produtoSalvo = produtoRepository.save(produto);
			return new CreatedResponse("Produto cadastrado com sucesso", produtoSalvo.getId());
		} catch (Exception e) {
			return new FailedResponse("Falha ao cadastrar o produto");
		}
	}
	
	@GetMapping("lanches")
	@ApiOperation(value = "Informa a lista com todos lanches do sistema")
	public BaseResponse informarLanches() {
		try {
			List<Produto> retrievedProducts = produtoRepository.findByTipo("lanches");
			return new RetrievedProductsResponse("Produtos recuperados com sucesso",retrievedProducts);
		} catch(Exception e) {
			return new FailedResponse("Falha ao recuperar lanches");
		}
	}

	@GetMapping("pizzas")
	@ApiOperation(value = "Informa a lista com todas pizzas do sistema")
	public BaseResponse informarPizzas() {
		try {
			List<Produto> retrievedProducts = produtoRepository.findByTipo("pizzas");
			return new RetrievedProductsResponse("Produtos recuperados com sucesso",retrievedProducts);
		} catch(Exception e) {
			return new FailedResponse("Falha ao recuperar pizzas");
		}
	}

	@GetMapping("saladas")
	@ApiOperation(value = "Informa a lista com todas saladas do sistema")
	public BaseResponse informarSaladas() {
		try {
			List<Produto> retrievedProducts = produtoRepository.findByTipo("saladas");
			return new RetrievedProductsResponse("Produtos recuperados com sucesso",retrievedProducts);
		} catch(Exception e) {
			return new FailedResponse("Falha ao recuperar saladas");
		}
	}

	@GetMapping("petiscos")
	@ApiOperation(value = "Informa a lista com todos petiscos do sistema")
	public BaseResponse informarPetiscos() {
		try {
			List<Produto> retrievedProducts = produtoRepository.findByTipo("petiscos");
			return new RetrievedProductsResponse("Produtos recuperados com sucesso",retrievedProducts);
		} catch(Exception e) {
			return new FailedResponse("Falha ao recuperar petiscos");
		}
	}

	@GetMapping("sobremesas")
	@ApiOperation(value = "Informa a lista com todas sobremesas do sistema")
	public BaseResponse informarSobremesas() {
		try {
			List<Produto> retrievedProducts = produtoRepository.findByTipo("sobremesas");
			return new RetrievedProductsResponse("Produtos recuperados com sucesso",retrievedProducts);
		} catch(Exception e) {
			return new FailedResponse("Falha ao recuperar sobremesas");
		}
	}

	@GetMapping("bebidas")
	@ApiOperation(value = "Informa a lista com todas bebidas do sistema")
	public BaseResponse informarBebidas() {
		try {
			List<Produto> retrievedProducts = produtoRepository.findByTipo("bebidas");
			return new RetrievedProductsResponse("Produtos recuperados com sucesso",retrievedProducts);
		} catch(Exception e) {
			return new FailedResponse("Falha ao recuperar bebidas");
		}
	}

}
