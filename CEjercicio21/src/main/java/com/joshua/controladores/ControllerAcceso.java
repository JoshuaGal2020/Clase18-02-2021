package com.joshua.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joshua.DAO.ClsUsuario;
import com.joshua.entidades.*;
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
		//
		clsLogin clsL = new clsLogin();
		usuario log = new usuario();
		
		log.setUsuario(user);
		log.setPass(pass);
		
		
		
		int valordeaceso=clsL.acceso(log);
		
		if(valordeaceso==1) {
			
			if (valordeaceso == 1) {
				//Este es un usuario Administrador
				System.out.println("> Usted ha iniciado como Administrador.");
				response.sendRedirect("Administrador.jsp");
			} else if (valordeaceso == 2) {
				//Este es un usuario normal
				System.out.println("> Usted ha iniciado como Usuario.");
				response.sendRedirect("Usuario.jsp");
			} else {
				System.out.println("> Error.");
				response.sendRedirect("Error.jsp");
			}
	}
}
}
