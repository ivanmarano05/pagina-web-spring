package com.example.mi_team.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mi_team.entities.EquipoEntidad;
import com.example.mi_team.entities.JugadorEntidad;
import com.example.mi_team.entities.PelotaEntidad;
import com.example.mi_team.models.EquipoModelo;
import com.example.mi_team.models.JugadorModelo;
import com.example.mi_team.models.PelotaModelo;
import com.example.mi_team.services.IJugadorService;

@SpringBootTest
class JugadorServiceTest {
	
	@Autowired
	@Qualifier("jugadorService")
	private IJugadorService jugadorService;
	
	@BeforeEach
	void setUp() {
		
		//Constructores
		
		Set<EquipoModelo> equiposJugadorModelo = new HashSet<>();
		equiposJugadorModelo.add(new EquipoModelo(1, "Prueba"));
		JugadorModelo jugadorModelo1 = new JugadorModelo();
		JugadorModelo jugadorModelo2 = new JugadorModelo(1, "Lionel Messi");
		JugadorModelo jugadorModelo3 = new JugadorModelo(2, "Enzo Fernandez", "mediocampista");
		JugadorModelo jugadorModelo4 = new JugadorModelo(3, "Pedri", "mediocampista", "españa");
		JugadorModelo jugadorModelo5 = new JugadorModelo(4, "Gavi", "mediocampista", "españa", equiposJugadorModelo);
		
		jugadorModelo1.setId(0);
		jugadorModelo1.setNombre("Pepe");
		jugadorModelo1.setPosicion("defensor");
		jugadorModelo1.setPais("Portugal");
		jugadorModelo1.setEquipos(equiposJugadorModelo);
		
		jugadorModelo1.getId();
		jugadorModelo1.getNombre();
		jugadorModelo1.getPosicion();
		jugadorModelo1.getPais();
		jugadorModelo1.getEquipos();
		jugadorModelo1.toString();
		
		Set<EquipoEntidad> equiposJugadorEntidad = new HashSet<>();
		equiposJugadorEntidad.add(new EquipoEntidad(1, "Prueba"));
		JugadorEntidad jugadorEntidad1 = new JugadorEntidad();
		JugadorEntidad jugadorEntidad2 = new JugadorEntidad(1, "Lionel Messi");
		JugadorEntidad jugadorEntidad3 = new JugadorEntidad(2, "Enzo Fernandez", "mediocampista");
		JugadorEntidad jugadorEntidad4 = new JugadorEntidad(3, "Pedri", "mediocampista", "españa");
		JugadorEntidad jugadorEntidad5 = new JugadorEntidad(4, "Gavi", "mediocampista", "españa", equiposJugadorEntidad);
		
		jugadorEntidad1.setId(0);
		jugadorEntidad1.setNombre("Pepe");
		jugadorEntidad1.setPosicion("defensor");
		jugadorEntidad1.setPais("Portugal");
		jugadorEntidad1.setEquipos(equiposJugadorEntidad);
		
		jugadorEntidad1.getId();
		jugadorEntidad1.getNombre();
		jugadorEntidad1.getPosicion();
		jugadorEntidad1.getPais();
		jugadorEntidad1.getEquipos();
		jugadorEntidad1.toString();
		
	}
	
	@Test
	void testGetAll() {

		List<JugadorEntidad> jugadoresEntidad = jugadorService.getAll();
		
		Assertions.assertEquals(23, jugadoresEntidad.size());
		
	}

	@Test
	void testTraerPorId() {

		JugadorModelo jugador = jugadorService.traerPorId(1);
		
		Assertions.assertEquals(1, jugador.getId());
		Assertions.assertEquals("Emiliano Martinez", jugador.getNombre());
		Assertions.assertEquals("arquero", jugador.getPosicion());
		Assertions.assertEquals("Argentina", jugador.getPais());
		
	}

	@Test
	void testGetAllModel() {

		List<JugadorModelo> listaDeJugadores;
		
		listaDeJugadores = jugadorService.getAllModel();
		
		Assertions.assertEquals(22, listaDeJugadores.size());
		
	}

	@Test
	void testInsertOrUpdate() {

		JugadorModelo jugador;
		
		jugador = jugadorService.insertOrUpdate(new JugadorModelo(23, "Cristiano Ronaldo", "delantero", "Portugal"));
		
		Assertions.assertEquals(23, jugador.getId());
		Assertions.assertEquals("Cristiano Ronaldo", jugador.getNombre());
		Assertions.assertEquals("delantero", jugador.getPosicion());
		Assertions.assertEquals("Portugal", jugador.getPais());
		
	}

	@Test
	void testRemove() {

		Boolean borrar;
		Boolean borrar2;
		
		borrar = jugadorService.remove(23);
		borrar2 = jugadorService.remove(74);
		
		Assertions.assertEquals(true, borrar);
		Assertions.assertEquals(false, borrar2);
		
	}

}
