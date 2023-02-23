package com.example.mi_team.services;

import java.util.List;

import com.example.mi_team.entities.JugadorEntidad;
import com.example.mi_team.models.JugadorModelo;

public interface IJugadorService {
	
	public List<JugadorEntidad> getAll();
	
	public JugadorModelo insertOrUpdate(JugadorModelo jugadorModelo);
	
	public JugadorModelo traerPorId(int id);
	
	public List<JugadorModelo> getAllModel();
	
	public boolean remove(int id);
	
}