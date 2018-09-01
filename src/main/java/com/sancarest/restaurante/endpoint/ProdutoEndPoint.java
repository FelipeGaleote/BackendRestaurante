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
	
	@RequestMapping(method = RequestMethod.GET, path = "todosprodutos")
	public List<Produto> informarTodosProdutos(){
		return asList(new Produto(1,"Whopper","Lanche",12.99));
	}


}
