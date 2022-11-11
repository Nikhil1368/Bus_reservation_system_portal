package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Bus;
import com.app.model.Reservation;
import com.app.repository.BusRepo;
import com.app.repository.ReservationRepo;


@Service
public class ReservationServiceImp implements ReservationService{

	@Autowired
	private ReservationRepo rRepo;
	@Autowired
	private BusRepo bRepo;
	
	
	Bus busForBooking;

	@Override
	public Reservation addReservation(String routeFrom, String routeTo,Integer busId) {
		
		List<Bus> bus = bRepo.getBusByRoute(routeFrom, routeTo);
		
		
		for( int i=0; i<bus.size(); i++ ) {
			if( bus.get(i).getBusId() == busId ) {
				busForBooking = bus.get(i);
			}
		}
	
		
		
	}
	
	

}
