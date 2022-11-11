package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.RouteException;
import com.app.model.Route;
import com.app.repository.RouteRepo;

 
public class RouteServiceImpl implements RouteService{

	
	@Autowired
    private RouteRepo routeRepo;
	
	
	@Override
	public Route addRoute(Route route)throws RouteException {
		
		Route routes = routeRepo.save(route);
		if(routes!=null) {
			return routes;	
		}else {
			throw new RouteException("Route not added due to technical error");
		}
		
	}

	
	@Override
	public Route updateRoute(Route route)throws RouteException {
				
		Route route2 = new Route();
		
		Optional < Route > optional = routeRepo.findById(route.getRouteId());
	        if (optional.isPresent()) {
	        	route2.setDistance(route.getDistance());
	        	route2.setRouteFrom(route.getRouteFrom());
	        	route2.setRouteId(route.getRouteId());
	        	route2.setRouteTo(route.getRouteTo());	
	          return routeRepo.save(route2);
	        } else {
	            throw new RouteException(" Route not found");
	        }
	        
	}

	@Override
	public Route deleteRoute(int routeId)throws RouteException {
		
		Route route2 = new Route();
		 Optional < Route > optional = routeRepo.findById(routeId);
	        if (optional.isPresent()) {
	        	route2.setDistance(optional.get().getDistance());
	        	route2.setRouteFrom(optional.get().getRouteFrom());
	        	route2.setRouteTo(optional.get().getRouteTo());
	            route2.setRouteId(optional.get().getRouteId());
	        	this.routeRepo.deleteById(routeId);
	        	return route2;
	        } else {
	            throw new RuntimeException(" Route not found for id :: " + routeId);
	        }
	        
		   
	}

	@Override
	public Route viewRoute(int routeId)throws RouteException {
		
		 Optional < Route > optional = routeRepo.findById(routeId);
		 Route route = null;
	        if (optional.isPresent()) {
	        return route = optional.get();
	        } else {
	            throw new RouteException(" Route not found for id :: " + routeId);
	        }
	        	
	}

	
	@Override
	public List<Route> viewAllRoute()throws RouteException {
		
		    List<Route> routes = routeRepo.findAll();
		    
		    if(routes!=null) {
		    	return routes;	
		    }else {
		    	throw new RouteException("rout not found");
		    }
	        
		
	}


	
		

		
}
