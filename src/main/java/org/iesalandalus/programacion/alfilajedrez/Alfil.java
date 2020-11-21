package org.iesalandalus.programacion.alfilajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alfil {
	
	private Color color;
	private Posicion posicion;
	
	public Alfil() {
		//Posicion p1 = new Posicion(8,"f".charAt(0));
		//this.setPosicion(p1);
		
		this.setColor(Color.NEGRO);
		this.setPosicion(new Posicion(8,"f".charAt(0)));
	}
	
	public Alfil(Color color) {
		Alfil alfil = new Alfil(color);
		if (color == Color.BLANCO) {
			alfil.setPosicion(new Posicion(1,"f".charAt(0)));
		} else {
			alfil.setPosicion(new Posicion(8,"f".charAt(0)));
		}
	}
	
	public Alfil(Color color, char columna) {
		if (columna != 'c' || columna != 'f') {
			throw new IllegalArgumentException("ERROR: Columna inicial no válida para Alfil.");
		}
		
		this.setColor(color);
		
		if (color == Color.BLANCO) {
			this.setPosicion(new Posicion(1, columna));
		} else {
			this.setPosicion(new Posicion(8, columna));
		}
	}
	
	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		String letras = "abcdefgh";
		int numColumna = letras.indexOf(this.getPosicion().getColumna()) +1;
		
		if(direccion == null) {
			throw new IllegalArgumentException("ERROR: La dirección no es válida.");
		}
		
		if(pasos > 0) {
				int filaFutura = this.getPosicion().getFila() + pasos;
				int columnaFutura = numColumna + pasos;
				if( filaFutura > 8 || columnaFutura > 8) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				} else {
					this.setPosicion(new Posicion(filaFutura, letras.charAt(columnaFutura)));
				}
		} else {
				throw new IllegalArgumentException("ERROR: La dirección no puede ser nula.");
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Alfil)) {
			return false;
		}
		Alfil other = (Alfil) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}

	@Override
	public String toString() {
		return "Alfil [color=" + color + ", posicion=" + posicion + "]";
	}

	public Color getColor() {
		return color;
	}
	
	private void setColor(Color color) {
		if (color != Color.BLANCO || color != Color.NEGRO) {
			throw new IllegalArgumentException("ERROR: El color no es válido.");
		}
		this.color = color;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	
	
}

