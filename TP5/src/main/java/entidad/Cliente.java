package entidad;

public class Cliente {
	private int idCliente;
	private String dni;
	private String cuil;
	private String nombre;
	private String apellido;
	private String sexo;
	private String fecha;
	private String direccion;
	private String nacionalidad;
	private String localidad;
	private String provincia;
	private String correo;
	private String telefono;

	
	// constructores
	public Cliente() { }

	public Cliente(String dni, String cuil, String nombre, String apellido, String sexo, String fecha, String direccion, 
								String nacionalidad, String localidad, String provincia, String correo, String telefono) {
		this.dni = dni;
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fecha = fecha;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
		this.localidad = localidad;
		this.provincia = provincia;
		this.correo = correo;
		this.telefono = telefono;
	}

	// getters y setters
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	// metodo toString
	
	@Override
	public String toString() {
		return "[" + idCliente + ", " + dni + ", " + cuil + ", " + nombre + ", "
				+ apellido + ", " + sexo + ", " + fecha + ", " + direccion + ", " 
					+ nacionalidad + ", " + localidad + ", " + provincia + ", "
						+ correo + ", " + telefono + "]";
	}
}