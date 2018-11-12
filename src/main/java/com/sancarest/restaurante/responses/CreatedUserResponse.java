package com.sancarest.restaurante.responses;

import org.springframework.http.HttpStatus;

public class CreatedUserResponse extends BaseResponse{
	
	private String id;
	public CreatedUserResponse(String statusMessage, String id) {
		super(HttpStatus.CREATED.value(), statusMessage);
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
