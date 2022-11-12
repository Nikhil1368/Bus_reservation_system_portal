package com.app.service;

import com.app.exceptions.BusExseption;
import com.app.model.Bus;

public interface BusService {

	public Bus addBus(Bus bus)throws BusExseption;
	public Bus updateBus(Bus bus)throws BusExseption;
	public Bus deleteBus(int busId)throws BusExseption;
	public Bus viewBus(int busId)throws BusExseption;
	
	
}
