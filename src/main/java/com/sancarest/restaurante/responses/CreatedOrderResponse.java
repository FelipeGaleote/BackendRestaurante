package com.sancarest.restaurante.responses;

import org.springframework.http.HttpStatus;

import com.sancarest.restaurante.model.Pedido;

public class CreatedOrderResponse extends BaseResponse{
	
	private Pedido order;

	public CreatedOrderResponse(String messageStatus, Pedido order) {
		super(HttpStatus.CREATED.value(), messageStatus);
		this.order = order;
	}

	public Pedido getOrder() {
		return order;
	}

	public void setOrder(Pedido order) {
		this.order = order;
	}
	
	
}
