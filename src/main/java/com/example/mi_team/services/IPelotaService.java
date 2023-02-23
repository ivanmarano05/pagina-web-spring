package com.example.mi_team.services;

import java.util.List;

import com.example.mi_team.entities.PelotaEntidad;
import com.example.mi_team.models.PelotaModelo;

public interface IPelotaService {
	
	public List<PelotaEntidad> getAll();
	
	public PelotaModelo insertOrUpdate(PelotaModelo pelotaModelo);
	
	public boolean remove(int id);
	
	public PelotaModelo traerPorId(int id);
	
	public PelotaModelo traerPorNombre(String nombre);
	
	public List<PelotaModelo> getAllModel();
	
}