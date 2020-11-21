package org.iesalandalus.programacion.alfilajedrez;

public class Alfil {
	
	private Color color;
	private Posicion posicion;
	
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
