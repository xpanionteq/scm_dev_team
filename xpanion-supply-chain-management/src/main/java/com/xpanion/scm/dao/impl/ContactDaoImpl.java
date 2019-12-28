package com.xpanion.scm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.xpanion.scm.dao.ContactDao;
import com.xpanion.scm.model.AddressModel;
import com.xpanion.scm.model.ContactModel;
import com.xpanion.scm.model.CustomerRouteModel;
import com.xpanion.scm.model.HomeModel;

@Repository
public class ContactDaoImpl implements ContactDao {

	public static final Logger LOGGER = LoggerFactory.getLogger(ContactDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	int returnContactId;
	int addressStatus;

	// ---------------------------------------------------CUSTOMER INSERTION-------------------------------------------------------------------------
	/*
	 * 
	 * @see com.xpanion.scm.dao.ContactDao#saveUpdateContacts(int, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, int, int,
	 * java.lang.String, int, int, char, java.util.List)
	 * 
	 * @author : Aswathy Raj.D
	  
	 * @purpose : save/edit/delete/view contacts in SCM
	 * 
	 * @exception : SQLException, DataAccessException
	 */
	@Override
	public int saveUpdateContacts(int contactId, String contactName,String companyName,
			String landNumber, String mobileNumber, String email, int contactTypeId, String gstIdentificationNumber,int createUserId,
			char activeStatus, List<AddressModel> addressDetails) {
		SqlParameterSource in;
		SimpleJdbcCall saveContactJdbcCall = null;
		SimpleJdbcCall saveAddressJdbcCall = null;
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;
		try {
			LOGGER.info("saveUpdateContacts()");
			if (contactTypeId > 0 && contactId >= 0) {
				saveContactJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						.withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_contact_details");
				inParamMap.put("p_contact_id", Integer.valueOf(contactId));
				inParamMap.put("p_contact_name", String.valueOf(contactName));
				inParamMap.put("p_company_name", String.valueOf(companyName));
				inParamMap.put("p_land_number", String.valueOf(landNumber));
				inParamMap.put("p_mobile_number", String.valueOf(mobileNumber));
				inParamMap.put("p_email", String.valueOf(email));
				inParamMap.put("p_contact_type_id", Integer.valueOf(contactTypeId));
				inParamMap.put("p_gst_identification_number",String.valueOf(gstIdentificationNumber));
				inParamMap.put("p_user_id", Integer.valueOf(createUserId));
				inParamMap.put("p_active_status", Character.valueOf(activeStatus));
				in = new MapSqlParameterSource(inParamMap);
				saveJdbcCallResult = saveContactJdbcCall.execute(in);
				saveJdbcCallResult.entrySet().forEach(System.out::println);
				saveJdbcCallResult.forEach((key, value) -> returnContactId = (int) value);
				LOGGER.info("id of the contact " + returnContactId);
			}

			if ((returnContactId > 0|| contactId >0) && addressDetails != null && activeStatus =='Y') {
				
			LOGGER.info("saveAndUpdateAddress()");

				saveAddressJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						.withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_contact_address_details");
				for (AddressModel address : addressDetails) {
					inParamMap.put("p_contact_address_id", address.getAddressId());
					if (contactId > 0) {
						inParamMap.put("p_contact_id", contactId);
					} else {
						inParamMap.put("p_contact_id", returnContactId);
					}
					//inParamMap.put("p_contact_id", address.getContactId());
					inParamMap.put("p_building", address.getBuildingNo());
					inParamMap.put("p_locality", address.getLocality());
					inParamMap.put("p_land_mark", address.getLandmark());
					inParamMap.put("p_city", address.getDistrict());
					inParamMap.put("p_state", address.getState());
					inParamMap.put("p_zipcode", address.getZipCode());
					inParamMap.put("p_shipment_route_id", address.getRouteId());
					inParamMap.put("p_work_phone", address.getContactNumber());
					inParamMap.put("p_user_id", createUserId);
					inParamMap.put("p_active_status", activeStatus);
					in = new MapSqlParameterSource(inParamMap);
					saveJdbcCallResult = saveAddressJdbcCall.execute(in);
					saveJdbcCallResult.entrySet().forEach(System.out::println);
					saveJdbcCallResult.forEach((key,value) -> addressStatus = (int)value);
					LOGGER.info("address id of the customer" +addressStatus);
				}
			}
			if (contactId > 0) {
				return contactId;
			}
			return returnContactId;
		} catch (Exception e) {
			LOGGER.info("error in saveUpdateContacts()" + e);
			return 0;
		}
	}
	
	//-----------------------------------------------------------delete-------------------------------------------------------------------------------//
	@Override
	public  int deletecontact(int contactId,int createUserId,char activeStatus){
		SqlParameterSource in;
		SimpleJdbcCall deleteContactJdbcCall = null;
		
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;
		try {
			LOGGER.info("deleteUpdateContacts()");
			
				deleteContactJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						.withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_contact_details");
				inParamMap.put("p_contact_id", Integer.valueOf(contactId));
				inParamMap.put("p_contact_name",null);
				inParamMap.put("p_company_name", null);
				inParamMap.put("p_land_number",null);
				inParamMap.put("p_mobile_number", null);
				inParamMap.put("p_email", null);
				inParamMap.put("p_contact_type_id",null);
				inParamMap.put("p_gst_identification_number",null);
				inParamMap.put("p_user_id", Integer.valueOf(createUserId));
				inParamMap.put("p_active_status", Character.valueOf(activeStatus));
				in = new MapSqlParameterSource(inParamMap);
				saveJdbcCallResult = deleteContactJdbcCall.execute(in);
				saveJdbcCallResult.entrySet().forEach(System.out::println);
				saveJdbcCallResult.forEach((key, value) -> returnContactId = (int) value);
				LOGGER.info("id of the contact " + returnContactId);
			
			return returnContactId;
		} catch (Exception e) {
			LOGGER.info("error in deleteContactJdbcCall()" + e);
			return 0;
		}
	}

	// -------------------------------------------------------GET CONTACT TYPE-----------------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xpanion.scm.dao.ContactDao#getContactTypes()
	 * 
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date : 27.03.2019
	 * 
	 * @purpose :
	 * 
	 */
	@Override
	public List<ContactModel> getContactTypes() {
		List<ContactModel> contactModel = new ArrayList<ContactModel>();
		String sql = "select pk_contact_type_id,lower(contact_type) from xpanion_supply_chain_management_system_dev.t_mst_scm_contact_type";

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ContactModel>>() {
			@Override
			public List<ContactModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ContactModel model = new ContactModel();
					model.setContactTypeId(rs.getInt(1));
					model.setContactType(rs.getString(2));
					contactModel.add(model);
				}
				return contactModel;
			}

		});
	}

