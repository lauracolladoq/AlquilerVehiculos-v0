package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {
	/// Crea el enumerado Opcion que contendrá las diferentes opciones de nuestro
	/// menú de opciones y que será utilizado posteriormente para mostrar las
	/// posibles opciones a realizar. Cada instancia debe estar parametrizada con
	/// una cadena con el texto adecuado a mostrarnos.
	SALIR("Salir"), INSERTAR_CLIENTE("Insertar cliente"), INSERTAR_TURISMO("Insertar turismo"),
	INSERTAR_ALQUILER("Insertar alquiler"), BUSCAR_CLIENTE("Buscar cliente"), BUSCAR_TURISMO("Buscar turismo"),
	BUSCAR_ALQUILER("Buscar alquiler"), MODIFICAR_CLIENTE("Modificar cliente"), DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"), BORRAR_TURISMO("Borrar turismo"), BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"), LISTAR_TURISMOS("Listar turismos"), LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar alquileres del cliente"),
	LISTAR_ALQUILERES_TURISMO("Listar alquileres del turismo");

	// Crea el atributo con el texto a mostrar que será asignado en el constructor
	// con parámetro, que también debes crear.
	private String texto;

	private Opcion(String texto) {
		this.texto = texto;
	}

	// Crea el método esOrdinalValido que comprobará si el ordinal pasado se
	// encuentra entre los ordinales válidos o no.
	private static boolean esOrdinalValido(int ordinal) {
		boolean comodin = false;
		if (ordinal >= 0 && ordinal < Opcion.values().length) {
			comodin = true;
		}
		return comodin;

	}

	// Crea el método get que devolverá la opción adecuada si el ordinal pasado es
	// correcto y lanzará una excepción en caso contrario.
	public static Opcion get(int ordinal) {
		Opcion comodin = null;
		if (esOrdinalValido(ordinal)) {
			comodin = Opcion.values()[ordinal];
		} else {
			throw new NullPointerException("ERROR: El parámetro introducido no es adecuado");
		}
		return comodin;

		// Crea el método toString que devuelva una cadena con el ordinal y el texto de
		// la opción que luego utilizaremos para mostrar las diferentes opciones del
		// menú.
	}

	@Override
	public String toString() {
		return String.format("%d. %s", ordinal(), texto);
	}

}
