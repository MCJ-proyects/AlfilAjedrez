package org.iesalandalus.programacion.alfilajedrez;

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
		
		this.setColor(color);
		
		if (color == Color.BLANCO) {
			this.setPosicion(new Posicion(1,"f".charAt(0)));
		} else {
			this.setPosicion(new Posicion(8,"f".charAt(0)));
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

