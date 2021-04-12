package com.joshua.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.joshua.Conexion.ConexionBd;
import com.joshua.entidades.usuario;

public class ClsUsuario {
	
	ConexionBd conexion = new ConexionBd();
    Connection con = conexion.RetornarConexion();
	
	
    public ArrayList<usuario> ListadoUSUARIOS() {
        ArrayList<usuario> Lista = new ArrayList<>();

        try {

            CallableStatement consulta = con.prepareCall("call SP_S_SOLOUSUARIOS()");
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                usuario user = new usuario();
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setUsuario(rs.getString("Usuario"));
                user.setPass(rs.getString("PassWord"));
                user.setIdTipoUsuario(rs.getInt("tipoUsuario"));
                Lista.add(user);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Ha ocurrido un error en: \n\n\n\n" + e);
        }

        return Lista;
    }
    	public void Eliminar(usuario user) {
    		try {
				CallableStatement consulta = con.prepareCall("call SP_D_USUER(?)");
				consulta.setInt("pIdUsuario", user.getIdUsuario());
				consulta.executeQuery();
				System.out.println("EXITO DE ELIMINACION");
				con.close();
				
			} catch (Exception e) {
				System.out.println(e);
			}
    	}
    	public void Actualizar(usuario user) {
    		try {
    			CallableStatement consulta = con.prepareCall("call SP_U_USUARIO(?,?,?)");
    			consulta.setString("PUsuario", user.getUsuario());
    			consulta.setString("PPass", user.getPass());
    			consulta.setInt("PidUsuario", user.getIdUsuario());
    			consulta.executeQuery();
    			System.out.println("Actualizado");
    			con.close();
    		} catch (Exception e) {
    			System.out.println(e);
    		}
    	}
    	
    	public void Agregar(usuario user) {
    		try {
    			CallableStatement consulta = con.prepareCall("call SP_I_USUARIO(?,?,?)");
    			consulta.setString("PUsuario", user.getUsuario());
    			consulta.setString("PPass", user.getPass());
    			consulta.setInt("PTipoUsuario", user.getIdTipoUsuario());
    			consulta.executeQuery();
    			System.out.println("Agregado");
    			con.close();
    		} catch (Exception e) {
    			System.out.println(e);
    		}
    	}
}
