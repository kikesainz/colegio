package com.kike.colegio.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class MatriculacionesEntity {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "id_asignatura")
	private String idAsignatura;

	@Column(name = "id_alumno")
	private int idAlumno;

	@Column(name = "fecha")
	private int fecha;
	
	@Column(name = "activo")
	private int activo;
	
	
	//Constructores, Getters y setters 
	
	
	public MatriculacionesEntity(int id, String idAsignatura, int idAlumno, int fecha, int activo) {
		super();
		this.id = id;
		this.idAsignatura = idAsignatura;
		this.idAlumno = idAlumno;
		this.fecha = fecha;
		this.activo = activo;
	}


	public MatriculacionesEntity() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIdAsignatura() {
		return idAsignatura;
	}


	public void setIdAsignatura(String idAsignatura) {
		this.idAsignatura = idAsignatura;
	}


	public int getIdAlumno() {
		return idAlumno;
	}


	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}


	public int getFecha() {
		return fecha;
	}


	public void setFecha(int fecha) {
		this.fecha = fecha;
	}


	public int getActivo() {
		return activo;
	}


	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	


	
	

}