package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class Clientes {
	Cliente cliente;

	private List<Cliente> coleccionClientes;

	public Clientes() {
		coleccionClientes = new ArrayList<Cliente>();
	}

	// devolverá una nueva lista con los mismos elementos (no debe crear nuevas
	// instancias)
	public List<Cliente> get() {
		return new ArrayList<Cliente>(coleccionClientes);
		// Devuelve un list pero en verdad de vuelve un ArrayList
	}

	// devolverá la cantidad de elementos que contiene la lista.
	public int getCantidad() {
		return coleccionClientes.size();
	}

	// añadirá un cliente a la lista si éste no es nulo y no existe aún en la lista.
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		if (coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		} else {
			coleccionClientes.add(cliente);
		}
	}

	// devolverá el cliente si éste se encuentra en la lista y null en caso
	// contrario.
	public Cliente buscar(Cliente cliente) {
		Cliente clienteComodin = null;
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		if (coleccionClientes.indexOf(cliente) != -1) {
			clienteComodin = coleccionClientes.get(coleccionClientes.indexOf(cliente));
		}
		return clienteComodin;

	}

	// borrará el cliente si éste existe en la lista o lanzará una excepción en caso
	// contrario.
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		if (buscar(cliente) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		} else {
			coleccionClientes.remove(cliente);
		}

	}

	// permitirá cambiar el nombre o el teléfono (si estos parámetros no son
	// nulos ni blancos) de un cliente existente y si no lanzará la correspondiente
	// excepción.
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		if (coleccionClientes.indexOf(cliente) == -1) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		} else {
			// Si el nombre no es nulo ni blanco, me deja cambiar el nombre
			if (nombre != null) {
				if (!nombre.isBlank()) {
					buscar(cliente).setNombre(nombre);
				}
			}

			if (telefono != null) {
				if (!telefono.isBlank()) {
					buscar(cliente).setTelefono(telefono);
				}
			}
		}

	}
}
