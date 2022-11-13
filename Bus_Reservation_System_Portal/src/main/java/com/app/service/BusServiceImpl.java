package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.BusException;
import com.app.exceptions.LoginException;
import com.app.exceptions.RouteException;

import com.app.model.Bus;
import com.app.model.CurrentUserSession;
import com.app.model.Route;
import com.app.repository.BusRepo;
import com.app.repository.RouteRepo;
import com.app.repository.SessionRepo;

@Service
public class BusServiceImpl implements BusService {

	private static final String BusType = null;

	@Autowired
	private RouteRepo rRepo;
	
	@Autowired
	private BusRepo bRepo;
	
	@Autowired
	private SessionRepo sr;
	
	@Override
	public Bus addBus(Bus bus,String key)throws BusException,LoginException {
		// TODO Auto-generated method stub
		 CurrentUserSession validAdminSession = sr.findByUuid(key);
			
			
			if(validAdminSession == null) {
				throw new LoginException("Admin Not Logged In with this Key");
				
			}
			
        Route route =rRepo.findByRouteFromAndRouteTo(bus.getRouteFrom(),bus.getRouteTo());
        
        		if(route != null) {
        			route.getBus().add(bus);
        			bus.setRoute(route);
        			return bRepo.save(bus);
        		}
	else {
			throw new BusException("Bus not added due to technical error");
		}
	}

	@Override
	public Bus updateBus(Bus bus,String key)throws BusException,LoginException{
		
		CurrentUserSession validAdminSession = sr.findByUuid(key);
		
		
		if(validAdminSession == null) {
			throw new LoginException("Admin Not Logged In with this Key");
			
		}
         
		Optional<Bus> updateBusOpt =bRepo.findById(bus.getBusId());
		Bus Bus2 = new Bus();
	      
		if(updateBusOpt.isPresent()) {
			Bus existingBus = updateBusOpt.get();
			if(existingBus.getAvailableSeats()!=existingBus.getSeats()) throw new BusException("Cannot update already scheduled bus!");
		
			Route route=rRepo.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());
			if(route == null) throw new BusException("Invalid route!");
			bus.setRoute(route);
			return bRepo.save(bus);
		}
		
	         else {
	            throw new BusException(" Route not found");
	        }
	        	
	}

	@Override
	public Bus deleteBus(int busId,String key)throws BusException,LoginException{
		// TODO Auto-generated method stub
		
CurrentUserSession validAdminSession = sr.findByUuid(key);
		
		
		if(validAdminSession == null) {
			throw new LoginException("Admin Not Logged In with this Key");
			
		}
		
		Bus Bus2 = new Bus();
		 Optional < Bus > optional = bRepo.findById(busId);
	        if (optional.isPresent()) {
	        	Bus2.setBusName(optional.get().getBusName());
	        	Bus2.setBusType(optional.get().getBusType());
	        	Bus2.setDriverName(optional.get().getDriverName());
	        	Bus2.setRouteFrom(optional.get().getRouteFrom());
	        	Bus2.setRouteTo(optional.get().getRouteTo());
	        	Bus2.setBusId(optional.get().getBusId());
	        	Bus2.setDepartureTime(optional.get().getDepartureTime());
	        	Bus2.setArrivalTime(optional.get().getArrivalTime());
	        	Bus2.setAvailableSeats(optional.get().getAvailableSeats());
	        	this.bRepo.deleteById(busId);
	        	return Bus2;
	        } else {
	            throw new BusException(" Bus not found for id :: " + busId);
	        }
	        
	}


	@Override
	public Bus viewBus(int busId)throws BusException {
		Optional < Bus > optional = bRepo.findById(busId);
		Bus bus = null;
	        if (optional.isPresent()) {
	        return bus = optional.get();
	        } else {
	            throw new BusException(" Bus not found for id :: " + busId);
	        }
	}

	@Override
	public List<Bus> viewBusByType(String BusType) throws BusException {
		// TODO Auto-generated method stub
		 List<Bus> listOfBusType = bRepo.findByBusType(BusType);
			
			if(listOfBusType.size() >0)
				return listOfBusType;
			else
				throw new BusException("There is no bus of type "+ BusType);
	}

	@Override
	public List<Bus> viewAllBuses() throws BusException {
		// TODO Auto-generated method stub
		List<Bus> listOfBusType = bRepo.findAll();
		
		if(listOfBusType.size() >0)
			return listOfBusType;
		else
			throw new BusException("There is no bus of type ");
}

	}


	


	

	


