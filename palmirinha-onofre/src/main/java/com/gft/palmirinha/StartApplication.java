package com.gft.palmirinha;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gft.palmirinha.entities.User;
import com.gft.palmirinha.repositories.UserRepository;

@Component
public class StartApplication implements CommandLineRunner {
	@Autowired
	private UserRepository repository;
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		User user = repository.findByUsername("admin");
		if(user==null) {
			user = new User();
			user.setName("ADMIN");
			user.setUsername("admin@gft.com");
			user.setPassword("Gft@1234");
			user.getRoles().add("MANAGERS");
			repository.save(user);
		}
		user = repository.findByUsername("user");
		if(user==null) {
			user = new User();
			user.setName("USER");
			user.setUsername("usuario@gft.com");
			user.setPassword("Gft@1234");
			user.getRoles().add("USERS");
			repository.save(user);
	}

  }
}
