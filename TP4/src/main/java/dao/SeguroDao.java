package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import dominio.Seguro;
import dominio.TipoSeguros;

public class SeguroDao {
	
	// METODO ALTA
	
	public int altaSeguro(Seguro seguro) {
		
		String query = "INSERT INTO seguros "
					 + "(descripcion, idTipo, costoContratacion, costoAsegurado) "
					 + "VALUES (?,?,?,?)";
		
		try
		( 
			Connection cn = Conexion.obtenerConexion(); 
			PreparedStatement pst = cn.prepareStatement(query)
		) {
			
			pst.setString(1, seguro.getDescripcion());
			pst.setInt(2, seguro.getTipoSeguro().getIdTipo());
			pst.setDouble(3, seguro.getCostoContratacion());
			pst.setDouble(4, seguro.getCostoAsegurado());
			
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// METODO LISTAR
	
	public ArrayList<Seguro> listarSeguros(int idTipo) {
		
		ArrayList<Seguro> listaS = new ArrayList<>();
		
		String query = "SELECT "
					 	+ "S.idSeguro, S.descripcion, "
					 	+ "T.idTipo, T.descripcion AS descripcionTipo, "
					 	+ "S.costoContratacion, S.costoAsegurado "
					 + "FROM seguros S "
					 + "INNER JOIN tipoSeguros T "
					 	+ "ON S.idTipo = T.idTipo";
		
		if (idTipo != 0)
			query += " WHERE S.idTipo = ?";
		
	    try (
	    	Connection cn = Conexion.obtenerConexion();
	    	PreparedStatement pst = cn.prepareStatement(query)
	    ) {
	    	
	    	if (idTipo != 0)
	    		pst.setInt(1, idTipo);
	    	
	    	try (
	    		ResultSet rs = pst.executeQuery()
	    	) {
	    		
	    		while (rs.next()) {
	    			TipoSeguros tipo = new TipoSeguros();
	    			
		    		tipo.setIdTipo(rs.getInt("idTipo"));
		            tipo.setDescripcion(rs.getString("descripcionTipo"));

		            Seguro seguro = new Seguro();

		            seguro.setIdSeguro(rs.getInt("idSeguro"));
		            seguro.setDescripcion(rs.getString("descripcion"));
		            seguro.setTipoSeguro(tipo);
		            seguro.setCostoContratacion(rs.getDouble("costoContratacion"));
		            seguro.setCostoAsegurado(rs.getDouble("costoAsegurado"));
		    	
		            listaS.add(seguro);
	    		}
	    	}
	    	
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    
	    return listaS;
	}
	
	// METODO PROXIMO ID
	
	public int obtenerProximoId() {

		String query = "SELECT MAX(idSeguro) FROM seguros";
		
		try 
		(
			Connection cn = Conexion.obtenerConexion();
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery()
		) {
			
			if (rs.next())
				return rs.getInt(1) + 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 1;
	}
}