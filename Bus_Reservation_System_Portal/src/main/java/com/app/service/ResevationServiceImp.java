package com.app.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.LoginException;
import com.app.exceptions.ReservationException;
import com.app.model.Bus;
import com.app.model.CurrentUserSession;
import com.app.model.Reservation;
import com.app.repository.BusRepo;
import com.app.repository.ReservationRepo;
import com.app.repository.SessionRepo;

import antlr.collections.List;

@Service
public class ResevationServiceImp implements ReservationService {

	@Autowired
	private ReservationRepo rRepo;
	@Autowired
	private BusRepo bRepo;
	@Autowired
	private SessionRepo sr;
	
	
	
	
	@Override
	public Reservation addReservation(Reservation reservation,String key) throws ReservationException,LoginException {
		
        CurrentUserSession cus = sr.findByUuid(key);
		
		if(cus == null)
		{
			throw new LoginException("User not Logged In with this key..");
		}
		
		
    Reservation reservation2=rRepo.save(reservation);
		
    if(reservation2 != null) {
    	return reservation2;
    }
    else {
    	throw new ReservationException("Invalid credentials");
    }
		
	
    }
	


	@Override
	public Reservation updateReservation(Reservation reservation,String key) throws ReservationException,LoginException {
        CurrentUserSession cus = sr.findByUuid(key);
		
		if(cus == null)
		{
			throw new LoginException("User not Logged In with this key..");
		}
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
	public Reservation deleteReservation(Integer reservationId,String key) throws ReservationException,LoginException {
		// TODO Auto-generated method stub
         CurrentUserSession cus = sr.findByUuid(key);
		
		if(cus == null)
		{
			throw new LoginException("User not Logged In with this key..");
		}
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
	public Reservation viewAllReservation(Integer reservationId,String key)throws LoginException {
		
		 CurrentUserSession validAdminSession = sr.findByUuid(key);
			
			
			if(validAdminSession == null) {
				throw new LoginException("Admin Not Logged In with this Key");
				
			}
		
		Optional<Reservation>opt=rRepo.findById(reservationId);
		
		Reservation reservation=opt.get();
		
		return reservation;
		
	}

	@Override
	public java.util.List<Reservation> getReservationDeatials(String key) throws ReservationException,LoginException {
		// TODO Auto-generated method stub
		 CurrentUserSession validAdminSession = sr.findByUuid(key);
			
			
			if(validAdminSession == null) {
				throw new LoginException("Admin Not Logged In with this Key");
				
			}
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
