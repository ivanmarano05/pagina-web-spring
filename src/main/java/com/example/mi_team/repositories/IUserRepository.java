package com.example.mi_team.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mi_team.entities.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable> {

	@Query("SELECT u FROM User u JOIN FETCH u.userRoles WHERE u.username = (:username)")
	public abstract User findByUsernameAndFetchUserRolesEagerly(@Param("username") String username);
	
//	@Query("INSERT INTO user (password, username) values = (:idPelota) WHERE e.id = (:idEquipo)")
//	public abstract void insertarUsuario(@Param("idEquipo") int idEquipo, @Param("idPelota") int idPelota);
	
//	@Query("SELECT u FROM User u JOIN FETCH u.equipo WHERE u.id = (:idEquipo)")
//	public abstract User findByIdAndFetchEquipoEntidadEagerly(@Param("idEquipo") int idEquipo);
//	
	@Query("SELECT u FROM User u WHERE u.id = (:idUsuario)")
	public abstract User findById(@Param("idUsuario") int idUsuario);
	
}