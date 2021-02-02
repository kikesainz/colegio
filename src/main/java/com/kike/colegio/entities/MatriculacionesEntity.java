package com.kike.colegio.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;



@Entity
@Table(name = "matriculaciones")
public class MatriculacionesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_asignatura")
	private AsignaturasEntity asignaturas;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_alumno")
	private AlumnoEntity alumnos;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "activo")
	private Integer activo;


	

  //Constructores, Getters y setters 

    
    
	public MatriculacionesEntity(int id, int fecha, int activo, AlumnoEntity alumnos, AsignaturasEntity asignaturas) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.activo = activo;
		this.alumnos = alumnos;
		this.asignaturas = asignaturas;
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





	public AlumnoEntity getAlumnos() {
		return alumnos;
	}





	public void setAlumnos(AlumnoEntity alumnos) {
		this.alumnos = alumnos;
	}





	public AsignaturasEntity getAsignaturas() {
		return asignaturas;
	}





	public void setAsignaturas(AsignaturasEntity asignaturas) {
		this.asignaturas = asignaturas;
	}





}