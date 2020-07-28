package com.password.manager.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.password.manager.services.IUserService;
import com.password.manager.services.UserServiceImpl;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.password.manager.repositories" })
@ComponentScan("com.password.manager.*")
@PropertySource("classpath:application.properties")
public class JPAConfiguration {

	@Bean
	public IUserService userService() {
		return new UserServiceImpl();
	}
	
}
