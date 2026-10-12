package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;

public class ClienteDao {

	public boolean existeDni(String dni) {
		String query = "SELECT 1 FROM clientes WHERE dni = ?";
		
		try (
			Connection cn = Conexion.obtenerConexion();
			PreparedStatement pst = cn.prepareStatement(query)
		) {
			pst.setString(1, dni);
			
			try (ResultSet rs = pst.executeQuery()) {
				return rs.next();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	

	public boolean existeDniYCuil(String dni, String cuil) {
		String query = "SELECT 1 FROM clientes WHERE dni = ? AND cuil = ?";
		
		try (
			Connection cn = Conexion.obtenerConexion();
			PreparedStatement pst = cn.prepareStatement(query)
		) {
			pst.setString(1, dni);
			pst.setString(2, cuil);
			
			try (ResultSet rs = pst.executeQuery()) {
				return rs.next();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
