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
import com.xpanion.scm.dao.HomeDao;
import com.xpanion.scm.dao.WarehouseDao;
import com.xpanion.scm.model.HomeModel;
import com.xpanion.scm.model.OrderModel;
import com.xpanion.scm.model.WareHouseModel;
import com.xpanion.scm.util.ScmWebResponse;

@RestController
public class warehouseController {
	
	
	@Autowired
	WarehouseDao warehousedao;
	
	@Autowired
	ScmWebResponse response;
	

	
	public static final Logger LOGGER = LoggerFactory.getLogger(warehouseController.class);

	
	
	//----------------------------------------------------------------------------------------------------------//
		@RequestMapping(value = "/warehouseOperations", method = RequestMethod.POST)
		public @ResponseBody ScmWebResponse saveUpdatewarehouse(
				@RequestParam(value = "warehouseId", required = false) Integer warehouseId,
				@RequestParam(value = "organizationId", required = false) Integer organizationId,
				@RequestParam(value = "warehousecode", required = false) String warehousecode,
				@RequestParam(value = "warehouseName", required = false) String warehouseName,
				@RequestParam(value = "warehouseAddress", required = false) String warehouseAddress,
				@RequestParam(value = "mobileNumber", required = false) String mobileNumber,
				@RequestParam(value = "warehouseemail", required = false) String warehouseemail,
			    @RequestParam(value = "activeStatus", required = false) Character activeStatus) 
		
			throws JsonParseException, JsonMappingException, IOException {
			try {
		int createUserId=1;
				int warehouseDetails = warehousedao.saveUpdateWarehouse(warehouseId,warehousecode,warehouseName,warehouseAddress,mobileNumber,warehouseemail,createUserId,activeStatus);
				if (warehouseDetails > 0) {
					response.setStatus(SUCCESS);
					response.setMessage("warehouseDetails");
				} else {
					response.setStatus(FAILED);
					response.setMessage("0");
				}
			} catch (Exception e) {
				response.setStatus(FAILED);
				response.setMessage("0");
				LOGGER.info("Issue in saveUpdatewarehouse" + e);
			}
			return response;

		}
	
	//---------------------------------------------------------------------------------------------------------------------//
		
		
		@RequestMapping(value = "/warehouseitems")
		public @ResponseBody ScmWebResponse getwarehouseDetails() {
			try {
				List<WareHouseModel> warehouse = warehousedao.getwarehouseDetails();
				response.setStatus(SUCCESS);
				response.setData(warehouse);

			} catch (Exception e) {
				LOGGER.error("Issue in getwarehouseDetails()  ", e);
				response.setData(null);
				response.setStatus(FAILED);
			}

			return response;
		}
		
		
	//--------------------------------------------------------------------------------------------------------------//
		
		@RequestMapping(value = "/getwarehouseedit")
		public @ResponseBody ScmWebResponse getwarehouseedit( 
				@RequestParam(value="warehouseId",required=false)Integer warehouseId){
			try {
				List<WareHouseModel> phonelists = warehousedao.getEditwarehouseDetails(warehouseId);
				response.setStatus(SUCCESS);
				response.setData(phonelists);

			} catch (Exception e) {
				LOGGER.error("Issue in getwarehouseedit() ", e);
				response.setData(null);
				response.setStatus(FAILED);
			}

			return response;
		}
		
		
		
		
		
		
		
	
	
	

}
