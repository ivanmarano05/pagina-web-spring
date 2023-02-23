package com.example.mi_team.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.mi_team.converters.PelotaConverter;
import com.example.mi_team.entities.PelotaEntidad;
import com.example.mi_team.models.PelotaModelo;
import com.example.mi_team.repositories.IPelotaRepository;
import com.example.mi_team.services.IPelotaService;

@Service("pelotaService")
public class PelotaService implements IPelotaService {
	
	@Autowired
	@Qualifier("pelotaRepository")
	private IPelotaRepository pelotaRepository;
	
	@Autowired
	@Qualifier("pelotaConverter")
	private PelotaConverter pelotaConverter;
	
	@Override
	public List<PelotaEntidad> getAll(){	
			
		return pelotaRepository.findAll();
		
	}
	
	public PelotaModelo traerPorId(int id) {
		
		return pelotaConverter.entityToModel(pelotaRepository.findById(id));
		
	};
	
	public PelotaModelo traerPorNombre(String nombre) {
		
		return pelotaConverter.entityToModel(pelotaRepository.findByNombre(nombre));
		
	};
	
	public List<PelotaModelo> getAllModel(){
		
		List<PelotaModelo> listaDePelotas = new ArrayList<PelotaModelo>();
		
		for (PelotaEntidad p:getAll() ) {
			
			listaDePelotas.add(pelotaConverter.entityToModel(p));
			
		}
		
		return listaDePelotas;
	}
	
	@Override
	public PelotaModelo insertOrUpdate(PelotaModelo pelotaModelo) {
		
		PelotaEntidad pelota = pelotaRepository.save(pelotaConverter.modelToEntity(pelotaModelo));
		
		return pelotaConverter.entityToModel(pelota);
	}
	
	@Override
	public boolean remove(int id) {
		
		try {
			pelotaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}