package com.sancarest.restaurante.endpoint;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sancarest.restaurante.model.*;
import com.sancarest.restaurante.repository.ProdutoRepository;

@RestController
@RequestMapping("produto")
public class ProdutoEndPoint {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@PostMapping()
	public Produto cadastrarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@GetMapping("lanches")
	public List<Produto> informarLanches() {
		return produtoRepository.findByTipo("lanches");
	}

	@GetMapping("pizzas")
	public List<Produto> informarPizzas() {
		return asList(new Produto(1, "Big King", "Lanche", 12.99, "lanches", "https://picsum.photos/200/300/?random"));
	}

	@GetMapping("saladas")
	public List<Produto> informarSaladas() {
		return asList(new Produto(1, "Big King", "Lanche", 12.99, "lanches", "https://picsum.photos/200/300/?random"));
	}

	@GetMapping("petiscos")
	public List<Produto> informarPetiscos() {
		return asList(new Produto(1, "Big King", "Lanche", 12.99, "lanches", "https://picsum.photos/200/300/?random"));
	}

	@GetMapping("sobremesas")
	public List<Produto> informarSobremesas() {
		return asList(new Produto(1, "Big King", "Lanche", 12.99, "lanches", "https://picsum.photos/200/300/?random"));
	}

	@GetMapping("bebidas")
	public List<Produto> informarBebidas() {
		return asList(new Produto(1, "Big King", "Lanche", 12.99, "lanches", "https://picsum.photos/200/300/?random"));
	}

}
