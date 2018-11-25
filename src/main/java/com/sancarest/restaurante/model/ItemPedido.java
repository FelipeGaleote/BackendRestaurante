package com.sancarest.restaurante.model;

import java.io.Serializable;

public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private long mesa;
	private String nomeProduto;
	private int quantidade;
	private double valor;
	private boolean finalizado;
	private long idItem;
	
	public ItemPedido(long mesa, String nomeProduto, int quantidade, double valor, boolean finalizado,long idItem) {
		super();
		this.mesa = mesa;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.finalizado = finalizado;
		this.idItem = idItem;
	}
	
	public ItemPedido() {
		
	}
	public long getMesa() {
		return mesa;
	}
	public void setMesa(long mesa) {
		this.mesa = mesa;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public long getIdItem() {
		return idItem;
	}

	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}
}
