package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptions.LoginException;
import com.app.exceptions.ReservationException;
import com.app.model.Reservation;
import com.app.service.ReservationService;


@RestController
public class ReservationController {
	
	@Autowired
	private ReservationService Rservice;
	

	
	@PostMapping("/Reservation/{key}")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation,@PathVariable("key") String key)throws ReservationException, LoginException{
		
		Reservation reservation2 = Rservice.addReservation(reservation,key);
		
		return new ResponseEntity<Reservation>(reservation2,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/Reservation/{key}")
	public ResponseEntity<Reservation>updateReservation(@RequestBody Reservation reservation,@PathVariable("key") String key) throws ReservationException, LoginException{
		
		Reservation upadateReservation = Rservice.updateReservation(reservation,key);
		
		return new ResponseEntity<Reservation>(upadateReservation,HttpStatus.ACCEPTED);
		
		
	}
	
	@DeleteMapping("/Reservation/{reservationId}/{key}")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable("reservationId") Integer reservationId,@PathVariable("key") String key) throws ReservationException, LoginException{
		
		Reservation deleteReservation = Rservice.deleteReservation(reservationId,key);
		
		return new ResponseEntity<Reservation>(deleteReservation,HttpStatus.OK);
		
	}

	@GetMapping("/Reservation/{reservationId}/{key}")
	public ResponseEntity<Reservation> viewAllReservation(@PathVariable("reservationId") Integer reservationId,@PathVariable("key") String key) throws ReservationException, LoginException{
		
		Reservation viewReservation = Rservice.viewAllReservation(reservationId,key);
		
		return new ResponseEntity<Reservation>(viewReservation,HttpStatus.OK);
	}
	
	
	@GetMapping("/ReservationbyDate/{reservationDate}")
	public ResponseEntity<List<Reservation>> getAllReservation(@PathVariable("reservationDate") LocalDate ld) throws ReservationException{
		
		List<Reservation> getAllReservation = Rservice.getAllReservation(ld);
		
		return new ResponseEntity<List<Reservation>> (getAllReservation,HttpStatus.OK);
	}
	
}
