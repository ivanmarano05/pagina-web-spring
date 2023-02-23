package com.example.mi_team.services.implementation;

import java.time.LocalDateTime;
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
import com.example.mi_team.entities.UsuarioEntidad;
import com.example.mi_team.models.EquipoModelo;
import com.example.mi_team.models.JugadorModelo;
import com.example.mi_team.models.PelotaModelo;
import com.example.mi_team.models.UsuarioModelo;
import com.example.mi_team.services.IEquipoService;
import com.example.mi_team.services.IPelotaService;
import com.example.mi_team.services.IUsuarioService;

@SpringBootTest
class EquipoServiceTest {
	
	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;
	
	@Autowired
	@Qualifier("pelotaService")
	private IPelotaService pelotaService;
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@BeforeEach
	void setUp() {
		
		//Constructores
		
		PelotaModelo pelotaModelo = new PelotaModelo(1, "Tango");
		UsuarioModelo usuarioModelo = new UsuarioModelo(1, "juan");
		Set<JugadorModelo> jugadoresModeloSet = new HashSet<>();
		jugadoresModeloSet.add(new JugadorModelo(1, "Theo Hernandez"));
		EquipoModelo equipoModelo1 = new EquipoModelo();
		EquipoModelo equipoModelo2 = new EquipoModelo(1);
		EquipoModelo equipoModelo3 = new EquipoModelo(1, "Los Capos");
		EquipoModelo equipoModelo4 = new EquipoModelo(1, "Los Capos", jugadoresModeloSet);
		EquipoModelo equipoModelo5 = new EquipoModelo(1, "Los Capos", pelotaModelo, jugadoresModeloSet);
		EquipoModelo equipoModelo6 = new EquipoModelo(1, "Los Capos", pelotaModelo, jugadoresModeloSet);
		EquipoModelo equipoModelo7 = new EquipoModelo(1, "Los Capos", pelotaModelo, jugadoresModeloSet, usuarioModelo);
		EquipoModelo equipoModelo8 = new EquipoModelo(1, "Los Capos", pelotaModelo, usuarioModelo);
		
		equipoModelo1.setId(0);
		equipoModelo1.setPelota(pelotaModelo);
		equipoModelo1.setNombre("Los Capos");
		equipoModelo1.setJugadores(jugadoresModeloSet);
		equipoModelo1.setPelota(pelotaModelo);
		
		equipoModelo1.getId();
		equipoModelo1.getPelota();
		equipoModelo1.getNombre();
		equipoModelo1.getJugadores();
		equipoModelo1.getPelota();
		equipoModelo1.toString();
		
		PelotaEntidad pelotaEntidad = new PelotaEntidad(1, "Tango");
		UsuarioEntidad usuarioEntidad = new UsuarioEntidad(1, "juan");
		Set<JugadorEntidad> jugadoresEntidadSet = new HashSet<>();
		jugadoresEntidadSet.add(new JugadorEntidad(1, "Lucas Hernandez"));
		LocalDateTime fechaInventada1 = LocalDateTime.of(2023, 2, 10, 20, 30, 0);
		LocalDateTime fechaInventada2 = LocalDateTime.of(2016, 1, 4, 14, 50, 0);
		EquipoEntidad equipoEntidad1 = new EquipoEntidad();
		EquipoEntidad equipoEntidad2 = new EquipoEntidad(1);
		EquipoEntidad equipoEntidad3 = new EquipoEntidad(1, "Los Capos");
		EquipoEntidad equipoEntidad4 = new EquipoEntidad(1, "Los Capos", jugadoresEntidadSet);
		EquipoEntidad equipoEntidad5 = new EquipoEntidad(1, "Los Capos", pelotaEntidad, jugadoresEntidadSet);
		EquipoEntidad equipoEntidad6 = new EquipoEntidad(1, "Los Capos", pelotaEntidad, jugadoresEntidadSet);
		EquipoEntidad equipoEntidad7 = new EquipoEntidad(1, "Los Capos", pelotaEntidad, jugadoresEntidadSet, usuarioEntidad);
		EquipoEntidad equipoEntidad8 = new EquipoEntidad(1, "Los Capos", pelotaEntidad, usuarioEntidad);
		EquipoEntidad equipoEntidad9 = new EquipoEntidad(1, "Los Capos", pelotaEntidad, jugadoresEntidadSet, fechaInventada1, fechaInventada2);
		
		equipoEntidad1.setId(0);
		equipoEntidad1.setPelota(pelotaEntidad);
		equipoEntidad1.setNombre("Los Capos");
		equipoEntidad1.setJugadores(jugadoresEntidadSet);
		equipoEntidad1.setUsuario(usuarioEntidad);
		equipoEntidad1.setCreatedAt(fechaInventada1);
		equipoEntidad1.setUpdatedAt(fechaInventada2);
		
		equipoEntidad1.getId();
		equipoEntidad1.getPelota();
		equipoEntidad1.getNombre();
		equipoEntidad1.getJugadores();
		equipoEntidad1.getUsuario();
		equipoEntidad1.getCreatedAt();
		equipoEntidad1.getUpdatedAt();
		equipoEntidad1.toString();
		
	}

