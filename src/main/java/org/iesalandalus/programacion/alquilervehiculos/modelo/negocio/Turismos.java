package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos {

	private List<Turismo> coleccionTurismos;

	// creará la lista
	public Turismos() {
		coleccionTurismos = new ArrayList<Turismo>();
	}

	// devolverá una nueva lista con los mismos elementos (no debe crear nuevas
	// instancias).
	public List<Turismo> get() {
		return new ArrayList<Turismo>(coleccionTurismos);
	}

	// devolverá la cantidad de elementos que contiene la lista
	public int getCantidad() {
		return coleccionTurismos.size();
	}

	// añadirá un turismo a la lista si éste no es nulo y no existe aún en la lista.
	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		if (coleccionTurismos.contains(turismo)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		} else {
			coleccionTurismos.add(turismo);
		}
	}

	// devolverá el turismo si éste se encuentra en la lista y null en caso
	// contrario.
	public Turismo buscar(Turismo turismo) {
		Turismo turismoComodin = null;
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}
		if (coleccionTurismos.indexOf(turismo) != -1) {
			turismoComodin = coleccionTurismos.get(coleccionTurismos.indexOf(turismo));
		}
		return turismoComodin;
	}

	// borrará el turismo si éste existe en la lista o lanzará una excepción en caso
	// contrario
	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}
		if (buscar(turismo) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		} else {
			coleccionTurismos.remove(turismo);
		}

	}

}
