package com.gft.palmirinha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gft.palmirinha.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	//@Query("SELECT e FROM user e JOIN FETCH e.roles WHERE e.username= (:username)")
	//public User findByUsername(@Param("username") String username);

}
