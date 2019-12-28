package com.xpanion.scm.controller;

import static com.xpanion.scm.util.CommonConstants.FAILED;
import static com.xpanion.scm.util.CommonConstants.SUCCESS;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.xpanion.scm.dao.RouteDao;
import com.xpanion.scm.model.HomeModel;
import com.xpanion.scm.model.RouteModel;
import com.xpanion.scm.util.ScmWebResponse;

/*
 * @author : ASHLIN ABRAHAM
 * @date : 13.04.2019
 * 
 */
@RestController
public class RouteController {
	@Autowired
	ScmWebResponse response;
	
	@Autowired
	RouteDao routeDao;
	public static final Logger LOGGER = LoggerFactory.getLogger(RouteController.class);
//----------------------------------------------START---------------------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * @date : 13.04.2019
	 * 
	 */
	@RequestMapping(value = "/getRoutes")
	public @ResponseBody ScmWebResponse getContactRoutes() {
		try {
			List<RouteModel> routes = routeDao.getRouteDetails();
			response.setStatus(SUCCESS);
			response.setData(routes);

		} catch (Exception e) {
			LOGGER.error("Issue in getContactRoutes() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
//----------------------------------------------END---------------------------------------------------------------
//---------------------------------------------------------insertion------------------------------------------------------//
	
	@RequestMapping(value = "/routeOperations", method = RequestMethod.POST)
	public @ResponseBody ScmWebResponse saveUpdateroute(
			@RequestParam(value = "routeId", required = false) Integer routeId,
			@RequestParam(value = "route", required = false) String route,
			@RequestParam(value = "startingRoute", required = false) String startingRoute,
			@RequestParam(value = "finalRoute", required = false) String finalRoute,
			@RequestParam(value = "via", required = false) String via,
			@RequestParam(value = "activeStatusIndicator", required = false) Character activeStatusIndicator) 
		throws JsonParseException, JsonMappingException, IOException {
		try {
	int createUserId=1;
	if (activeStatusIndicator == 'N' && routeId > 0) {
		 int routeDetails= routeDao.deleteroute(routeId,activeStatusIndicator,createUserId);
		
		
		 if(routeDetails>=1) {
			
			 response.setStatus(SUCCESS);
			 response.setMessage(null);
			 response.setData(null);
		 }else if(routeDetails == -2) {
			 response.setStatus(FAILED);
			 response.setData(null); 
			 response.setMessage("-2");
		 }else {
			 response.setStatus(FAILED);
			 response.setData(null); 
		 }
		 
		

	}
			int routeDetails =routeDao.saveUpdateroute(routeId,route,startingRoute,finalRoute,via,createUserId,activeStatusIndicator);
			if (routeDetails > 0) {
				response.setStatus(SUCCESS);
				response.setMessage("routeDetails");
			} else {
				response.setStatus(FAILED);
				response.setMessage("0");
			}
		} catch (Exception e) {
			response.setStatus(FAILED);
			response.setMessage("0");
			LOGGER.info("Issue in saveUpdateroute" + e);
		}
		return response;

	}
	
//----------------------------------------------------------------------------------------------------------------------//
	
	@RequestMapping(value = "/getrouteedit")
	public @ResponseBody ScmWebResponse geteditroute( 
			@RequestParam(value="routeId",required=false)Integer routeId){
		try {
			List<RouteModel> routelist = routeDao.geteditroute(routeId);
			response.setStatus(SUCCESS);
			response.setData(routelist);

		} catch (Exception e) {
			LOGGER.error("Issue in getrouteedit() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
	
	
}
