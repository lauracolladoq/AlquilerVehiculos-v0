package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {
	// es posible registrar un alquiler pasado (nuestro cliente a veces apunta los
	// alquileres y luego los pasa a la aplicación). La fecha de alquiler no puede
	// ser posterior a hoy. La fecha de devolución no puede ser igual o anterior a
	// la fecha de alquiler y tampoco puede ser posterior a hoy.
	static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int PRECIO_DIA = 29;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;

	// No salen en el diagrama pero se añaden para conectar las dos clases
	private Cliente cliente;
	private Turismo turismo;

	public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {
		setCliente(cliente);
		setTurismo(turismo);
		setFechaAlquiler(fechaAlquiler);
	}

	public Alquiler(Alquiler alquiler) {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		}
		setCliente(
				new Cliente(alquiler.cliente.getNombre(), alquiler.cliente.getDni(), alquiler.cliente.getTelefono()));
		setTurismo(new Turismo(alquiler.turismo.getMarca(), alquiler.turismo.getModelo(),
				alquiler.turismo.getCilindrada(), alquiler.turismo.getMatricula()));
		setFechaAlquiler(alquiler.fechaAlquiler);
		setFechaDevolucion(alquiler.fechaDevolucion);

	}

	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}
		this.cliente = cliente;
	}

	public Turismo getTurismo() {
		return turismo;
	}

	private void setTurismo(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		}

		this.turismo = turismo;
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	private void setFechaAlquiler(LocalDate fechaAlquiler) {
		if (fechaAlquiler == null) {
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
		if (fechaAlquiler.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		}
		this.fechaAlquiler = fechaAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	private void setFechaDevolucion(LocalDate fechaDevolucion) {
		if (fechaDevolucion == null) {
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		if (fechaDevolucion.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		// ERROR AQUI
		if (fechaDevolucion.compareTo(getFechaAlquiler()) <= 0) {
			throw new IllegalArgumentException(
					"ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		}

		this.fechaDevolucion = fechaDevolucion;
	}

	// se encargará de asignar la fecha de devoluión si ésta es correcta
	public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (getFechaDevolucion() != null) {
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
		} else {
			setFechaDevolucion(fechaDevolucion);
		}

	}

	// devolverá el precio del alquiler conforme a la fórmula establecida por
	// nuestro cliente y explicada anteriormente
	public int getPrecio() {
		long dias;

		if (getFechaDevolucion() == null) {
			dias = 0;
		} else {
			// Saco los días entre la fechaAlquiler y la fechaDevolucion
			dias = (int) ChronoUnit.DAYS.between(getFechaAlquiler(), getFechaDevolucion());
		}
		return (int) (PRECIO_DIA * dias);
	}

	// Un alquiler será igual a otro si es el mismo cliente, el mismo turismo y la
	// fecha de alquiler
	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(turismo, other.turismo);
	}

	@Override
	public String toString() {
		String cadena = null;
		if (getFechaDevolucion() == null) {
			cadena = String.format("%s <---> %s, %s - Aún no devuelto (%s€)", cliente, turismo,
					getFechaAlquiler().format(FORMATO_FECHA), getPrecio());
		} else {
			cadena = String.format("%s <---> %s, %s - %s (%s€)", cliente, turismo,
					getFechaAlquiler().format(FORMATO_FECHA), getFechaDevolucion().format(FORMATO_FECHA), getPrecio());
		}
		return cadena;

	}
}
