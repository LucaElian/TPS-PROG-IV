package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import entidad.Cliente;

public class ClienteDao {

	public int altaCliente(Cliente cliente) {
		int filas = 0;

		String query = "INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, fecha_nacimiento, "
				+ "direccion, nacionalidad, localidad, provincia, correo_electronico, telefono) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection cn = Conexion.obtenerConexion(); PreparedStatement pst = cn.prepareStatement(query)) {
			pst.setString(1, cliente.getDni());
			pst.setString(2, cliente.getCuil());
			pst.setString(3, cliente.getNombre());
			pst.setString(4, cliente.getApellido());
			pst.setString(5, cliente.getSexo());
			pst.setString(6, cliente.getFecha());
			pst.setString(7, cliente.getDireccion());
			pst.setString(8, cliente.getNacionalidad());
			pst.setString(9, cliente.getLocalidad());
			pst.setString(10, cliente.getProvincia());
			pst.setString(11, cliente.getCorreo());
			pst.setString(12, cliente.getTelefono());

			filas = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return filas;
	}

	public boolean existeDni(String dni) {
		String query = "SELECT 1 FROM clientes WHERE dni = ?";

		try (Connection cn = Conexion.obtenerConexion(); PreparedStatement pst = cn.prepareStatement(query)) {
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

		try (Connection cn = Conexion.obtenerConexion(); PreparedStatement pst = cn.prepareStatement(query)) {
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
	
	public ArrayList<Cliente> listarClientes() {

	    ArrayList<Cliente> listaClientes = new ArrayList<>();

	    String query = "SELECT * FROM clientes";

	    try (
	        Connection cn = Conexion.obtenerConexion();
	        PreparedStatement pst = cn.prepareStatement(query);
	        ResultSet rs = pst.executeQuery()
	    ) {

	        while (rs.next()) {

	            Cliente cliente = new Cliente();

	            cliente.setIdCliente(rs.getInt("id_cliente"));
	            cliente.setDni(rs.getString("dni"));
	            cliente.setCuil(rs.getString("cuil"));
	            cliente.setNombre(rs.getString("nombre"));
	            cliente.setApellido(rs.getString("apellido"));
	            cliente.setSexo(rs.getString("sexo"));
	            cliente.setFecha(rs.getString("fecha_nacimiento"));
	            cliente.setDireccion(rs.getString("direccion"));
	            cliente.setNacionalidad(rs.getString("nacionalidad"));
	            cliente.setLocalidad(rs.getString("localidad"));
	            cliente.setProvincia(rs.getString("provincia"));
	            cliente.setCorreo(rs.getString("correo_electronico"));
	            cliente.setTelefono(rs.getString("telefono"));

	            listaClientes.add(cliente);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return listaClientes;
	}

}
