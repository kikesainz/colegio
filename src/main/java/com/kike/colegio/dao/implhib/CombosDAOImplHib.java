package com.kike.colegio.dao.implhib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kike.colegio.dao.CombosDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.utils.DBUtils;

public class CombosDAOImplHib implements CombosDAO{

	@Override
	public List<ComboDTO> comboMunicipios() {
		
		String hql = "select new com.kike.colegio.dtos.ComboDTO (a.idMunicipio, a.nombre)" + " FROM MunicipiosEntity a ";
		
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();


		Query query = s.createQuery(hql);
		List<ComboDTO> lista = query.getResultList();
		s.close(); // Cerramos la sesión

		return lista;
	}
	
	@Override
	public List<ComboDTO> comboAlumnos() {
		String sql = "SELECT * FROM alumnos ORDER BY nombre";
		List<ComboDTO> listaAlumnos = new ArrayList<>();
		
		try {
			Connection connection = DBUtils.DBConnection();			
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			

			while (rs.next()) {

				ComboDTO a = new ComboDTO(rs.getInt(1), rs.getString(2));
				listaAlumnos.add(a);

			}

			return listaAlumnos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return null;
	}

	@Override
	public List<ComboDTO> comboAsignaturas() {
		String sql = "SELECT * FROM asignaturas ORDER BY nombre";
		List<ComboDTO> listaAsignaturas = new ArrayList<>();
		
		try {
			Connection connection = DBUtils.DBConnection();			
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			

			while (rs.next()) {

				ComboDTO a = new ComboDTO(rs.getInt(1), rs.getString(2));
				listaAsignaturas.add(a);

			}

			return listaAsignaturas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return null;
	}

}
