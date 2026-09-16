package entidad;

public class Categoria {
	private int idCategoria;
	private String nombre;
	private boolean estado;

	// constructores

	public Categoria() { }

	public Categoria(String nombre) { // Para agregar
		this.nombre = nombre;
	}

	public Categoria(int idCategoria, String nombre, boolean estado) { // Para modificar
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.estado = estado;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	// metodo toString()

	@Override
	public String toString() {
		return idCategoria + ", " + nombre + ", " +
				(this.estado ? "Activo" : "Inactivo");
	}
}