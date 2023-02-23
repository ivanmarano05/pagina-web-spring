package com.example.mi_team.services.implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.mi_team.converters.JugadorConverter;
import com.example.mi_team.entities.JugadorEntidad;
import com.example.mi_team.models.JugadorModelo;
import com.example.mi_team.repositories.IJugadorRepository;
import com.example.mi_team.services.IJugadorService;

@Service("jugadorService")
public class JugadorService implements IJugadorService {
	
	@Autowired
	@Qualifier("jugadorRepository")
	private IJugadorRepository jugadorRepository;
	
	@Autowired
	@Qualifier("jugadorConverter")
	private JugadorConverter jugadorConverter;
	
	@Override
	public List<JugadorEntidad> getAll(){
		
		List<JugadorEntidad> jugadores = new LinkedList<>();
		
		jugadores = jugadorRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
		
//		for (JugadorEntidad j : jugadores) {
//			System.out.println(j.getNombre());
//		}
			
		return jugadores;
		
//		return jugadorRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
	}
	
	public JugadorModelo traerPorId(int id) {
		
		return jugadorConverter.entityToModel(jugadorRepository.findById(id));
		
	};
	
	public List<JugadorModelo> getAllModel(){
		
		List<JugadorModelo> listaDeJugadores = new ArrayList<JugadorModelo>();
		
		for (JugadorEntidad j:getAll() ) {
			
			listaDeJugadores.add(jugadorConverter.entityToModel(j));
			
		}
		
		return listaDeJugadores;
	}
	
	@Override
	public JugadorModelo insertOrUpdate(JugadorModelo jugadorModelo) {
		
		JugadorEntidad jugador = jugadorRepository.save(jugadorConverter.modelToEntity(jugadorModelo));
		
		return jugadorConverter.entityToModel(jugador);
	}
	
	@Override
	public boolean remove(int id) {
		
		try {
			jugadorRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}