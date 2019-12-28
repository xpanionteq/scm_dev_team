package com.xpanion.scm.model;
/*
 * @author : ASHLIN ABRAHAM
 * @date : 13.04.2019
 * 
 */

public class RouteModel {
	private int routeId;
	private String route;
	private String startingRoute;
	private String finalRoute;
	private String via;
	private int createUserId;
	private char activeStatusIndicator;

	
	
	
	public String getStartingRoute() {
		return startingRoute;
	}

	public void setStartingRoute(String startingRoute) {
		this.startingRoute = startingRoute;
	}

	public String getFinalRoute() {
		return finalRoute;
	}

	public void setFinalRoute(String finalRoute) {
		this.finalRoute = finalRoute;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public char getActiveStatusIndicator() {
		return activeStatusIndicator;
	}

	public void setActiveStatusIndicator(char activeStatusIndicator) {
		this.activeStatusIndicator = activeStatusIndicator;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

}
