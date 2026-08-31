package ejercicio2;

public class Edificio {

	private double superficie; 

	//constructores
	public Edificio() {
		this.superficie = 0; 
	}
	
	public Edificio(double superficie) {
		this.superficie = superficie; 
	}
	
	//metodos
	public double getSuperficieEdificio() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	@Override
	public String toString() {
		return "La superficie es de " + superficie;
	}
	
	

}
