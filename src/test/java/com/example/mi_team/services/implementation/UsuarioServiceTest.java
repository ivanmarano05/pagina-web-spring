package com.example.mi_team.services.implementation;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mi_team.entities.EquipoEntidad;
import com.example.mi_team.entities.UsuarioEntidad;
import com.example.mi_team.models.UsuarioModelo;
import com.example.mi_team.services.IUsuarioService;

@SpringBootTest
class UsuarioServiceTest {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@BeforeEach
	void setUp() {
		
		//Constructores
		
		UsuarioModelo usuarioModelo1 = new UsuarioModelo();
		UsuarioModelo usuarioModelo2 = new UsuarioModelo(1, "ivo");
		
		usuarioModelo1.setId(0);
		usuarioModelo1.setNombre("martu");
		
		usuarioModelo1.getId();
		usuarioModelo1.getNombre();
		usuarioModelo1.toString();
		
		EquipoEntidad equipoEntidad = new EquipoEntidad(1, "Los Capos");
		UsuarioEntidad usuarioEntidad1 = new UsuarioEntidad();
		UsuarioEntidad usuarioEntidad2 = new UsuarioEntidad(1, "ivo");
		UsuarioEntidad usuarioEntidad3 = new UsuarioEntidad(2, "ivo", equipoEntidad);
		
		usuarioEntidad1.setId(0);
		usuarioEntidad1.setNombre("martu");
		usuarioEntidad1.setEquipo(equipoEntidad);
		
		usuarioEntidad1.getId();
		usuarioEntidad1.getNombre();
		usuarioEntidad1.getEquipo();
		usuarioEntidad1.toString();
		
	}

	@Test
	void testGetAll() {

		List<UsuarioEntidad> usuariosEntidad = usuarioService.getAll();
		
		Assertions.assertEquals(4, usuariosEntidad.size());
		
	}

	@Test
	void testTraerPorId() {

		UsuarioModelo usuario = usuarioService.traerPorId(1);
		
		Assertions.assertEquals(1, usuario.getId());
		Assertions.assertEquals("ivo", usuario.getNombre());
		
	}

	@Test
	void testTraerPorNombre() {

		UsuarioModelo usuario = usuarioService.traerPorNombre("martu");
		
		Assertions.assertEquals(2, usuario.getId());
		Assertions.assertEquals("martu", usuario.getNombre());
		
	}

	@Test
	void testInsertOrUpdate() {

		UsuarioModelo usuario;
		
		usuario = usuarioService.insertOrUpdate(new UsuarioModelo(5, "Miguel Angel"));
		
		Assertions.assertEquals(6, usuario.getId());
		Assertions.assertEquals("Miguel Angel", usuario.getNombre());
		
	}

	@Test
	void testRemove() {

		Boolean borrar;
		Boolean borrar2;
		
		borrar = usuarioService.remove(6);
		borrar2 = usuarioService.remove(7);
		
		Assertions.assertEquals(true, borrar);
		Assertions.assertEquals(false, borrar2);
		
	}

	@Test
	void testGetAllModel() {

		List<UsuarioModelo> usuariosModelo = usuarioService.getAllModel();
		
		Assertions.assertEquals(3, usuariosModelo.size());
		
	}

}
