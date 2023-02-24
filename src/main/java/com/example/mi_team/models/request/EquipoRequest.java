package com.example.mi_team.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquipoRequest {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("Nombre")
	private String nombre;
	
	@JsonProperty("Pelota")
	private String pelota;
	
	@JsonProperty("Imagen")
	private String imagen;
	
	@JsonProperty("Usuario")
	private String usuario;
	
	public EquipoRequest() {
		
	}
	
	public EquipoRequest(int id) {
		super();
		this.id = id;
	}
	
	public EquipoRequest(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public EquipoRequest(int id, String nombre, String pelota, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pelota = pelota;
		this.imagen = imagen;
	}
	
	public EquipoRequest(int id, String nombre, String pelota, String imagen, String usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pelota = pelota;
		this.imagen = imagen;
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

	public String getPelota() {
		return pelota;
	}

	public void setPelota(String pelota) {
		this.pelota = pelota;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "EquipoRequest [id=" + id + ", nombre=" + nombre + ", pelota=" + pelota + ", imagen=" + imagen
				+ ", usuario=" + usuario + "]";
	}

}
