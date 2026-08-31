package ejercicio2;

public class Polideportivo extends Edificio implements IInstalacionDeportiva {
	private String nombre;
	private int tipoDeInstalacion;
	
	// constructores
	
	public Polideportivo() {
		super();
		this.nombre = "Sin nombre";
		this.tipoDeInstalacion = 0;
	}

	public Polideportivo(double superficie, String nombre, int tipoDeInstalacion) {
		super(superficie);
		this.nombre = nombre;
		this.tipoDeInstalacion = tipoDeInstalacion;
	}

	// getters y setters

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

	// metodo toString()

	@Override
	public String toString() {
		return "POLIDEPORTIVO" + 
				"\n" + super.toString() +
				"\nnombre=" + nombre +
				"\ntipo=" + tipoDeInstalacion;
	}
}