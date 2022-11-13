package com.app.service;

import com.app.exceptions.BusException;
import com.app.exceptions.LoginException;
import com.app.model.Bus;

public interface BusService {

	public Bus addBus(Bus bus,String key)throws BusException,LoginException;
	public Bus updateBus(Bus bus,String key)throws BusException,LoginException;
	public Bus deleteBus(int busId,String key)throws BusException,LoginException;
	public Bus viewBus(int busId)throws BusException;
	
	
}
