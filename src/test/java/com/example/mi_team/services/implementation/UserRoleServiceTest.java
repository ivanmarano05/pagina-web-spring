package com.example.mi_team.services.implementation;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mi_team.entities.EquipoEntidad;
import com.example.mi_team.entities.JugadorEntidad;
import com.example.mi_team.entities.UserRole;
import com.example.mi_team.models.EquipoModelo;
import com.example.mi_team.models.JugadorModelo;
import com.example.mi_team.services.IUserRoleService;
import com.example.mi_team.services.IUserService;

@SpringBootTest
class UserRoleServiceTest {
	
	@Autowired
	@Qualifier("userRoleService")
	private IUserRoleService userRoleService;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@BeforeEach
	void setUp() {
		
		//Constructores
		
		com.example.mi_team.entities.User usuarioUser = new com.example.mi_team.entities.User("juan", "123", true);
		LocalDateTime fechaInventada1 = LocalDateTime.of(2023, 2, 10, 20, 30, 0);
		LocalDateTime fechaInventada2 = LocalDateTime.of(2016, 1, 4, 14, 50, 0);
		UserRole userRole1 = new UserRole();
		UserRole userRole2 = new UserRole(1, usuarioUser, "ROLE_ADMIN");
		UserRole userRole3 = new UserRole(2, usuarioUser, "ROLE_ADMIN", fechaInventada1, fechaInventada2);
		
		
		userRole1.setId(0);
		userRole1.setUser(usuarioUser);
		userRole1.setRole("defensor");
		userRole1.setCreatedAt(fechaInventada1);
		userRole1.setUpdatedAt(fechaInventada2);
		
		userRole1.getId();
		userRole1.getUser();
		userRole1.getRole();
		userRole1.getCreatedAt();
		userRole1.getUpdatedAt();
		
	}

	@Test
	void testInsertOrUpdate() {

		com.example.mi_team.entities.User usuarioUser;
//		com.example.mi_team.entities.User usuarioAdmin;
		
		usuarioUser = userService.traerPorId(1);
//		usuarioAdmin = userService.traerPorId(1);
		
		System.out.println("Usuario User: " + usuarioUser.getUsername());
//		System.out.println("Usuario Admin: " + usuarioAdmin.getUsername());
		
		UserRole rolUser = new UserRole(5, usuarioUser, "ROLE_USUARIO");
//		UserRole rolAdmin = new UserRole(6, usuarioAdmin, "ROLE_ADMIN");
		
		rolUser = userRoleService.insertOrUpdate(rolUser, false, usuarioUser);
//		rolAdmin = userRoleService.insertOrUpdate(rolAdmin, true, usuarioAdmin);
		
		Assertions.assertEquals(5, rolUser.getId());
		Assertions.assertEquals("ivo", usuarioUser.getUsername());
		
//		Assertions.assertEquals(5, rolAdmin.getId());
//		Assertions.assertEquals("ivo", usuarioAdmin.getUsername());
		
	}

	@Test
	void testRemove() {

		Boolean borrar;
		Boolean borrar2;
		
		borrar = userRoleService.remove(5);
		borrar2 = userRoleService.remove(6);
		
		Assertions.assertEquals(true, borrar);
		Assertions.assertEquals(false, borrar2);
		
	}

}
