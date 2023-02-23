package com.example.mi_team.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.mi_team.entities.JugadorEntidad;
import com.example.mi_team.models.JugadorModelo;

@Component("jugadorConverter")
public class JugadorConverter {
	
	public JugadorModelo entityToModel(JugadorEntidad jugadorEntidad) {
		
		return new JugadorModelo(jugadorEntidad.getId(), jugadorEntidad.getNombre(), 
				jugadorEntidad.getPosicion(), jugadorEntidad.getPais());
		
	}
	
	
	public JugadorEntidad modelToEntity(JugadorModelo jugadorModelo) {
		
		return new JugadorEntidad(jugadorModelo.getId(), jugadorModelo.getNombre(),
				jugadorModelo.getPosicion(), jugadorModelo.getPais());
		
	}
	
	public Set<JugadorModelo> entidadAModeloSet(Set<JugadorEntidad> jugadores){
		
		Set<JugadorModelo> lista = new HashSet<>();
		
		for(JugadorEntidad j: jugadores) {
			
			lista.add(entityToModel(j));	
			
		}
		
		return lista;
	}
	
	
	public Set<JugadorEntidad> modeloAEntidadSet(Set<JugadorModelo> jugadores){
		
		Set<JugadorEntidad> lista = new HashSet<>();
		
		for(JugadorModelo p: jugadores) {
			
			lista.add(modelToEntity(p));	
			
		}
		
		return lista;
	}

}
