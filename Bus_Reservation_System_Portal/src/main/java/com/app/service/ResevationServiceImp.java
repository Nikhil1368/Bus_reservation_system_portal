package com.app.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.ReservationException;
import com.app.model.Bus;
import com.app.model.Reservation;
import com.app.repository.BusRepo;
import com.app.repository.ReservationRepo;

import antlr.collections.List;

@Service
public class ResevationServiceImp implements ReservationService {

	@Autowired
	private ReservationRepo rRepo;
	@Autowired
	private BusRepo bRepo;
	
	
	
	
	@Override
	public Reservation addReservation(Reservation reservation) throws ReservationException {
		
    Reservation reservation2=rRepo.save(reservation);
		
    if(reservation2 != null) {
    	return reservation2;
    }
    else {
    	throw new ReservationException("Invalid credentials");
    }
		
	
    }
	


	@Override
	public Reservation updateReservation(Reservation reservation) throws ReservationException {
		Optional<Reservation> opt=rRepo.findById(reservation.getReservationId());
		
		if(opt.isPresent()) {
			Reservation updateReservation=rRepo.save(reservation);
			
			return updateReservation;
		}
		else {
			throw new ReservationException("Insert correct Reservation Id");
		}
	}

	@Override
	public Reservation deleteReservation(Integer reservationId) throws ReservationException {
		// TODO Auto-generated method stub
		
          Optional<Reservation> opt=rRepo.findById(reservationId);
		
		if(opt.isPresent()) {
			Reservation DeleteReservation=opt.get();
			rRepo.delete(DeleteReservation);
			
			return DeleteReservation;
		}
		else {
			throw new ReservationException("Insert Correct Reservation Id");
		}
	}

	@Override
	public Reservation viewAllReservation(Integer reservationId) {
		
		Optional<Reservation>opt=rRepo.findById(reservationId);
		
		Reservation reservation=opt.get();
		
		return reservation;
		
	}

	@Override
	public java.util.List<Reservation> getReservationDeatials() throws ReservationException {
		// TODO Auto-generated method stub
		java.util.List<Reservation>reservations=rRepo.findAll();
		
		if(reservations.size() == 0) {
			throw new ReservationException("Reservation List is Empty....");
		}
		else {

			return reservations;
		}
	}



	@Override
	public java.util.List<Reservation>  getAllReservation(LocalDate date) throws ReservationException {
        java.util.List<Reservation> reservations=rRepo.findByReservationDate(date);
		
        if(reservations.size() == 0) {
        	throw new ReservationException("No Reservation fot This Date");
        }
        else {
        	return reservations;
        }
		
		
	}

}
