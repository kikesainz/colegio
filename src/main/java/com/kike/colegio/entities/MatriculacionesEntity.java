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

	private CajaEntity caja;

}