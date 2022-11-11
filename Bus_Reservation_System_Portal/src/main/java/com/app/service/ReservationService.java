package com.app.service;
import com.app.model.Bus;
import com.app.model.Reservation;

public interface ReservationService {
	
	public Reservation addReservation(String routeFrom, String routeTo,Integer busId);
	
	
}
