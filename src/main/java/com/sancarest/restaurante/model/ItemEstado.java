package com.sancarest.restaurante.model;

public class ItemEstado {
		
	private long itemId;
	private boolean itemEstado;
	
	public ItemEstado() {
		
	}

	public ItemEstado(long itemId, boolean itemEstado) {
		super();
		this.itemId = itemId;
		this.itemEstado = itemEstado;
	}
	
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public boolean isItemEstado() {
		return itemEstado;
	}
	public void setItemEstado(boolean itemEstado) {
		this.itemEstado = itemEstado;
	}
	
	
}
