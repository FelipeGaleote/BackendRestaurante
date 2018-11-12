package com.sancarest.restaurante.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sancarest.restaurante.model.Item;
import com.sancarest.restaurante.model.Pedido;
import com.sancarest.restaurante.util.DataUtil;

import io.swagger.annotations.Api;

import static java.util.Arrays.asList;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("pedido")
@Api("Endpoint de pedidos")
@CrossOrigin(origins="*")
public class PedidoEndpoint {

	@Autowired
	DataUtil dataUtil;

	@RequestMapping(method = RequestMethod.GET, path = "/todositens")
	public List<Item> todosItens() {
		System.out.println(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return asList(new Item("Pastel de frango"), new Item("5"));
	}

}
