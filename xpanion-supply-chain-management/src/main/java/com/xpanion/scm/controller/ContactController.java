package com.xpanion.scm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpanion.scm.dao.ContactDao;
import com.xpanion.scm.model.AddressModel;
import com.xpanion.scm.model.ContactModel;
import com.xpanion.scm.model.HomeModel;
import com.xpanion.scm.model.QualificationModel;
import com.xpanion.scm.service.ContactService;
import com.xpanion.scm.util.ScmWebResponse;

import java.util.List;
import static com.xpanion.scm.util.CommonConstants.SUCCESS;
import static com.xpanion.scm.util.CommonConstants.FAILED;

/*
 * @author : Aswathy Raj.D
 * @purpose : controller for contacts
 * 
 */
@RestController
public class ContactController {
	@Autowired
	ScmWebResponse response;

	@Autowired
	ContactDao contactDao;
	
	

	@Autowired
	ContactService contactService;
	ObjectMapper mapper = new ObjectMapper();

	public static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

	// --------------------------------------------------------START---------------------------------------------------------------------------------
	@RequestMapping(value = "/contactOperations", method = RequestMethod.POST)
	public @ResponseBody ScmWebResponse saveUpdateDeleteContacts(
			@RequestParam(value = "contactId", required = false) Integer contactId,
			@RequestParam(value = "contactName", required = false) String contactName,
			@RequestParam(value = "companyName", required = false) String companyName,
			@RequestParam(value = "landNumber", required = false) String landNumber,
			@RequestParam(value = "mobileNumber", required = false) String mobileNumber,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value="gstIdentificationNumber",required =false)String gstIdentificationNumber,
			@RequestParam(value = "contactTypeId", required = false) Integer contactTypeId,
			@RequestParam(value = "activeStatus", required = false) Character activeStatus,
			@RequestParam(value = "addressDetails", required = false) String addressDetails) {
		try {
			int createUserId = 1;
	
			List<AddressModel> addressDetailsList;
			if(contactId > 0 && activeStatus == 'N') {
				int contactDetails=contactDao.deletecontact(contactId,createUserId,activeStatus);
				
				
					if(contactDetails >=1) {
					response.setStatus(SUCCESS);
					response.setMessage(null);
					response.setData(null);
				} else if(contactDetails == -2){
					response.setStatus(FAILED);
					response.setData(null);
					response.setMessage("-2");
				
				         }else {
				        	 response.setStatus(FAILED);
				        	 response.setData(null);
				        	 
				         }
			}
			
			
			if(addressDetails != null && activeStatus=='Y') {
				addressDetailsList= mapper.readValue(addressDetails,new TypeReference<List<AddressModel>>() {});
			}
			else {
				addressDetailsList=null;
			}
			if(contactId>=0 && activeStatus=='Y') {
			int contactDetails = contactDao.saveUpdateContacts(contactId,contactName, companyName,
					landNumber, mobileNumber, email, contactTypeId, gstIdentificationNumber,createUserId, activeStatus, addressDetailsList);
			if (contactDetails > 0) {
				response.setStatus(SUCCESS);
				response.setMessage("" + contactDetails + "");
			} else {
				response.setStatus(FAILED);
				response.setMessage("0");
			}
			}
		} catch (Exception e) {
			response.setStatus(FAILED);
			response.setMessage("0");
			LOGGER.info("Issue in saveUpdateDeleteContacts " + e);
		}
		return response;

	}

	// -----------------------------------------------------------END-------------------------------------------------------------------------
	@RequestMapping(value = "/getcust")
	public @ResponseBody ScmWebResponse getcontactlists() {
		try {
			List<ContactModel> custlist = contactDao.getcontactlists();
			response.setStatus(SUCCESS);
			response.setData(custlist);

		} catch (Exception e) {
			LOGGER.error("Issue in getcontactlists() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
	
//--------------------------------------------------------------------------------------------------//
	
	@RequestMapping(value = "/getvend")
	public @ResponseBody ScmWebResponse getvendors() {
		try {
			List<ContactModel> vendlist =contactDao.getvendors();
			response.setStatus(SUCCESS);
			response.setData(vendlist);

		} catch (Exception e) {
			LOGGER.error("Issue in getcontactlists() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}

	
	
	
	// --------------------------------------------------------START------------------------------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date : 27.03.2019
	 * 
	 * @purpose :
	 */
	@RequestMapping(value = "/contactTypes")
	public @ResponseBody ScmWebResponse getContactTypes() {
		try {
			List<ContactModel> contactTypes = contactDao.getContactTypes();
			response.setStatus(SUCCESS);
			response.setData(contactTypes);

		} catch (Exception e) {
			LOGGER.error("Issue in getContactTypes() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
	
	

	// -----------------------------------------------------------END-------------------------------------------------------------------------
	
   //----------------------------------------------------------START------------------------------------------------------------------------
	
	 @RequestMapping(value = "/getSingleCustomerDetails") 
	 public  @ResponseBody ScmWebResponse getSingleCustDetails(
	 @RequestParam(value = "contactTypeId", required = false) Integer contactTypeId) {
	  
	  try {
	  List<ContactModel> contactDetails = contactDao.getContactDetails(contactTypeId);
	  response.setData(contactDetails); 
	  response.setStatus(SUCCESS);
	 
	  }
	  catch (Exception e) { 
		  
	  LOGGER.error("Issue in getSingleCustDetails() ", e);
	  response.setData(null); 
	  response.setStatus(FAILED); 
	  }
	 
	  return response; 
	 }
	 
//------------------------------------------------------------END------------------------------------------------------------------------
//----------------------------------------------------------START------------------------------------------------------------------------
	 @RequestMapping(value = "/getContactDetails") 
	 public  @ResponseBody ScmWebResponse getContactDetails( @RequestParam(value = "contactId", required = false) Integer contactId) {
	  
	  try {
	  List<ContactModel> contactEditDetails =  contactDao.getEditCustomerDetails(contactId);
	  response.setData(contactEditDetails); 
	  response.setStatus(SUCCESS);
	 
	  }
	  catch (Exception e) { 
		  
	  LOGGER.error("Issue in getContactDetails() ", e);
	  response.setData(null); 
	  response.setStatus(FAILED); 
	  }
	 
	  return response; 
	 }
	 
	

		
	
			
	


		 
	//------------------------------------------------------------END------------------------------------------------------------------------

// ------------------------------get vendor List-------------------------------------------------------------------
	/*
	 * @author:ASWATHY RAJ D
	 * 
	 * @date:01-04-2019
	 * 
	 * @purpose:To vie the vendor List
	 */
	@RequestMapping(value = "/viewvendor", method = RequestMethod.GET)
	public @ResponseBody ScmWebResponse viewvendor() {
		LOGGER.error("Vendor details ");
		try {
			List<ContactModel> vendorList = contactDao.getVendorDetails();
			response.setData(vendorList);
			response.setStatus(SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Issue in listing Vendor details ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
	// -------------------------------------------------------------------------------------------------
// ------------------------------get vendor List details-------------------------------------------------------------------
	/*
	 * @author:ASWATHY RAJ D
	 * 
	 * @date:01-04-2019
	 * 
	 * @purpose:To vie the vendor List
	 */
	@RequestMapping(value = "/getPrimaryContactDetails", method = RequestMethod.GET)
	public @ResponseBody ScmWebResponse getPrimaryContactDetails(
			@RequestParam(value = "contactId", required = false) Integer contactId) {
		LOGGER.error("Contact details ");
		try {
			List<ContactModel> contactList = contactDao.getPrimaryContactDetails(contactId);
			response.setData(contactList);
			response.setStatus(SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Issue in listing Contact details ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
// -------------------------------------------------------------------------------------------------
	


}
