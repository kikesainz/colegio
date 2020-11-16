package com.kike.colegio.dtos;

public class Alumno {
	
	private Integer id;
	private String nombre;
	private String municipio;
	
	
	public Alumno() {
		super();
	}
	
	


	public Alumno(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}




	public Alumno(Integer id, String nombre, String municipio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.municipio = municipio;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	
	
	
	

}
