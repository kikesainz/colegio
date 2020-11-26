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
			ResultSet rs = st.executeQuery("SELECT * FROM ALUMNOS");

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
		// String sql = "SELECT * FROM alumnos WHERE id LIKE ? AND nombre LIKE ?";
		String sql = "SELECT a.id, a.nombre, m.nombre, m.id_municipio " + "FROM alumnos a, municipios m "
				+ "WHERE  a.id_municipio = m.id_municipio " + "AND a.id LIKE ? AND a.nombre LIKE ?";

		ResultSet alumnoResultSet = null;
		Connection connection = DBUtils.DBConnection();
		List<Alumno> listaAlumnos = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");

			alumnoResultSet = ps.executeQuery();

			while (alumnoResultSet.next()) {
				Alumno a = new Alumno(alumnoResultSet.getInt(1), alumnoResultSet.getString(2),
						alumnoResultSet.getString(3), alumnoResultSet.getInt(4));
				listaAlumnos.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAlumnos;
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String idMunicipio) {
		String sql = "INSERT INTO alumnos (id, nombre, id_municipio) VALUES (?, ?, ?)";
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setString(3, idMunicipio);

			resultado = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return resultado;
	}

	@Override
	public Integer actualizarAlumno(String idOld, String idNew, String nombre, String idMunicipio) {
		String sql = "UPDATE alumnos SET id= ?, nombre = ? ,id_municipio = ? WHERE id = ?";

		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, idNew);
			ps.setString(2, nombre);
			ps.setString(3, idMunicipio);
			ps.setString(4, idOld);

			resultado = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return resultado;
	}

	@Override
	public Integer borrarAlumno(String id) {
		String sql = "DELETE FROM alumnos WHERE id = ?";

		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, id);

			resultado = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return resultado;
	}

}
