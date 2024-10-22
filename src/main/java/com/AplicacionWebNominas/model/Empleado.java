package com.AplicacionWebNominas.model;

public class Empleado {
	public String nombre, dni;
	public char sexo;
	public int categoria, anyos;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getAnyos() {
		return anyos;
	}
	public void setAnyos(int anyos) {
		this.anyos = anyos;
	}
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.categoria = categoria;
		this.anyos = anyos;
	}
	public Empleado() {
		super();
	}
	
}
