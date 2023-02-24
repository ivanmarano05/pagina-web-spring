package com.example.mi_team.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mi_team.converters.JugadorConverter;
import com.example.mi_team.entities.JugadorEntidad;
import com.example.mi_team.entities.PelotaEntidad;
import com.example.mi_team.helpers.ViewRouteHelper;
import com.example.mi_team.models.EquipoModelo;
import com.example.mi_team.models.JugadorModelo;
import com.example.mi_team.models.PelotaModelo;
import com.example.mi_team.models.UsuarioModelo;
import com.example.mi_team.services.IEquipoService;
import com.example.mi_team.services.IJugadorService;
import com.example.mi_team.services.IPelotaService;
import com.example.mi_team.services.IUserRoleService;
import com.example.mi_team.services.IUserService;
import com.example.mi_team.services.IUsuarioService;

@Controller
@RequestMapping("equipo")
public class EquipoControlador {
	
	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;
	
	@Autowired
	@Qualifier("jugadorService")
	private IJugadorService jugadorService;
	
	@Autowired
	@Qualifier("jugadorConverter")
	private JugadorConverter jugadorConverter;
	
	@Autowired
	@Qualifier("pelotaService")
	private IPelotaService pelotaService;
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("userRoleService")
	private IUserRoleService userRoleService;
	
	
	@GetMapping("/crearEquipo")
	public ModelAndView crearEquipo(Model model) {
		
		User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UsuarioModelo u = usuarioService.traerPorNombre(usuario.getUsername());
		
		EquipoModelo e = equipoService.traerPorIdUsuario(u.getId());
		
		if(e != null) {
			model.addAttribute("equipo", e);
		} else {
			EquipoModelo equipo = new EquipoModelo(u.getId());
			model.addAttribute("equipo", equipo);
		}
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.CREAR_EQUIPO);
		modelAndView.addObject("usuario", user.getUsername());
		
