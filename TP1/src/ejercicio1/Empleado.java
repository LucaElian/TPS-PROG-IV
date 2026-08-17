package ejercicio1;

public class Empleado extends Persona {

	private int legajo;
	private String puesto;

	// constructor

	public Empleado() {
		super();
	}

	// getters y setters

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
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
