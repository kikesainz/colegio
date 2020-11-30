package com.kike.colegio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kike.colegio.dao.AsignaturaDAO;
import com.kike.colegio.dtos.Alumno;
import com.kike.colegio.dtos.AsignaturaDTO;
import com.kike.colegio.utils.DBUtils;

public class AsignaturaDAOImpl implements AsignaturaDAO{

	@Override
	public List<AsignaturaDTO> obtenerAsignaturasporIdyNombre(String id, String nombre, String curso, String tasa) {
		String sql = "SELECT * FROM asignaturas WHERE id LIKE ? AND nombre LIKE ?  AND curso LIKE ? AND tasa LIKE ?";
		ResultSet asignaturasResultSet = null;
		Connection connection = DBUtils.DBConnection();
		List<AsignaturaDTO> listaAsignaturas = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");
			ps.setString(3, "%" + curso + "%");
			ps.setString(4, "%" + tasa + "%");

			asignaturasResultSet = ps.executeQuery();

			while (asignaturasResultSet.next()) {
				AsignaturaDTO a = new AsignaturaDTO(asignaturasResultSet.getString(1), asignaturasResultSet.getString(2), 
											asignaturasResultSet.getString(3), asignaturasResultSet.getString(4));
				listaAsignaturas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAsignaturas;
	}

}
