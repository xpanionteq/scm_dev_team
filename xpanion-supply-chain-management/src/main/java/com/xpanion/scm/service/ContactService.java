package com.xpanion.scm.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpanion.scm.dao.ContactDao;
import com.xpanion.scm.model.AddressModel;

/*
 * @author : Aswathy Raj.D
 * @purpose:service for contacts
 * 
 */
@Service
public class ContactService {

	@Autowired
	ContactDao contactDao;

	ObjectMapper mapper = new ObjectMapper();

	public static final Logger LOGGER = LoggerFactory.getLogger(ContactService.class);
	
	int returnedContactId;
	List<AddressModel> addressDetailsList;
	// -------------------------------------------------------START------------------------------------------------------------------------------
	public int ContactServiceOperation(int contactId, String contactName,
			String companyName, String landNumber, String mobileNumber, String email, int contactTypeId,
			String gstIdentificationNumber,int createUserId, char activeStatus, String addressDetails)
			throws JsonParseException, JsonMappingException, IOException {
		try {
			if (contactId >= 0) {
				
				if(addressDetails != null) {
					addressDetailsList = mapper.readValue(addressDetails, new TypeReference<List<AddressModel>>() {});	
				}
				else {
					addressDetailsList = null;
				}
				
				 if(contactId > 0 && activeStatus == 'N') {
				contactName=null;
				companyName = null;
				landNumber = null;
				mobileNumber = null;
				email = null;
				gstIdentificationNumber=null;
				contactTypeId = 0;
			}
			 returnedContactId = contactDao.saveUpdateContacts(contactId,contactName, companyName, landNumber,
						mobileNumber, email, contactTypeId,gstIdentificationNumber,createUserId, activeStatus, addressDetailsList);
				
			
			}

		} catch (Exception e) {
			LOGGER.info("Issue in ContactServiceOperation " + e);
			return 0;
		}
		return returnedContactId;
		

	}
// --------------------------------------------------------END------------------------------------------------------------------------------

}