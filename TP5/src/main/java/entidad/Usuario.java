package entidad;

public class Usuario {
	private int IdUsuario;
	private String nombre;
	private String pass;
	
	
	// constructores 
	
	public Usuario() { }
	
	public Usuario(String nombre, String pass) {
		this.nombre = nombre;
		this.pass = pass;
	}
	
	// getters y setters
	
	public int getIdUsuario() {
		return IdUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	// metodo toString
	
	@Override
	public String toString() {
		return "[" + IdUsuario + ", " + nombre + ", " + pass + "]";
	}
}