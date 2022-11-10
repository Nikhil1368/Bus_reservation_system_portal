package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.currentUserSession;

public interface SessionRepo extends JpaRepository<currentUserSession, Integer> {

	
	public currentUserSession findByUuid(String Uuid);
}
