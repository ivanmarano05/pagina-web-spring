package com.example.mi_team.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.example.mi_team.entities.UserRole;
import com.example.mi_team.repositories.IUserRoleRepository;
import com.example.mi_team.services.IUserRoleService;

@Service("userRoleService")
public class UserRoleService implements IUserRoleService {

	@Autowired
	@Qualifier("userRoleRepository")
	private IUserRoleRepository userRoleRepository;
	
	@Override
	public UserRole insertOrUpdate(UserRole rol, Boolean esAdmin, com.example.mi_team.entities.User usuario) {
		
		if(esAdmin) {
			rol.setRole("ROLE_ADMIN");
		} else {
			rol.setRole("ROLE_USUARIO");
		}
		
		rol.setUser(usuario);
		
		userRoleRepository.save(rol);
		
		return rol;
		
	}
	
	@Override
	public boolean remove(int id) {
		
		try {
			userRoleRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}