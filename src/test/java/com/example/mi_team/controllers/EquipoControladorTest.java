package com.example.mi_team.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.mi_team.entities.User;
import com.example.mi_team.entities.UserRole;
import com.example.mi_team.helpers.ViewRouteHelper;
import com.example.mi_team.models.EquipoModelo;
import com.example.mi_team.models.PelotaModelo;
import com.example.mi_team.services.IEquipoService;
import com.example.mi_team.services.IPelotaService;
import com.example.mi_team.services.IUserService;
import com.example.mi_team.services.IUsuarioService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class EquipoControladorTest {
	
	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;
	
	@Autowired
	@Qualifier("pelotaService")
	private IPelotaService pelotaService;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@Autowired
	EquipoControlador equipoControlador = new EquipoControlador();

	@Test
	@Order(1)
	void testCrearEquipo() {
		
		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User("tito", "tito", new ArrayList<>());
	    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null);
	    SecurityContextHolder.getContext().setAuthentication(auth);
		
		Model model = new ExtendedModelMap();
		
		ModelAndView mv;
		
        mv = equipoControlador.crearEquipo(model);
        
        Assertions.assertEquals(ViewRouteHelper.CREAR_EQUIPO, mv.getViewName());
		
	}

	@Test
	@Order(2)
	void testElegirPelotaEquipoModeloModel() {
		
		EquipoModelo equipoModelo = new EquipoModelo(8, "Fachas");
		Model model = new ExtendedModelMap();
		
		ModelAndView mv;
		
        mv = equipoControlador.elegirPelota(equipoModelo, model);
        
        Assertions.assertEquals(ViewRouteHelper.ELEGIR_PELOTA, mv.getViewName());
		
	}

	@Test
	@Order(3)
	void testElegirPelotaIntIntModel() {
		
		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User("tito", "tito", new ArrayList<>());
	    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null);
	    SecurityContextHolder.getContext().setAuthentication(auth);

		int idEquipo = 8;
		int idPelota = 2;
		Model model = new ExtendedModelMap();
		
		ModelAndView mv;
		
		mv = equipoControlador.elegirPelota(idEquipo, idPelota, model);
        
		Assertions.assertEquals(ViewRouteHelper.ELEGIR_JUGADORES, mv.getViewName());
		
	}
	
//	@Test
//	void testElegirPelotaIntIntModel() {
//
//	    org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User("tito", "tito", new ArrayList<>());
//	    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null);
//	    SecurityContextHolder.getContext().setAuthentication(auth);
//	    
//	    Model model = new ExtendedModelMap();
//
//	    // Invocar el método elegirPelota del controlador
//	    ModelAndView modelAndView = equipoControlador.elegirPelota(1, 2, model);
//
//	    // Verificar que el método devuelve el modelo y la vista correctos y que los datos del modelo son los esperados
//	    assertEquals(ViewRouteHelper.ELEGIR_JUGADORES, modelAndView.getViewName());
//	}

	@Test
	@Order(4)
	void testAgregarJugadorJugadoresNull() {

		int idEquipo = 8;
		int idJugador = 2;
		Model model = new ExtendedModelMap();
		
		ModelAndView mv;
		
        mv = equipoControlador.agregarJugador(idEquipo, idJugador, model);
        
        Assertions.assertEquals(ViewRouteHelper.ELEGIR_JUGADORES, mv.getViewName());
		
	}
	
	@Test
	@Order(10)
	void testAgregarJugadorJugadoresNotNull() {

		int idEquipo = 1;
		int idJugador = 2;
		Model model = new ExtendedModelMap();
		
		ModelAndView mv;
		
        mv = equipoControlador.agregarJugador(idEquipo, idJugador, model);
        
        Assertions.assertEquals(ViewRouteHelper.MI_EQUIPO, mv.getViewName());
		
	}
	
	@Test
	@Order(11)
	void testAgregarJugadorRepetido() {

		int idEquipo = 1;
		int idJugador = 1;
		Model model = new ExtendedModelMap();
		
		ModelAndView mv;
		
        mv = equipoControlador.agregarJugador(idEquipo, idJugador, model);
        
        Assertions.assertEquals(ViewRouteHelper.ELEGIR_JUGADORES, mv.getViewName());
		
	}

	@Test
	@Order(5)
	void testEditarEquipo() {

		int id = 8;
		Model model = new ExtendedModelMap();
		
		ModelAndView mv;
		
        mv = equipoControlador.editarEquipo(id, model);
        
        Assertions.assertEquals(ViewRouteHelper.CREAR_EQUIPO, mv.getViewName());
		
	}

	@Test
	@Order(6)
	void testDetalles() {

		int id = 8;
		Model model = new ExtendedModelMap();
		
		ModelAndView mv;
		
        mv = equipoControlador.detalles(id, model);
        
        Assertions.assertEquals(ViewRouteHelper.DETALLES_EQUIPO, mv.getViewName());
		
	}

//	@Test
//	@Order(7)
//	void testEliminarUsuario() {
//		
//		com.example.mi_team.entities.User usuario = new com.example.mi_team.entities.User(5, "lala", "lala");
//		UserRole rol = new UserRole(5, usuario, "ROLE_ADMIN");
//		Set<UserRole> userRoles = new HashSet<>();
//		userRoles.add(rol);
//		usuario.setUserRoles(userRoles);
//	    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usuario, null);
//	    SecurityContextHolder.getContext().setAuthentication(auth);
//		
//		int id = 4;
//		Model model = new ExtendedModelMap();
//		
//		ModelAndView mv;
//		
//        mv = equipoControlador.eliminarUsuario(id, model);
//        
//        Assertions.assertEquals(ViewRouteHelper.VER_EQUIPOS, mv.getViewName());
//		
//	}

	@Test
	@Order(7)
	void testListaEquipos() {

        ModelAndView mv;
		
        mv = equipoControlador.listaEquipos();
		
		Assertions.assertEquals(ViewRouteHelper.VER_EQUIPOS, mv.getViewName());
		
	}

	@Test
	@Order(8)
	void testMiEquipo() {
		
		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User("ivo", "ivancito", new ArrayList<>());
	    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null);
	    SecurityContextHolder.getContext().setAuthentication(auth);

        ModelAndView mv;
		
        mv = equipoControlador.miEquipo();
		
		Assertions.assertEquals(ViewRouteHelper.MI_EQUIPO, mv.getViewName());
		
	}

	@Test
	@Order(9)
	void testInicio() {

		String texto;
		
		texto = equipoControlador.inicio();
		
		Assertions.assertEquals(ViewRouteHelper.INDEX, texto);
		
	}

}
