package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import entidad.Categoria;

public class daoCategoria {
	
	private String host = "jdbc:mysql://localhost:3306/"; 
	private String dbName = "bdinventario"; 
	
	public daoCategoria() {
		
	}
	
	//metodo de alta Categoria
	public int altaCategoria(Categoria categoria) {
		
		String query = "Insert into categorias(Nombre)values('"+categoria.getNombre()+"')";
		Connection cn = null; 
		int filas = 0 ; 
		
		try {
			cn = DriverManager.getConnection(host+dbName); 
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filas; 
	}
	
}
