package com.example.mi_team.services;

import com.example.mi_team.models.EquipoModelo;
import com.example.mi_team.models.PelotaModelo;
import com.example.mi_team.models.UsuarioModelo;

import java.util.List;
import java.util.Set;

import com.example.mi_team.entities.EquipoEntidad;
import com.example.mi_team.entities.JugadorEntidad;
import com.example.mi_team.entities.PelotaEntidad;
import com.example.mi_team.entities.UsuarioEntidad;

public interface IEquipoService {	
	
	public List<EquipoEntidad> getAll();
	
	public EquipoModelo insertOrUpdate(EquipoModelo equipoModelo);
	
	public EquipoModelo insertOrUpdateSet(EquipoModelo equipoModelo);
	
	public boolean remove(int id);
	
	public EquipoModelo traerPorId(int id);
	
	public EquipoModelo traerPorIdUsuario(int idUsuario);
	
	public EquipoModelo traerEquipoCompletoPorId(int id);
	
	public List<EquipoModelo> getAllModel();
	
	public Set<JugadorEntidad> jugadoresDelEquipo(int id);
	
	public PelotaEntidad pelotaDelEquipoEntidad(int id);
	
	public PelotaModelo pelotaDelEquipoModelo(int id);
	
	public UsuarioEntidad usuarioDelEquipoEntidad(int id);
	
	public UsuarioModelo usuarioDelEquipoModelo(int id);
	
	public List<EquipoEntidad> getEquiposCompletos();
	
}