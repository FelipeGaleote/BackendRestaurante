package com.sancarest.restaurante.responses;

import org.springframework.http.HttpStatus;

public class CreatedResponse extends BaseResponse {
	
	private long id;

	public CreatedResponse(String statusMessage, long id) {
		super(HttpStatus.CREATED.value(), statusMessage);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
