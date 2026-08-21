package ejercicio1;

import java.time.LocalDate;

public class Empleado extends Persona {
	
	private final int legajo;
	private String puesto;
	
	private static int contLegajo = 1000;
	
	
	// constructores
	
	public Empleado() {
		
		super();
		this.legajo = contLegajo++;
		this.puesto = "";
	}
	
	
    public Empleado(String dni, String nombre, String apellido, 
    				int edad, LocalDate fechaNacimiento, String genero, 
					String direccion, String telefono, String email, String puesto) {
        super(dni, nombre, apellido, edad, fechaNacimiento, genero, direccion, telefono, email);
        
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
		return super.toString() + 
				"\nlegajo=" + legajo +
				"\npuesto=" + puesto;
	}
	
	// metodo devuelveProximoLegajo()
	public static int devuelveProximoLegajo() {
		return contLegajo; 
	}
	
}
