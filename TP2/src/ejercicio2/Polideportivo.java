package ejercicio2;

public class Polideportivo extends Edificio implements IInstalacionDeportiva {

	// Atributos
	private String nombre;
	private int tipoDeInstalacion;
	
	// Constructores	
	public Polideportivo() {
		super();
		this.nombre = "Sin nombre";
		this.tipoDeInstalacion = 0;
	}

	public Polideportivo(String nombre, double superficie) {
		super(superficie);
		this.nombre = nombre;
		this.tipoDeInstalacion = 0;
	}

	public Polideportivo(String nombre, double superficie, int tipoDeInstalacion) {
		super(superficie);
		this.nombre = nombre;
		this.tipoDeInstalacion = tipoDeInstalacion;
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int getTipoDeInstalacion() {
		return tipoDeInstalacion;
	}

	public void setTipoDeInstalacion(int tipoDeInstalacion) {
		this.tipoDeInstalacion = tipoDeInstalacion;
	}

	// Metodo toString()

	@Override
	public String toString() {
		return "Polideportivo [Nombre: " + nombre + ", Tipo de instalacion: " + tipoDeInstalacion + ", " + super.toString() + "]";
	}
	
}
