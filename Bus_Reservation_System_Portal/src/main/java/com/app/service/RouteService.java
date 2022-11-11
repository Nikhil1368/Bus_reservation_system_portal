package com.app.service;

import java.util.List;

import com.app.exceptions.RouteException;
import com.app.model.Route;

public interface RouteService {
	   public Route addRoute(Route route)throws RouteException;
	   public Route updateRoute(Route route)throws RouteException; 
	   public Route deleteRoute(int routeId)throws RouteException;
	   public Route viewRoute(int routeId)throws RouteException;
	   List<Route> viewAllRoute()throws RouteException;
}
