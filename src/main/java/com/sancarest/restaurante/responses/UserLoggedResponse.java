package com.sancarest.restaurante.responses;

import org.springframework.http.HttpStatus;

public class UserLoggedResponse extends BaseResponse{
	
	private String userId;
	
	public UserLoggedResponse (String statusMessage, String userId) {
		super(HttpStatus.ACCEPTED.value(), statusMessage);
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
