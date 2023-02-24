package com.example.mi_team.models;

import java.util.HashSet;

import java.util.Set;

public class JugadorModelo {
	
	private int id;

	private String nombre;
	
	private String posicion;
	
	private String pais;

	private Set<EquipoModelo> equipos = new HashSet<>();

	public JugadorModelo() {
		
	}
	
	public JugadorModelo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public JugadorModelo(int id, String nombre, String posicion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.posicion = posicion;
	}
	
	public JugadorModelo(int id, String nombre, String posicion, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.posicion = posicion;
		this.pais = pais;
	}
	
	public JugadorModelo(int id, String nombre, String posicion, String pais,
						  Set<EquipoModelo> equipos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.posicion = posicion;
		this.pais = pais;
		this.equipos = equipos;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Set<EquipoModelo> getEquipos() {
		return equipos;
	}

	public void setEquipos(Set<EquipoModelo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "JugadorEntidad [id=" + id + ", nombre=" + nombre + ", posicion=" + posicion + ", pais=" + pais
				+ ", equipos=" + equipos + "]";
	}
	
}
