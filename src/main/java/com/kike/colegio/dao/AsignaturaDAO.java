package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dtos.Alumno;
import com.kike.colegio.dtos.AsignaturaDTO;

public interface AsignaturaDAO {
	
//	List<Alumno> obtenerTodosAlumnos();
	List<AsignaturaDTO> obtenerAsignaturaPorIdNombreCursoTasa(String id, String nombre, String curso , String tasa);
	Integer insertarAsignatura(String id, String nombre, String curso, String tasa);
	Integer actualizarAsignatura(String idOld, String idNew, String nombre, String curso, String tasa);
//	Integer borrarAlumno (String id);
}
