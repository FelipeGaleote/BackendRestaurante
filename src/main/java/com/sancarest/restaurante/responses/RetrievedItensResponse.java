package com.sancarest.restaurante.responses;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.sancarest.restaurante.model.Item;
import com.sancarest.restaurante.model.Produto;

public class RetrievedItensResponse extends BaseResponse{
	
	private List<Item> itens;
	private List<Produto> produtos;
	
	public RetrievedItensResponse(String messageStatus, List<Item> itens, List<Produto> produtos) {
		super(HttpStatus.OK.value(), messageStatus);
		this.itens = itens;
		this.produtos = produtos;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
