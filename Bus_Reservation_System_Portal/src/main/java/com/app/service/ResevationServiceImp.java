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
import com.app.model.Reservation;
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
	public Reservation addReservation(ReservationDTO reservationDTO,String key ) throws ReservationException,LoginException {
	
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
	
			Reservation reservation=new Reservation();
			
			opt.get().setAvailableSeats(seat-reservationDTO.getNoOfSeatsToBook());
			
			Bus upadateBus=bRepo.save(opt.get());
			
			reservation.setReservationStatus("Successfull");	
			reservation.setDestination(opt.get().getRouteTo());
			reservation.setNoOfSeatsBooked(reservationDTO.getNoOfSeatsToBook());
            reservation.setFare((opt.get().getFarePerSeat())*(reservationDTO.getNoOfSeatsToBook()));
			reservation.setJourneyDate(reservationDTO.getJourneyDate());
            
			java.util.List<Reservation> userReservation =user.getRervation();
			userReservation.add(reservation);
			
			user.setRervation(userReservation);
			
			reservation.setUser(user);
			
			Reservation savedReservation =rRepo.save(reservation);
			
			if(savedReservation==null) throw new ReservationException("Could not Reserve the Added");
			return savedReservation;

	
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
		User user=ur.findById(cus.getUserId()).orElseThrow(()-> new LoginException("User NOt Found"));
		
		java.util.List<Reservation> reList=user.getRervation();
		
		boolean vb=false;
		
         for(int i=0;i<reList.size();i++) {
        	 if(reList.get(i).getReservationId()==reservationId) {
        		 vb=true;
        		 
        		 Optional<Reservation>opt=rRepo.findById(reservationId);
        		 Reservation found=opt.orElseThrow(()-> new ReservationException("Put the valid Id"));
        	
        		 Bus bus=found.getBus();
        		 
        		 if(found.getReservationDate().isBefore(LocalDate.now()))throw new ReservationException("Con't Cancel journey!...");
        	 
        		 bus.setAvailableSeats(bus.getAvailableSeats()+found.getNoOfSeatsBooked());
        		 Bus updateBus=bRepo.save(bus);
        		 
        		 reList.remove(i);
        		 rRepo.delete(found);
        		 return found;
        	
        	 }
         }
		
		if(!vb)throw new LoginException("Reservation Id :"+reservationId +"Incorrect Id");
	    return null;
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
