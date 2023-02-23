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
import com.example.mi_team.entities.UserRole;
import com.example.mi_team.services.IUserService;

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@BeforeEach
	void setUp() {
		
		//Constructores
		
		Set<UserRole> userRoleSet = new HashSet<>();
		userRoleSet.add(new UserRole(1, new com.example.mi_team.entities.User("juan", "123", true), "ROLE_ADMIN"));
		LocalDateTime fechaInventada1 = LocalDateTime.of(2023, 2, 10, 20, 30, 0);
		LocalDateTime fechaInventada2 = LocalDateTime.of(2016, 1, 4, 14, 50, 0);
		com.example.mi_team.entities.User user1 = new com.example.mi_team.entities.User();
		com.example.mi_team.entities.User user2 = new com.example.mi_team.entities.User(1, "juan", "123");
		com.example.mi_team.entities.User user3 = new com.example.mi_team.entities.User("juan", "123", true);
		com.example.mi_team.entities.User user4 = new com.example.mi_team.entities.User("juan", "123", true, userRoleSet);
		com.example.mi_team.entities.User user5 = new com.example.mi_team.entities.User(1, "juan", "123", true, userRoleSet);
		com.example.mi_team.entities.User user6 = new com.example.mi_team.entities.User(1, "juan", "123", true, fechaInventada1, fechaInventada2, userRoleSet);
		
		user1.setId(0);
		user1.setUserRoles(userRoleSet);
		user1.setUsername("juan");
		user1.setPassword("123");
		user1.setEnabled(true);
		user1.setCreatedAt(fechaInventada1);
		user1.setUpdatedAt(fechaInventada2);
		
		user1.getId();
		user1.getUserRoles();
		user1.getUsername();
		user1.getPassword();
		user1.isEnabled();
		user1.getCreatedAt();
		user1.getUpdatedAt();
		user1.toString();
		
	}

	@Test
	void testInsertOrUpdate() {

		com.example.mi_team.entities.User usuario;
		
		usuario = userService.insertOrUpdate(new com.example.mi_team.entities.User("Miguel Angel", "$2a$10$Cqlltd3H0k2gQLO8.T5d4OaHNC6MS8hiohFzAFjZOcjvm5HTxKRru", true));
		
		Assertions.assertEquals(6, usuario.getId());
		Assertions.assertEquals("Miguel Angel", usuario.getUsername());
		Assertions.assertEquals("$2a$10$Cqlltd3H0k2gQLO8.T5d4OaHNC6MS8hiohFzAFjZOcjvm5HTxKRru", usuario.getPassword());
		
	}

	@Test
	void testRemove() {

		Boolean borrar;
		Boolean borrar2;
		
		borrar = userService.remove(6);
		borrar2 = userService.remove(7);
		
		Assertions.assertEquals(true, borrar);
		Assertions.assertEquals(false, borrar2);
		
	}
	
	@Test
	void testTraerPorId() {

		com.example.mi_team.entities.User usuario = userService.traerPorId(1);
		
		Assertions.assertEquals(1, usuario.getId());
		Assertions.assertEquals("ivo", usuario.getUsername());
		
	}

}
