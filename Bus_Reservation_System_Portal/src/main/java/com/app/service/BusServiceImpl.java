package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.BusInvalidIdException;
import com.app.exceptions.BusNotAvailableException;
import com.app.model.Bus;
import com.app.repository.BusRepo;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepo bRepo;
	
	@Override
	public Bus addBus(Bus bus) {
		// TODO Auto-generated method stub
		Bus saveBus =bRepo.save(bus);
		
		return saveBus;
	}

	@Override
	public Bus updateBus(Bus bus)throws BusNotAvailableException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Bus deleteBus(int busId)throws BusInvalidIdException {
		// TODO Auto-generated method stub
		
		Optional<Bus>b1=bRepo.findById(busId);
		if(b1.isPresent()) {
			Bus existingBus =b1.get();
			bRepo.delete(existingBus);
			return existingBus;
		}
		else {
			return null;
		}
	}

	@Override
	public Bus viewBus(int busId) throws BusInvalidIdException {
		// TODO Auto-generated method stub
		
		Optional<Bus> b2 =bRepo.findById(busId);
		if (b2.isPresent()){
			Bus b3=b2.get();
			return b3;
		}
		else {
			throw new BusInvalidIdException("Bus does not exist with this busId" +busId); 
		}
		
	}

}
