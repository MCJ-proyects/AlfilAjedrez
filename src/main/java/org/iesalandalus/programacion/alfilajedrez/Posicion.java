package org.iesalandalus.programacion.alfilajedrez;

import java.util.Objects;

public class Posicion {
	
	
	//**********************  VARIABLES  *************************
	//************************************************************
	
	private int fila;
	private char columna;
	
	//******************* CONSTRUCTORES  *************************
	//************************************************************
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	
	//constructor copia de la clase Posicion                                                              
	public Posicion(final Posicion p) {
		if(p == null) {
			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		}
	        fila = p.fila;
	        columna = p.columna;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Posicion)) {
			return false;
		}
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}
	
	

	@Override
	public String toString() {
		return "fila=" + fila + ", columna=" + columna;
	}

	//************ creaci�n de get y set *************************
	//************************************************************
	public int getFila() {
		return fila;
	}
	private void setFila(int fila) {
		if (fila < 1 || fila > 8) {
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		}
		this.fila = fila;
	}
	public char getColumna() {
		return columna;
	}
	private void setColumna(char columna) {
		if (columna < 'a' || columna > 'h') {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
		this.columna = columna;
		
	}

}
