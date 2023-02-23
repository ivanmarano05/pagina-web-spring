package com.example.mi_team;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class MiTeamApplicationTests {

	@Test
	void contextLoads() {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String passEncriptado = "tito"; //El pass que quieras para el usuario
		System.out.println("PALABRA: " + passEncriptado + " " + pe.encode(passEncriptado));
	}

}
