package com.example.mi_team.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.mi_team.converters.EquipoConverter;
import com.example.mi_team.converters.PelotaConverter;
import com.example.mi_team.converters.UsuarioConverter;
import com.example.mi_team.entities.EquipoEntidad;
import com.example.mi_team.entities.JugadorEntidad;
import com.example.mi_team.entities.PelotaEntidad;
import com.example.mi_team.entities.UsuarioEntidad;
import com.example.mi_team.models.EquipoModelo;
import com.example.mi_team.models.PelotaModelo;
import com.example.mi_team.models.UsuarioModelo;
import com.example.mi_team.repositories.IEquipoRepository;
import com.example.mi_team.services.IEquipoService;

@Service("equipoService")
public class EquipoService implements IEquipoService {
	
	@Autowired
	@Qualifier("equipoRepository")
	private IEquipoRepository equipoRepository;
	
	@Autowired
	@Qualifier("equipoConverter")
	private EquipoConverter equipoConverter;
	
	@Autowired
	@Qualifier("jugadorService")
	private JugadorService jugadorService;
	
	@Autowired
	@Qualifier("pelotaConverter")
	private PelotaConverter pelotaConverter;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Override
	public List<EquipoEntidad> getAll(){
		
		return equipoRepository.findAll();
		
	}	
	
	public EquipoModelo traerPorId(int id) {		
		
		return equipoConverter.entityToModel(equipoRepository.findById(id));
		
	};
	
	public EquipoModelo traerPorIdUsuario(int idUsuario) {		
		
		return equipoConverter.entityToModel(equipoRepository.findByIdAndFetchUsuarioEagerly(idUsuario));
		
	};
	
//	public EquipoModelo traerPorNombreUsuario(String nombreUsuario) {		
//		
//		return equipoConverter.entityToModel(equipoRepository.findByNombreAndFetchUsuarioEagerly(nombreUsuario));
//		
//	};
	
	public EquipoModelo traerEquipoCompletoPorId(int id) {
		
		List<EquipoEntidad> listaEntidad = getEquiposCompletos();
		EquipoModelo equipoEncontrado = new EquipoModelo();
		
		for (EquipoEntidad e: listaEntidad) {
			
			if(e.getId() == id) {
				
				equipoEncontrado = equipoConverter.entityToModel(e);
				
			}
			
		}
		
		return equipoEncontrado;
	}
	
	public List<EquipoEntidad> getEquiposCompletos(){
		
		List<EquipoEntidad> equipos = getAll();
		
		for (EquipoEntidad e: equipos) {
			
//			Avatar avatar = avatarRepository.findById(p.getAvatar().getId());
			
			Set<JugadorEntidad> jugadores = jugadoresDelEquipo(e.getId());
			
			PelotaEntidad pelota = pelotaDelEquipoEntidad(e.getId());
			
//			if(avatar != null) {
//				e.setAvatar(avatar);
//			}
			
			if(jugadores != null) {
				e.setJugadores(jugadores);
			}
			
			if(pelota != null) {
				e.setPelota(pelota);
			}
		}
		
		return equipos;
	}
	
	public List<EquipoModelo> getAllModel(){
		
		List<EquipoModelo> listaDeEquipos = new ArrayList<EquipoModelo>();
		
		for (EquipoEntidad e:getAll() ) {
			
			listaDeEquipos.add(equipoConverter.entityToModel(e));
			
		}	
		
		return listaDeEquipos;
	}
	
	@Override
	public EquipoModelo insertOrUpdate(EquipoModelo equipoModelo) {
		
		EquipoEntidad equipo = equipoRepository.save(equipoConverter.modelToEntity(equipoModelo));
		
		return equipoConverter.entityToModel(equipo);
	}
	
	@Override
	public EquipoModelo insertOrUpdateSet(EquipoModelo equipoModelo) {
		
		EquipoEntidad equipo = equipoRepository.save(equipoConverter.modelToEntitySet(equipoModelo));
		
		return equipoConverter.entityToModelSet(equipo);
		
	}
	
	public Set<JugadorEntidad> jugadoresDelEquipo(int id) {
		
		EquipoEntidad e = equipoRepository.findByIdAndFetchJugadoresEagerly(id);
		Set<JugadorEntidad> setJugadores = new HashSet<>();
		
		if (e != null) {
			if(e.getJugadores() != null) {
				setJugadores = e.getJugadores();
			}
		}
		
		return setJugadores;
	}
	
	public PelotaEntidad pelotaDelEquipoEntidad(int id) {
		
		EquipoEntidad e = equipoRepository.findByIdAndFetchPelotaEagerly(id);
		
		PelotaEntidad pelota = new PelotaEntidad();
		
		if (e != null) {
			if(e.getPelota() != null) {
				pelota = e.getPelota();
			}
		}
		
		return pelota;
	}
	
	public PelotaModelo pelotaDelEquipoModelo(int id) {
		
		EquipoEntidad e = equipoRepository.findByIdAndFetchPelotaEagerly(id);
		
		PelotaEntidad pelotaEntidad = new PelotaEntidad();
		
		PelotaModelo pelotaModelo = new PelotaModelo();
		
		if (e != null) {
			if(e.getPelota() != null) {
				pelotaEntidad = e.getPelota();
				pelotaModelo = pelotaConverter.entityToModel(pelotaEntidad);
			}
		}
		
		return pelotaModelo;
	}
	
	public UsuarioEntidad usuarioDelEquipoEntidad(int id) {
		
		EquipoEntidad e = equipoRepository.findByIdAndFetchUsuarioEagerly(id);
		
		UsuarioEntidad usuario = new UsuarioEntidad();
		
		if (e != null) {
			if(e.getUsuario() != null) {
				usuario = e.getUsuario();
			}
		}
		
		return usuario;
	}
	
	public UsuarioModelo usuarioDelEquipoModelo(int id) {
		
		EquipoEntidad e = equipoRepository.findByIdAndFetchUsuarioEagerly(id);
		
		UsuarioEntidad usuarioEntidad = new UsuarioEntidad();
		
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		
		if (e != null) {
			if(e.getUsuario() != null) {
				usuarioEntidad = e.getUsuario();
				usuarioModelo = usuarioConverter.entityToModel(usuarioEntidad);
			}
		}
		
		return usuarioModelo;
	}
	
	@Override
	public boolean remove(int id) {
		
		try {
			equipoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}