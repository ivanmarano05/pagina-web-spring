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
	
	//Metodos que se pueden llamar desde el controlador :) 
	//Si se utilizan nombres standar como findBy, Order, GroupBy, etc no hace falta 
	//desarrollar las consultas,tambien se puede hacer buscarPorNombre, pero
	//con esos nombres deberas programarlo personalmente
	public abstract EquipoEntidad findByNombre(String nombre);
	
	public abstract EquipoEntidad findById(int id);
	
	@Query("SELECT e FROM EquipoEntidad e JOIN FETCH e.jugadores WHERE e.id = (:id)")
	public abstract EquipoEntidad findByIdAndFetchJugadoresEagerly(@Param("id") int id);
	
	@Query("SELECT e FROM EquipoEntidad e JOIN FETCH e.pelota WHERE e.id = (:id)")
	public abstract EquipoEntidad findByIdAndFetchPelotaEagerly(@Param("id") int id);
	
	@Query("SELECT e FROM EquipoEntidad e JOIN FETCH e.usuario WHERE e.id = (:idUsuario)")
	public abstract EquipoEntidad findByIdAndFetchUsuarioEagerly(@Param("idUsuario") int idUsuario);
	
//	@Query("UPDATE EquipoEntidad e SET e.id = (:idUsuario) WHERE e.id = (:idActual)")
//	public abstract EquipoEntidad actualizarID(@Param("idActual") int idActual, @Param("idUsuario") int idUsuario);
	
//	@Query("SELECT e FROM EquipoEntidad e JOIN FETCH e.usuario WHERE e.nombre = (:nombreUsuario)")
//	public abstract EquipoEntidad findByNombreAndFetchUsuarioEagerly(@Param("nombreUsuario") String nombreUsuario);
	
//	@Query("UPDATE EquipoEntidad e SET e.pelota = (:idPelota) WHERE e.id = (:idEquipo)")
//	public abstract EquipoEntidad insertarPelota(@Param("idEquipo") int idEquipo, @Param("idPelota") int idPelota);
	
}