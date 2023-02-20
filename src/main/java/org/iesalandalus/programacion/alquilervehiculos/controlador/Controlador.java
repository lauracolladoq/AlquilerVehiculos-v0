package org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Controlador {
	// Crea el constructor con parámetros que comprobará que no son nulos y los
	// asignará a los atributos. Además debe llamar al método setVista de la vista
	// con una instancia suya.
	public void Controlador(Modelo modelo, Vista vista) {

	}

	// Crea los métodos comenzar y terminar, que llamarán a los correspondientes
	// métodos en el modelo y en la vista
	public void comenzar() {

	}

	public void terminar() {

	}

	// Crea los demás métodos que simplemente harán una llamada al correspondiente
	// método del modelo.

	public void insertar(Cliente cliente) {

	}

	public void insertar(Turismo turismo) {

	}

	public void insertar(Alquiler alquiler) {

	}

	public Cliente buscar(Cliente cliente) {
		return cliente;

	}

	public Turismo buscar(Turismo turismo) {
		return turismo;
	}

	public Alquiler buscar(Alquiler alquiler) {
		return alquiler;
	}

	public void modificar(Cliente cliente, String nombre, String telefono) {

	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) {

	}

	public void borrar(Cliente cliente) {

	}

	public void borrar(Turismo turismo) {

	}

	public void borrar(Alquiler alquiler) {

	}

	public List<Cliente> getClientes() {
		return null;

	}

	public List<Turismo> getTurismos() {
		return null;

	}

	public List<Alquiler> getAlquileres() {
		return null;

	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		return null;

	}

	public List<Alquiler> getAlquileres(Turismo turismo) {
		return null;

	}

}
