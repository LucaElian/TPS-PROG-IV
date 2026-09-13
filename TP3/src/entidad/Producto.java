package entidad;

public class Producto {
	private String codigo;
	private String nombre;
	private double precio;
	private int stock;
	private Categoria categoria;

	
	// constructores
	
	public Producto() {	}

	public Producto(String codigo, String nombre, double precio, int stock, int idCategoria) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;

		this.categoria = new Categoria();
		this.categoria.setIdCategoria(idCategoria);
	}

	// getters y setters

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// metodo toString
	
	@Override
	public String toString() {
		return "[" + codigo + ", " + nombre + ", " + precio + ", " + stock + ", " + categoria + "]";
	}
}