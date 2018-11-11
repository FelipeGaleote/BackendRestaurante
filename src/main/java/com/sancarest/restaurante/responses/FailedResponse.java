package com.sancarest.restaurante.responses;

import org.springframework.http.HttpStatus;

public class FailedResponse extends BaseResponse{

	public FailedResponse(String statusMessage) {
		super(HttpStatus.INTERNAL_SERVER_ERROR.value(), statusMessage);
	}

}
