package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {
	private List<Alquiler> coleccionAlquileres;

	// creará la lista
	public Alquileres() {
		coleccionAlquileres = new ArrayList<Alquiler>();
	}

	// devolverá una nueva lista con los mismos elementos (no debe crear nuevas
	// instancias)
	public ArrayList<Alquiler> get() {
		return new ArrayList<Alquiler>(coleccionAlquileres);
	}

	// para un cliente dado, que devolverá una nueva lista con los alquileres para
	// dicho cliente (no debe crear nuevas instancias).
	public ArrayList<Alquiler> get(Cliente cliente) {
		List<Alquiler> alqCliente = new ArrayList<Alquiler>();
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getCliente().equals(cliente)) {
				alqCliente.add(alquiler);
			}
		}
		return (ArrayList<Alquiler>) alqCliente;

	}

	// para un turismo dado, que devolverá una nueva lista con los alquileres para
	// dicho turismo (no debe crear nuevas instancias).
	public ArrayList<Alquiler> get(Turismo turismo) {
		List<Alquiler> alqTurismo = new ArrayList<Alquiler>();
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getTurismo().equals(turismo)) {
				alqTurismo.add(alquiler);
			}
		}
		return (ArrayList<Alquiler>) alqTurismo;
	}

	// devolverá la cantidad de elementos que contiene la lista
	public int getCantidad() {
		return coleccionAlquileres.size();
	}

	// comprobará que en la lista no existe ningún alquiler sin devolver ni para el
	// cliente ni para el turismo y que tampoco hay un alquiler devuelto, del
	// cliente o del turismo, con fecha de devolución posterior a la fecha en la que
	// se pretende alquiler.

	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler)
			throws OperationNotSupportedException {
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getCliente().equals(cliente) && alquiler.getFechaDevolucion() == null) {
				throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
			}
			if (alquiler.getTurismo().equals(turismo) && alquiler.getFechaDevolucion() == null) {
				throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
			}
			if (alquiler.getCliente().equals(cliente) && alquiler.getFechaDevolucion() != null) {
				if (alquiler.getFechaDevolucion().isAfter(fechaAlquiler) || alquiler.getFechaDevolucion().isEqual(fechaAlquiler)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
				}
			}
			if (alquiler.getTurismo().equals(turismo) && alquiler.getFechaDevolucion() != null) {
				if (alquiler.getFechaDevolucion().isAfter(fechaAlquiler) || alquiler.getFechaDevolucion().isEqual(fechaAlquiler)) {
					throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
				}
			}

		}

	}

	// añadirá un alquiler a la lista si éste no es nulo y pasa la comprobación
	// anterior
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}

		comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
		coleccionAlquileres.add(alquiler);
	}

	// devolverá (asignará la fecha de devolución) si éste existe en la lista o
	// lanzará la excepción en caso contrario.
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		}
		if (buscar(alquiler) != alquiler) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}

		if (buscar(alquiler) != null) {
			// indexOf saca la posición y al método get tienes que pasarle una posición
			coleccionAlquileres.get(coleccionAlquileres.indexOf(alquiler)).devolver(fechaDevolucion);
		}

	}

	// devolverá el alquiler si éste se encuentra en la lista y null en caso
	// contrario
	Alquiler buscar(Alquiler alquiler) {
		Alquiler comodinBuscar = null;
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}
		if (coleccionAlquileres.indexOf(alquiler) != -1) {
			comodinBuscar = coleccionAlquileres.get(coleccionAlquileres.indexOf(alquiler));
		}
		return comodinBuscar;

	}

	// borrará el alquiler si éste existe en la lista o lanzará una excepción en
	// caso contrario.
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}
		if (buscar(alquiler) != alquiler) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		if (coleccionAlquileres.indexOf(alquiler) != -1) {
			coleccionAlquileres.remove((coleccionAlquileres.indexOf(alquiler)));
		}

	}

}
