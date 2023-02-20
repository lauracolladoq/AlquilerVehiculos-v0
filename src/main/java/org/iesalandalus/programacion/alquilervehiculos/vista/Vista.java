package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

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
		Opcion elegirOpcion = null;
		do {
			elegirOpcion = Consola.elegirOpcion();
			Consola.mostrarMenu();
			ejecutar(elegirOpcion);
		} while (elegirOpcion != Opcion.SALIR);
	}

	// mostrará un mensaje de despedida por consola
	public void terminar() {
		System.out.println("Hasta luego Lucas!");
	}

	// dependiendo de la opción pasada por parámetro invocará a un método o a otro
	private void ejecutar(Opcion opcion) {
		switch (opcion.ordinal()) {
		case 0:
			terminar();
			break;
		case 1:
			insertarCliente();
			break;
		case 2:
			insertarTurismo();
			break;
		case 3:
			insertarAlquiler();
			break;
		case 4:
			buscarCliente();
			break;
		case 5:
			buscarTurismo();
			break;
		case 6:
			buscarAlquiler();
			break;
		case 7:
			modificarCliente();
			break;
		case 8:
			devolverAlquiler();
			break;
		case 9:
			borrarCliente();
			break;
		case 10:
			borrarTurismo();
			break;
		case 11:
			borrarAlquiler();
			break;
		case 12:
			listarClientes();
			break;
		case 13:
			listarTurismos();
			break;
		case 14:
			listarAlquileres();
			break;
		case 15:
			listarAlquileresCliente();
			break;
		case 16:
			listarAlquileresTurismo();
			break;
		}

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
		try {
			Consola.mostrarCabecera("Modificar cliente");
			controlador.modificar(Consola.leerCliente(), Consola.leerNombre(), Consola.leerTelefono());
			System.out.println("Cliente modificado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	private void devolverAlquiler() {
		try {
			Consola.mostrarCabecera("Devolver alquiler");
			controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
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
		try {
			Consola.mostrarCabecera("Listar clientes");
			for (Cliente clienteLista : controlador.getClientes()) {
				System.out.println(clienteLista);
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarTurismos() {
		try {
			Consola.mostrarCabecera("Listar turismos");
			for (Turismo turismoLista : controlador.getTurismos()) {
				System.out.println(turismoLista);
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

	private void listarAlquileres() {
		try {
			Consola.mostrarCabecera("Listar alquileres");
			for (Alquiler alquilerLista : controlador.getAlquileres()) {
				System.out.println(alquilerLista);
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

	private void listarAlquileresCliente() {
		try {
			Consola.mostrarCabecera("Listar alquileres por clientes");
			for (Alquiler alquilerListaCliente : controlador.getAlquileres(Consola.leerCliente())) {
				System.out.println(alquilerListaCliente);
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

	private void listarAlquileresTurismo() {
		try {
			Consola.mostrarCabecera("Listar alquileres por turismos");
			for (Alquiler alquilerListaTurismo : controlador.getAlquileres(Consola.leerTurismo())) {
				System.out.println(alquilerListaTurismo);
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}
}
