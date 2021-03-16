package com.joshua.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joshua.DAO.ClsUsuario;
import com.joshua.entidades.Login;
import com.joshua.negocio.clsLogin;

/**
 * Servlet implementation class ControllerAcceso
 */
@WebServlet("/ControllerAcceso")
public class ControllerAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAcceso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		Login log = new Login();
		clsLogin clsL = new clsLogin();
		
		log.setUser(user);
		log.setPass(pass);
		
		int valordeaceso=clsL.acceso(log);
		
		if(valordeaceso==1) {
			
		System.out.println("WELCOME");
		
		ClsUsuario clsUsuario = new ClsUsuario();
		
		var usuario = clsUsuario.ListadoUSUARIOS();
		
		for(var iteracion: usuario)
		{
			System.out.print(iteracion.getUsuario());
		}
		
		
		
		response.sendRedirect("SALUDO.jsp");
		}else {
			System.out.println("ERROR");
			response.sendRedirect("Error.jsp");
		}
	}

}
