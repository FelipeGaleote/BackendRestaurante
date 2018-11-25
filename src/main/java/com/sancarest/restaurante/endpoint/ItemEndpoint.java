package com.sancarest.restaurante.endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sancarest.restaurante.model.Item;
import com.sancarest.restaurante.model.ItemEstado;
import com.sancarest.restaurante.model.ItemPedido;
import com.sancarest.restaurante.model.Pedido;
import com.sancarest.restaurante.model.Produto;
import com.sancarest.restaurante.repository.ItemRepository;
import com.sancarest.restaurante.repository.PedidoRepository;
import com.sancarest.restaurante.repository.ProdutoRepository;
import com.sancarest.restaurante.responses.AllOrderItensResponse;
import com.sancarest.restaurante.responses.BaseResponse;
import com.sancarest.restaurante.responses.CreatedResponse;
import com.sancarest.restaurante.responses.FailedResponse;
import com.sancarest.restaurante.responses.RetrievedItensResponse;
import com.sancarest.restaurante.responses.UpdatedResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("itens")
@Api("Endpoint de itens")
@CrossOrigin(origins="*")
public class ItemEndpoint {
	
	@Autowired
	ItemRepository repository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	
	@PostMapping
	@ApiOperation(value = "Adiciona um item ao pedido e retorna o id do item")
	public BaseResponse adicionarItem(@RequestBody Item item) {
		try {
			Item itemAdicionado = repository.save(item);
			if(itemAdicionado != null) {
				return new CreatedResponse("Item adicionado com sucesso", itemAdicionado.getId());
			} else {
				return new FailedResponse("Falha ao adicionar item");
			}
		} catch (Exception e) {
			return new FailedResponse("Falha ao adicionar item");
		}
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza o estado de um item do pedido")
	public BaseResponse atualizarEstadoDoItem(@RequestBody ItemEstado itemEstado) {
		repository.save(itemEstado.getItemId(), itemEstado.isItemEstado());
		return new UpdatedResponse("Estado do pedido atualizado com sucesso", itemEstado.getItemId());
	}
	
	@GetMapping("/{idPedido}")
	@ApiOperation(value = "Retorna todos itens de um pedido com base em seu id")
	public BaseResponse recuperarItensPorPedido(@PathVariable("idPedido") long idPedido) {
		try {
			List<Item> itens = repository.findByIdPedido(idPedido);
			if(itens != null) {
				List<Produto> produtos = new ArrayList<Produto>();
				for(Item item: itens) {
					Optional<Produto> produto = produtoRepository.findById(item.getIdProduto());
					if(produto.isPresent()) {
						produtos.add(produto.get());
					}
				}
				return new RetrievedItensResponse("Itens recuperados com sucesso", itens, produtos);
			} else {
				return new FailedResponse("Falha ao recuperar itens");
			}
		} catch(Exception e) {
			return new FailedResponse("Falha ao recuperar itens");
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Retorna todos pedidos e seus respectivos produtos e mesas")
	public AllOrderItensResponse recuperarTodosPedidosEItens() {
		List<Pedido> todosPedidos = pedidoRepository.findAll();
		List<Item> todosItens = repository.findAll();
		List<ItemPedido> itensPedidos = new ArrayList<ItemPedido>();
		for (Pedido pedido : todosPedidos) {
			for(Item item : todosItens) {
				if(item.getIdPedido() == pedido.getId()) {
					if(!item.isFinalizado()) {
						Optional<Produto> produto = produtoRepository.findById(item.getIdProduto());
						if(produto.isPresent()) {
							ItemPedido itemPedido = new ItemPedido(pedido.getIdMesa(), item.getNomeProduto(), item.getQuantidade(), produto.get().getValor(), item.isFinalizado(), item.getId());
							itensPedidos.add(itemPedido);
						}	
					}
				}
			}
		}
		return new AllOrderItensResponse(200, "Itens de pedido recuperados com sucesso!", itensPedidos);
	}

}
