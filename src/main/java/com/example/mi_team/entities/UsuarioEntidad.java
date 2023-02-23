package com.example.mi_team.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class UsuarioEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	//Entidad no propietaria
	@OneToOne(mappedBy = "usuario")
	@JsonIgnore
	private EquipoEntidad equipo;
	
	public UsuarioEntidad() {
		
	}
	
	public UsuarioEntidad(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public UsuarioEntidad(int id, String nombre, EquipoEntidad equipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.equipo = equipo;
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

	public EquipoEntidad getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoEntidad equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "UsuarioEntidad [id=" + id + ", nombre=" + nombre + ", equipo=" + equipo + "]";
	}
	
}