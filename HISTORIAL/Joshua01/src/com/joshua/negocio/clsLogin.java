package com.joshua.negocio;

import com.joshua.entidades.Login;

public class clsLogin {

	public int acceso(Login log)
	{
		int acess = 0;
		
		if(log.getUser().equals("Joshua") && log.getPass().equals("123"))
		{
			acess = 1;
		}
		
		return acess;
	}
}