// ----------------------------------------------------------END----------------------------------------------------------------------
	
// ---------------------------------------View Vendor List------------------------------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xpanion.scm.dao.ContactDao#getVendorDetails()
	 * 
	 * @author:ASWATHY RAJ D
	 */
	@Override
	public List<ContactModel> getVendorDetails() {

		List<ContactModel> vendorModel = new ArrayList<ContactModel>();
		String sql = "select cont.pk_contact_id,company_name,email,land_number,mobile_number,fk_contact_type_id,ct.pk_contact_type_id,contact_type from xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details cont left join xpanion_supply_chain_management_system_dev.t_mst_scm_contact_type ct on cont.fk_contact_type_id=ct.pk_contact_type_id where cont.active_state_indicator='Y' and ct.contact_type='vendor'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ContactModel>>() {
			@Override
			public List<ContactModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ContactModel model = new ContactModel();
					
					model.setContactId(rs.getInt("pk_contact_id"));
					model.setCompanyName(rs.getString("company_name"));
					model.setEmail(rs.getString("email"));
					model.setLandNumber(rs.getString("land_number"));
					model.setMobileNumber(rs.getString("mobile_number"));
					model.setContactType(rs.getString("contact_type"));
					model.setContactTypeId(rs.getInt("fk_contact_type_id"));
					vendorModel.add(model);
				}
				return vendorModel;
			}

		});
	}
	//--------------------------------------------------------------------------------------
	
	@Override
	public List<ContactModel> getAddress(int contactId) {

		List<ContactModel> addressModel = new ArrayList<ContactModel>();
		String sql = "select co.pk_contact_id,mobile_number,cd.pk_contact_address_id,fk_contact_id,fk_shipment_route_id,building,land_mark,locality,city,state,zipcode,sr.pk_shipment_route_id,shipment_route from xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details co left join  xpanion_supply_chain_management_system_dev.t_det_scm_contact_address_details cd on cd.fk_contact_id=co.pk_contact_id left join xpanion_supply_chain_management_system_dev.t_mst_scm_shipment_routes sr on sr.pk_shipment_route_id=cd.fk_shipment_route_id where co.active_state_indicator='Y' and co.pk_contact_id ="+contactId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ContactModel>>() {
			@Override
			public List<ContactModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ContactModel model = new ContactModel();
					
					model.setContactId(rs.getInt("pk_contact_id"));
					model.setBuilding(rs.getString("building"));
					model.setLocality(rs.getString("locality"));
					model.setLandmark(rs.getString("land_mark"));
					model.setCity(rs.getString("city"));
					model.setZipcode(rs.getString("zipcode"));
					model.setState(rs.getString("state"));
					model.setShipmentRouteId(rs.getInt("pk_shipment_route_id"));
					model.setRoute(rs.getString("shipment_route"));
					model.setMobileNumber(rs.getString("mobile_number"));
					
					addressModel.add(model);
				}
				return addressModel;
			}

		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	
	
	@Override
	public List<ContactModel> getCustomerDetails() {

		List<ContactModel> customerModel = new ArrayList<ContactModel>();
		String sql = "select cont.pk_contact_id,upper(company_name),email,land_number,mobile_number,fk_contact_type_id,ct.pk_contact_type_id,contact_type from xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details cont left join xpanion_supply_chain_management_system_dev.t_mst_scm_contact_type ct on cont.fk_contact_type_id=ct.pk_contact_type_id where cont.active_state_indicator='Y' and ct.contact_type='customer'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ContactModel>>() {
			@Override
			public List<ContactModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ContactModel model = new ContactModel();
					
					model.setContactId(rs.getInt("pk_contact_id"));
					model.setCompanyName(rs.getString(2));
					model.setEmail(rs.getString("email"));
					model.setLandNumber(rs.getString("land_number"));
					model.setMobileNumber(rs.getString("mobile_number"));
					model.setContactType(rs.getString("contact_type"));
					model.setContactTypeId(rs.getInt("fk_contact_type_id"));
					customerModel.add(model);
				}
				return customerModel;
			}

		});
	}

