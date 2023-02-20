package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private void Consola() {

	}

	// mostrará por pantalla el mensaje pasado por parámetro y luego mostrará un
	// subrayado compuesto de guiones con su misma longitud.
	private static void mostrarCabecera(String mensaje) {
		System.out.println(mensaje);
		System.out.println("-".repeat(mensaje.length()));

	}

	// mostrará una cabecera informando del cometido de la aplicación y mostrará las
	// diferentes opciones del menú.
	private static void mostrarMenu() {
		System.out.println("Menú de opciones");

		for (int i = 0; i < (Opcion.values().length); i++) {
			System.out.println(Opcion.values()[i]);
		}
	}

	// mostrará el mensaje pasado por parámetro y devolverá la cadena que lea por
	// consola.
	private static String leerCadena(String mensaje) {
		System.out.println(mensaje);
		return Entrada.cadena();

	}

	private static Integer leerEntero(String mensaje) {
		System.out.println(mensaje);
		return Entrada.entero();

	}
	// hará lo mismo, pero con una fecha. Deberá repetir la lectura mientras la
	// fecha no se haya podido crear correctamente

	private static LocalDate leerFecha(String mensaje) {
		LocalDate fecha = null;
		try {
			System.out.println(mensaje);
			String cadena = Entrada.cadena();
			fecha = LocalDate.parse(cadena, FORMATO_FECHA);

		} catch (DateTimeParseException e) {
			System.out.println("La fecha no es válida, inténtalo de nuevo");
			fecha = null;
		}
		return fecha;
	}

	// leerá un entero (utilizando el método anteriormente creado) asociado a la
	// opción y devolverá la opción correspondiente. Si el entero introducido no se
	// corresponde con ninguna opción deberá volver a leerlo hasta que éste sea
	// válido.
	public static Opcion elegirOpcion() {
		Opcion opcion = null;
		leerEntero(String mensaje);
		return entero;
		do {
			leerEntero(mensaje);

		} while (entero != null);
	}

	public static Cliente leerCliente() {
		return null;

	}

	public static Cliente leerClienteDni() {
		return null;

	}

	public static String leerNombre() {
		return null;

	}

	public static String leerTelefono() {
		return null;

	}

	public static Turismo leerTurismo() {
		return null;

	}

	public static Turismo leerTurismoMatricula() {
		return null;

	}

	public static Alquiler leerAlquiler() {
		return null;

	}

	public static LocalDate leerFechaDevolucion() {
		return null;

	}
}
