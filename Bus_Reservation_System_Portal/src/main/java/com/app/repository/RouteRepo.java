package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Route;

public interface RouteRepo extends JpaRepository<Route, Integer> {

}
