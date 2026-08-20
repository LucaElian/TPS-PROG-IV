package ejercicio1;

public class Empleado extends Persona {

	private String puesto;
	private static int contLegajo = 1000;
	private final int legajo;
	
	
	//Constructor provisorio
	
	public Empleado() {
		this.legajo = contLegajo ++;
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
