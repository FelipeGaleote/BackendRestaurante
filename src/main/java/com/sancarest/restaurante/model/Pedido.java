package com.sancarest.restaurante.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long idMesa;
	private String idUsuario;
	private long dataDeInicio;
	private long dataDeFinalizacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(long idMesa) {
		this.idMesa = idMesa;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(long dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public long getDataDeFinalizacao() {
		return dataDeFinalizacao;
	}

	public void setDataDeFinalizacao(long dataDeFinalizacao) {
		this.dataDeFinalizacao = dataDeFinalizacao;
	}
}
