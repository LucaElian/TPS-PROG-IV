package entidad;

public class Producto {

	private String codigo;
	private String nombre;
	private double precio;
	private int stock;
	private Categoria categoria;

	public Producto() {
		this.codigo = "";
		this.nombre = "";
		this.precio = 0;
		this.stock = 0;
		this.categoria = new Categoria();
	}

	public Producto(String codigo, String nombre, double precio, int stock, Categoria categoria) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
	}

	

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

	// Metodo toString
	@Override
	public String toString() {
		return "Producto: " + codigo +
				", Nombre: " + nombre + 
				", Precio: " + precio + 
				", Stock: " + stock
				+ ", " + 
				(categoria != null ? categoria.toString() : "Sin categoria");
	}

}
