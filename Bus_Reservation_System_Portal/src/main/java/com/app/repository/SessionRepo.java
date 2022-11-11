package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.CurrentUserSession;

public interface SessionRepo extends JpaRepository<CurrentUserSession, Integer> {

	
	public CurrentUserSession findByUuid(String Uuid);
}
