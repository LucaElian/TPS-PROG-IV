package entidad;

public class Categoria {

	private int idCategoria;
	private String nombre;
	
	public Categoria() {
		
	}
	
	public Categoria(int idCategoria, String nombre) {
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}
	
	
	public int getIdCatetgoria() {
		return idCategoria;
	}
	public void setIdCatetgoria(int idCatetgoria) {
		this.idCategoria = idCatetgoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categoria: " + idCategoria + ", nombre: " + nombre;
	}
	
	
	
}
