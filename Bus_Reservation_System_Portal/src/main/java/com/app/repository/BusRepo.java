package com.app.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Bus;

public interface BusRepo extends JpaRepository<Bus, Integer> {

	
}
