package com.password.manager.services;

import java.util.List;
import java.util.Optional;

import com.password.manager.entities.WebsitePasswords;

public interface IPasswordService {

	List<WebsitePasswords> findAllByUserId(Integer user_id);
	
	WebsitePasswords save(WebsitePasswords newPassword);
	
}
