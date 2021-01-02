package com.kike.colegio.dao.implhib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.utils.DBUtils;

//
//import com.kike.colegiohibernate.dao.AlumnoDAO;
//import com.kike.colegiohibernate.dtos.Alumno;
//import com.kike.colegiohibernate.entidades.AlumnoEntity;
//import com.kike.colegiohibernate.utils.DBUtils;

public class AlumnoDAOImplHib implements AlumnoDAO {




	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() {
		String hql = " FROM AlumnoEntity";
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();

		Query query = s.createQuery(hql);
		List<AlumnoDTO> lista = query.getResultList();
		
		s.close(); //Cerramos la sesión
		
		return lista;
	}

	@Override
	public List<AlumnoDTO> obtenerAlumnosporIdyNombre(String id, String nombre) {
		String hql = " FROM AlumnoEntity a WHERE a.id ";
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();

		Query query = s.createQuery(hql);
		List<AlumnoDTO> lista = query.getResultList();
		
		s.close(); //Cerramos la sesión
		
		return lista;
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String idMunicipio, String famNumerosa) {
		
		AlumnoEntity a = new AlumnoEntity(Integer.parseInt(id), nombre, Integer.parseInt(id));
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		
		Integer idPk = (Integer) s.save(a);
		
		
		s.getTransaction().commit();
		
//		s.close();
		return idPk;
	}

	@Override
	public Integer actualizarAlumno(String idOld, String idNew, String nombre, String idMunicipio, String famNumerosa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarAlumno(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean esFamiliaNumerosa(String idAlumno) {
		// TODO Auto-generated method stub
		return false;
	}
}