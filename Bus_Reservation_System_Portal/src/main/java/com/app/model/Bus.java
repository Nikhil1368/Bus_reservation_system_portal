package com.app.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Bus {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO )	
	private Integer busId;
	
	@NotNull(message = "Bus Name can not be null..")
	@NotBlank(message = "Bus Name can not be blank..")
	@NotEmpty(message = "Bus Name can not be empty..")
	private String busName;
	
	@NotNull(message = "Driver Name can not be null..")
	@NotBlank(message = "Driver Name can not be blank..")
	@NotEmpty(message = "Driver Name can not be empty..")
	private String driverName;
	
	@NotNull(message = "Bus Type can not be null..")
	@NotBlank(message = "Bus Type can not be blank..")
	@NotEmpty(message = "Bus Type can not be empty..")
	private String busType;
	
	@NotNull(message = "This Field can not be null..")
	@NotBlank(message = "This Field can not be blank..")
	@NotEmpty(message = "This Field can not be empty..")
	private String routeFrom;
	
	@NotNull(message = "This Field can not be null..")
	@NotBlank(message = "This Field can not be blank..")
	@NotEmpty(message = "This Field can not be empty..")
	private String routeTo;

	private LocalTime arrivalTime;
	
	private LocalTime departureTime;
	
	private Integer farePerSeat;
	

	@Min(value = 1)
	@Max(value = 60)

	private Integer seats;
	
	private Integer availableSeats;
	
	@JsonIgnore
	@ManyToOne
	private Route route;

	
	
	
	public Bus(Integer busId,
			@NotNull(message = "Bus Name can not be null..") @NotBlank(message = "Bus Name can not be blank..") @NotEmpty(message = "Bus Name can not be empty..") String busName,
			@NotNull(message = "Driver Name can not be null..") @NotBlank(message = "Driver Name can not be blank..") @NotEmpty(message = "Driver Name can not be empty..") String driverName,
			@NotNull(message = "Bus Type can not be null..") @NotBlank(message = "Bus Type can not be blank..") @NotEmpty(message = "Bus Type can not be empty..") String busType,
			@NotNull(message = "This Field can not be null..") @NotBlank(message = "This Field can not be blank..") @NotEmpty(message = "This Field can not be empty..") String routeFrom,
			@NotNull(message = "This Field can not be null..") @NotBlank(message = "This Field can not be blank..") @NotEmpty(message = "This Field can not be empty..") String routeTo,
			LocalTime arrivalTime, LocalTime departureTime, Integer farePerSeat, @Min(1) @Max(60) Integer seats,
			Integer availableSeats, Route route) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.driverName = driverName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.farePerSeat = farePerSeat;
		this.seats = seats;
		this.availableSeats = availableSeats;
		this.route = route;
	}



	public Integer getBusId() {
		return busId;
	}



	public void setBusId(Integer busId) {
		this.busId = busId;
	}



	public String getBusName() {
		return busName;
	}



	public void setBusName(String busName) {
		this.busName = busName;
	}



	public String getDriverName() {
		return driverName;
	}



	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}



	public String getBusType() {
		return busType;
	}



	public void setBusType(String busType) {
		this.busType = busType;
	}



	public String getRouteFrom() {
		return routeFrom;
	}



	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}



	public String getRouteTo() {
		return routeTo;
	}



	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}



	public LocalTime getArrivalTime() {
		return arrivalTime;
	}



	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}



	public LocalTime getDepartureTime() {
		return departureTime;
	}



	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}



	public Integer getFarePerSeat() {
		return farePerSeat;
	}



	public void setFarePerSeat(Integer farePerSeat) {
		this.farePerSeat = farePerSeat;
	}



	public Integer getSeats() {
		return seats;
	}



	public void setSeats(Integer seats) {
		this.seats = seats;
	}



	public Integer getAvailableSeats() {
		return availableSeats;
	}



	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}



	public Route getRoute() {
		return route;
	}



	public void setRoute(Route route) {
		this.route = route;
	}



	public Bus() {
		// TODO Auto-generated constructor stub
	}
	
	
}

