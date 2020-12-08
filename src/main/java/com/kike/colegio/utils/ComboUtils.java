package com.kike.colegio.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kike.colegio.dao.CombosDAO;
import com.kike.colegio.dao.impl.CombosDAOImpl;
import com.kike.colegio.dtos.ComboDTO;

public class ComboUtils {

	
	public static void recuperacionComboMunicipios(HttpServletRequest request) {
		CombosDAO comboMunicipio = new CombosDAOImpl();
		List<ComboDTO> listaMunicipios = comboMunicipio.comboMunicipios();
		request.setAttribute("comboMunicipios", listaMunicipios);
	}
	
	
	public static void recuperarComboAlumnos(HttpServletRequest request) {
		//Recuperar todos los alumnos y meterlos en una lista		
		CombosDAO c = new CombosDAOImpl();		
		
		//Pasar la lista a la vista
		request.setAttribute("listaAlumnos", c.comboAlumnos());
	}
	
	public static void recuperarComboAsignaturas(HttpServletRequest request) {
		//Recuperar todos los asignaturas y meterlos en una lista		
		CombosDAO c = new CombosDAOImpl();		
		
		//Pasar la lista a la vista
		request.setAttribute("listaAsignaturas", c.comboAsignaturas());
	}
}