//--------------------------------------------------------------------------------------------------------------------------------
	/*@author:Aswathy Raj.D
	 * (non-Javadoc)
	 * @see com.xpanion.scm.dao.ContactDao#getContactDetails()
	 */
	@Override
	public List<ContactModel> getContactDetails(int contactTypeId) {
		
		List<ContactModel> contactModel = new ArrayList<ContactModel>();
		String sql ="select co.pk_contact_id,upper(company_name),fk_contact_type_id,contact_name,email,gst_identification_number,ct.pk_contact_type_id,contact_type from xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details co left join xpanion_supply_chain_management_system_dev.t_mst_scm_contact_type ct on ct.pk_contact_type_id=co.fk_contact_type_id where ct.pk_contact_type_id="+contactTypeId+" and co.active_state_indicator='Y' ";
				
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ContactModel>>() {
			@Override
			public List<ContactModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ContactModel model = new ContactModel();
					System.out.println("inside dao impl");
					model.setContactId(rs.getInt("pk_contact_id"));
					model.setCompanyName(rs.getString(2));
					model.setContactTypeId(rs.getInt("fk_contact_type_id"));
					model.setContactName(rs.getString("contact_name"));
					model.setEmail(rs.getString("email"));
					model.setContactType(rs.getString("contact_type"));
					model.setContactTypeId(rs.getInt("pk_contact_type_id"));
					contactModel.add(model);
				}
				return contactModel;
			}

		});
	}


