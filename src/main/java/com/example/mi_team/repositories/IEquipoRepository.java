package com.example.mi_team.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mi_team.entities.EquipoEntidad;

@Repository("equipoRepository")
public interface IEquipoRepository extends 
						JpaRepository<EquipoEntidad, Serializable> {
	
	public abstract EquipoEntidad findByNombre(String nombre);
	
	public abstract EquipoEntidad findById(int id);
	
	@Query("SELECT e FROM EquipoEntidad e JOIN FETCH e.jugadores WHERE e.id = (:id)")
	public abstract EquipoEntidad findByIdAndFetchJugadoresEagerly(@Param("id") int id);
	
	@Query("SELECT e FROM EquipoEntidad e JOIN FETCH e.pelota WHERE e.id = (:id)")
	public abstract EquipoEntidad findByIdAndFetchPelotaEagerly(@Param("id") int id);
	
	@Query("SELECT e FROM EquipoEntidad e JOIN FETCH e.usuario WHERE e.id = (:idUsuario)")
	public abstract EquipoEntidad findByIdAndFetchUsuarioEagerly(@Param("idUsuario") int idUsuario);
	
}