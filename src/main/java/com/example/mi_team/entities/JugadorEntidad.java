package com.example.mi_team.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "jugador")
public class JugadorEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String posicion;
	
	private String pais;
	
	@ManyToMany(mappedBy = "jugadores")
	@JsonIgnoreProperties("jugadores")
	private Set<EquipoEntidad> equipos = new HashSet<>();
	
	public JugadorEntidad() {
		
	}
	
	public JugadorEntidad(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public JugadorEntidad(int id, String nombre, String posicion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.posicion = posicion;
	}
	
	public JugadorEntidad(int id, String nombre, String posicion, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.posicion = posicion;
		this.pais = pais;
	}
	
	public JugadorEntidad(int id, String nombre, String posicion, String pais,
						  Set<EquipoEntidad> equipos) {
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
	
	public Set<EquipoEntidad> getEquipos() {
		return equipos;
	}

	public void setEquipos(Set<EquipoEntidad> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "JugadorEntidad [id=" + id + ", nombre=" + nombre + ", posicion=" + posicion + ", pais=" + pais
				+ ", equipos=" + equipos + "]";
	}
	
}
