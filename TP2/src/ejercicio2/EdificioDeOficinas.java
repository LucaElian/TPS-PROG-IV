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
}