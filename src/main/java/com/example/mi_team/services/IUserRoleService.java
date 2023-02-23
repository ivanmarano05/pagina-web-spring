package com.example.mi_team.services;

import com.example.mi_team.entities.UserRole;

public interface IUserRoleService {
	
	public UserRole insertOrUpdate(UserRole rol, Boolean esAdmin, com.example.mi_team.entities.User usuario);
	
	public boolean remove(int id);

}
