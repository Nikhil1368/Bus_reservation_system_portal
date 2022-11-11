package com.app.service;

import com.app.exceptions.BusInvalidIdException;
//import com.app.exceptions.BusInvalidIdException;
import com.app.exceptions.BusNotAvailableException;
import com.app.model.Bus;

public interface BusService {

	public Bus addBus(Bus bus);
	public Bus updateBus(Bus bus)throws BusNotAvailableException ;
	public Bus deleteBus(int busId)throws BusInvalidIdException ;
	public Bus viewBus(int busId)throws BusInvalidIdException;
	
	
}
