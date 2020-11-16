package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dtos.Alumno;

public interface AlumnoDAO {
	
	List<Alumno> obtenerTodosAlumnos();
	List<Alumno> obtenerAlumnosporIdyNombre(String id, String nombre);

}
