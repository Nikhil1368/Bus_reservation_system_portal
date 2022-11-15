package com.app.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.BusDTO;
import com.app.dto.ReservationDTO;
import com.app.exceptions.LoginException;
import com.app.exceptions.ReservationException;
import com.app.model.Bus;
import com.app.model.CurrentUserSession;
import com.app.model.Reservations;
import com.app.model.User;
import com.app.repository.BusRepo;
import com.app.repository.ReservationRepo;
import com.app.repository.SessionRepo;
import com.app.repository.UserRepo;

import antlr.collections.List;

@Service
public class ResevationServiceImp implements ReservationService {

	@Autowired
	private ReservationRepo rRepo;
	@Autowired
	private BusRepo bRepo;
	@Autowired
	private SessionRepo sr;
	@Autowired
	private UserRepo ur;
	
	
	
	
	@Override
	public Reservations addReservation(ReservationDTO reservationDTO,String key ) throws ReservationException,LoginException {
	
        CurrentUserSession cus = sr.findByUuid(key);
		
		if(cus == null)
		{
			throw new LoginException("User not Logged In with this key..");
		}
	
		User user=ur.findById(cus.getUserId()).orElseThrow(()-> new LoginException("User NOt Found"));
		
		Optional<Bus> opt=bRepo.findById(reservationDTO.getBusDTO().getBusId());
		
		if(opt.isEmpty()) {
			throw new ReservationException("Bus Id is not watch write correct Id");
		}
		
		if(reservationDTO.getJourneyDate().isBefore(LocalDate.now()))throw new ReservationException("Please enter fucture date!");
		
		if(!reservationDTO.getDestination().equalsIgnoreCase(opt.get().getRouteTo()))
		
			throw new ReservationException("Bus is not Available on route :" +reservationDTO.getDestination());
			
			int seat=opt.get().getAvailableSeats();
			
			if(seat<reservationDTO.getNoOfSeatsToBook())throw new ReservationException("Seat is not available");
	
			opt.get().setAvailableSeats(seat-reservationDTO.getNoOfSeatsToBook());
			
			Bus upadateBus=bRepo.save(opt.get());
			Reservations reservation = new Reservations();
			
			reservation.setReservationStatus("Successfull");	
			reservation.setDestination(opt.get().getRouteTo());
			reservation.setNoOfSeatsBooked(reservationDTO.getNoOfSeatsToBook());
            reservation.setFare((opt.get().getFarePerSeat())*(reservationDTO.getNoOfSeatsToBook()));
			reservation.setJourneyDate(reservationDTO.getJourneyDate());
			reservation.setUser(user);
			reservation.setBus(upadateBus);
			reservation.setReservationType("General");
			reservation.setSource(reservationDTO.getSource());
			
            
//			java.util.List<Reservation> userReservation =user.getRervation();
//			userReservation.g			
//			user.setRervation(userReservation);
			System.out.println(" Hello... ");

			return rRepo.save(reservation);
				
    }
	


	@Override
	public Reservations updateReservation(Reservations reservation,String key) throws ReservationException,LoginException {
        CurrentUserSession cus = sr.findByUuid(key);
		
		if(cus == null)
		{
			throw new LoginException("User not Logged In with this key..");
		}
		Optional<Reservations> opt=rRepo.findById(reservation.getReservationId());
		
		if(opt.isPresent()) {
			Reservations updateReservation=rRepo.save(reservation);
			
			
			return updateReservation;
		}
		else {
			throw new ReservationException("Insert correct Reservation Id");
		}
	}

	@Override
	public Reservations deleteReservation(Integer reservationId,String key) throws ReservationException,LoginException {
		// TODO Auto-generated method stub
         CurrentUserSession cus = sr.findByUuid(key);	
		if(cus == null)
		{
			throw new LoginException("User not Logged In with this key..");
		}
		User user=ur.findById(cus.getUserId()).orElseThrow(()-> new LoginException("User NOt Found"));
		      		 
        Optional<Reservations>opt=rRepo.findById(reservationId);
       Reservations found=opt.orElseThrow(()-> new ReservationException("Put the valid Id")); 
       
        Bus bus=found.getBus();	
        
       if(found.getReservationDate().isBefore(LocalDate.now()))throw new ReservationException("Con't Cancel journey!...");    	 
       bus.setAvailableSeats(bus.getAvailableSeats()+found.getNoOfSeatsBooked());
       Bus updateBus=bRepo.save(bus);
       rRepo.delete(found);
       return found;

	}

	@Override
	public Reservations viewAllReservation(Integer reservationId,String key)throws LoginException {
		
		 CurrentUserSession validAdminSession = sr.findByUuid(key);
			
			
			if(validAdminSession == null) {
				throw new LoginException("Admin Not Logged In with this Key");
				
			}
		
		Optional<Reservations>opt=rRepo.findById(reservationId);
		
		Reservations reservation=opt.get();
		
		return reservation;
		
	}

	@Override
	public java.util.List<Reservations> getReservationDeatials(String key) throws ReservationException,LoginException {
		// TODO Auto-generated method stub
		 CurrentUserSession validAdminSession = sr.findByUuid(key);
			
			
			if(validAdminSession == null) {
				throw new LoginException("Admin Not Logged In with this Key");
				
			}
		java.util.List<Reservations>reservations=rRepo.findAll();
		
		if(reservations.size() == 0) {
			throw new ReservationException("Reservation List is Empty....");
		}
		else {

			return reservations;
		}
	}



}
