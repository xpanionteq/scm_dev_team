package com.xpanion.scm.dao;

import java.util.List;

import com.xpanion.scm.model.AddressModel;
import com.xpanion.scm.model.ContactModel;
import com.xpanion.scm.model.CustomerRouteModel;
import com.xpanion.scm.model.HomeModel;

/*
 * @author : Aswathy Raj.D
   @purpose : 
 */
public interface ContactDao {
	int saveUpdateContacts(int contactId, String contactName, String companyName, String landNumber,
			String mobileNumber, String email, int contactTypeId, String gstIdentificationNumber,int createUserId, char activeStatus,
			List<AddressModel> addressDetails,int contactAddressId);

    public List<ContactModel> getContactTypes();
	public List<ContactModel> getPrimaryContactDetails(int contactId);

	public List<ContactModel> getVendorDetails();
	
    public List<ContactModel> getContactDetails(int contactTypeId);
    
   
    public List<ContactModel> getCustomerDetails();
    public List<ContactModel> getAddress(int contactId);
    public List<ContactModel> getEditCustomerDetails(int contactId);
    
    public List<ContactModel> getcontactlists();
	public List<ContactModel> getvendors();
	 
    
  // int deletecontact(int contactId,int createUserId,char activeStatus);
    
	
    
    
	/*public List<CustomerRouteModel> filterCustomerDetails(int routeId);*/
//hari
}
