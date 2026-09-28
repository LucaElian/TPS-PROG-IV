package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String URL = "jdbc:mysql://localhost:3306/segurosgroup";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	private Conexion() { }
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection obtenerConexion() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}
}