	@Test
	void testGetAll() {
		
		List<EquipoEntidad> equiposEntidad = equipoService.getAll();
		
		Assertions.assertEquals(4, equiposEntidad.size());
		
	}

	@Test
	void testTraerPorId() {

		EquipoModelo equipo = equipoService.traerPorId(1);
		
		Assertions.assertEquals(1, equipo.getId());
		Assertions.assertEquals("Fulminadores", equipo.getNombre());
		
	}

	@Test
	void testTraerPorIdUsuario() {

		EquipoModelo equipo = equipoService.traerPorIdUsuario(1);
		
		Assertions.assertEquals(1, equipo.getId());
		Assertions.assertEquals("Fulminadores", equipo.getNombre());
		
	}

	@Test
	void testTraerEquipoCompletoPorId() {

		EquipoModelo equipo = equipoService.traerEquipoCompletoPorId(1);
		
		Assertions.assertEquals(1, equipo.getId());
		Assertions.assertEquals("Fulminadores", equipo.getNombre());
		
	}

	@Test
	void testGetEquiposCompletos() {

		List<EquipoEntidad> equipos = equipoService.getEquiposCompletos();
		
		Assertions.assertEquals(3, equipos.size());
		
	}

	@Test
	void testGetAllModel() {

		List<EquipoModelo> equiposModelo = equipoService.getAllModel();
		
		Assertions.assertEquals(3, equiposModelo.size());
		
	}

	@Test
	void testInsertOrUpdate() {

		EquipoModelo equipo;
		
		equipo = equipoService.insertOrUpdate(new EquipoModelo(5, "Los Cracks"));
		
		Assertions.assertEquals(5, equipo.getId());
		Assertions.assertEquals("Los Cracks", equipo.getNombre());
		
	}

	@Test
	void testInsertOrUpdateSet() {

		EquipoModelo equipo = new EquipoModelo(5, "Los Villanos");
		PelotaModelo pelota = pelotaService.traerPorId(3);
		UsuarioModelo usuario = usuarioService.traerPorId(5);
		
		/*REVISAR ACA*/
		
		equipo.setPelota(pelota);
		equipo.setUsuario(usuario);
		
		equipo = equipoService.insertOrUpdateSet(equipo);
		
		Assertions.assertEquals(5, equipo.getId());
		Assertions.assertEquals("Los Villanos", equipo.getNombre());
		
	}

	@Test
	void testJugadoresDelEquipo() {

		Set<JugadorEntidad> jugadores;
		
		jugadores = equipoService.jugadoresDelEquipo(1);
		
		Assertions.assertEquals(12, jugadores.size());
		
	}

	@Test
	void testPelotaDelEquipoEntidad() {

		PelotaEntidad pelota;
		
		pelota = equipoService.pelotaDelEquipoEntidad(1);
		
		Assertions.assertEquals(1, pelota.getId());
		Assertions.assertEquals("Tango", pelota.getNombre());
		
	}

	@Test
	void testPelotaDelEquipoModelo() {

		PelotaModelo pelota;
		
		pelota = equipoService.pelotaDelEquipoModelo(2);
		
		Assertions.assertEquals(2, pelota.getId());
		Assertions.assertEquals("Jabulani", pelota.getNombre());
		
	}

	@Test
	void testUsuarioDelEquipoEntidad() {

		UsuarioEntidad usuario;
		
		usuario = equipoService.usuarioDelEquipoEntidad(1);
		
		Assertions.assertEquals(1, usuario.getId());
		Assertions.assertEquals("ivo", usuario.getNombre());
		
	}

	@Test
	void testUsuarioDelEquipoModelo() {

		UsuarioModelo usuario;
		
		usuario = equipoService.usuarioDelEquipoModelo(1);
		
		Assertions.assertEquals(1, usuario.getId());
		Assertions.assertEquals("ivo", usuario.getNombre());
		
	}

	@Test
	void testRemoveInt() {

		Boolean borrar;
		Boolean borrar2;
		
		borrar = equipoService.remove(5);
		borrar2 = equipoService.remove(10);
		
		Assertions.assertEquals(true, borrar);
		Assertions.assertEquals(false, borrar2);
		
	}

}