		return modelAndView;
	}
	
	@PostMapping("/elegirPelota")
	public ModelAndView elegirPelota(@ModelAttribute("equipo")EquipoModelo equipo, Model model) {
		
		equipo = equipoService.insertOrUpdate(equipo);
		
		List<PelotaEntidad> pelotas = pelotaService.getAll();
		
		model.addAttribute("equipo", equipo);
		model.addAttribute("pelotas", pelotas);

		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.ELEGIR_PELOTA);
		
		return modelAndView;
	}
	
	@GetMapping("/elegirPelota/{idEquipo}/{idPelota}")
	public ModelAndView elegirPelota(@PathVariable("idEquipo") int idEquipo, @PathVariable("idPelota")int idPelota, Model model) {	
		
		EquipoModelo equipo = equipoService.traerPorId(idEquipo);
		
		PelotaModelo pelota = pelotaService.traerPorId(idPelota);
		
		equipo.setPelota(pelota);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UsuarioModelo usuario = usuarioService.traerPorNombre(user.getUsername());
		
		equipo.setUsuario(usuario);
		
		equipo = equipoService.insertOrUpdate(equipo);

		ModelAndView mV = new ModelAndView();
		
		mV.setViewName(ViewRouteHelper.ELEGIR_JUGADORES);
		mV.addObject("texto", "");
		mV.addObject("equipo", equipo);
		mV.addObject("pelota", pelota);
		mV.addObject("usuario", usuario);
		mV.addObject("jugadores", jugadorService.getAll());
		
		return mV;	
	}
	
	@GetMapping("/agregarJugador/{idEquipo}/{idJugador}")
	public ModelAndView agregarJugador(@PathVariable("idEquipo") int idEquipo, @PathVariable("idJugador")int idJugador, Model model) {	
		
		EquipoModelo equipo = equipoService.traerPorId(idEquipo);
		
		PelotaModelo pelota = equipoService.pelotaDelEquipoModelo(idEquipo);
		
		UsuarioModelo usuario = equipoService.usuarioDelEquipoModelo(idEquipo);
		
		Set<JugadorEntidad> jugadores = equipoService.jugadoresDelEquipo(idEquipo);
		
		int cont = 0;
		
		if(jugadores != null) {
			
			for (JugadorEntidad j : jugadores) {
					
				equipo.getJugadores().add(jugadorConverter.entityToModel(j));
				cont = cont + 1;
					
			}
			
		}
			
			JugadorModelo jugador = jugadorService.traerPorId(idJugador);
			
		try {
			equipo.getJugadores().add(jugador);
			
			equipo = equipoService.insertOrUpdateSet(equipo);
	
			ModelAndView mV = new ModelAndView();
			
			if(cont >= 10) {
				
				mV.setViewName(ViewRouteHelper.MI_EQUIPO);
				mV.addObject("equipo", equipo);
				mV.addObject("pelota", pelota);
				mV.addObject("usuario", usuario);
				mV.addObject("jugadores", equipoService.jugadoresDelEquipo(idEquipo));
				
			} else {
				
				mV.setViewName(ViewRouteHelper.ELEGIR_JUGADORES);
				mV.addObject("texto", "");
				mV.addObject("equipo", equipo);
				mV.addObject("pelota", pelota);
				mV.addObject("usuario", usuario);
				mV.addObject("jugadores", jugadorService.getAll());
				mV.addObject("jugadoresDelEquipo", equipoService.jugadoresDelEquipo(idEquipo));
				
			}
			
			return mV;
			
		} catch (Exception e) {
			
			ModelAndView mV = new ModelAndView();
			
			mV.setViewName(ViewRouteHelper.ELEGIR_JUGADORES);
			mV.addObject("texto", "JUGADOR REPETIDO. ELIGE OTRO JUGADOR");
			mV.addObject("equipo", equipo);
			mV.addObject("pelota", pelota);
			mV.addObject("usuario", usuario);
			mV.addObject("jugadores", jugadorService.getAll());
			mV.addObject("jugadoresDelEquipo", equipoService.jugadoresDelEquipo(idEquipo));
			cont = cont - 1;
			
			return mV;
		}
		
	}
	
	@GetMapping("/editarEquipo/{id}")
	public ModelAndView editarEquipo(@PathVariable("id")int id, Model model) {
		
		EquipoModelo equipo = equipoService.traerPorId(id);
		PelotaModelo pelota = equipoService.pelotaDelEquipoModelo(id);

		model.addAttribute("equipo", equipo);
		model.addAttribute("pelota", pelota);
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.CREAR_EQUIPO);		
		
		return modelAndView;	
	}
	
	@GetMapping("/detalles/{id}")
	public ModelAndView detalles(@PathVariable("id")int id, Model model) {	
		
		EquipoModelo equipo = equipoService.traerPorId(id);
		PelotaModelo pelota = equipoService.pelotaDelEquipoModelo(id);
		Set<JugadorEntidad> jugadores = equipoService.jugadoresDelEquipo(id);
		UsuarioModelo usuario = equipoService.usuarioDelEquipoModelo(id);

		model.addAttribute("equipo", equipo);
		model.addAttribute("jugadores", jugadores);
		model.addAttribute("pelota", pelota);
		model.addAttribute("usuario", usuario);
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.DETALLES_EQUIPO);
		
		return modelAndView;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/eliminarUsuario/{id}")
	public ModelAndView eliminarUsuario(@PathVariable("id")int id, Model model) {
	
		equipoService.remove(id);
		userRoleService.remove(id);
		userService.remove(id);
		
		return listaEquipos();
	}
	
	@GetMapping("/listaEquipos")
	public ModelAndView listaEquipos() {
		
		ModelAndView mV = new ModelAndView();
			
		mV.setViewName(ViewRouteHelper.VER_EQUIPOS);
		mV.addObject("listaEquipos",equipoService.getAll());
			
		return mV;
	}
	
	@GetMapping("/miEquipo")
	public ModelAndView miEquipo() {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UsuarioModelo u = usuarioService.traerPorNombre(user.getUsername());
		
		ModelAndView mV = new ModelAndView();
		
		try {
		
			EquipoModelo equipo = equipoService.traerPorIdUsuario(u.getId());
			PelotaModelo pelota = equipoService.pelotaDelEquipoModelo(equipo.getId());
			Set<JugadorEntidad> jugadores = equipoService.jugadoresDelEquipo(equipo.getId());
			UsuarioModelo usuario = equipoService.usuarioDelEquipoModelo(equipo.getId());

			mV.setViewName(ViewRouteHelper.MI_EQUIPO);
			mV.addObject("equipo", equipo);
			mV.addObject("usuario", usuario);
			mV.addObject("pelota", pelota);
			mV.addObject("jugadores", jugadores);
			
		} catch (NullPointerException e) {
			
			EquipoModelo nuevoEquipo = new EquipoModelo(u.getId());
			mV.setViewName(ViewRouteHelper.CREAR_EQUIPO);
			mV.addObject("equipo", nuevoEquipo);
			mV.addObject("texto", "PARA VER TU EQUIPO, PRIMERO DEBES CREARLO");
			
		}
			
		return mV;
	}
	
	@GetMapping("/index")
	public String inicio() {
		
		return ViewRouteHelper.INDEX;
		
	}
}
