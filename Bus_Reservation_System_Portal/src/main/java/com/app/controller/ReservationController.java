package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

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

import com.app.dto.ReservationDTO;
import com.app.exceptions.LoginException;
import com.app.exceptions.ReservationException;
import com.app.model.Reservations;
import com.app.service.ReservationService;


@RestController
public class ReservationController {
	
	@Autowired
	private ReservationService Rservice;
	

	
	@PostMapping("/Reservation/{key}")
	public ResponseEntity<Reservations> addReservation(@Valid @RequestBody ReservationDTO reservationDTO,@PathVariable String key)throws ReservationException, LoginException{
		
		Reservations reservation2 = Rservice.addReservation(reservationDTO,key);
		
		return new ResponseEntity<Reservations>(reservation2,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/Reservation/{key}")
	public ResponseEntity<Reservations>updateReservation(@Valid @RequestBody Reservations reservation,@PathVariable("key") String key) throws ReservationException, LoginException{
		
		Reservations upadateReservation = Rservice.updateReservation(reservation,key);
		
		return new ResponseEntity<Reservations>(upadateReservation,HttpStatus.ACCEPTED);
		
		
	}
	
	@DeleteMapping("/Reservation/{reservationId}/{key}")
	public ResponseEntity<Reservations> deleteReservation(@PathVariable("reservationId") Integer reservationId,@PathVariable("key") String key) throws ReservationException, LoginException{
		
		Reservations deleteReservation = Rservice.deleteReservation(reservationId,key);
		
		return new ResponseEntity<Reservations>(deleteReservation,HttpStatus.OK);
		
	}

	@GetMapping("/Reservation/{reservationId}/{key}")
	public ResponseEntity<Reservations> viewAllReservation(@PathVariable("reservationId") Integer reservationId,@PathVariable("key") String key) throws ReservationException, LoginException{
		
		Reservations viewReservation = Rservice.viewAllReservation(reservationId,key);
		
		return new ResponseEntity<Reservations>(viewReservation,HttpStatus.OK);
	}
	
	
	
	
}
