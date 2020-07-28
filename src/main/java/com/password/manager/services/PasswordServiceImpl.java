package com.password.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.password.manager.entities.WebsitePasswords;
import com.password.manager.repositories.IPasswordRepository;

@Transactional
@Service
public class PasswordServiceImpl implements IPasswordService {

	@Autowired
	private IPasswordRepository passwordRepository;
	
	@Override
	public List<WebsitePasswords> findAllByUserId(Integer user_id) {
		return passwordRepository.findAllByUserId(user_id);
	}
	
	@Override
	public WebsitePasswords save(WebsitePasswords newPassword) {
		return passwordRepository.save(newPassword);
	}
	
}
