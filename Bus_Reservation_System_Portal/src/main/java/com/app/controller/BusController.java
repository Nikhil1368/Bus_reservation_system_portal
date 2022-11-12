package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptions.BusException;
import com.app.model.Bus;
import com.app.service.BusService;

@RestController
@RequestMapping("/bus/")
public class BusController {
	@Autowired
	private BusService  bService;
		
	@PostMapping("/save")
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus)throws BusException {
		
        return new ResponseEntity<Bus>(bService.addBus(bus),HttpStatus.OK);
    } 
	
	@GetMapping("/find/{busId}")
    public ResponseEntity<Bus> getBusById(@PathVariable int busId)throws BusException{
		
		return new ResponseEntity<Bus>(bService.viewBus(busId),HttpStatus.OK); 
    }
		
	
	@PutMapping("/update")
    public ResponseEntity<Bus> updateBusById(@RequestBody Bus bus)throws BusException {
		
		return new ResponseEntity<Bus>(bService.updateBus(bus),HttpStatus.OK);
    }
	
	@DeleteMapping("/delet/{busId}")
    public ResponseEntity<Bus> deleteRouteById(@PathVariable int busId)throws BusException {
		
		return new ResponseEntity<Bus>(bService.deleteBus(busId),HttpStatus.OK);
    }

}
