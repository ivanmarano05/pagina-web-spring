package com.example.mi_team.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "pelota")
public class PelotaEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String imagen;
	
	@OneToMany(mappedBy = "pelota", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private Set<EquipoEntidad> equipos;
	
	public PelotaEntidad() {
		
	}
	
	public PelotaEntidad(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public PelotaEntidad(int id, String nombre, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
	}
	
	public PelotaEntidad(int id, String nombre, String imagen, Set<EquipoEntidad> equipos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
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
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public Set<EquipoEntidad> getEquipo() {
		return equipos;
	}

	public void setEquipo(Set<EquipoEntidad> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "PelotaEntidad [id=" + id + ", nombre=" + nombre + ", equipo=" + equipos + "]";
	}
	
}
