package ejercicio1;

import java.time.LocalDate;

public class Persona {
	private String dni;
	private String nombre;
	private String apellido;
	private int edad;
	private LocalDate fechaNacimiento;
	private String genero;
	private String direccion;
	private String telefono;
	private String email;

	// constructor

	public Persona() {
		this.dni = "";
		this.nombre = "sin nombre";
		this.apellido = "";
		this.edad = 99;
		this.fechaNacimiento = null;
		this.genero = "";
		this.direccion = "";
		this.telefono = "";
		this.email = "";
	}

	public Persona(String dni, String nombre, String apellido, int edad, LocalDate fechaNacimiento, String genero,
			String direccion, String telefono, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	// getters y setters

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// metodo toString()

	@Override
	public String toString() {
		return "DNI=" + dni + "\nnombre=" + nombre + "\napellido=" + apellido + "\nedad=" + edad + "\nfechaNacimiento="
				+ fechaNacimiento + "\ngenero=" + genero + "\ndireccion=" + direccion + "\ntelefono=" + telefono
				+ "\nemail=" + email;
	}
}
