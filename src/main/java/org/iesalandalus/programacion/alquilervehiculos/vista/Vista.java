package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public class Vista {
	private Controlador controlador;

	// asignará el controlador pasado al atributo si éste no es nulo.
	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("No puedes asignar un controlador nulo");
		}
		this.controlador = controlador;
	}

	// que mostrará el menú, leerá una opción de consola y la ejecutará. Repetirá
	// este proceso mientras la opción elegida no sea la correspondiente a salir.
	// Utilizará los correspondientes métodos de la clase Consola y llamará al
	// método ejecutar de esta clase que describiré a continuación.
	public void comenzar() {
		Consola.mostrarMenu();

	}

	// mostrará un mensaje de despedida por consola
	public void terminar() {
		System.out.println("Hasta luego Lucas!");
	}

	// dependiendo de la opción pasada por parámetro invocará a un método o a otro
	private void ejecutar(Opcion opcion) {

	}

	// Estos métodos deberán mostrar una cabecera informando en que opción nos
	// encontramos, pedirnos los datos adecuados y realizar la operación adecuada
	// llamando al método correspondiente de nuestro controlador. También deben
	// controlar todas las posibles excepciones.

	private void insertarCliente() {
		try {
			Consola.mostrarCabecera("Insertar cliente");
			controlador.insertar(Consola.leerCliente());
			System.out.println("Cliente insertado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	private void insertarTurismo() {
		try {
			Consola.mostrarCabecera("Insertar turismo");
			controlador.insertar(Consola.leerTurismo());
			System.out.println("Turismo insertado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	private void insertarAlquiler() {
		try {
			Consola.mostrarCabecera("Insertar alquiler");
			controlador.insertar(Consola.leerAlquiler());
			System.out.println("Alquiler insertado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	private void buscarCliente() {
		try {
			Consola.mostrarCabecera("Buscar cliente");
			controlador.buscar(Consola.leerClienteDni());
			System.out.println("Cliente buscando correctamente");
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void buscarTurismo() {
		try {
			Consola.mostrarCabecera("Buscar turismo");
			controlador.buscar(Consola.leerTurismoMatricula());
			System.out.println("Turismo buscando correctamente");
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void buscarAlquiler() {

		try {
			Consola.mostrarCabecera("Buscar alquiler");
			controlador.buscar(Consola.leerAlquiler());
			System.out.println("Alquiler buscando correctamente");
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void modificarCliente() {

	}

	private void devolverAlquiler() {

	}

	private void borrarCliente() {
		try {
			Consola.mostrarCabecera("Borrar cliente");
			controlador.borrar(Consola.leerClienteDni());
			System.out.println("Cliente borrado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	private void borrarTurismo() {
		try {
			Consola.mostrarCabecera("Borrar turismo");
			controlador.borrar(Consola.leerTurismoMatricula());
			System.out.println("Turismo borrado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}

	}

	private void borrarAlquiler() {
		try {
			Consola.mostrarCabecera("Borrar alquiler");
			controlador.borrar(Consola.leerAlquiler());
			System.out.println("Alquiler borrado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarClientes() {

	}

	private void listarTurismos() {

	}

	private void listarAlquileres() {

	}

	private void listarAlquileresCliente() {

	}

	private void listarAlquileresTurismo() {

	}
}
