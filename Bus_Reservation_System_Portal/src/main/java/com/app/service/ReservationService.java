package com.app.service;
import java.time.LocalDate;
import java.util.List;

import com.app.exceptions.ReservationException;
import com.app.model.Bus;
import com.app.model.Reservation;


public interface ReservationService {
	
	public Reservation addReservation(Reservation reservation ) throws ReservationException;

	public Reservation updateReservation(Reservation reservation) throws ReservationException;
	
	public Reservation deleteReservation(Integer reservationId) throws ReservationException;
	
	public Reservation viewAllReservation(Integer reservationId);
	
	public List<Reservation> getReservationDeatials() throws ReservationException;
	
	public List<Reservation> getAllReservation(LocalDate date) throws ReservationException;
	
	
	
}
