package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.CallableStatement;

import entidad.Categoria;
import entidad.Producto;

public class DaoProducto {
	private String host = "jdbc:mysql://localhost:3306/"; 
	private String dbName = "bdinventario";
	private String user = "root";
	private String pass = "root";
	
	public DaoProducto() { }
	
	private Connection obtenerConexion() throws SQLException {
		return DriverManager.getConnection(host + dbName, user, pass);
	}
	
	// metodo de modificacion Producto

	public int modificarProducto(Producto producto) {

		String query = "UPDATE Productos "
					 + "SET Nombre = ?, "
					 + "Precio = ?, "
					 + "Stock = ?, "
					 + "IdCategoria = ? ,"
					 + "Estado = ? "
					 + "WHERE Codigo = ?";

		try (
			Connection cn = obtenerConexion(); 
			PreparedStatement pst = cn.prepareStatement(query)
		) {

			pst.setString(1, producto.getNombre());
			pst.setDouble(2, producto.getPrecio());
			pst.setInt(3, producto.getStock());
			pst.setInt(4, producto.getCategoria().getIdCategoria());
			pst.setBoolean(5, producto.isEstado());
			pst.setString(6, producto.getCodigo());

			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// metodo de baja Producto

	public int bajaProducto(String codigo) {

		String query = "UPDATE Productos "
				 + "SET Estado = FALSE "
				 + "WHERE Codigo = ?";

		try (
			Connection cn = obtenerConexion(); 
			PreparedStatement pst = cn.prepareStatement(query)
		) {

			pst.setString(1, codigo);

			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// metodo de listado Producto

	public ArrayList<Producto> listarProductos() {
			
		ArrayList<Producto> productos = new ArrayList<>();
		String query = "SELECT p.Codigo, "
							+ "p.Nombre, "
							+ "p.Precio, "
							+ "p.Stock, "
							+ "p.Estado, "
							+ "c.IdCategoria, "
							+ "c.Nombre AS NombreCategoria "
					+ "FROM Productos p "
					+ "INNER JOIN Categorias c "
						+ "ON p.IdCategoria = c.IdCategoria "
					+ "WHERE p.Estado = TRUE "
					+ "AND c.Estado = TRUE";
		
		try (
			Connection cn = obtenerConexion();
			PreparedStatement pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery()
		) {
			
			while (rs.next()) {
				Producto producto = new Producto();
				Categoria categoria = new Categoria();

				producto.setCodigo(rs.getString("Codigo"));
				producto.setNombre(rs.getString("Nombre"));
				producto.setPrecio(rs.getFloat("Precio"));
				producto.setStock(rs.getInt("Stock"));

				categoria.setIdCategoria(rs.getInt("IdCategoria"));
				categoria.setNombre(rs.getString("NombreCategoria"));

				producto.setCategoria(categoria);
				
				producto.setEstado(rs.getBoolean("Estado"));
				
				productos.add(producto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return productos;
	}
	
	// metodo de alta Producto con procedimiento almacenado
	
	public int sp_AgregarProducto(Producto producto) {
		
		String query = "CALL sp_AgregarProducto(?, ?, ?, ?, ?)";
		
		try (
			Connection cn = obtenerConexion();
			CallableStatement cs = cn.prepareCall(query);
		) {
			
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