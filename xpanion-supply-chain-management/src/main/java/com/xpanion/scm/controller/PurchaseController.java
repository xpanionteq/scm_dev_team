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
import com.xpanion.scm.dao.PurchaseDao;
import com.xpanion.scm.model.PurchaseModel;
import com.xpanion.scm.model.PurchaseProductsModel;
import com.xpanion.scm.util.ScmWebResponse;

 /** @author:Aswathy Raj.D
 * @purpose:Controller for Purchase Order
 */
@RestController
public class PurchaseController {
	
	@Autowired
	PurchaseDao purchasedao;

	@Autowired
	ScmWebResponse response;
	
	
	ObjectMapper mapper = new ObjectMapper();
	
	
	public static final Logger LOGGER = LoggerFactory.getLogger(PurchaseController.class);
//------------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/getPurchaseProductDetails", method = RequestMethod.GET)
	public @ResponseBody ScmWebResponse getProductDetails(
			@RequestParam(value = "purchaseId", required = false) Integer purchaseId){
	try {
		List<PurchaseModel> getPurchaseProducts = purchasedao.getPurchaseProductDetails(purchaseId);
		response.setStatus(SUCCESS);
		response.setData(getPurchaseProducts);

		} catch (Exception e) {
			LOGGER.error("Issue in getPurchaseProductDetails() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

	return response;
}
//------------------------------------------------------------------------------------------------------------------------------
 
	
	@RequestMapping(value = "/getContactNames", method = RequestMethod.GET)
	public @ResponseBody ScmWebResponse getContactNames(){
	try {
		List<PurchaseModel> contactName = purchasedao.getContactNames();
		response.setStatus(SUCCESS);
		response.setData(contactName);

		} catch (Exception e) {
			LOGGER.error("Issue in getContactNames() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

	return response;
}

	
	
//------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------
 
	
	@RequestMapping(value = "/getProductNames", method = RequestMethod.GET)
	public @ResponseBody ScmWebResponse getProductNames(){
	try {
		List<PurchaseModel> productName = purchasedao.getProductNames();
		response.setStatus(SUCCESS);
		response.setData(productName);

		} catch (Exception e) {
			LOGGER.error("Issue in getProductNames() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

	return response;
}

	
	
//------------------------------------------------------------------------------------------------------------------------------


	List<PurchaseProductsModel> purchaseProductsList;
   
   @RequestMapping(value = "/puchaseOrderOperations", method = RequestMethod.POST)
	public @ResponseBody ScmWebResponse saveUpdateDeletePurchaseOrder(
			@RequestParam(value = "purchaseId", required = false) Integer purchaseId,
			@RequestParam(value = "contactId", required = false) Integer contactId,
			@RequestParam(value=  "warehouseId",required = false)Integer warehouseId,
			@RequestParam(value = "statusId",required = false)Integer statusId,
			@RequestParam(value = "expectedDeliveryDate", required = false) String expectedDeliveryDate,
			@RequestParam(value = "activeStatus", required = false) Character activeStatus,
			@RequestParam(value = "PurchaseProductsmodel", required = false) String PurchaseProductsmodel)throws JsonParseException, JsonMappingException, IOException {
		
		    try {
			int createUserId = 1;
		    if (purchaseId >= 0 ) {
		    	if(PurchaseProductsmodel != null ){
					
		    		   purchaseProductsList = mapper.readValue(PurchaseProductsmodel, new TypeReference<List<PurchaseProductsModel>>() {});
						
					}
					else{
						purchaseProductsList = null;
				   }
		    	 int purchase = purchasedao.saveUpdatePurchaseOrder(purchaseId, contactId, warehouseId, statusId, expectedDeliveryDate,createUserId, activeStatus, purchaseProductsList);
		    	 
		    	 if (purchase > 0) {
						response.setStatus(SUCCESS);
						response.setData(null);
					} else {
						response.setData(null);
						response.setStatus(FAILED);
					}

				   }
		        }catch (Exception e) {
					LOGGER.error("Issue in saveUpdatePurchaseDetails() ", e);
					response.setData(null);
					response.setStatus(FAILED);
				}

				return response;

	}

//-----------------------------------------------------------------------------------------------------------------------------
   
   @RequestMapping(value = "/getPendingPurchaseId", method = RequestMethod.GET)
	public @ResponseBody ScmWebResponse getPendingPurchaseId(){
	try {
		List<PurchaseModel> pendingPurchase = purchasedao.getPurchaseId();
		response.setStatus(SUCCESS);
		response.setData(pendingPurchase);

		} catch (Exception e) {
			LOGGER.error("Issue in getpendingPurchase() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

	return response;
}
 //------------------------------------------------------------------------------------------------------------------------------
 	@RequestMapping(value = "/getProductDetails", method = RequestMethod.GET)
 	public @ResponseBody ScmWebResponse getProductQuantityDetails(
 			@RequestParam(value = "purchaseProductDetId", required = false) Integer purchaseProductDetId){
 	try {
 		List<PurchaseModel> ProductsDetails = purchasedao.getProductDetails(purchaseProductDetId);
 		response.setStatus(SUCCESS);
 		response.setData(ProductsDetails);

 		} catch (Exception e) {
 			LOGGER.error("Issue in getProductDetails() ", e);
 			response.setData(null);
 			response.setStatus(FAILED);
 		}

 	return response;
 }
// ------------------------------------------------------------------------------------------------------------------------------
  
}
