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

import com.xpanion.scm.dao.HomeDao;
import com.xpanion.scm.model.ContactModel;
import com.xpanion.scm.model.HomeModel;

@Repository
public class HomeDaoImpl implements HomeDao {

	
	public static final Logger LOGGER = LoggerFactory.getLogger(HomeDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	int returnPhoneId;
	
	
	//----------------------------------------------------------GET CONTACT DETAILS--------------------------------------------------------------------------------------//
	@Override
	public List<HomeModel> getphonedetails() {
		List<HomeModel> phonemodel = new ArrayList<HomeModel>();
		String sql = "select pk_contact_id,contact_name,mobile_number,email from xpanion_supply_chain_management_system_dev.t_mst_scm_phone where active_status_indicator='Y'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<HomeModel>>() {
			@Override
			public List<HomeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					HomeModel model = new HomeModel();
					model.setPhoneId(rs.getInt(1));
					model.setContactName(rs.getString(2));
					model.setMobileNumber(rs.getString(3));
					model.setEmail(rs.getString(4));
					phonemodel.add(model);
				}
				return phonemodel;
			}

		});
	}
	//-----------------------------------------PHONEBOOK EDIT-------------------------------//
	
	@Override
	public List<HomeModel> getphoneedit(int phoneId) {
		List<HomeModel> phonemodel = new ArrayList<HomeModel>();
		String sql = "select pk_contact_id,contact_name,mobile_number,email from xpanion_supply_chain_management_system_dev.t_mst_scm_phone where active_status_indicator='Y' and pk_contact_id="+phoneId;

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<HomeModel>>() {
			@Override
			public List<HomeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					HomeModel model = new HomeModel();
					model.setPhoneId(rs.getInt("pk_contact_id"));
					model.setContactName(rs.getString("contact_name"));
					model.setMobileNumber(rs.getString("mobile_number"));
					model.setEmail(rs.getString("email"));
					phonemodel.add(model);
				}
				return phonemodel;
			}

		});
	}
	
	//----------------------------------------------------------------TO VIEW CONTACT---------------------------------------------------------//
	
//-------------------------------------------------------PHONE BOOK INSERTION---------------------------------------------------------//
	@Override
	public  int saveUpdatephone(int phoneId,String contactName,String mobileNumber, String email,int createUserId, char activeStatus) {
		SqlParameterSource in;
		SimpleJdbcCall savePhoneJdbcCall = null;
		
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;
		try {
			LOGGER.info("saveUpdatephone()");
			
				savePhoneJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						.withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_phone_details");
				inParamMap.put("p_contact_id", Integer.valueOf(phoneId));
			
				inParamMap.put("p_contact_name", String.valueOf(contactName));
				inParamMap.put("p_mobile_number", String.valueOf(mobileNumber));
				inParamMap.put("p_email", String.valueOf(email));
				inParamMap.put("p_user_id", Integer.valueOf(createUserId));
				inParamMap.put("p_active_status", Character.valueOf(activeStatus));
				
				in = new MapSqlParameterSource(inParamMap);
				saveJdbcCallResult = savePhoneJdbcCall.execute(in);
				saveJdbcCallResult.entrySet().forEach(System.out::println);
				saveJdbcCallResult.forEach((key, value) -> returnPhoneId = (int) value);
				LOGGER.info("id of the phone " + returnPhoneId);
			
			if (phoneId > 0) {
				return phoneId;
			}
			return returnPhoneId;
		}catch (Exception e) {
				LOGGER.info("error in saveUpdatephone()" + e);
				return 0;
			}
		
	
		
	
}
	//------------------------------------------------------------------------------------------------------------------------------------//
	/*public List<HomeModel> getcustomer(int contactId) {
		List<HomeModel> vendmodel = new ArrayList<HomeModel>();
		String sql = "select cd.company_name,contact_name,email,mobile_number,fk_contact_type_id,pk_contact_id,ct.pk_contact_type_id,contact_type,ad.building,locality,city,state,fk_contact_id from xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details cd left join xpanion_supply_chain_management_system_dev.t_mst_scm_contact_type ct on ct.pk_contact_type_id=cd.fk_contact_type_id left join xpanion_supply_chain_management_system_dev.t_det_scm_contact_address_details ad on ad.fk_contact_id=cd.pk_contact_id  where cd.active_state_indicator='Y' and ct.pk_contact_type_id=1";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<HomeModel>>() {
			@Override
			public List<HomeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					HomeModel model = new HomeModel();
					
					
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
	}*/
	
	//---------------------------------------------delete----------------------------------------------///
	@Override
	public   int deletephone(int phoneId,int createUserId,char activeStatus) {
		SqlParameterSource in;
		SimpleJdbcCall deletePhoneJdbcCall = null;
		
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;
		try {
			LOGGER.info("saveUpdatephone()");
			
			deletePhoneJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						.withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_phone_details");
				inParamMap.put("p_contact_id", Integer.valueOf(phoneId));
			
				inParamMap.put("p_contact_name",null);
				inParamMap.put("p_mobile_number",null);
				inParamMap.put("p_email",null);
				inParamMap.put("p_user_id", Integer.valueOf(createUserId));
				inParamMap.put("p_active_status", Character.valueOf(activeStatus));
				
				in = new MapSqlParameterSource(inParamMap);
				saveJdbcCallResult = deletePhoneJdbcCall.execute(in);
				saveJdbcCallResult.entrySet().forEach(System.out::println);
				saveJdbcCallResult.forEach((key, value) -> returnPhoneId = (int) value);
				LOGGER.info("id of the phone " + returnPhoneId);
			
			return returnPhoneId;
		}catch (Exception e) {
				LOGGER.info("error in saveUpdatephone()" + e);
				return 0;
			}
		
	
		
	
}
	
	
//--------------------------------------------------------------------------------------------------------------------------------------------//	
}