package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {
	Clientes clientes;
	Alquileres alquileres;
	Turismos turismos;

	public Modelo() {

	}

	// creará la instancia de las clases de negocio anteriores
	public void comenzar() {
		clientes = new Clientes();
		alquileres = new Alquileres();
		turismos = new Turismos();

	}

	// mostrará un mensaje informativo indicando que el modelo ha terminado.
	public void terminar() {
		System.out.println("El modelo ha terminado");
	}

	// Crea los diferentes métodos insertar, teniendo en cuenta que ahora ya si
	// insertaremos nuevas instancias utilizando los constructores copia

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		clientes.insertar(cliente);
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		turismos.insertar(turismo);
	}

	// en el caso de los alquileres, primero debe buscar el cliente y el turismo y
	// utilizar dichas instancias encontradas.
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		// Creo un nuevo cliente y le digo que me busque el alquiler de ese cliente
		Cliente clienteNuevo = clientes.buscar(alquiler.getCliente());
		if (clienteNuevo == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}
		Turismo turismoNuevo = turismos.buscar(alquiler.getTurismo());
		if (turismoNuevo == null) {
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}
		alquileres.insertar(new Alquiler(clienteNuevo, turismoNuevo, alquiler.getFechaAlquiler()));
	}

	// devolverá una nueva instancia del elemento encontrado si éste existe
	public Cliente buscar(Cliente cliente) {
		// Uso método buscar de la clase Clientes que eso ya me busca si cliente existe
		return new Cliente(clientes.buscar(cliente));

	}

	public Turismo buscar(Turismo turismo) {
		return new Turismo(turismos.buscar(turismo));
	}

	public Alquiler buscar(Alquiler alquiler) {
		return new Alquiler(alquileres.buscar(alquiler));
	}

	// invocará a su homólogo en la clase de negocio (modificar de clientes)
	public void modificar(Cliente cliente, String nombre, String teléfono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, teléfono);

	}

	// realizará la devolución, si es posible, del alquiler pasado
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		alquiler = alquileres.buscar(alquiler);
		if (alquiler == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}

		alquiler.devolver(fechaDevolucion);
	}

	// teniendo en cuenta que los borrados se realizarán en cascada, es decir, si
	// borramos un cliente también borraremos todos sus alquileres y lo mismo pasará
	// con los turismos.

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get(cliente)) {
			alquileres.borrar(alquiler);
		}
		clientes.borrar(cliente);
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get(turismo)) {
			alquileres.borrar(alquiler);
		}
		turismos.borrar(turismo);

	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.borrar(alquiler);
	}

	// deben devolver una nueva lista pero que contenga nuevas instancias no una
	// copia de los elementos.

	public List<Cliente> getClientes() {
		// Creo la lista en la que creo nueva instancias
		List<Cliente> listaClientes = new ArrayList<>();
		// Recorro la lista y esta me va creando nuevos clientes
		for (Cliente cliente : clientes.get()) {
			listaClientes.add(new Cliente(cliente));
		}
		return listaClientes;
	}

	public List<Turismo> getTurismos() {
		List<Turismo> listaTurismo = new ArrayList<>();
		for (Turismo turismo : turismos.get()) {
			listaTurismo.add(new Turismo(turismo));
		}
		return listaTurismo;
	}

	public List<Alquiler> getAlquileres() {
		List<Alquiler> listaAlquileres = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			listaAlquileres.add(new Alquiler(alquiler));
		}
		return listaAlquileres;
	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		List<Alquiler> listaAlquileresCliente = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get(cliente)) {
			listaAlquileresCliente.add(new Alquiler(alquiler));
		}
		return listaAlquileresCliente;
	}

	public List<Alquiler> getAlquileres(Turismo turismo) {
		List<Alquiler> listaAlquileresTurismo = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get(turismo)) {
			listaAlquileresTurismo.add(new Alquiler(alquiler));
		}
		return listaAlquileresTurismo;
	}

}
