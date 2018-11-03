package com.sancarest.restaurante.endpoint;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sancarest.restaurante.model.*;

@RestController
@RequestMapping("produtos")
public class ProdutoEndPoint {

	@RequestMapping(method = RequestMethod.GET, path = "lanches")
	public List<Produto> informarLanches() {
		return asList(new Produto(1, "Big King", "Lanche", 12.99, "lanches", "https://picsum.photos/200/300/?random"));
	}

	@RequestMapping(method = RequestMethod.GET, path = "pizzas")
	public List<Produto> informarPizzas() {
		return asList(new Produto(1, "Big King", "Lanche", 12.99, "lanches", "https://picsum.photos/200/300/?random"));
	}

	@RequestMapping(method = RequestMethod.GET, path = "saladas")
	public List<Produto> informarSaladas() {
		return asList(new Produto(1, "Big King", "Lanche", 12.99, "lanches", "https://picsum.photos/200/300/?random"));
	}

	@RequestMapping(method = RequestMethod.GET, path = "pestiscos")
	public List<Produto> informarPetiscos() {
		return asList(new Produto(1, "Big King", "Lanche", 12.99, "lanches", "https://picsum.photos/200/300/?random"));
	}

	@RequestMapping(method = RequestMethod.GET, path = "sobremesas")
	public List<Produto> informarSobremesas() {
		return asList(new Produto(1, "Big King", "Lanche", 12.99, "lanches", "https://picsum.photos/200/300/?random"));
	}

	@RequestMapping(method = RequestMethod.GET, path = "bebidas")
	public List<Produto> informarBebidas() {
		return asList(new Produto(1, "Big King", "Lanche", 12.99, "lanches", "https://picsum.photos/200/300/?random"));
	}

}
