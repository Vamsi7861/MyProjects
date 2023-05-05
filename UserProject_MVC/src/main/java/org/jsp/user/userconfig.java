package org.jsp.user;

import javax.persistence.EntityManager;

import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.jsp.user")
public class userconfig {
	@Bean
	public EntityManager getenEntityManager() {
		return Persistence.createEntityManagerFactory("dev").createEntityManager();
	}

}