// -----------------------------------------------------END-------------------------------------------------------------
// -----------------------------------------------------START-------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * @see com.xpanion.scm.dao.ContactDao#filterCustomerDetails(int)
	 * @author : ASHLIN ABRAHAM
	 * @date : 20.05.2019
	 * @purpose: filter customer details based on route
	 * @exception : DataAccessException, SQLException
	 */
	/*@Override
	public List<CustomerRouteModel> filterCustomerDetails(int routeId) {
		List<CustomerRouteModel> custList = new ArrayList<CustomerRouteModel>();
		String sql = "select adrs.fk_contact_details_id,fk_route_id,route.contact_route,det.first_name,last_name,company_name,mobile_number,land_number,\r\n"
				+ "ct.pk_contact_type_id,contact_type \r\n"
				+ "from xpanion_supply_chain_management_system.t_det_address_type_details adrs\r\n" + "left join \r\n"
				+ "xpanion_supply_chain_management_system.t_mst_contact_route route\r\n"
				+ "on adrs.fk_route_id=route.pk_route_id\r\n"
				+ "left join xpanion_supply_chain_management_system.t_det_contact_details det\r\n"
				+ "on adrs.fk_contact_details_id = det.pk_contact_details_id \r\n"
				+ "left join xpanion_supply_chain_management_system.t_mst_contact_type ct on fk_contact_type_id=pk_contact_type_id						\r\n"
				+ "where  det.active_state_indicator='Y' and adrs.active_state_indicator='Y' and contact_type='customer'and adrs.fk_route_id="
				+ routeId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<CustomerRouteModel>>() {
			@Override
			public List<CustomerRouteModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					CustomerRouteModel model = new CustomerRouteModel();
					model.setContactId(rs.getInt("fk_contact_details_id"));
					model.setRouteId(rs.getInt("fk_route_id"));
					model.setRoute(rs.getString("contact_route"));
					model.setFirstName(rs.getString("first_name"));
					model.setLastName(rs.getString("last_name"));
					model.setCompanyName(rs.getString("company_name"));

					model.setLandNumber(rs.getString("land_number"));
					model.setMobileNumber(rs.getString("mobile_number"));
					model.setType(rs.getString("contact_type"));
					custList.add(model);
				}
				return custList;
			}
		});
	}
*/	// -----------------------------------------------------END-------------------------------------------------------------
// --------------------------------------------------------START----------------------------------------------------------------------
		
		/* * (non-Javadoc)
		 * 
		 * @see com.xpanion.scm.dao.ContactDao#getPrimaryContactDetails(int)
		 * 
		 * @author : ASWATHY
		 * 
		 * @date : 28.03.2019
		 * 
		 * @purpose :
		*/ 
		@Override
		public List<ContactModel> getPrimaryContactDetails(int contactId) {
			List<ContactModel> primaryModel = new ArrayList<ContactModel>();
			
			String sql ="select cont.pk_contact_id,upper(contact_name),upper(company_name),email,gst_identification_number, \r\n" + 
					"									email,fk_contact_type_id ,ct.pk_contact_type_id,contact_type,\r\n" + 
					"									addr.building,locality,city,zipcode,state,land_number,work_phone\r\n" + 
					"									from xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details cont \r\n" + 
					"									left join  \r\n" + 
					"									xpanion_supply_chain_management_system_dev.t_mst_scm_contact_type ct on ct.pk_contact_type_id=cont.fk_contact_type_id \r\n" + 
					"									left join \r\n" + 
					"									xpanion_supply_chain_management_system_dev.t_det_scm_contact_address_details addr on addr.fk_contact_id=cont.pk_contact_id  \r\n" + 
					"									where  cont.active_state_indicator='Y' and pk_contact_id="+contactId+"\r\n" + 
					"";
			return jdbcTemplate.query(sql, new ResultSetExtractor<List<ContactModel>>() {
				@Override
				public List<ContactModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while (rs.next()) {
						ContactModel model = new ContactModel();
						model.setContactId(rs.getInt("pk_contact_id"));
						model.setContactName(rs.getString(2));
						model.setCompanyName(rs.getString(3));
						model.setContactType(rs.getString("contact_type"));
						model.setLandNumber(rs.getString("land_number"));
						model.setMobileNumber(rs.getString("work_phone"));
						model.setEmail(rs.getString("email"));
						model.setBuilding(rs.getString("building"));
						model.setLocality(rs.getString("locality"));
						model.setCity(rs.getString("city"));
						model.setZipcode(rs.getString("zipcode"));
						model.setState(rs.getString("state"));
						model.setGstIdentificationNumber(rs.getString("gst_identification_number"));
						model.setContactTypeId(rs.getInt(8));
						
						primaryModel.add(model);	
					}
					return primaryModel;
				}

			});
		}	
