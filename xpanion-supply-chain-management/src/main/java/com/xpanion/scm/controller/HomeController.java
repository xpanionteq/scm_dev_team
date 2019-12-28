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
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.xpanion.scm.dao.HomeDao;
import com.xpanion.scm.model.ContactModel;
import com.xpanion.scm.model.HomeModel;
import com.xpanion.scm.util.ScmWebResponse;

@RestController
public class HomeController {
	@Autowired
	HomeDao homedao;
	
	@Autowired
	ScmWebResponse response;
	

	
	public static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(value = "/getphonedetails")
	public @ResponseBody ScmWebResponse getphonedetails() {
		try {
			List<HomeModel> phonelist = homedao.getphonedetails();
			response.setStatus(SUCCESS);
			response.setData(phonelist);

		} catch (Exception e) {
			LOGGER.error("Issue in getphonedetails() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
	//------------------------------------------------------------------------------------------------//
	
	@RequestMapping(value = "/getphoneedit")
	public @ResponseBody ScmWebResponse getphoneedit( 
			@RequestParam(value="phoneId",required=false)Integer phoneId){
		try {
			List<HomeModel> phonelist = homedao.getphoneedit(phoneId);
			response.setStatus(SUCCESS);
			response.setData(phonelist);

		} catch (Exception e) {
			LOGGER.error("Issue in getphoneedit() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
	//-------------------------------------------------------------------------------------//
	
    
    
//-----------------------------------------------------------------------------------------------------------//
	
	
	//----------------------------------------------------------------------------------------------------------//
	@RequestMapping(value = "/homeOperations", method = RequestMethod.POST)
	public @ResponseBody ScmWebResponse saveUpdatephone(
			@RequestParam(value = "phoneId", required = false) Integer phoneId,
			
			@RequestParam(value = "contactName", required = false) String contactName,
			@RequestParam(value = "mobileNumber", required = false) String mobileNumber,
			@RequestParam(value = "email", required = false) String email,
			
			 @RequestParam(value = "activeStatus", required = false) Character activeStatus) 
		throws JsonParseException, JsonMappingException, IOException {
		try {
	int createUserId=1;
	if (activeStatus == 'N' && phoneId > 0) {
		 int phoneDetails= homedao.deletephone(phoneId,createUserId,activeStatus);
		
		
		 if(phoneDetails>=1) {
			
			 response.setStatus(SUCCESS);
			 response.setMessage(null);
			 response.setData(null);
		 }else if(phoneDetails == -2) {
			 response.setStatus(FAILED);
			 response.setData(null); 
			 response.setMessage("-2");
		 }else {
			 response.setStatus(FAILED);
			 response.setData(null); 
		 }
		 
		

	}
			int phoneDetails = homedao.saveUpdatephone(phoneId,contactName,mobileNumber,email,createUserId,activeStatus);
			if (phoneDetails > 0) {
				response.setStatus(SUCCESS);
				response.setMessage("phoneDetails");
			} else {
				response.setStatus(FAILED);
				response.setMessage("0");
			}
		} catch (Exception e) {
			response.setStatus(FAILED);
			response.setMessage("0");
			LOGGER.info("Issue in saveUpdatephone" + e);
		}
		return response;

	}
	
	//------------------------------------------------------------------------------------------------------//
	
}