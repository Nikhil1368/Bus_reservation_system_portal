package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	
	

}
