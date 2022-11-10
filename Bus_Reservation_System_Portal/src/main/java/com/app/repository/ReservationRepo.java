package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

}
