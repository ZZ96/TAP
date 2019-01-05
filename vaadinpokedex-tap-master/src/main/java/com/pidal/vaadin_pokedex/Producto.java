package com.pidal.vaadin_pokedex;

public class Producto {

	private String name;
	private String number;
	private String type;
	private int unidades;
	
	public Producto(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}
	public Producto(String number, String name, String type, int unidades) {
		super();
		this.name = name;
		this.number = number;
		this.type = type;
		this.unidades=unidades;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
