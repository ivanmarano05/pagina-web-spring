package com.example.mi_team.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Size;

public class EquipoModelo {
	
	private int id;
	
	@Size(min = 2, max = 50)
	private String nombre;

	private PelotaModelo pelota;
	
	private Set<JugadorModelo> jugadores = new HashSet<>();
	
	private UsuarioModelo usuario;
	
	public EquipoModelo() {
		
	}
	
	public EquipoModelo(int id) {
		super();
		this.id = id;
	}
	
	public EquipoModelo(int id, @Size(min = 2, max = 50) String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public EquipoModelo(int id, @Size(min = 2, max = 50) String nombre, PelotaModelo pelota) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pelota = pelota;
	}
	
	public EquipoModelo(int id, @Size(min = 2, max = 50) String nombre, Set<JugadorModelo> jugadores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.jugadores = jugadores;
	}
	
	public EquipoModelo(int id, @Size(min = 2, max = 50) String nombre, PelotaModelo pelota,
						Set<JugadorModelo> jugadores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pelota = pelota;
		this.jugadores = jugadores;
	}
	
	public EquipoModelo(int id, @Size(min = 2, max = 50) String nombre, PelotaModelo pelota, UsuarioModelo usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pelota = pelota;
		this.usuario = usuario;
	}
	
	public EquipoModelo(int id, @Size(min = 2, max = 50) String nombre, PelotaModelo pelota,
						Set<JugadorModelo> jugadores, UsuarioModelo usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pelota = pelota;
		this.jugadores = jugadores;
		this.usuario = usuario;
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

	public PelotaModelo getPelota() {
		return pelota;
	}

	public void setPelota(PelotaModelo pelota) {
		this.pelota = pelota;
	}

	public Set<JugadorModelo> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<JugadorModelo> jugadores) {
		this.jugadores = jugadores;
	}

	public UsuarioModelo getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModelo usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "EquipoModelo [id=" + id + ", nombre=" + nombre + ", pelota=" + pelota + ", jugadores=" + jugadores
				+ ", usuario=" + usuario + "]";
	}

}