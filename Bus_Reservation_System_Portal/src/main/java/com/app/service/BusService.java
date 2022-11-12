package com.app.service;

import com.app.exceptions.BusException;
import com.app.model.Bus;

public interface BusService {

	public Bus addBus(Bus bus)throws BusException;
	public Bus updateBus(Bus bus)throws BusException;
	public Bus deleteBus(int busId)throws BusException;
	public Bus viewBus(int busId)throws BusException;
	
	
}
