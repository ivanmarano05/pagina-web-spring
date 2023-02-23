package com.example.mi_team.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mi_team.entities.PelotaEntidad;

@Repository("pelotaRepository")
public interface IPelotaRepository extends 
						JpaRepository<PelotaEntidad, Serializable> {
	
	public abstract PelotaEntidad findById(int id);
	
	public abstract PelotaEntidad findByNombre(String nombre);
	
	public abstract PelotaEntidad findByImagen(String imagen);

}