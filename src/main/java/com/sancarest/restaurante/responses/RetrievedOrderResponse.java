package com.sancarest.restaurante.responses;

import org.springframework.http.HttpStatus;

import com.sancarest.restaurante.model.Pedido;

public class RetrievedOrderResponse extends BaseResponse{
	
	private Pedido pedido;
	
	public RetrievedOrderResponse(String messageStatus, Pedido pedido) {
		super(HttpStatus.OK.value(), messageStatus);
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
