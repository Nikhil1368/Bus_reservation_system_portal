package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.app.model.Bus;
import com.app.model.Reservation;
import antlr.collections.List;


public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
	
	
	
}
