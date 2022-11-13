package com.app.service;
import java.time.LocalDate;
import java.util.List;

import com.app.dto.ReservationDTO;
import com.app.exceptions.LoginException;
import com.app.exceptions.ReservationException;
import com.app.model.Bus;
import com.app.model.Reservation;


public interface ReservationService {
	
	public Reservation addReservation(ReservationDTO reservationDTO,String key ) throws ReservationException,LoginException;

	public Reservation updateReservation(Reservation reservation,String key) throws ReservationException,LoginException;
	
	public Reservation deleteReservation(Integer reservationId,String key) throws ReservationException,LoginException;
	
	public Reservation viewAllReservation(Integer reservationId,String key)throws LoginException;
	
	public List<Reservation> getReservationDeatials(String key) throws ReservationException,LoginException;
	
	public List<Reservation> getAllReservation(LocalDate date) throws ReservationException;
	
	
	
}
