package com.password.manager.services;

import java.util.Optional;

import com.password.manager.entities.Users;

public interface IUserService {

	Optional<Users> findByUsername(String username);
	
	Users save(Users user);
	
}
