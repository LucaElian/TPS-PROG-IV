package dominio;

public class TipoSeguro {
	
	private int idTipo; 
	private String descripcion; 
	
	//constructores 
	public TipoSeguro() {
		
	}
	
	public TipoSeguro(int idTipo, String descripcion) {
		this.idTipo = idTipo; 
		this.descripcion = descripcion;
	}

	//metodos get y set
	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoSeguro\n" +
				"idTipo: " + idTipo + "\n" +
				"descripcion" + descripcion ;
	}
	
	
}
