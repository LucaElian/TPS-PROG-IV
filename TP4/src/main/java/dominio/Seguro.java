package dominio;

public class Seguro {

	private int idSeguro;
	private String descripcion;
	private TipoSeguros tipoSeguro;
	private double costoContratacion;
	private double costoAsegurado;
	
	//Constructores
	public Seguro() {};
		
	public Seguro(int idSeguro, String descripcion, int idTipo, double costoContratacion,
			double costoAsegurado) {
		super();
		this.idSeguro = idSeguro;
		this.descripcion = descripcion;
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
		
		this.tipoSeguro = new TipoSeguros();
		this.tipoSeguro.setIdTipo(idTipo);
		
	}
	
	//Getters y setters
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoSeguros getTipoSeguro() {
	    return tipoSeguro;
	}
	public void setTipoSeguro(TipoSeguros tipoSeguro) {
	    this.tipoSeguro = tipoSeguro;
	}
	public Double getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(double costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	public Double getCostoAsegurado() {
		return costoAsegurado;
	}
	public void setCostoAsegurado(double costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}
	
	@Override
	public String toString() {
		return "Seguro\n" +
				"idSeguro: " + idSeguro + "\n" +
				"descripcion: " + descripcion + "\n" +
				"idTipo:" + tipoSeguro.getIdTipo() + "\n" +
				"costoContratacion: " + costoContratacion + "\n" +
				"costoAsegurado: " + costoAsegurado;
	}
		
	
}