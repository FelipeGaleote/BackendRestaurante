package com.sancarest.restaurante.responses;

import org.springframework.http.HttpStatus;

public class UpdatedResponse extends BaseResponse{
	
	private long id;
	
	public UpdatedResponse(String statusMessage, long id) {
		super(HttpStatus.OK.value(), statusMessage);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
