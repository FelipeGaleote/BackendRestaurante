package com.sancarest.restaurante.responses;

import java.util.List;

import com.sancarest.restaurante.model.ItemPedido;

public class AllOrderItensResponse extends BaseResponse {

	private List<ItemPedido> itensPedido;
	
	public AllOrderItensResponse(int statusCode, String statusMessage, List<ItemPedido> itensPedido) {
		super(statusCode, statusMessage);
		this.itensPedido = itensPedido;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

}
