package com.AplicacionWebNominas.model;

public class DatosNoCorrectosException extends Exception{

	public DatosNoCorrectosException(String mensaje) {
	    super(mensaje);
	}

	public void mensaje() {
		System.out.println("Error en los datos");
	}
}
