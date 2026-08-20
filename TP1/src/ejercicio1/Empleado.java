package ejercicio1;

import java.time.LocalDate;

public class Empleado extends Persona {

	private String puesto;
	private static int contLegajo = 1000;
	private final int legajo;
	
	
	//Constructor provisorio
	
	public Empleado() {
		this.legajo = contLegajo ++;
	}
	
	
	 // Constructor con parámetros (recibe atributos de Persona y puesto de Empleado, legajo se autogenera)
    public Empleado(String dni, String nombre, String apellido, LocalDate fechaNacimiento, int edad,
                    String genero, String direccion, String telefono, String email, String puesto) {
        super(dni, nombre, apellido,edad, fechaNacimiento, genero, direccion, telefono, email);
        this.legajo = contLegajo++;
        this.puesto = puesto;
    }
    
   
    
    

	
	// getters y setters

	public int getLegajo() {
		return legajo;
	}


	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	// metodo ToString()

	@Override
	public String toString() {
		return super.toString() + "\nlegajo=" + legajo + "\npuesto=" + puesto;
	}
}
