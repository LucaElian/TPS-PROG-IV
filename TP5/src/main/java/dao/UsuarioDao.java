package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;

public class UsuarioDao {

	public boolean existeUsuario(String usuario, String pass) {
		
		String query = "SELECT 1 FROM usuarios "
					 + "WHERE usuario = ? AND contrasena = ?";
		
		try (
			Connection cn = Conexion.obtenerConexion();
			PreparedStatement pst = cn.prepareStatement(query)
		) {
			
			pst.setString(1, usuario);
			pst.setString(2, pass);
			
			try (ResultSet rs = pst.executeQuery()) {
				return rs.next();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}