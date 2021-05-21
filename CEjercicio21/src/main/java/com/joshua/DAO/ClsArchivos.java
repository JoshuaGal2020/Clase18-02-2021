package com.joshua.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.joshua.Conexion.ConexionBd;

public class ClsArchivos {
	
	public void guardararchivos(String nombre) {
		try {
			
			ConexionBd con = new ConexionBd();
			
			PreparedStatement stm;
			String consultad = "insert into imagen(Nombrearchivo) value(?)";
			
			stm = con.RetornarConexion().prepareStatement(consultad);
			stm.setString(1, nombre);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	public String seleccionararchivos() {
		ConexionBd con = new ConexionBd();
		
		String nombre = "";
		PreparedStatement stm;
		
		String consulta = "select * from imagen";
		try {
			stm = con.RetornarConexion().prepareStatement(consulta);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				nombre  = rs.getString("Nombrearchivo");			
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return nombre;
	}
	

}
