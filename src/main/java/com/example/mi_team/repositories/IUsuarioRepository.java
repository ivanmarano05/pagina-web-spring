package com.example.mi_team.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mi_team.entities.UsuarioEntidad;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends 
						JpaRepository<UsuarioEntidad, Serializable> {
	
	public abstract UsuarioEntidad findByNombre(String nombre);
	
	public abstract UsuarioEntidad findById(int id);

}