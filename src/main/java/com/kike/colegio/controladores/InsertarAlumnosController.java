package com.kike.colegio.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.CombosDAO;
import com.kike.colegio.dao.impl.CombosDAOImpl;
import com.kike.colegio.dtos.ComboDTO;

/**
 * Servlet implementation class InsertarAlumnosController
 */

@WebServlet("/insertaralumno")
public class InsertarAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarAlumnosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-Recuperar de la BBDD todos los municipios y meterlos en una lista
		
		CombosDAO comboMunicipio = new CombosDAOImpl();
		List<ComboDTO> listaMunicipios = comboMunicipio.comboMunicipios();
		
		//2-Pasar la lista a la vista
		
		request.setAttribute("comboMunicipios", listaMunicipios);
		
		
		//3-Redirigir a la vista
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/insertarAlumnos.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
