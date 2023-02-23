//package com.example.mi_team;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import com.example.mi_team.controllers.EquipoControlador;
//import com.example.mi_team.converters.EquipoConverter;
//import com.example.mi_team.converters.PelotaConverter;
//import com.example.mi_team.entities.EquipoEntidad;
//import com.example.mi_team.entities.JugadorEntidad;
//import com.example.mi_team.entities.PelotaEntidad;
//import com.example.mi_team.models.PelotaModelo;
//import com.example.mi_team.repositories.IEquipoRepository;
//import com.example.mi_team.repositories.IPelotaRepository;
//import com.example.mi_team.services.IEquipoService;
//import com.example.mi_team.services.IPelotaService;
//import com.example.mi_team.services.IUserRoleService;
//import com.example.mi_team.services.IUserService;
//import com.example.mi_team.services.implementation.EquipoService;
//
//import antlr.collections.List;
//
/////Usaremos Mockito :) Comportamiento sin conectar a base de datos, para que no sea de integración
//
//public class EquipoControladorTest {
//	
////		@Autowired
////		@Qualifier("equipoService")
////		private IEquipoService equipoService;
//	
////		@Autowired
////		@Qualifier("pelotaService")
////		private IPelotaService pelotaService;
//		
//		@Autowired
//		@Qualifier("userRoleService")
//		private IUserRoleService userRoleService;
//		
//		@Autowired
//		@Qualifier("pelotaConverter")
//		private PelotaConverter pelotaConverter;
//		
//		@Autowired
//		@Qualifier("equipoConverter")
//		private EquipoConverter equipoConverter;
//		
//		@Autowired
//		@Qualifier("userService")
//		private IUserService userService;
//		
////		@Autowired
////		@Qualifier("equipoRepository")
////		private IEquipoRepository equipoRepository;
//		
//		@Autowired
//		IPelotaRepository pelotaRepositoryMock = Mockito.mock(IPelotaRepository.class);
//		
//		@Autowired
//		IPelotaService pelotaServiceMock = Mockito.mock(IPelotaService.class);
//		
//		//Antes de cada prueba - Simula la conectividad a la bd
//		@BeforeEach
//		void setUp() {
//			
//			//Constructores
//			
//			//Pelota
//			
//			PelotaModelo pelotaModelo1 = new PelotaModelo();
//			PelotaModelo pelotaModelo2 = new PelotaModelo(1, "Tango");
//			PelotaModelo pelotaModelo3 = new PelotaModelo(2, "Jabulani", "jabulani.jpg");
//			
//			pelotaModelo1.setId(0);
//			pelotaModelo1.setNombre("Al Rihla");
//			pelotaModelo1.setImagen("al rihla.jpg");
//			
//			pelotaModelo1.getId();
//			pelotaModelo1.getNombre();
//			pelotaModelo1.getImagen();
//			pelotaModelo1.toString();
//			
//			Set<EquipoEntidad> equiposPelota = new HashSet<>();
//			equiposPelota.add(new EquipoEntidad(1, "Prueba"));
//			PelotaEntidad pelotaEntidad1 = new PelotaEntidad();
//			PelotaEntidad pelotaEntidad2 = new PelotaEntidad(1, "Tango");
//			PelotaEntidad pelotaEntidad3 = new PelotaEntidad(2, "Jabulani", "jabulani.jpg");
//			PelotaEntidad pelotaEntidad4 = new PelotaEntidad(3, "Brazuca", "brazuca.jpg", equiposPelota);
//			
//			pelotaEntidad1.setId(0);
//			pelotaEntidad1.setNombre("Al Rihla");
//			pelotaEntidad1.setImagen("al rihla.jpg");
//			pelotaEntidad1.setEquipo(equiposPelota);
//			
//			pelotaEntidad1.getId();
//			pelotaEntidad1.getNombre();
//			pelotaEntidad1.getImagen();
//			pelotaEntidad1.getEquipo();
//			pelotaEntidad1.toString();
//			
//			EquipoEntidad equipoEntidad = new EquipoEntidad(1, "Holaaaa");
//			
//			java.util.List<PelotaEntidad> pelotasEntidad = new ArrayList<>();
//			pelotasEntidad.add(new PelotaEntidad(1, "Tangooo"));
//				
//			//Primero instanción los objetos
//			Mockito.when(pelotaServiceMock.traerPorId(1)).thenReturn(pelotaModelo2);
//			Mockito.when(pelotaRepositoryMock.findAll()).thenReturn(pelotasEntidad);
//				
////			//Respuesta - Mockeado
////			pelotaMock = null;
////			respuesta = ResponseEntity.status(HttpStatus.NO_CONTENT).body(pelotaMock);
////				
////			//Primero instanción los objetos
////			Mockito.when(serviceMock.traerPorId(100)).thenReturn(respuesta);
//		}
//			
//			
////		@Test
////		void inicio() {
////				
////			String respuestaMock;
////		//		
////			respuestaMock = controladorMock.inicio();
////				
////			Assertions.assertEquals("home/index", respuestaMock);
////		
////		}
////		
//		
////		@Test
////		public void getAllPelotas(){
////			
////			java.util.List<PelotaEntidad> pelotasEntidad;
////			
////			pelotasEntidad = pelotaRepositoryMock.findAll();
////			
////			Assertions.assertEquals(1, pelotasEntidad.size());
////		        
////		}
//	
//		@Test
//		void traerPorId() {
//			
//			PelotaModelo pelota;
//			
//			pelota = pelotaServiceMock.traerPorId(1);
//
//			Assertions.assertEquals(1, pelota.getId());
//		
//		}
////			
////		@Test
////		void eliminarUsuario() {
////				
////			String respuestaMock;
////		//		
////			respuestaMock = controladorMock.inicio();
////				
////			Assertions.assertEquals("home/index", respuestaMock);
////		
////		}
//		//	
////			@Test
////			void traerFiguritaErronea() {
////		//		
////				ResponseEntity<Object> respuesta;
////		//		
////				respuesta = controladorMock.traerFigurita(100);
////		//		
////				Assertions.assertEquals(null,  ((Figurita) (respuesta.getBody())));
////		//
////			}
//	 
//}
//
