package com.sancarest.restaurante.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sancarest.restaurante.model.Item;
import com.sancarest.restaurante.util.DataUtil;

import static java.util.Arrays.asList;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoEndpoint {

	@Autowired
	DataUtil dataUtil;

	@RequestMapping(method = RequestMethod.GET, path = "/todositens")
	public List<Item> todosItens() {
		System.out.println(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return asList(new Item("Pastel de frango"), new Item("5"));
	}

}
