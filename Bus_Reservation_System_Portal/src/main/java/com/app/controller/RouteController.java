package com.app.controller;


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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptions.RouteException;
import com.app.model.Route;
import com.app.service.RouteService;


@RestController
@RequestMapping("/route/")
public class RouteController {
	@Autowired
	private RouteService  rService;
	
	@GetMapping("/viewAll")
    public ResponseEntity<List <Route>> getAllRoutes()throws RouteException {
		
        return new ResponseEntity<List <Route>>(rService.viewAllRoute(),HttpStatus.OK);
    }
	
	@PostMapping("/save")
    public ResponseEntity<Route> createRoute(@RequestBody Route route)throws RouteException {
		
		Route rou = rService.addRoute(route);
		
        return new ResponseEntity<Route>(rou,HttpStatus.OK);
    } 
	
	@GetMapping("/find/{routeId}")
    public ResponseEntity<Route> getRouteById(@PathVariable int routeId)throws RouteException{
		
		Route route = rService.viewRoute(routeId);
		
		return new ResponseEntity<Route>(route,HttpStatus.OK); 
    }
		
	
	@PutMapping("/update")
    public ResponseEntity<Route> updateRouteById(@RequestBody Route route)throws RouteException {
		
		return new ResponseEntity<Route>(rService.updateRoute(route),HttpStatus.OK);
    }
	
	@DeleteMapping("/delet/{routeId}")
    public ResponseEntity<Route> deleteRouteById(@PathVariable int routeId)throws RouteException {
		
		return new ResponseEntity<Route>(rService.deleteRoute(routeId),HttpStatus.OK);
    }

	
}
