package com.kike.colegio.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kike.colegio.dtos.Alumno;


/**
 * Servlet implementation class Inicio
 */

@WebServlet("/inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LoggerFactory.getLogger(Inicio.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Alumno> listaAlumnos = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String dbURL = "jdbc:mysql://localhost:3306/colegio";
			String username = "root";
			String password = "1234";
			Connection connection = DriverManager.getConnection(dbURL, username, password);
			
			Statement st = connection.createStatement();
			
			ResultSet  rs = st.executeQuery("SELECT * FROM ALUMNOS");
			
			while (rs.next()) {
				
				Alumno a = new Alumno(rs.getInt(1), rs.getString(2), "");
				listaAlumnos.add(a);
				
				
			}
			request.setAttribute("lista", listaAlumnos);
			RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/listadoAlumnos.jsp");
			d.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
