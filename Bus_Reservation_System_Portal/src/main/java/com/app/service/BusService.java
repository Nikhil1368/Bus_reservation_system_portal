package com.app.service;

import com.app.model.Bus;

public interface BusService {

	public Bus addBus(Bus bus);
	public Bus updateBus(Bus bus);
	public Bus deleteBus(int busId);
	public Bus viewBus(int busId);
	
	
}
