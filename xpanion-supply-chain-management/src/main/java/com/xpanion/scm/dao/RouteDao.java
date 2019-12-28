package com.xpanion.scm.dao;

import java.util.List;

import com.xpanion.scm.model.RouteModel;

/*
 * @author : ASHLIN ABRAHAM
 * @date : 13.04.2019
 * 
 */
public interface RouteDao {
	
	int saveUpdateroute(int routeId,String route,String startingRoute,String finalRoute,String via,int createUserId,char activeStatusIndicator);
	public List<RouteModel> getRouteDetails();
	public List<RouteModel> geteditroute(int routeId);
	
    int deleteroute(int routeId,char activeStatusIndicator,int createUserId);
}
