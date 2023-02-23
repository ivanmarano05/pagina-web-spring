package com.example.mi_team.controllers.api.v0;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.mi_team.models.EquipoModelo;
import com.example.mi_team.models.request.EquipoRequest;
import com.example.mi_team.services.IEquipoService;

@SpringBootTest
class EquipoControladorRestTest {
	
	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;
	
	@Autowired
	EquipoControladorRest equipoControlador = new EquipoControladorRest();
	
	@BeforeEach
	void setUp() {
		
		//Constructores
		
		EquipoRequest equipoRequest1 = new EquipoRequest();
		EquipoRequest equipoRequest2 = new EquipoRequest(1);
		EquipoRequest equipoRequest3 = new EquipoRequest(1, "Los Capos");
		EquipoRequest equipoRequest4 = new EquipoRequest(1, "Los Capos", "Jabulani", "jabulani.jpg");
		EquipoRequest equipoRequest5 = new EquipoRequest(1, "Los Capos", "Jabulani", "jabulani.jpg", "ivo");
		
		equipoRequest1.setId(0);
		equipoRequest1.setNombre("Los Capos");
		equipoRequest1.setPelota("Jabulani");
		equipoRequest1.setImagen("jabulani.jpg");
		equipoRequest1.setUsuario("ivo");
		
		equipoRequest1.getId();
		equipoRequest1.getNombre();
		equipoRequest1.getPelota();
		equipoRequest1.getImagen();
		equipoRequest1.getUsuario();
		equipoRequest1.toString();
		
	}

	@Test
	void testTodosLosEquipos() {

		ResponseEntity<List<EquipoModelo>> equipos;
		
		equipos = equipoControlador.todosLosEquipos();
		
		Assertions.assertEquals(HttpStatus.OK, equipos.getStatusCode());
		
	}

	@Test
	void testTraerEquipo() {

		ResponseEntity<Object> equipo;
		
		equipo = equipoControlador.traerEquipo(1);
		
		Assertions.assertEquals(HttpStatus.OK, equipo.getStatusCode());
		
	}

	@Test
	void testTodosLosEquiposBD() {

		ResponseEntity<Object> equipos;
		
		equipos = equipoControlador.todosLosEquiposBD();
		
		Assertions.assertEquals(HttpStatus.OK, equipos.getStatusCode());
		
	}

	@Test
	void testAgregar() {
		
		EquipoRequest equipoRequest = new EquipoRequest(3, "Las bestias", "Tango", "tango.jpg", "pepe");

		ResponseEntity<Object> agregarEquipo;
		
		agregarEquipo = equipoControlador.agregar(equipoRequest);
		
		Assertions.assertEquals(HttpStatus.CREATED, agregarEquipo.getStatusCode());
		
	}

	@Test
	void testEditar() {

		EquipoRequest equipoRequest = new EquipoRequest(2, "Las aguilas", "Al Rihla", "al rihla.jpg", "martu");

		ResponseEntity<Object> editarEquipo;
		
		editarEquipo = equipoControlador.editar(2, equipoRequest);
		
		Assertions.assertEquals(HttpStatus.CREATED, editarEquipo.getStatusCode());
		
	}

	@Test
	void testEliminarEquipo() {

		ResponseEntity<Object> respuesta;
		
		respuesta = equipoControlador.eliminarEquipo(3);
		
		Assertions.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		
	}

}