// -----------------------------------------------------CONTACT EDIT-------------------------------------------------------------
		@Override
		public List<ContactModel> getEditCustomerDetails(int contactId) {
			
			List<ContactModel>  contactDetailsModel = new ArrayList<ContactModel>();
			String sql = "select co.pk_contact_id,fk_contact_type_id,contact_name,company_name,email,gst_identification_number,mobile_number,land_number,cd.pk_contact_address_id,fk_contact_id,fk_shipment_route_id,building,land_mark,locality,city,state,zipcode,work_phone,ct.pk_contact_type_id,contact_type from xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details co left join  xpanion_supply_chain_management_system_dev.t_det_scm_contact_address_details cd on cd.fk_contact_id=co.pk_contact_id left join xpanion_supply_chain_management_system_dev.t_mst_scm_contact_type ct on ct.pk_contact_type_id=co.fk_contact_type_id  where co.active_state_indicator='Y' and co.pk_contact_id ="+contactId;
			return jdbcTemplate.query(sql, new ResultSetExtractor<List<ContactModel>>() {
				@Override
				public List<ContactModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while (rs.next()) {
						ContactModel model = new ContactModel();
						
						model.setContactId(rs.getInt("pk_contact_id"));
						model.setContactTypeId(rs.getInt("fk_contact_type_id"));
						model.setContactName(rs.getString("contact_name"));
						model.setCompanyName(rs.getString("company_name"));
						model.setEmail(rs.getString("email"));
						model.setGstIdentificationNumber(rs.getString("gst_identification_number"));
						model.setMobileNumber(rs.getString("mobile_number"));
						model.setLandNumber(rs.getString("land_number"));
						model.setContactAddressId(rs.getInt("pk_contact_address_id"));
						model.setShipmentRouteId(rs.getInt("fk_shipment_route_id"));
						model.setBuilding(rs.getString("building"));
						model.setLandmark(rs.getString("land_mark"));
						model.setLocality(rs.getString("locality"));
						model.setCity(rs.getString("city"));
						model.setState(rs.getString("state"));
						model.setZipcode(rs.getString("zipcode"));
						model.setContactNumber(rs.getString("work_phone"));
						model.setContactType(rs.getString("contact_type"));
						model.setContactTypeId(rs.getInt("fk_contact_type_id"));
						
						
						contactDetailsModel.add(model);
					}
					return contactDetailsModel;
				}

			});
		}

		
		
		//-----------------------------------------------------END------------------------------------------------------------------
		@Override
		public List<ContactModel> getcontactlists() {
			List<ContactModel> custmodel = new ArrayList<ContactModel>();
			String sql = "select cd.company_name,contact_name,email,mobile_number,fk_contact_type_id,pk_contact_id,ct.pk_contact_type_id,contact_type,ad.building,locality,city,state,fk_contact_id from xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details cd left join xpanion_supply_chain_management_system_dev.t_mst_scm_contact_type ct on ct.pk_contact_type_id=cd.fk_contact_type_id left join xpanion_supply_chain_management_system_dev.t_det_scm_contact_address_details ad on ad.fk_contact_id=cd.pk_contact_id  where cd.active_state_indicator='Y' and ct.pk_contact_type_id=2";
			return jdbcTemplate.query(sql, new ResultSetExtractor<List<ContactModel>>() {
				@Override
				public List<ContactModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while (rs.next()) {
						ContactModel model = new ContactModel();
						
						
					    model.setContactName(rs.getString("contact_name"));
					    model.setCompanyName(rs.getString("company_name"));
						model.setEmail(rs.getString("email"));
						
						model.setMobileNumber(rs.getString("mobile_number"));
						model.setContactId(rs.getInt("pk_contact_id"));
						model.setBuilding(rs.getString("building"));
						model.setLocality(rs.getString("locality"));
						model.setCity(rs.getString("city"));
						model.setState(rs.getString("state"));
						custmodel.add(model);
					}
					return custmodel;
				}

			});
		}
		
		//------------------------------------------------------------TO VIEW VENDOR----------------------------------------------------------//
		
		
		@Override
		public List<ContactModel> getvendors() {
			List<ContactModel> vendmodel = new ArrayList<ContactModel>();
			String sql = "select cd.company_name,contact_name,email,mobile_number,fk_contact_type_id,pk_contact_id,ct.pk_contact_type_id,contact_type,ad.building,locality,city,state,fk_contact_id from xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details cd left join xpanion_supply_chain_management_system_dev.t_mst_scm_contact_type ct on ct.pk_contact_type_id=cd.fk_contact_type_id left join xpanion_supply_chain_management_system_dev.t_det_scm_contact_address_details ad on ad.fk_contact_id=cd.pk_contact_id  where cd.active_state_indicator='Y' and ct.pk_contact_type_id=1";
			return jdbcTemplate.query(sql, new ResultSetExtractor<List<ContactModel>>() {
				@Override
				public List<ContactModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while (rs.next()) {
						ContactModel model = new ContactModel();
						
						
						model.setContactName(rs.getString("contact_name"));
					    model.setCompanyName(rs.getString("company_name"));
						model.setEmail(rs.getString("email"));
						
						model.setMobileNumber(rs.getString("mobile_number"));
						model.setContactId(rs.getInt("pk_contact_id"));
						model.setBuilding(rs.getString("building"));
						model.setLocality(rs.getString("locality"));
						model.setCity(rs.getString("city"));
						model.setState(rs.getString("state"));
						vendmodel.add(model);
					}
					return vendmodel;
				}

			});
		}
		
//-----------------------------------------------------------------------------------------------------------------------//
}


