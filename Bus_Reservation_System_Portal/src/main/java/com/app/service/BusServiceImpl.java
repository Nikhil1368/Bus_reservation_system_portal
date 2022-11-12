package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.BusExseption;

import com.app.exceptions.RouteException;

import com.app.model.Bus;
import com.app.model.Route;
import com.app.repository.BusRepo;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepo bRepo;
	
	@Override
	public Bus addBus(Bus bus)throws BusExseption {
		// TODO Auto-generated method stub

		Bus saveBus =bRepo.save(bus);
		if(saveBus!=null) {
			return saveBus;	

		Bus bus2 = bRepo.save(bus);
		if(bus2!=null) {
			return bus2;	

		}else {
			throw new BusExseption("Bus not added due to technical error");
		}
	}

	@Override
	public Bus updateBus(Bus bus)throws BusExseption {
         
		Bus Bus2 = new Bus();
		
		Optional < Bus > optional = bRepo.findById(bus.getBusId());
	        if (optional.isPresent()) {
	        	Bus2.setBusName(bus.getBusName());
	        	Bus2.setBusType(bus.getBusType());
	        	Bus2.setDriverName(bus.getDriverName());
	        	Bus2.setRouteFrom(bus.getRouteFrom());
	        	Bus2.setRouteTo(bus.getRouteTo());
	        	Bus2.setBusId(bus.getBusId());
	        	Bus2.setDepartureTime(bus.getDepartureTime());
	        	Bus2.setArrivalTime(bus.getArrivalTime());
	        	Bus2.setAvailableSeats(bus.getAvailableSeats());
	          return bRepo.save(Bus2);
	        } else {
	            throw new BusExseption(" Route not found");
	        }
	        	
	}

	@Override
	public Bus deleteBus(int busId)throws BusExseption {
		// TODO Auto-generated method stub
		
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
	            throw new BusExseption(" Bus not found for id :: " + busId);
	        }
	        
	}

	@Override
	public Bus viewBus(int busId)throws BusExseption {
		Optional < Bus > optional = bRepo.findById(busId);
		Bus bus = null;
	        if (optional.isPresent()) {
	        return bus = optional.get();
	        } else {
	            throw new BusExseption(" Bus not found for id :: " + busId);
	        }
	}


	

	

}
