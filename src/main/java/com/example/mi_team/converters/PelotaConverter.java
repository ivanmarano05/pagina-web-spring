package com.example.mi_team.converters;

import org.springframework.stereotype.Component;

import com.example.mi_team.entities.PelotaEntidad;
import com.example.mi_team.models.PelotaModelo;

@Component("pelotaConverter")
public class PelotaConverter {
	
	public PelotaModelo entityToModel(PelotaEntidad pelotaEntidad) {
		
		return new PelotaModelo(pelotaEntidad.getId(), pelotaEntidad.getNombre(), pelotaEntidad.getImagen());
	
	}
	
	
	public PelotaEntidad modelToEntity(PelotaModelo pelotaModelo) {
		
		return new PelotaEntidad(pelotaModelo.getId(), pelotaModelo.getNombre(), pelotaModelo.getImagen());
		
	}

}