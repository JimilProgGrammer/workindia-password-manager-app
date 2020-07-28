package com.password.manager.services;

import org.springframework.transaction.annotation.Transactional;

import com.password.manager.entities.Users;
import com.password.manager.repositories.IUserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public Optional<Users> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public Users save(Users user) {
		return userRepository.save(user);
	}
	
}
