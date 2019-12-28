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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpanion.scm.dao.ProductDao;
import com.xpanion.scm.dao.SectionDao;
import com.xpanion.scm.model.QualificationModel;
import com.xpanion.scm.model.WareHouseModel;
import com.xpanion.scm.service.ProductService;
import com.xpanion.scm.util.ScmWebResponse;

@RestController
public class SectionController {
	
	
	@Autowired
	ScmWebResponse response;


	@Autowired
	 SectionDao sectionDao;

	ObjectMapper mapper = new ObjectMapper();

	public static final Logger LOGGER = LoggerFactory.getLogger(SectionController.class);
	
	
	
	//---------------------------------------------------------------------------------------------------------------------//
	
	
	   @RequestMapping(value = "/sectionOperations", method = RequestMethod.POST)
	   public @ResponseBody ScmWebResponse saveUpdateSection(
			
			 @RequestParam(value = "sectionId", required = false) Integer sectionId,
		     @RequestParam(value = "warehouseId",required = false) Integer warehouseId,
		     @RequestParam(value = "sectionName",required = false) String sectionName,
	    
		   	 @RequestParam(value = "activeStatus", required = false) Character activeStatus) {
		try {
			int createUserId = 1;
	      	if (sectionId >= 0 && activeStatus == 'Y') {
			  int Details = sectionDao.saveUpdateSection(sectionId,warehouseId,sectionName,createUserId,activeStatus);
				
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
			LOGGER.info("Issue in saveUpdateSection " + e);
		}
		return response;

	}
	
	
	
	
	
	
	
	

	//---------------------------------------------------------------------------------------------------------------------//
	
	
	
	
	@RequestMapping(value = "/sections")
	public @ResponseBody ScmWebResponse getsectionrackDetails(
			@RequestParam(value="warehouseId",required=false)Integer warehouseId) {
		try {
			List<WareHouseModel> warehouse = sectionDao.getsectionrackDetails( warehouseId);
			response.setStatus(SUCCESS);
			response.setData(warehouse);

		} catch (Exception e) {
			LOGGER.error("Issue in getsectionrackDetails()  ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
	
	
//-----------------------------------------------------------------------------------------------------------------------//
	

	
	@RequestMapping(value = "/editsection")
	public @ResponseBody ScmWebResponse getEditsectionDetails(
			@RequestParam(value="sectionId",required=false)Integer sectionId) {
		try {
			List<WareHouseModel> warehouse = sectionDao.getEditsectionDetails( sectionId);
			response.setStatus(SUCCESS);
			response.setData(warehouse);

		} catch (Exception e) {
			LOGGER.error("Issue in getsectionDetails()  ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
	

	
	
	
	
	
	
	

}
