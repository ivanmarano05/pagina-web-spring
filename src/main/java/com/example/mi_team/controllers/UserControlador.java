package com.example.mi_team.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mi_team.entities.UserRole;
import com.example.mi_team.entities.UsuarioEntidad;
import com.example.mi_team.helpers.ViewRouteHelper;
import com.example.mi_team.models.UsuarioModelo;
import com.example.mi_team.services.IUserRoleService;
import com.example.mi_team.services.IUserService;
import com.example.mi_team.services.IUsuarioService;

@Controller
public class UserControlador {
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("userRoleService")
	private IUserRoleService userRoleService;
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;

	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelper.USER_LOGIN;
	}	
	
    @RequestMapping(value="/logout", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null) {      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }

         return ViewRouteHelper.USER_LOGOUT; 
    }
    
//    @GetMapping("/logout")  
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
//        if (auth != null) {      
//           new SecurityContextLogoutHandler().logout(request, response, auth);  
//        }
//
//         return ViewRouteHelper.USER_LOGOUT; 
//    }
    
	@GetMapping("/loginsuccess")
	public String loginCheck() {
		return "redirect:/equipo/index";
	}
	
	@GetMapping("/user/crearUsuario")
	public String crearUsuario() {
		return ViewRouteHelper.USER_CREARUSUARIO;
	}
	
	@PostMapping("/user/nuevoUsuario")
	public ModelAndView nuevoUsuario(@ModelAttribute("username") String usuario, @ModelAttribute("password") String password,
							   		 @ModelAttribute("esAdmin") Boolean esAdmin) {
		
		java.util.List<UsuarioEntidad> listaUsuarios = usuarioService.getAll();
		
		Boolean esRepetido = false;
		
		for (UsuarioEntidad usuarioEntidad : listaUsuarios) { 
			System.out.println("Usuario: " + usuarioEntidad.getNombre());
			
			if(usuarioEntidad.getNombre().equals(usuario)) {
				System.out.println("Hay repetido");
				esRepetido = true;
			}
		}
		
		ModelAndView mV = new ModelAndView();
		
		if(esRepetido) {
			
			System.out.println("El usuario no se insertó por ser repetido");
			
			mV.setViewName(ViewRouteHelper.USER_CREARUSUARIO);
			mV.addObject("texto", "USUARIO REPETIDO. ELIGE OTRO USERNAME");
			
			return mV;
			
		} else {
			
			BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
			String passEncriptado = pe.encode(password);
			
			System.out.println("Usuario: " + usuario);
			System.out.println("Contraseña: " + password);
			System.out.println("Contraseña encriptada: " + passEncriptado);
			
			com.example.mi_team.entities.User usuarioCompleto = new com.example.mi_team.entities.User();
			
			usuarioCompleto.setUsername(usuario);
			usuarioCompleto.setPassword(passEncriptado);
			usuarioCompleto.setEnabled(true);
			
			usuarioCompleto = userService.insertOrUpdate(usuarioCompleto);
			
			UsuarioModelo usuarioNormal = new UsuarioModelo();
			
			usuarioNormal.setNombre(usuario);
			
			usuarioService.insertOrUpdate(usuarioNormal);
			
			usuarioNormal = usuarioService.traerPorNombre(usuario);
			
			UserRole rol = new UserRole();
			
			if(esAdmin) {
				rol = userRoleService.insertOrUpdate(rol, true, usuarioCompleto);
			} else {
				rol = userRoleService.insertOrUpdate(rol, false, usuarioCompleto);
			}
			
			mV.setViewName(ViewRouteHelper.USER_LOGIN);
			mV.addObject("texto", "USUARIO CREADO CORRECTAMENTE");
			
			return mV;
			
		}
		
	}
	
	@GetMapping("")
	public String redirectPrincipal() {
		return "redirect:/equipo/index";
	}
}