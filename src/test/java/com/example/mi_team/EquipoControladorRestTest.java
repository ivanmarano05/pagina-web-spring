//package com.example.mi_team;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.example.mi_team.controllers.api.v0.EquipoControladorRest;
//import com.example.mi_team.models.EquipoModelo;
//import com.example.mi_team.services.IEquipoService;
//
/////Usaremos Mockito :) Comportamiento sin conectar a base de datos, para que no sea de integración
//
//public class EquipoControladorRestTest {
//	
//		@Autowired
//		@Qualifier("equipoService")
//		private IEquipoService equipoService;
//		
//		@Autowired
//		EquipoControladorRest controladorMock = Mockito.mock(EquipoControladorRest.class);
//		
//		//Antes de cada prueba - Simula la conectividad a la bd
//		@BeforeEach
//		void setUp() {
//				
//			//Respuesta - Mockeado
//			EquipoModelo equipoMock2 = new EquipoModelo();
//			equipoMock2.setId(2);
//			equipoMock2.setNombre("Los Cracks");
//			EquipoModelo equipoMock = new EquipoModelo(1, "Los Fulminadores");
//			ResponseEntity<Object> respuesta = ResponseEntity.status(HttpStatus.OK).body(equipoMock);
//				
//			//Primero instanción los objetos
//			Mockito.when(controladorMock.traerEquipo(1)).thenReturn(respuesta);
//				
//			//Respuesta - Mockeado
//			equipoMock = null;
//			respuesta = ResponseEntity.status(HttpStatus.NO_CONTENT).body(equipoMock);
//				
//			//Primero instanción los objetos
//			Mockito.when(controladorMock.traerEquipo(100)).thenReturn(respuesta);
//		}
//			
//			
//			@Test
//			void traerEquipo() {
//				
//				ResponseEntity<Object> respuesta;
//		//		
//				respuesta = controladorMock.traerEquipo(1);
//				
//				Assertions.assertEquals(1,  ((EquipoModelo) (respuesta.getBody())).getId());
//				Assertions.assertEquals("Los Fulminadores",  ((EquipoModelo) (respuesta.getBody())).getNombre());
//		
//			}
//		//	
//			@Test
//			void traerFiguritaErronea() {
//		//		
//				ResponseEntity<Object> respuesta;
//		//		
//				respuesta = controladorMock.traerEquipo(100);
//		//		
//				Assertions.assertEquals(null,  ((EquipoModelo) (respuesta.getBody())));
//		//
//			}
//	 
//}