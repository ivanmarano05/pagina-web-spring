package com.example.mi_team.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "equipo")
public class EquipoEntidad {

	//columnas que no estan en models
	@Id
	private int id;
	
	//Las mismas de la capa models:
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "pelota_id")
	@JsonBackReference
	private PelotaEntidad pelota;
	
	@ManyToMany(cascade = {
	           CascadeType.PERSIST,
	           CascadeType.MERGE
	 })
	   @JoinTable(name = "equipo_jugador",
	           joinColumns = @JoinColumn(name = "id_equipo"),
	           inverseJoinColumns = @JoinColumn(name = "id_jugador")
	)
	@JsonIgnoreProperties("equipos")
	private Set<JugadorEntidad> jugadores = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
	@JsonIgnore
	private UsuarioEntidad usuario;
	
	//Nuevas que se suelen usar
	@Column(name = "creado")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name = "actualizado")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	public EquipoEntidad() {
		
	}
	
	public EquipoEntidad(int id) {
		super();
		this.id = id;
	}

	public EquipoEntidad(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public EquipoEntidad(int id, String nombre, PelotaEntidad pelota) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pelota = pelota;
	}
	
	public EquipoEntidad(int id, String nombre, Set<JugadorEntidad> jugadores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.jugadores = jugadores;
	}
	
	public EquipoEntidad(int id, String nombre, PelotaEntidad pelota,
 						 UsuarioEntidad usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pelota = pelota;
		this.usuario = usuario;
	}
	
	public EquipoEntidad(int id, String nombre, PelotaEntidad pelota,
			 			Set<JugadorEntidad> jugadores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pelota = pelota;
		this.jugadores = jugadores;
	}
	
	public EquipoEntidad(int id, String nombre, PelotaEntidad pelota,
			Set<JugadorEntidad> jugadores, UsuarioEntidad usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pelota = pelota;
		this.jugadores = jugadores;
		this.usuario = usuario;
	}
	
	public EquipoEntidad(int id, String nombre, PelotaEntidad pelota,
			 			 Set<JugadorEntidad> jugadores, LocalDateTime createdAt,
			 			 LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pelota = pelota;
		this.jugadores = jugadores;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public Set<JugadorEntidad> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<JugadorEntidad> jugadores) {
		this.jugadores = jugadores;
	}
	
	public PelotaEntidad getPelota() {
		return pelota;
	}

	public void setPelota(PelotaEntidad pelota) {
		this.pelota = pelota;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public UsuarioEntidad getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntidad usuario) {
		this.usuario = usuario;
	}

//	@Override
//	public String toString() {
//		return "EquipoEntidad [id=" + id + ", nombre=" + nombre + ", pelota=" + pelota + ", jugadores=" + jugadores
//				+ ", usuario=" + usuario + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
//	}
	
	@Override
	public String toString() {
		return "Nombre equipo: " + nombre;
	}

}