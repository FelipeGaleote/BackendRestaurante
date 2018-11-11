package com.sancarest.restaurante.responses;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.sancarest.restaurante.model.Produto;

public class RetrievedProductsResponse extends BaseResponse{
	
	private List<Produto> products;
	
	public RetrievedProductsResponse(String statusMessage, List<Produto> products) {
		super(HttpStatus.OK.value(), statusMessage);
		this.products = products;
	}

	public List<Produto> getProducts() {
		return products;
	}

	public void setProducts(List<Produto> products) {
		this.products = products;
	}
	
}
