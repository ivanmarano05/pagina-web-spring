package com.example.mi_team.models;

import javax.validation.constraints.Size;

public class PelotaModelo {
	
	private int id;
	
	@Size(min = 5, max = 30)
	private String nombre;
	
	private String imagen;

	public PelotaModelo() {
		
	}
	
	public PelotaModelo(int id, @Size(min = 5, max = 30) String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public PelotaModelo(int id, @Size(min = 5, max = 30) String nombre, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
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

	@Override
	public String toString() {
		return "PelotaModelo [id=" + id + ", nombre=" + nombre + "]";
	}

}
