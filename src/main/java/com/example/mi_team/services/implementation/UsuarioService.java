package com.example.mi_team.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.mi_team.converters.UsuarioConverter;
import com.example.mi_team.entities.UsuarioEntidad;
import com.example.mi_team.models.UsuarioModelo;
import com.example.mi_team.repositories.IUsuarioRepository;
import com.example.mi_team.services.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Override
	public List<UsuarioEntidad> getAll(){	
			
		return usuarioRepository.findAll();
		
	}
	
	public UsuarioModelo traerPorId(int id) {
		
		return usuarioConverter.entityToModel(usuarioRepository.findById(id));
		
	};
	
	public UsuarioModelo traerPorNombre(String nombre) {
		
		return usuarioConverter.entityToModel(usuarioRepository.findByNombre(nombre));
		
	};
	
	@Override
	public UsuarioModelo insertOrUpdate(UsuarioModelo usuarioModelo) {
		
		UsuarioEntidad usuario = usuarioRepository.save(usuarioConverter.modelToEntity(usuarioModelo));
		
		return usuarioConverter.entityToModel(usuario);
		
	}
	
	@Override
	public boolean remove(int id) {
		
		try {
			usuarioRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public List<UsuarioModelo> getAllModel(){
		
		List<UsuarioModelo> listaDeUsuarios = new ArrayList<UsuarioModelo>();
		
		for (UsuarioEntidad u:getAll() ) {
			
			listaDeUsuarios.add(usuarioConverter.entityToModel(u));
			
		}
		
		return listaDeUsuarios;
	}
}