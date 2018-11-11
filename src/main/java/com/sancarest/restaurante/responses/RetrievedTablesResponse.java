package com.sancarest.restaurante.responses;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.sancarest.restaurante.model.Mesa;

public class RetrievedTablesResponse extends BaseResponse{
	
	private List<Mesa> tables;

	public RetrievedTablesResponse(String statusMessage, List<Mesa> tables) {
		super(HttpStatus.OK.value(), statusMessage);
		this.tables = tables;
	}

	public List<Mesa> getTables() {
		return tables;
	}

	public void setTables(List<Mesa> tables) {
		this.tables = tables;
	}
	
}
