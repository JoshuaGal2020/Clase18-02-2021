package com.joshua.negocio;

import com.joshua.DAO.ClsLoginBD;
import com.joshua.entidades.*;

public class clsLogin {

	public int acceso(usuario log) {
		int acceso = 0;
		ClsLoginBD clsLoginBD = new ClsLoginBD();
		usuario user = new usuario();
		
		user = clsLoginBD.ValidarLogin(log);
		if (user != null) {
			if (user.getTipoUsuario() == 1) {
				acceso = 1;
				System.out.println(user.getTipoUsuario());
			} else if (user.getTipoUsuario() == 2) {
				acceso = 2;
				System.out.println(user.getTipoUsuario());
			}
		} else {
			System.out.println("El usuario no existe");
		}
		return acceso;
	}
}
