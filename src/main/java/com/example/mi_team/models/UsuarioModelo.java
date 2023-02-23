package com.example.mi_team.models;

import javax.validation.constraints.Size;

public class UsuarioModelo {
	
	private int id;
	
	@Size(min = 2, max = 30)
	private String nombre;
	
	public UsuarioModelo() {
		
	}
	
	public UsuarioModelo(int id, @Size(min = 2, max = 30) String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "UsuarioModelo [id=" + id + ", nombre=" + nombre + "]";
	}

}