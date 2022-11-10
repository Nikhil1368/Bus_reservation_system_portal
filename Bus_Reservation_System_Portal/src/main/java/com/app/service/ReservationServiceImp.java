package com.app.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


import com.app.model.Bus;
import com.app.model.Reservation;
import com.app.repository.BusRepo;
import com.app.repository.ReservationRepo;

public class ReservationServiceImp implements ReservationService {
	
	@Autowired
	private ReservationRepo rRepo;
	@Autowired
	private BusRepo bRepo;
	

	@Override
	public Reservation addReservation(Reservation reservation)  {
		
		Bus bus= bRepo.findByrouteFrom(routeFrom);

		

		if(bus != null) {
			bus.getRouteFrom().add(reservation);

		}
		else {
			throw new BusException("Bus Not found "+routeFrom);
		}
	}

}
