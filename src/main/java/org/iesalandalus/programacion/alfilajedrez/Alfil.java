package org.iesalandalus.programacion.alfilajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alfil {
	
	private Color color;
	private Posicion posicion;
	
	public Alfil() {
		this.setColor(Color.NEGRO);
		this.setPosicion(new Posicion(8,'f'));
	}
	
	public Alfil(Color color) {
		this.setColor(color);
		System.out.println(color.toString());
		if (color == Color.BLANCO) {
			this.setPosicion(new Posicion(1,'f'));
		} else {
			this.setPosicion(new Posicion(8,'f'));
		}
	}
	
	public Alfil(Color color, char columna) {
		
		if (columna != 'c' | columna != 'f') {
			this.setColor(color);
			
			if (color == Color.BLANCO) {
				this.setPosicion(new Posicion(1, columna));
			} else {
				this.setPosicion(new Posicion(8, columna));
			}
		
		} else {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
	}
	
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	private void setColor(Color color) {
		if ( color == Color.BLANCO || color == Color.NEGRO) {
			this.color = color;
		} else {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}
	}

	public Color getColor() {
		return this.color;
	}

	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		String letras = "abcdefgh";
		int numColumna = letras.indexOf(this.getPosicion().getColumna()) +1;
		
		//if(direccion == null) {
		if(direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		int filaFutura =0, columnaFutura=0;
		if(pasos > 0) {
			if (direccion == Direccion.ARRIBA_DERECHA) {
				filaFutura = this.getPosicion().getFila() + pasos;
				columnaFutura = numColumna + pasos;
			}
			if (direccion == Direccion.ARRIBA_IZQUIERDA) {
				filaFutura = this.getPosicion().getFila() + pasos;
				columnaFutura = numColumna - pasos;
			}
			if (direccion == Direccion.ABAJO_DERECHA) {
				filaFutura = this.getPosicion().getFila() - pasos;
				columnaFutura = numColumna + pasos;
			}
			if (direccion == Direccion.ABAJO_IZQUIERDA) {
				filaFutura = this.getPosicion().getFila() - pasos;
				columnaFutura = numColumna - pasos;
			}				
				if( filaFutura > 8 || columnaFutura > 8) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				} else {
					System.out.println(letras.charAt(columnaFutura-1));
					this.setPosicion(new Posicion(filaFutura, letras.charAt(columnaFutura-1)));
				}
		} else {
				throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
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
		return posicion.toString() + ", color=" + color;
	}
	
	
	
}

