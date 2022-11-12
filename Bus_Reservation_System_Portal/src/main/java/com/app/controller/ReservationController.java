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

import com.app.exceptions.ReservationException;
import com.app.model.Reservation;
import com.app.service.ReservationService;


@RestController
public class ReservationController {
	
	@Autowired
	private ReservationService Rservice;
	

	
	@PostMapping("/Reservation")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation)throws ReservationException{
		
		Reservation reservation2 = Rservice.addReservation(reservation);
		
		return new ResponseEntity<Reservation>(reservation2,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/Reservation")
	public ResponseEntity<Reservation>updateReservation(@RequestBody Reservation reservation) throws ReservationException{
		
		Reservation upadateReservation = Rservice.updateReservation(reservation);
		
		return new ResponseEntity<Reservation>(upadateReservation,HttpStatus.ACCEPTED);
		
		
	}
	
	@DeleteMapping("/Reservation/{reservationId}")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable("reservationId") Integer reservationId) throws ReservationException{
		
		Reservation deleteReservation = Rservice.deleteReservation(reservationId);
		
		return new ResponseEntity<Reservation>(deleteReservation,HttpStatus.OK);
		
	}

	@GetMapping("/Reservation/{reservationId}")
	public ResponseEntity<Reservation> viewAllReservation(@PathVariable("reservationId") Integer reservationId) throws ReservationException{
		
		Reservation viewReservation = Rservice.viewAllReservation(reservationId);
		
		return new ResponseEntity<Reservation>(viewReservation,HttpStatus.OK);
	}
	
	
	@GetMapping("/ReservationbyDate/{reservationDate}")
	public ResponseEntity<List<Reservation>> getAllReservation(@PathVariable("reservationDate") LocalDate ld) throws ReservationException{
		
		List<Reservation> getAllReservation = Rservice.getAllReservation(ld);
		
		return new ResponseEntity<List<Reservation>> (getAllReservation,HttpStatus.OK);
	}
	
}
