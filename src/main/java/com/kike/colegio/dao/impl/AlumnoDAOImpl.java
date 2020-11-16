package com.kike.colegio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dtos.Alumno;
import com.kike.colegio.utils.DBUtils;

public class AlumnoDAOImpl implements AlumnoDAO {

	@Override
	public List<Alumno> obtenerTodosAlumnos() {

		List<Alumno> listaAlumnos = new ArrayList<>();
		
		try {
			Connection connection = DBUtils.DBConnection();			 
			Statement st = connection.createStatement();
			ResultSet  rs = st.executeQuery("SELECT * FROM ALUMNOS");
			
			while (rs.next()) {				
				Alumno a = new Alumno(rs.getInt(1), rs.getString(2), "");
				listaAlumnos.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return listaAlumnos;
	}

	@Override
	public List<Alumno> obtenerAlumnosporIdyNombre(String id, String nombre) {
		String sql = "SELECT * FROM alumnos WHERE id LIKE ? AND nombre LIKE ?";
		
		ResultSet alumnoResultSet = null;
		Connection connection = DBUtils.DBConnection();
		List<Alumno> listaAlumnos = new ArrayList<>();
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");
			
			alumnoResultSet = ps.executeQuery();	
			
			while(alumnoResultSet.next()) {
				Alumno a = new Alumno (alumnoResultSet.getInt(1), alumnoResultSet.getString(2));
				listaAlumnos.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAlumnos;
	}

}
