package com.example.mi_team.services;

public interface IUserService {
	
	public com.example.mi_team.entities.User insertOrUpdate(com.example.mi_team.entities.User usuario);
	
	public boolean remove(int id);
	
	public com.example.mi_team.entities.User traerPorId(int id);

}
