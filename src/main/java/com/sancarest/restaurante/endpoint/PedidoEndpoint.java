package com.sancarest.restaurante.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sancarest.restaurante.model.Item;
import com.sancarest.restaurante.model.Pedido;
import com.sancarest.restaurante.model.Usuario;
import com.sancarest.restaurante.repository.PedidoRepository;
import com.sancarest.restaurante.repository.UsuarioRepository;
import com.sancarest.restaurante.responses.BaseResponse;
import com.sancarest.restaurante.responses.CreatedOrderResponse;
import com.sancarest.restaurante.responses.CreatedResponse;
import com.sancarest.restaurante.responses.FailedResponse;
import com.sancarest.restaurante.responses.RetrievedOrderResponse;
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
	@Autowired
	PedidoRepository repository;
	@Autowired
	UsuarioRepository userRepository;
	

	@RequestMapping(method = RequestMethod.GET, path = "/todositens")
	public List<Item> todosItens() {
		System.out.println(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return asList(new Item("Pastel de frango"), new Item("5"));
	}
	
	@PostMapping
	public BaseResponse criarPedido(@RequestBody Pedido pedido) {
		Usuario autorDoPedido = userRepository.getOne(pedido.getIdUsuario());
		if(autorDoPedido != null && repository.findByIdUsuario(autorDoPedido.getNomeUsuario()) != null) {
			return new CreatedResponse("Pedido ja cadastrado", repository.findByIdUsuario(autorDoPedido.getNomeUsuario()).getId());
		} else {
			pedido.setDataDeInicio(System.currentTimeMillis());
			Pedido pedidoCriado = repository.save(pedido);
			return new CreatedOrderResponse("Pedido criado com sucesso", pedidoCriado);
		}
	}
	
	@GetMapping("/{userId}")
	public BaseResponse consultarPedidoPorUsuario(@PathVariable("userId") String userId) {
		Pedido order = repository.findByIdUsuario(userId);
		if(order != null) {
			return new RetrievedOrderResponse("Pedido recuperado com sucesso", order);
		} else {
			return new FailedResponse("Não foi possivel recuperar pedidos desse usuario");
		}
	}

}
