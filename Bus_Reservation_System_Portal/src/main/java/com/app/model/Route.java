package com.app.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
	
	private Integer routeId;
	private String  routeFrom;
	private String routeTo;
	private Integer distance;
	private List<Bus> bus;
	

}
