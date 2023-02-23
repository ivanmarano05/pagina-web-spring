package com.example.mi_team.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mi_team.entities.JugadorEntidad;

@Repository("jugadorRepository")
public interface IJugadorRepository extends 
						JpaRepository<JugadorEntidad, Serializable> {
	
	public abstract JugadorEntidad findByNombre(String nombre);
	
	public abstract JugadorEntidad findById(int id);

}