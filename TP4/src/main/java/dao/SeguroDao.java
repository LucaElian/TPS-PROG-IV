package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import dominio.Seguro;

public class SeguroDao {
	
	public int altaSeguro(Seguro seguro) {
		
		String query = "INSERT INTO seguros (descripcion, idTipo, costoContratacion, costoAsegurado) VALUES (?,?,?,?)";
		
		try( Connection cn = Conexion.obtenerConexion(); PreparedStatement pst = cn.prepareStatement(query)) 
		{
			
			pst.setString(1, seguro.getDescripcion());
			pst.setInt(2, seguro.getTipoSeguro().getIdTipo());
			pst.setDouble(3, seguro.getCostoContratacion());
			pst.setDouble(4, seguro.getCostoAsegurado());
			
			int filas = pst.executeUpdate();
			
			return filas;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return -1;
		}
		
	}

	public int obtenerProximoId() {
		int proximoId = 1;
		String query = "SELECT MAX(idSeguro) FROM seguros";
		
		try (Connection cn = Conexion.obtenerConexion();
			 PreparedStatement pst = cn.prepareStatement(query);
			 ResultSet rs = pst.executeQuery()) {
			
			if (rs.next()) {
				proximoId = rs.getInt(1) + 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return proximoId;
	}

}


