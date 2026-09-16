package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Categoria;

public class DaoCategoria {
	private String host = "jdbc:mysql://localhost:3306/";
	private String dbName = "bdinventario";
	private String user = "root";
	private String pass = "root";

	public DaoCategoria() { }

	private Connection obtenerConexion() throws SQLException {
		return DriverManager.getConnection(host + dbName, user, pass);
	}

	// metodo de alta Categoria

	public int altaCategoria(Categoria categoria) {

		String query = "INSERT INTO categorias (Nombre) "
					 + "VALUES (?)";

		try (
			Connection cn = obtenerConexion(); 
			PreparedStatement pst = cn.prepareStatement(query)
		) {

			pst.setString(1, categoria.getNombre());

			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// metodo de modificacion Categoria

	public int modificarCategoria(Categoria categoria) {

		String query = "UPDATE categorias "
					 + "SET Nombre = ?, "
					 + "SET Estado = ?" 
					 + "WHERE IdCategoria = ?";

		try (
			Connection cn = obtenerConexion(); 
			PreparedStatement pst = cn.prepareStatement(query)
		) {

			pst.setString(1, categoria.getNombre());
			pst.setBoolean(2, categoria.isEstado());
			pst.setInt(3, categoria.getIdCategoria());

			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// metodo de baja Categoria

	public int bajaCategoria(int idCategoria) {

		String query = "UPDATE categorias "
	             	 + "SET Estado = FALSE "
	             	 + "WHERE IdCategoria = ?";
		try (
			Connection cn = obtenerConexion(); 
			PreparedStatement pst = cn.prepareStatement(query)
		) {

			pst.setInt(1, idCategoria);

			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// metodo de listado Categoria

	public ArrayList<Categoria> listaCategorias() {
		
		ArrayList<Categoria> categorias = new ArrayList<>();
		String query = "SELECT * FROM categorias";
		
		try (
			Connection cn = obtenerConexion(); 
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery()
		) {
			
			while(rs.next()) {
				Categoria cat = new Categoria();
				cat.setIdCategoria(rs.getInt("IdCategoria"));
				cat.setNombre(rs.getString("Nombre"));
				cat.setEstado(rs.getBoolean("Estado"));
				
				categorias.add(cat);			
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return categorias;
	}
}