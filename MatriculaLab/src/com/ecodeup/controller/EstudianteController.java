package com.ecodeup.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecodeup.dao.EstudianteDAO;
import com.ecodeup.model.Estudiante;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet(description = "Administra peticion", urlPatterns = { "/estudiante" })
public class EstudianteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EstudianteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = request.getParameter("opcion");
		
		if(opcion.equals("registrar")) {
			System.out.println("opcion Registrarse presionada");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/views/registrar.jsp");
			requestDispatcher.forward(request, response);
		}else if(opcion.equals("listar")) {
			
			EstudianteDAO estudianteDAO=new EstudianteDAO();
			List<Estudiante> lista = new ArrayList<>();
			try {
				lista=estudianteDAO.obtenerProductos();
				for(Estudiante estudiante : lista) {
					System.out.println(estudiante);
				}
				request.setAttribute("lista",lista);
				
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("opcion Listar presionada");
			
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		EstudianteDAO estudianteDAO = new EstudianteDAO(); 
		Estudiante estudiante = new Estudiante();
		estudiante.setCui(Integer.parseInt(request.getParameter("cui")));
		estudiante.setNombres(request.getParameter("nombres"));
		estudiante.setApellidos(request.getParameter("apellidos"));
		estudiante.setCorreo(request.getParameter("correo"));
		
		try {
			estudianteDAO.guardar(estudiante);
			System.out.println("Registro guardado");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//doGet(request, response);
	}

}
