package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findByContact(Long contact);
	
	
	
	

}
