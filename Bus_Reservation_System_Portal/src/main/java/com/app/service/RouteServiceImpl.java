package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.LoginException;
import com.app.exceptions.RouteException;
import com.app.model.CurrentUserSession;
import com.app.model.Route;
import com.app.repository.RouteRepo;
import com.app.repository.SessionRepo;

 @Service
public class RouteServiceImpl implements RouteService{

	
	@Autowired
    private RouteRepo routeRepo;
	
	@Autowired
	private SessionRepo sr;
	
	
	@Override
	public Route addRoute(Route route,String key)throws RouteException,LoginException {
		CurrentUserSession validAdminSession = sr.findByUuid(key);
		
		
		if(validAdminSession == null) {
			throw new LoginException("Admin Not Logged In with this Key");
			
		}
		
		Route routes = routeRepo.save(route);
		if(routes!=null) {
			return routes;	
		}else {
			throw new RouteException("Route not added due to technical error");
		}
		
	}

	
	@Override
	public Route updateRoute(Route route,String key)throws RouteException,LoginException {
		CurrentUserSession validAdminSession = sr.findByUuid(key);
		
		
		if(validAdminSession == null) {
			throw new LoginException("Admin Not Logged In with this Key");
			
		}
				
		Route route2 = new Route();
		
		Optional < Route > optional = routeRepo.findById(route.getRouteId());
	        if (optional.isPresent()) {
	        	route2.setRouteId(route.getRouteId());
	        	route2.setDistance(route.getDistance());
	        	route2.setRouteFrom(route.getRouteFrom());
	        	route2.setRouteTo(route.getRouteTo());	
	          return routeRepo.save(route2);
	        } else {
	            throw new RouteException(" Route not found");
	        }
	        
	}

	@Override
	public Route deleteRoute(int routeId,String key)throws RouteException,LoginException {
		CurrentUserSession validAdminSession = sr.findByUuid(key);
		
		
		if(validAdminSession == null) {
			throw new LoginException("Admin Not Logged In with this Key");
			
		}
		
		 Optional < Route > optional = routeRepo.findById(routeId);
	        if (optional.isPresent()) {
	        	
	        	Route r = optional.get();
	        	
	        	routeRepo.delete(r);
	        	
	        	return r;
	        } else {
	            throw new RouteException(" Route not found for id :: " + routeId);
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
