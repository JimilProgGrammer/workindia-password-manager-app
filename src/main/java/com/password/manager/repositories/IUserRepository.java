package com.password.manager.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.password.manager.entities.Users;

@Repository
public interface IUserRepository extends CrudRepository<Users, Integer> {
	
	public Optional<Users> findByUsername(final String username);
	
	public Users save(Users p);
	
}
