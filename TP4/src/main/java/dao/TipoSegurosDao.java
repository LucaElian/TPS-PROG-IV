package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;

import dominio.TipoSeguros;

public class TipoSegurosDao {
	
	public ArrayList<TipoSeguros> listarTipoSeguros() {

        ArrayList<TipoSeguros> listaTS = new ArrayList<>();

        String query = "SELECT idTipo, descripcion "
                      + "FROM tiposeguros";

        try (
            Connection cn = Conexion.obtenerConexion();
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery()
        ) {

            while (rs.next()) {

                TipoSeguros tipo = new TipoSeguros();

                tipo.setIdTipo(rs.getInt("idTipo"));
                tipo.setDescripcion(rs.getString("descripcion"));

                listaTS.add(tipo);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return listaTS;
    } 

}
