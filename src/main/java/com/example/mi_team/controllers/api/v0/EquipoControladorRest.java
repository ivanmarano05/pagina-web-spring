package com.example.mi_team.controllers.api.v0;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mi_team.converters.JugadorConverter;
import com.example.mi_team.entities.EquipoEntidad;
import com.example.mi_team.models.EquipoModelo;
import com.example.mi_team.models.PelotaModelo;
import com.example.mi_team.models.UsuarioModelo;
import com.example.mi_team.models.request.EquipoRequest;
import com.example.mi_team.services.IEquipoService;
import com.example.mi_team.services.IJugadorService;
import com.example.mi_team.services.IPelotaService;
import com.example.mi_team.services.IUsuarioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/v0/equipo")
public class EquipoControladorRest {

	@Autowired
	@Qualifier("equipoService")
	private IEquipoService equipoService;

	@Autowired
	@Qualifier("jugadorService")
	private IJugadorService jugadorService;
	
	@Autowired
	@Qualifier("jugadorConverter")
	private JugadorConverter jugadorConverter;
	
	@Autowired
	@Qualifier("pelotaService")
	private IPelotaService pelotaService;
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<EquipoModelo>> todosLosEquipos(){
		
		List<EquipoModelo> equipos = new ArrayList<EquipoModelo>();
		equipos.add(new EquipoModelo(1,"Fulminadores"));
		equipos.add(new EquipoModelo(2,"Juego Lirico"));
		
		return new ResponseEntity<List<EquipoModelo>>(equipos, HttpStatus.OK);
	}
	
	@Operation(summary="Trae equipo por id", description = "Trae a los equipos con su determinado id y todas sus relaciones")
	@GetMapping("/traer/{id}")
	public ResponseEntity<Object> traerEquipo(@PathVariable("id") int id) {
	
	    EquipoModelo p = equipoService.traerPorId(id);
	    Object body;
	    		
	    if (p == null) {
	    	body = "No se puedo traer al equipo";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	    }

	    return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	@Operation(summary="Lista de equipos", description = "Devuelve la lista de equipos con su pelota, sus jugadores y su usuario")
	@GetMapping("/listaDeEquipos")
	public ResponseEntity<Object> todosLosEquiposBD(){
		
		List<EquipoEntidad> listaEquipos = equipoService.getAll();
		
		Object body = "Lista vacia";
				
		if(listaEquipos != null) {
			body = listaEquipos;
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}
	
	@Operation(summary="Agrega un equipo con pelota y usuario", description = "Se guarda en la base de datos el equipo con su correspondiente pelota y usuario y jugadores nulos.")
	@PostMapping("/agregarEquipo")
	public ResponseEntity<Object> agregar(@RequestBody EquipoRequest equipo){
		
		Object body = "";
		HttpStatus status = HttpStatus.CONFLICT;
		
		EquipoModelo e = new EquipoModelo();
		PelotaModelo p = new PelotaModelo();
		UsuarioModelo u = new UsuarioModelo();
		String pelota;
		String usuario;
		
		u.setNombre(equipo.getUsuario());
		p.setNombre(equipo.getPelota());
		p.setImagen(equipo.getImagen());
		
		pelota = equipo.getPelota();
		usuario = equipo.getUsuario();
		
		p = pelotaService.traerPorNombre(pelota);
		u = usuarioService.traerPorNombre(usuario);
		
		e.setId(equipo.getId());
		e.setNombre(equipo.getNombre());
		e.setPelota(p);
		
		try {
			EquipoModelo equipoAgregado = equipoService.insertOrUpdate(e); 
			
			equipoAgregado = equipoService.traerPorId(equipoAgregado.getId());
			
			equipoAgregado.setUsuario(u);
			
			equipoService.insertOrUpdate(equipoAgregado);
			
			body = equipoAgregado;
			status = HttpStatus.CREATED;
		} catch (Exception error) {
			body = "Error de la excepcion: " + error.getMessage(); 
		}
		
		return ResponseEntity.status(status).body(body);
	}
	
	@Operation(summary="Edita un equipo", description = "Se actualizan los datos de la tabla Equipo")
	@PutMapping("/editarEquipo/{id}")
	public ResponseEntity<Object> editar(@PathVariable int id, 
			@RequestBody EquipoRequest equipo){
		
		Object body = "";
		HttpStatus status = HttpStatus.CONFLICT;
		
		EquipoModelo e = equipoService.traerPorId(id);
		
		e.setId(equipo.getId());
		e.setNombre(equipo.getNombre());
		e.getPelota().setNombre(equipo.getPelota());
		e.getPelota().setImagen(equipo.getImagen());
		e.getUsuario().setNombre(equipo.getUsuario());
		
		
		try {
			EquipoModelo equipoAgregado = equipoService.insertOrUpdate(e); 
			body = equipoAgregado;
			status = HttpStatus.CREATED;
		} catch (Exception error) {
			body = "Error de la excepcion: " + error.getMessage(); 
		}
		
		return ResponseEntity.status(status).body(body);
	}
	
	@Operation(summary="Eliminar equipo por id", description = "Elimina a los equipos con su determinado id y todas sus relaciones")
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminarEquipo(@PathVariable("id") int id) {
		
	    boolean isRemoved = equipoService.remove(id);
	    
	    if (!isRemoved) {
	    	Object body ="No se puedo eliminar";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	    }

	    return ResponseEntity.status(HttpStatus.OK).body("Eliminado id: " +id);
	}
}
