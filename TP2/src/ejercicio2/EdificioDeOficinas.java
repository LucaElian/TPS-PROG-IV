package ejercicio2;

public class EdificioDeOficinas extends Edificio {
	private int cantidadOficinas;
	
	// constructores
	
	public EdificioDeOficinas() {
		super();
		this.cantidadOficinas = 0;
	}
	
	public EdificioDeOficinas(double superficie, int cantidadOficinas) {
		super(superficie);
		this.cantidadOficinas = cantidadOficinas;
	}
	
	// getters y setters
	
	public int getCantidadOficinas() {
		return cantidadOficinas;
	}
	
	public void setCantidadOficinas(int cantidadOficinas) {
		this.cantidadOficinas = cantidadOficinas;
	}

	//metodo toString 
	
	@Override
	public String toString() {
		return "EDIFICIO DE OFICINAS" +
				"\n[" + super.toString() + 
				", cantidad de oficinas= " + cantidadOficinas + "]\n";
	}
}