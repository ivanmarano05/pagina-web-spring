package com.example.mi_team.converters;

import org.springframework.stereotype.Component;

import com.example.mi_team.entities.UsuarioEntidad;
import com.example.mi_team.models.UsuarioModelo;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	public UsuarioModelo entityToModel(UsuarioEntidad usuarioEntidad) {
		
		return new UsuarioModelo(usuarioEntidad.getId(), usuarioEntidad.getNombre());
	
	}
	
	
	public UsuarioEntidad modelToEntity(UsuarioModelo usuarioModelo) {
		
		return new UsuarioEntidad(usuarioModelo.getId(), usuarioModelo.getNombre());
		
	}

}
