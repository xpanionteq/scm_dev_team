package com.xpanion.scm.controller;

import static com.xpanion.scm.util.CommonConstants.FAILED;
import static com.xpanion.scm.util.CommonConstants.SUCCESS;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpanion.scm.dao.RackDao;
import com.xpanion.scm.model.WareHouseModel;
import com.xpanion.scm.util.ScmWebResponse;

@RestController
public class RackController {
	
	@Autowired
	ScmWebResponse response;


	@Autowired
	 RackDao rackDao;

	ObjectMapper mapper = new ObjectMapper();

	public static final Logger LOGGER = LoggerFactory.getLogger(RackController.class);
	

	
	//---------------------------------------------------------------------------------------------------------------------//
	
	
	   @RequestMapping(value = "/rackOperations", method = RequestMethod.POST)
	   public @ResponseBody ScmWebResponse saveUpdateRack(
			
			 @RequestParam(value = "rackId", required = false) Integer rackId,
		     @RequestParam(value = "warehouseId",required = false) Integer warehouseId,
		     @RequestParam(value = "sectionId",required = false) Integer sectionId,
		     @RequestParam(value = "rackName",required = false) String rackName,
	    
		   	 @RequestParam(value = "activeStatus", required = false) Character activeStatus) {
		try {
			int createUserId = 1;
	      	if (rackId >= 0 && activeStatus == 'Y') {
			  int Details = rackDao.saveUpdateRack(rackId,warehouseId,sectionId,rackName,createUserId,activeStatus);
				
				if(Details >=1) {
				response.setStatus(SUCCESS);
				response.setMessage(""+Details+"");
			}
			
			 else if(Details == 0){
				response.setStatus(FAILED);
				response.setData(null);
				response.setMessage("0");
			
			 }
		    }
	   
		    }
			catch (Exception e) {
			response.setStatus(FAILED);
			response.setMessage("0");
			LOGGER.info("Issue in saveUpdateRack " + e);
		}
		return response;

	}
	
	
	
	
	   


		//---------------------------------------------------------------------------------------------------------------------//
		
			@RequestMapping(value = "/racks")
			public @ResponseBody ScmWebResponse getrack(
					@RequestParam(value="sectionId",required=false)Integer sectionId) {
				try {
					List<WareHouseModel> warehouse = rackDao.getrack( sectionId);
					response.setStatus(SUCCESS);
					response.setData(warehouse);

				} catch (Exception e) {
					LOGGER.error("Issue in getrack()  ", e);
					response.setData(null);
					response.setStatus(FAILED);
				}

				return response;
			}
			
	
	
	
	

	//---------------------------------------------------------------------------------------------------------------------//
	
		@RequestMapping(value = "/sectionracks")
		public @ResponseBody ScmWebResponse getrackDetails(
				@RequestParam(value="sectionId",required=false)Integer sectionId) {
			try {
				List<WareHouseModel> warehouse = rackDao.getrackDetails( sectionId);
				response.setStatus(SUCCESS);
				response.setData(warehouse);

			} catch (Exception e) {
				LOGGER.error("Issue in getrackDetails()  ", e);
				response.setData(null);
				response.setStatus(FAILED);
			}

			return response;
		}
		
	
	
	 
	
//-----------------------------------------------------------------------------------------------------------------------//
	
	
	
	
	
	
	
}
