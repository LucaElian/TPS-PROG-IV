package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import entidad.Producto;
import java.sql.CallableStatement;
public class DaoProducto {
	private String host = "jdbc:mysql://localhost:3306/"; 
	private String dbName = "bdinventario";
	private String user = "root";
	private String pass = "root";
	
	public DaoProducto() { }
	
	private Connection obtenerConexion() throws SQLException {
		return DriverManager.getConnection(host + dbName, user, pass);
	}
	
	// metodo de alta Producto
	
	public int altaProducto(Producto producto) {
		
		String query = "{ call sp_AgregarProducto(?, ?, ?, ?, ?)}";
		
		try (
			Connection cn = obtenerConexion();
			CallableStatement cs = cn.prepareCall(query);
		    
			
		){
			cs.setString(1, producto.getCodigo());
			cs.setString(2, producto.getNombre());
			cs.setDouble(3, producto.getPrecio());
			cs.setInt(4, producto.getStock());
			cs.setInt(5, producto.getCategoria().getIdCategoria());
			
			return cs.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
