package com.app.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.Bus;


public interface BusRepo extends JpaRepository<Bus, Integer> {
	
	@Query("select b from Bus b where b.routeFrom =?1 and b.routeTo = ?2")
	public List<Bus> getBusByRoute(String routeFrom, String routeTo);

	public List<Bus> findByBusType(String busType);

}
