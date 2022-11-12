package com.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
	
	public List<Reservation> findByReservationDate(LocalDate date);

}
