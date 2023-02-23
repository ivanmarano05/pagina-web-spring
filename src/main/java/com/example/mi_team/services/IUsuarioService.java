package com.example.mi_team.services;

import java.util.List;

import com.example.mi_team.entities.UsuarioEntidad;
import com.example.mi_team.models.UsuarioModelo;

public interface IUsuarioService {

	public List<UsuarioEntidad> getAll();
	
	public UsuarioModelo insertOrUpdate(UsuarioModelo usuarioModelo);
	
	public boolean remove(int id);
	
	public UsuarioModelo traerPorId(int id);
	
	public UsuarioModelo traerPorNombre(String nombre);
	
	public List<UsuarioModelo> getAllModel();
	
}
