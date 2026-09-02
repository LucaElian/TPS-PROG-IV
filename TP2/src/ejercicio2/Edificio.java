package ejercicio2;

public class Edificio {
	private double superficie; 

	
	// constructores
	
	public Edificio() {
		this.superficie = 0; 
	}
	
	public Edificio(double superficie) {
		this.superficie = superficie; 
	}
	
	// metodo getSuperficieEdificio
	
	public double getSuperficieEdificio() {
		return superficie;
	}

	// setter
	
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	// metodo toString
	
	@Override
	public String toString() {
		return "superficie= " + superficie;
	}
}