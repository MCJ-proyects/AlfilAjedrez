package org.iesalandalus.programacion.alfilajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	public static Alfil alfil = null;
	
	public void mainApp() {
	}
	
	
	public static void main(String[] args) throws OperationNotSupportedException {
		int opcion = 0;
		boolean salir = false;
		
		while (!salir) { 
			
			mostarMenu();
			opcion = elegirOpcion();
			
			switch (opcion) {
				case 1: // alfil defecto
				case 2: // alfil color
				case 3: // alfil color columna
					ejecutarOpcion(opcion);
					break;
				case 4: // mover
					if (alfil != null) {
						ejecutarOpcion(opcion);
					} else {
						System.out.println("Deberá crear un Alfil antes de moverlo.");
					}
					break;

				case 5: // salir
					System.out.println("¡Hasta luego!");
					salir=true;
					break;
				default:
					 System.out.println("Error opcion no valida");
					break;
			}	
		}
	}

	
	
//********************************** funciones ***********************************************************************
	
	private static void mostrarAlfil() {
		System.out.println(alfil.toString());
	}
	
	private static void mostarMenu() {
		System.out.println ("***AJEDREZ***");
		System.out.println ("1-) Crear un alfil por defecto");
		System.out.println ("2-) Crear un alfil de color");
		System.out.println ("3-) Crear alfil de un color y de una fila en especifico");
		System.out.println ("4-) Mover alfil");
		System.out.println ("5-) Salir");
	}
	
	private static int elegirOpcion() {
		System.out.print ("elija una opcion: ");
		return Entrada.entero();
	}
	
	private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
		switch (opcion) {
			case 1: // alfil defecto
				crearAlfilDefecto();
				mostrarAlfil();
				break;
			case 2: // alfil color
				crearAlfilColor();
				mostrarAlfil();
				break;
			case 3: // alfil color columna
				crearAlfilColorColumna();
				mostrarAlfil();
				break;
			case 4: // mover
				mover();
				mostrarAlfil();
				break;
		}
	}
	
	private static void crearAlfilDefecto() {
		System.out.print ("creacion de alfil default \n");
		alfil = new Alfil ();

	}
	
	private static void crearAlfilColor() {
		System.out.print ("creacion de alfil con color \n");
		Color color = elegirColor();
		alfil = new Alfil (color);

	}
	
	private static Color elegirColor() {
		
		System.out.println ("Elegir color: ");
		System.out.println ("1-) Negro");
		System.out.println ("2-) Blanco");
		
		int opcionColor = elegirOpcion();

		boolean salir = false;
		
		Color color = null;
		while (!salir) {
			switch (opcionColor) {
				case 1: // negro
					color = Color.NEGRO;
					salir = true;
					break;
				case 2: // blanco
					color = Color.BLANCO;
					salir = true;
					break;
				default:
					 System.out.println("Error opcion no valida");
			}	
		}
		return color;
	}
	
	private static void crearAlfilColorColumna() {
		System.out.print ("creacion de alfil con color y posicion \n");
		Color color = elegirColor();
		char columna = elegirColumnaInicial();
		alfil = new Alfil(color, columna);

	}
	
	private static char elegirColumnaInicial() {
		System.out.println ("Elegir columna: ");
		System.out.println ("1-) c");
		System.out.println ("2-) f");
		int opcionColumna = elegirOpcion();
		char columna = 'c';
		boolean salir = false;
		
		while (!salir) {
			switch (opcionColumna) {
				case 1: // c
					columna = 'c';
					salir = true;
					break;
				case 2: // f
					columna = 'f';
					salir = true;
					break;
				default:
					 System.out.println("Error opcion no valida");
			}	
		}
		return columna;
	}
	
	private static void mover() throws OperationNotSupportedException {
		System.out.print ("movimiento\n");
		mostrarMenuDirecciones();
		Direccion direccion = elegirDireccion();
		System.out.print("Indique numero de pasos: ");
		int pasos = elegirOpcion();
		
		alfil.mover(direccion, pasos);
		
	}
	
	private static void mostrarMenuDirecciones() {
		System.out.println ("Elegir direccion: ");
		System.out.println ("1-) ARRIBA_DERECHA");
		System.out.println ("2-) ABAJO_DERECHA");
		System.out.println ("3-) ARRIBA_IZQUIERDA");
		System.out.println ("4-) ABAJO_IZQUIERDA");
	}
	
	private static Direccion elegirDireccion() {
		Direccion direccion = null;
		int opcionDireccion = elegirOpcion();
		switch (opcionDireccion) {
		
		case 1:
			direccion = Direccion.ARRIBA_DERECHA;
			break;
			
		case 2:
			direccion = Direccion.ABAJO_DERECHA;
			break;
			
		case 3:
			direccion = Direccion.ARRIBA_IZQUIERDA;
			break;
			
		case 4:
			direccion = Direccion.ABAJO_IZQUIERDA;
			break;
			
		default:
			 System.out.println("Error opcion no valida");
			
		}
		return direccion;
	}
	
}
