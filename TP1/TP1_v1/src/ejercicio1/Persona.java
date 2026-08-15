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
    
    public Persona() {
        this.nombre = "sin nombre";
        this.edad = 0;
        this.dni = "";
        this.apellido = "";
        this.fechaNacimiento = null;
        this.genero = "";
        this.direccion = "";
        this.telefono = "";
        this.email = "";
    }
    
}
