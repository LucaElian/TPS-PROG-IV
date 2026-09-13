package entidad;

public class Categoria {
	private int idCategoria;
	private String nombre;
	
	
	// constructores
	
	public Categoria() { }
	
	public Categoria(String nombre) {
		this.nombre = nombre;
	}
	
	public Categoria(int idCategoria, String nombre) {
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}
	
	// getters y setters
	
	public int getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(int idCatetgoria) {
		this.idCategoria = idCatetgoria;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// metodo toString()
	
	@Override
	public String toString() {
		return idCategoria + ", " + nombre;
	}	
}