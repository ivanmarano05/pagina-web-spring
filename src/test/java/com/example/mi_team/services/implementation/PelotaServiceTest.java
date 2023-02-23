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
import com.example.mi_team.entities.PelotaEntidad;
import com.example.mi_team.models.PelotaModelo;
import com.example.mi_team.services.IPelotaService;

@SpringBootTest
class PelotaServiceTest {
	
	@Autowired
	@Qualifier("pelotaService")
	private IPelotaService pelotaService;
	
	@BeforeEach
	void setUp() {
		
		//Constructores
		
		PelotaModelo pelotaModelo1 = new PelotaModelo();
		PelotaModelo pelotaModelo2 = new PelotaModelo(1, "Tango");
		PelotaModelo pelotaModelo3 = new PelotaModelo(2, "Jabulani", "jabulani.jpg");
		
		pelotaModelo1.setId(0);
		pelotaModelo1.setNombre("Al Rihla");
		pelotaModelo1.setImagen("al rihla.jpg");
		
		pelotaModelo1.getId();
		pelotaModelo1.getNombre();
		pelotaModelo1.getImagen();
		pelotaModelo1.toString();
		
		Set<EquipoEntidad> equiposPelota = new HashSet<>();
		equiposPelota.add(new EquipoEntidad(1, "Prueba"));
		PelotaEntidad pelotaEntidad1 = new PelotaEntidad();
		PelotaEntidad pelotaEntidad2 = new PelotaEntidad(1, "Tango");
		PelotaEntidad pelotaEntidad3 = new PelotaEntidad(2, "Jabulani", "jabulani.jpg");
		PelotaEntidad pelotaEntidad4 = new PelotaEntidad(3, "Brazuca", "brazuca.jpg", equiposPelota);
		
		pelotaEntidad1.setId(0);
		pelotaEntidad1.setNombre("Al Rihla");
		pelotaEntidad1.setImagen("al rihla.jpg");
		pelotaEntidad1.setEquipo(equiposPelota);
		
		pelotaEntidad1.getId();
		pelotaEntidad1.getNombre();
		pelotaEntidad1.getImagen();
		pelotaEntidad1.getEquipo();
		pelotaEntidad1.toString();
		
		java.util.List<PelotaEntidad> pelotasEntidad = new ArrayList<>();
		pelotasEntidad.add(new PelotaEntidad(1, "Tangooo"));
		
	}

	@Test
	void testGetAll() {

		List<PelotaEntidad> pelotasEntidad = pelotaService.getAll();
		
		Assertions.assertEquals(4, pelotasEntidad.size());
		
	}

	@Test
	void testTraerPorId() {

		PelotaModelo pelota = pelotaService.traerPorId(1);
		
		Assertions.assertEquals(1, pelota.getId());
		Assertions.assertEquals("Tango", pelota.getNombre());
		
	}

	@Test
	void testTraerPorNombre() {

		PelotaModelo pelota = pelotaService.traerPorNombre("Tango");
		
		Assertions.assertEquals(1, pelota.getId());
		Assertions.assertEquals("Tango", pelota.getNombre());
		
	}

	@Test
	void testGetAllModel() {

		List<PelotaModelo> listaDePelotas;
		
		listaDePelotas = pelotaService.getAllModel();
		
		Assertions.assertEquals(3, listaDePelotas.size());
		
	}

	@Test
	void testInsertOrUpdate() {

		PelotaModelo pelota;
		
		pelota = pelotaService.insertOrUpdate(new PelotaModelo(4, "Brazuca"));
		
		Assertions.assertEquals(4, pelota.getId());
		Assertions.assertEquals("Brazuca", pelota.getNombre());
		
	}

	@Test
	void testRemove() {

		Boolean borrar;
		Boolean borrar2;
		
		borrar = pelotaService.remove(4);
		borrar2 = pelotaService.remove(5);
		
		Assertions.assertEquals(true, borrar);
		Assertions.assertEquals(false, borrar2);
		
	}

}
