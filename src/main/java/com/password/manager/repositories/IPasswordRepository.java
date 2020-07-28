package com.password.manager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.password.manager.entities.WebsitePasswords;

@Repository
public interface IPasswordRepository extends CrudRepository<WebsitePasswords, Integer> {
	
	@Query("select p from WebsitePasswords p where p.userId = :user_id")
	public List<WebsitePasswords> findAllByUserId(@Param("user_id") Integer user_id);
	
	public WebsitePasswords save(WebsitePasswords newPassword);

}
