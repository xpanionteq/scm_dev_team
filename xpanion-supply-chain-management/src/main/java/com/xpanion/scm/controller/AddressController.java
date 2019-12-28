package com.xpanion.scm.controller;

import static com.xpanion.scm.util.CommonConstants.FAILED;
import static com.xpanion.scm.util.CommonConstants.SUCCESS;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xpanion.scm.dao.AddressDao;
import com.xpanion.scm.dao.ContactDao;
import com.xpanion.scm.model.AddressModel;
import com.xpanion.scm.util.ScmWebResponse;

/*
 * @author : ASHLIN ABRAHAM
 * @date : 27.03.2019
 * @purpose : 
 */
@RestController
public class AddressController {
	@Autowired
	ScmWebResponse response;
	
	@Autowired
	AddressDao addressDao;
	@Autowired
	ContactDao contactDao;
	public static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
//-------------------------------------------------------------START---------------------------------------------------------------------------------
		/*
		 * @author : ASHLIN ABRAHAM
		 * @date : 28.03.2019
		 * @purpose : Get contact details using contact ID
		 * 
		 */
		@RequestMapping(value = "/getSingleCustomerAddressDetails")
		public @ResponseBody ScmWebResponse getSingleCustAddressDetails(
				@RequestParam(value = "contactId", required = false) Integer contactId) {

			try {
				List<AddressModel> address = addressDao.getSingleCustomerAddress(contactId);
				response.setData(address);
				response.setStatus(SUCCESS);

			} catch (Exception e) {
				LOGGER.error("Issue in getSingleCustAddressDetails() ", e);
				response.setData(null);
				response.setStatus(FAILED);
			}

			return response;
		}

//------------------------------------------------------------END------------------------------------------------------------------------
/*//----------------------------------------------------------START---------------------------------------------------------
		
		 * @author : ASHLIN ABRAHAM
		 * @date : 16.04.2019
		 * @purpose : delete address of contacts
		 
		@RequestMapping(value = "/getEmployeePrimaryDet", method = RequestMethod.POST)
		public @ResponseBody ScmWebResponse getEmployeePrimaryDetails(
				@RequestParam(value = "employeeId", required = false) int employeeId){
			try {
				int addressStatus = contactDao.saveUpdateContacts(contactId, firstName, lastName, companyName, landNumber, mobileNumber, email, contactTypeId, createUserId, activeStatus, addressDetails);
			} catch (Exception e) {
				response.setStatus(FAILED);
				response.setData(null);
				response.setMessage("");
				LOGGER.info("Issue in getEmployeePrimaryDetails " + e);
			}
			return response;
		}
	//-----------------------------------------------------END------------------------------------------------------
*/
}
