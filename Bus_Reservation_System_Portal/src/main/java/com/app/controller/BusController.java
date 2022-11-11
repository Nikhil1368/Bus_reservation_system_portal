package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.model.Bus;
import com.app.service.BusService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class BusController {

	@Autowired
	private BusService bs;
	
	@PostMapping("/save")
	public ResponseEntity<Bus> saveBusHandler(@RequestBody Bus bus) {
		System.out.println(bus.toString());
		
		Bus bu=bs.addBus(bus);
				return new ResponseEntity<Bus>(bu,HttpStatus.OK);
	}
}
