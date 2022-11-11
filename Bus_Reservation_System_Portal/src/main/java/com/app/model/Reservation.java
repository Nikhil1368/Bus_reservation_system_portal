package com.app.model;

import java.time.LocalDate;
import java.time.LocalTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reservationId;
	
	@NotNull(message = "This Field can not be null..")
	@NotBlank(message = "This Field can not be blank..")
	@NotEmpty(message = "This Field can not be empty..")
	private String reservationStatus;
	
	@NotNull(message = "This Field can not be null..")
	@NotBlank(message = "This Field can not be blank..")
	@NotEmpty(message = "This Field can not be empty..")
	private String reservationType;
	private LocalDate reservationDate;
	private LocalTime reservationTime;
	
	@NotNull(message = "This Field can not be null..")
	@NotBlank(message = "This Field can not be blank..")
	@NotEmpty(message = "This Field can not be empty..")
	private String source;
	
	@NotNull(message = "This Field can not be null..")
	@NotBlank(message = "This Field can not be blank..")
	@NotEmpty(message = "This Field can not be empty..")
	private String destination;
	
	
	@OneToOne
	private Bus bus;
	public Integer getReservationId() {
		return reservationId;
	}
	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}
	public String getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	public String getReservationType() {
		return reservationType;
	}
	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	public LocalTime getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(LocalTime reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", reservationStatus=" + reservationStatus
				+ ", reservationType=" + reservationType + ", reservationDate=" + reservationDate + ", reservationTime="
				+ reservationTime + ", source=" + source + ", destination=" + destination + ", bus=" + bus + "]";
	}
	public Reservation(Integer reservationId, String reservationStatus, String reservationType,
			LocalDate reservationDate, LocalTime reservationTime, String source, String destination, Bus bus) {
		super();
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.source = source;
		this.destination = destination;
		this.bus = bus;
	}
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	
		

}
