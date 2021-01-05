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
public class CajaEntity {

	@Id
	@Column(name = "id")
	private int id;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idmatricula")
	private MatriculacionesEntity matriculacion;

	@Column(name = "importe")
	private Double importe;


}