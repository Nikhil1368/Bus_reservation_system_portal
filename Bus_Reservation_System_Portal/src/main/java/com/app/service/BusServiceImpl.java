package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Bus updateBus(Bus bus) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Bus deleteBus(int busId) {
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
	public Bus viewBus(int busId) {
		// TODO Auto-generated method stub
		return null;
	}


	

	

}
