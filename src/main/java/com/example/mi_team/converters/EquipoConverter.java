package com.example.mi_team.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.mi_team.entities.EquipoEntidad;
import com.example.mi_team.models.EquipoModelo;

@Component("equipoConverter")
public class EquipoConverter {
	
	@Autowired
	@Qualifier("pelotaConverter")
	private PelotaConverter pelotaConverter;
	
	@Autowired
	@Qualifier("jugadorConverter")
	private JugadorConverter jugadorConverter;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	public EquipoModelo entityToModel(EquipoEntidad equipoEntidad) {
		
		if(equipoEntidad != null) {
			
			if(equipoEntidad.getPelota() == null) {
				
				return new EquipoModelo(equipoEntidad.getId(), equipoEntidad.getNombre());
				
			} else {
				
				if(equipoEntidad.getUsuario() == null){
				
					return new EquipoModelo(equipoEntidad.getId(), equipoEntidad.getNombre(), pelotaConverter.entityToModel(equipoEntidad.getPelota()));
				
				} else {
					
					return new EquipoModelo(equipoEntidad.getId(), equipoEntidad.getNombre(), pelotaConverter.entityToModel(equipoEntidad.getPelota()),
											usuarioConverter.entityToModel(equipoEntidad.getUsuario()));
					
				}
			}
			
		} else {
			return null;
		}
		
	}
	
	public EquipoEntidad modelToEntity(EquipoModelo equipoModelo) {
		
		if(equipoModelo.getPelota() == null) {
			
			return new EquipoEntidad(equipoModelo.getId(), equipoModelo.getNombre());
			
		} else {
			
			if(equipoModelo.getUsuario() == null) {
			
				return new EquipoEntidad(equipoModelo.getId(), equipoModelo.getNombre(), pelotaConverter.modelToEntity(equipoModelo.getPelota()));
				
			} else {
				
				return new EquipoEntidad(equipoModelo.getId(), equipoModelo.getNombre(), pelotaConverter.modelToEntity(equipoModelo.getPelota()),
										 usuarioConverter.modelToEntity(equipoModelo.getUsuario()));
				
			}
		}
	}
	
	public EquipoModelo entityToModelSet(EquipoEntidad equipoEntidad) {
		
		return new EquipoModelo(equipoEntidad.getId(), equipoEntidad.getNombre(), pelotaConverter.entityToModel(equipoEntidad.getPelota()),
				jugadorConverter.entidadAModeloSet(equipoEntidad.getJugadores()), usuarioConverter.entityToModel(equipoEntidad.getUsuario()));
		
	}
	
	public EquipoEntidad modelToEntitySet(EquipoModelo equipoModelo) {
		
		return new EquipoEntidad(equipoModelo.getId(), equipoModelo.getNombre(), pelotaConverter.modelToEntity(equipoModelo.getPelota()),
				jugadorConverter.modeloAEntidadSet(equipoModelo.getJugadores()), usuarioConverter.modelToEntity(equipoModelo.getUsuario()));
	
	}

}
