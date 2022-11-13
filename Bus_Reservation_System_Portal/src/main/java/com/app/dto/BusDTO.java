package com.app.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BusDTO {

	private Integer busId;
	private String routeFrom;
	private String routeTo;
	
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate busJourneyDate;



	public Integer getBusId() {
		return busId;
	}



	public void setBusId(Integer busId) {
		this.busId = busId;
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



	public LocalDate getBusJourneyDate() {
		return busJourneyDate;
	}



	public void setBusJourneyDate(LocalDate busJourneyDate) {
		this.busJourneyDate = busJourneyDate;
	}



	public BusDTO(Integer busId, String routeFrom, String routeTo, LocalDate busJourneyDate) {
		super();
		this.busId = busId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.busJourneyDate = busJourneyDate;
	}
	public BusDTO(){
		
	}
	
	
}
