package com.example.mi_team.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.mi_team.helpers.ViewRouteHelper;
import com.example.mi_team.services.IUsuarioService;

@SpringBootTest
class UserControladorTest {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@Autowired
	UserControlador userControlador = new UserControlador();
	
	@Test
	void testLogin() {

		Model model = new ExtendedModelMap();
        String error = "Error de autenticación";
        String logout = "Cierre de sesión exitoso";
        
        String texto;
		
		texto = userControlador.login(model, error, logout);
		
		Assertions.assertEquals(ViewRouteHelper.USER_LOGIN, texto);
		
	}

	@Test
	void testLoginCheck() {

		String texto;
		
		texto = userControlador.loginCheck();
		
		Assertions.assertEquals("redirect:/equipo/index", texto);
		
	}

	@Test
	void testCrearUsuario() {

		String texto;
		
		texto = userControlador.crearUsuario();
		
		Assertions.assertEquals(ViewRouteHelper.USER_CREARUSUARIO, texto);
		
	}

	@Test
	void testNuevoUsuario() {

        String usuario = "juan";
        String contraseña = "123";
        Boolean esAdmin = false;
        
        ModelAndView mv;
		
        mv = userControlador.nuevoUsuario(usuario, contraseña, esAdmin);
		
		Assertions.assertEquals(ViewRouteHelper.USER_LOGIN, mv.getViewName());
		
	}

	@Test
	void testRedirectPrincipal() {
		
		String texto;
		
		texto = userControlador.redirectPrincipal();
		
		Assertions.assertEquals("redirect:/equipo/index", texto);
		
	}

}
