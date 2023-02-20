package org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {
	private Modelo modelo;
	private Vista vista;

	// Crea el constructor con parámetros que comprobará que no son nulos y los
	// asignará a los atributos. Además debe llamar al método setVista de la vista
	// con una instancia suya.
	public Controlador(Modelo modelo, Vista vista) {
		if (modelo == null) {
			throw new NullPointerException("No puedes crear un controlador con un modelo nulo");
		}

		if (vista == null) {
			throw new NullPointerException("No puedes crear un controlador con una vista nula");
		}
		this.vista = vista;
		this.modelo = modelo;

		vista.setControlador(this);
	}

	// Crea los métodos comenzar y terminar, que llamarán a los correspondientes
	// métodos en el modelo y en la vista
	public void comenzar() {
		modelo.comenzar();
		vista.comenzar();
	}

	public void terminar() {
		modelo.terminar();
		vista.terminar();
	}

	// Crea los demás métodos que simplemente harán una llamada al correspondiente
	// método del modelo.

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		modelo.insertar(cliente);
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		modelo.insertar(turismo);
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		modelo.insertar(alquiler);
	}

	public Cliente buscar(Cliente cliente) {
		return modelo.buscar(cliente);
	}

	public Turismo buscar(Turismo turismo) {
		return modelo.buscar(turismo);
	}

	public Alquiler buscar(Alquiler alquiler) {
		return modelo.buscar(alquiler);
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		modelo.modificar(cliente, nombre, telefono);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		modelo.devolver(alquiler, fechaDevolucion);
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		modelo.borrar(cliente);
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		modelo.borrar(turismo);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		modelo.borrar(alquiler);
	}

	public List<Cliente> getClientes() {
		return modelo.getClientes();

	}

	public List<Turismo> getTurismos() {
		return modelo.getTurismos();

	}

	public List<Alquiler> getAlquileres() {
		return modelo.getAlquileres();

	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		return modelo.getAlquileres(cliente);

	}

	public List<Alquiler> getAlquileres(Turismo turismo) {
		return modelo.getAlquileres(turismo);

	}

}
