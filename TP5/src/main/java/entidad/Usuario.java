package entidad;

public class Usuario {
	private int IdUsuario;
	private String usuario;
	private String pass;
	
	
	// constructores 
	
	public Usuario() { }
	
	public Usuario(String usuario, String pass) {
		this.usuario = usuario;
		this.pass = pass;
	}
	
	// getters y setters
	
	public int getIdUsuario() {
		return IdUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
		return "[" + IdUsuario + ", " + usuario + ", " + pass + "]";
	}
}