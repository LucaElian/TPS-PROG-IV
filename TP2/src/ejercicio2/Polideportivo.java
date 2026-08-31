package ejercicio2;

public class Polideportivo extends Edificio {

	//Atributos
	private String nombre;
	
	//Constructores	
	public Polideportivo() {
		super();
		this.nombre = "Sin nombre";
	}

	public Polideportivo(String nombre, double superficie) {
		super(superficie);
		this.nombre = nombre;
	}

	//getters y setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
