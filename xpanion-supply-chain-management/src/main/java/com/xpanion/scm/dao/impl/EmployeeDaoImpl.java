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

import com.xpanion.scm.dao.EmployeeDao;
import com.xpanion.scm.model.EmployeeModel;
import com.xpanion.scm.model.HomeModel;
import com.xpanion.scm.model.QualificationModel;

/*
 * @author : ASHLIN ABRAHAM
 * @date : 02.04.2019
 * 
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	int returnEmployeeId;
	int returnQualificationId;
	int returnLoginId;
	int loginId=0;
//--------------------------------------------GET EMPLOYEE DETAILS------------------------------------------------------------
	 @Override
		public List<EmployeeModel> getemployee() {
			List<EmployeeModel> empmodel = new ArrayList<EmployeeModel>();
			String sql = "select ed.pk_employee_id,fk_designation_type_id,employee_first_name,employee_last_name,email,dt.pk_designation_type_id,designation_type from xpanion_supply_chain_management_system_dev.t_mst_scm_employee_details ed left join xpanion_supply_chain_management_system_dev.t_mst_scm_designation_type dt on ed.fk_designation_type_id=dt.pk_designation_type_id where ed.active_state_indicator='Y'";

			return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
				@Override
				public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while (rs.next()) {
						EmployeeModel model = new EmployeeModel();
						model.setEmployeeId(rs.getInt("pk_employee_id"));
						model.setDesignationType(rs.getString("designation_type"));
						
						
						model.setEmployeeFirstName(rs.getString("employee_first_name"));
						model.setEmployeeLastName(rs.getString("employee_last_name"));
						
						model.setEmail(rs.getString("email"));
					empmodel.add(model);
					}
					return empmodel;
				}

			});
		}
		
	//-----------------------------------------------------------EMPLOYEE EDIT----------------------------------------------------------------------//
	 
	 public List<EmployeeModel> getemployees(int employeeId) {
			List<EmployeeModel> emplmodel = new ArrayList<EmployeeModel>();
			String sql = "select ed.pk_employee_id,fk_designation_type_id,employee_first_name,employee_last_name,email,\r\n" + 
					"employee_mobile_number,employee_date_of_birth,employee_address,employee_joining_date,\r\n" + 
					"fk_gender_type_id,dt.pk_designation_type_id,designation_type,gt.pk_gender_type_id,\r\n" + 
					"gender_type,qd.fk_employee_id,fk_qualification_type_id,other_qualification,experience,pk_qualification_details_id,\r\n" + 
					"qt.pk_qualification_type_id,qualification_type,ld.fk_employee_id,user_name,user_password \r\n" + 
					"from xpanion_supply_chain_management_system_dev.t_mst_scm_employee_details ed \r\n" + 
					"left join xpanion_supply_chain_management_system_dev.t_mst_scm_designation_type dt on \r\n" + 
					"ed.fk_designation_type_id=dt.pk_designation_type_id left join \r\n" + 
					"xpanion_supply_chain_management_system_dev.t_mst_scm_gender_type gt on \r\n" + 
					"gt.pk_gender_type_id=ed.fk_gender_type_id left join \r\n" + 
					"xpanion_supply_chain_management_system_dev.t_det_scm_employee_qualification_details qd \r\n" + 
					"on qd.fk_employee_id=ed.pk_employee_id left join xpanion_supply_chain_management_system_dev.\r\n" + 
					"t_mst_scm_qualification_type qt on qt.pk_qualification_type_id=qd.fk_qualification_type_id left join xpanion_supply_chain_management_system_dev.t_det_scm_employee_login_details ld on ld.fk_employee_id=ed.pk_employee_id\r\n" + 
					"where ed.active_state_indicator='Y' and ed.pk_employee_id="+employeeId;

			return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
				@Override
				public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while (rs.next()) {
						EmployeeModel model = new EmployeeModel();
						model.setEmployeeId(rs.getInt("pk_employee_id"));
						model.setDesignationType(rs.getString("designation_type"));
					    model.setEmployeeFirstName(rs.getString("employee_first_name"));
						model.setEmployeeLastName(rs.getString("employee_last_name"));
						model.setEmail(rs.getString("email"));
						model.setMobileNumber(rs.getString("employee_mobile_number"));
						model.setDateOfBirth(rs.getString("employee_date_of_birth"));
					    model.setEmployeeAddress(rs.getString("employee_address"));
						model.setExperience(rs.getInt("experience"));
						model.setGenderType(rs.getString("gender_type"));
						model.setGenderTypeId(rs.getInt("fk_gender_type_id"));
						model.setJoiningDate(rs.getString("employee_joining_date"));
						model.setOther_qualification(rs.getString("other_qualification"));
						model.setQualificationId(rs.getInt("fk_qualification_type_id"));
						model.setQualificationType(rs.getString("qualification_type"));
						model.setQualificationDetId(rs.getInt("pk_qualification_details_id"));
					    model.setUserName(rs.getString("user_name"));
						model.setUserPassword(rs.getString("user_password"));
						
					emplmodel.add(model);
					}
					return emplmodel;
				}

			});
		}
		

	//-----------------------------------------------------------------------------------------//
	
	/*
	 * (non-Javadoc)
	 * @see com.xpanion.scm.dao.EmployeeDao#getEmployeePageInformation(int)
	 * @author : ASHLIN ABRAHAM
	 * @date : 02.04.2019
	 * @purpose : 
	 * 
	 */
	//@Override
	/*public List<EmployeeModel> getEmployeePageInformation(int employeeId) {
		List<EmployeeModel> empModel = new ArrayList<EmployeeModel>();
		String sql = "select emp.employee_first_name,employee_last_name,email, desig.designation_type from xpanion_supply_chain_management_system.t_mst_employee_details emp inner join xpanion_supply_chain_management_system.t_mst_designation_type_details desig on emp.fk_designation_id = desig.pk_designation_type_id where emp.pk_employee_id = "+employeeId+" and emp.active_state_indicator='Y';\n";
			return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
			@Override
			public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					EmployeeModel model = new EmployeeModel();
					model.setEmployeeFirstName(rs.getString(1));
					model.setEmployeeLastName(rs.getString(2));
					model.setEmail(rs.getString(3));
					model.setDesignationType(rs.getString(4));
					
					empModel.add(model);
				}
				return empModel;
			}

		});
	}*/
//---------------------------------------------------END-------------------------------------------------------
//---------------------------------------------------EMPLOYEE INSERTION-----------------------------------------------------------------//
/*
 * 	(non-Javadoc)
 * @see com.xpanion.scm.dao.EmployeeDao#saveUpdateEmployee(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, char, java.util.List, java.util.List)
 * @author:ASWATHY RAJ D
 * @date:04-05-2019
 * @purpose:Insering employee login,Qualification Details
 */
	
	 @Override	
	public int saveUpdateEmployee(int employeeId,String employeeFirstName,String employeeLastName,String email,String mobileNumber,String joiningDate,String dateOfBirth,int genderTypeId,
			String employeeAddress,int designationTypeId,int loginId,int userTypeId,String userName,String userPassword,
			int createUserId,char activeStatus,List<QualificationModel>qualificationList) {
		SqlParameterSource in;
		SimpleJdbcCall saveEmployeeJdbcCall = null;
		SimpleJdbcCall saveQualificationJdbcCall = null;
		SimpleJdbcCall saveLoginJdbcCall=null;
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;
		try {
			LOGGER.info("saveUpdateEmployee()");
			saveEmployeeJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("xpanion_supply_chain_management_system_dev")
					.withFunctionName("fn_save_update_employee_details");
			inParamMap.put("p_employee_Id", Integer.valueOf(employeeId));
			inParamMap.put("p_first_name", String.valueOf(employeeFirstName));
			inParamMap.put("p_last_name", String.valueOf(employeeLastName));
			inParamMap.put("p_email", String.valueOf(email));
			inParamMap.put("p_mobile_number", String.valueOf(mobileNumber));
			inParamMap.put("p_joining_date", String.valueOf(joiningDate));
			inParamMap.put("p_dob", String.valueOf(dateOfBirth));
			inParamMap.put("p_gender_type_id", Integer.valueOf(genderTypeId));
			inParamMap.put("p_address", String.valueOf(employeeAddress));
			inParamMap.put("p_designation_type_id", Integer.valueOf(designationTypeId));
			inParamMap.put("p_created_user_id", Integer.valueOf(createUserId));
			inParamMap.put("p_active_status", Character.valueOf(activeStatus));
			
			in = new MapSqlParameterSource(inParamMap);
			saveJdbcCallResult = saveEmployeeJdbcCall.execute(in);
			saveJdbcCallResult.entrySet().forEach(System.out::println);
			saveJdbcCallResult.forEach((key, value) -> returnEmployeeId = (int) value);
			LOGGER.info("id of the employee " + returnEmployeeId);
		     	if(returnEmployeeId > 0 && activeStatus == 'Y') {
					LOGGER.info("saveAndUpdateLoginDetails()");
					saveLoginJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("xpanion_supply_chain_management_system_dev")
							.withFunctionName("fn_save_update_employee_login_details");
					
						inParamMap.put("p_employee_login_id", Integer.valueOf(loginId));
						inParamMap.put("p_employee_id", returnEmployeeId);
						inParamMap.put("p_user_type_id", Integer.valueOf(userTypeId));
						inParamMap.put("p_user_name",String.valueOf(userName) );
						inParamMap.put("p_user_password",String.valueOf(userPassword));
					    inParamMap.put("p_create_user_id", createUserId);
						inParamMap.put("p_active_status", activeStatus);
						in = new MapSqlParameterSource(inParamMap);
						saveJdbcCallResult = saveLoginJdbcCall.execute(in);
						saveJdbcCallResult.entrySet().forEach(System.out::println);
						saveJdbcCallResult.forEach((key, value) -> returnLoginId = (int) value);
				  		LOGGER.info("Lgin id of the employee " + returnLoginId);
					    
				    }
					if(returnEmployeeId > 0 && qualificationList !=null && activeStatus == 'Y') {
						LOGGER.info("saveAndUpdateQualificationDetails()");
						saveQualificationJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("xpanion_supply_chain_management_system_dev")
								.withFunctionName("fn_save_update_employee_qualification_details");
						for ( QualificationModel qualification: qualificationList) {
							inParamMap.put("p_qualification_details_id", qualification.getQualificationDetId());
							inParamMap.put("p_employee_id", returnEmployeeId);
							inParamMap.put("p_qualification_type_id",qualification.getQualificationTypeId());
							inParamMap.put("p_other_qualification",qualification.getOtherQualification() );
							inParamMap.put("p_experiance",qualification.getExperience() );
							inParamMap.put("p_create_user_id", createUserId);
							inParamMap.put("p_active_status", activeStatus);
							in = new MapSqlParameterSource(inParamMap);
							saveJdbcCallResult = saveQualificationJdbcCall.execute(in);
							saveJdbcCallResult.entrySet().forEach(System.out::println);
							saveJdbcCallResult.forEach((key, value) -> returnQualificationId = (int) value);
							LOGGER.info("Qualification id of the employee " + returnQualificationId);
						}
				      }
			
				
			return returnEmployeeId;
		}
	

		catch(Exception e) {
			LOGGER.info("error in saveUpdateEmployees()"+e);
			return 0;
		}
	}
	 //---------------------------------------------------------------------------------------------------------------------//
	 
	 
	 
	 
	 @Override	
		public  int deleteemployee(int employeeId,int createUserId,char activeStatus) {
			SqlParameterSource in;
			SimpleJdbcCall deleteEmployeeJdbcCall = null;
			SimpleJdbcCall deleteEmployeequaliJdbcCall = null;
			SimpleJdbcCall deleteEmployeeloginJdbcCall = null;
			
			
			Map<String, Object> inParamMap = new HashMap<>();
			Map<String, Object> saveJdbcCallResult = null;
			try {
				LOGGER.info("saveUpdateEmployee()");
				deleteEmployeeJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_employee_details");
				inParamMap.put("p_employee_Id", Integer.valueOf(employeeId));
				inParamMap.put("p_first_name",null);
				inParamMap.put("p_last_name", null);
				inParamMap.put("p_email", null);
				inParamMap.put("p_mobile_number", null);
				inParamMap.put("p_joining_date",null);
				inParamMap.put("p_dob", null);
				inParamMap.put("p_gender_type_id",null);
				inParamMap.put("p_address", null);
				inParamMap.put("p_designation_type_id",null);
				inParamMap.put("p_created_user_id", Integer.valueOf(createUserId));
				inParamMap.put("p_active_status", Character.valueOf(activeStatus));
				
				in = new MapSqlParameterSource(inParamMap);
				saveJdbcCallResult = deleteEmployeeJdbcCall.execute(in);
				saveJdbcCallResult.entrySet().forEach(System.out::println);
				saveJdbcCallResult.forEach((key, value) -> returnEmployeeId = (int) value);
				LOGGER.info("id of the employee " + returnEmployeeId);
				
			
				return returnEmployeeId;
			}
		

			catch(Exception e) {
				LOGGER.info("error in deleteEmployees()"+e);
				return 0;
			}
		}
//---------------------------------------------END------------------------------------------------------------------------------------	
//------------------------------------DESIGNATION TYPE----------------------------------------------------------------------------
/*
 * (non-Javadoc)
 * @see com.xpanion.scm.dao.EmployeeDao#getDesignationType()
 * @author:ASWATHY RAJ D
 * @purpose:Get Designation Type
 * @date::04-05-2019
 */	@Override
	public List<EmployeeModel> getDesignationType() {
		List<EmployeeModel> DesigModel = new ArrayList<EmployeeModel>();
		String sql = "select pk_designation_type_id,designation_type from xpanion_supply_chain_management_system_dev.t_mst_scm_designation_type where active_state_indicator='Y'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<EmployeeModel>>() {
		@Override
		public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
			while (rs.next()) {
				EmployeeModel model = new EmployeeModel();
				model.setDesignationTypeId(rs.getInt(1));
				model.setDesignationType(rs.getString(2));
				
				DesigModel.add(model);
			}
			return DesigModel;
		}

	});
}
//---------------------------------------END-----------------------------------------------------------------------------
//---------------------------------------START---------------------------------------------------------------------------
/*
 * (non-Javadoc)
 * @see com.xpanion.scm.dao.EmployeeDao#getEmployeeFirstNames()
 * @author:ASWATHY RAJ D
 * @purpose:Get Employee firstName
 */
 
/*@Override
public List<EmployeeModel> getEmployeeFirstNames() {
	List<EmployeeModel> getFirstNameModel = new ArrayList<EmployeeModel>();
	String sql = "select distinct upper(employee_first_name) from xpanion_supply_chain_management_system.t_mst_employee_details where active_state_indicator='Y'";
	return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
	@Override
	public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			
			model.setEmployeeFirstName(rs.getString(1));
			
			getFirstNameModel.add(model);
		}
		return getFirstNameModel;
	}

});
	
}*/

//-------------------------------------START-----------------------------------------------------------------------------
/*
 * (non-Javadoc)
 * @see com.xpanion.scm.dao.EmployeeDao#getEmployeeLastNames()
 * * @author:ASWATHY RAJ D
 * @purpose:Get Employee LastName
 * @date::04-05-2019
 */
 
/*@Override
public List<EmployeeModel> getEmployeeLastNames() {
	List<EmployeeModel> LastNameModel = new ArrayList<EmployeeModel>();
	String sql = "select distinct upper(employee_last_name) from xpanion_supply_chain_management_system.t_mst_employee_details where active_state_indicator='Y'";
	return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
	@Override
	public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			
			model.setEmployeeLastName(rs.getString(1));
			
			LastNameModel.add(model);
		}
		return LastNameModel;
	}

});

  }*/
//----------------------------------------------END---------------------------------------------------------------
//------------------------------------------------GENDER TYPE-----------------------------------------------------------
/*
 * (non-Javadoc)
 * @see com.xpanion.scm.dao.EmployeeDao#getGenderType()
 * @author:ASWATHY RAJ D
 * @purpose: Get gender type
 */

@Override
public List<EmployeeModel> getGenderTypes() {
	List<EmployeeModel> GenderTypeModel = new ArrayList<EmployeeModel>();
	String sql = "select pk_gender_type_id,gender_type from xpanion_supply_chain_management_system_dev.t_mst_scm_gender_type where active_state_indicator='Y'";
	return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
	@Override
	public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			model.setGenderTypeId(rs.getInt(1));
			model.setGenderType(rs.getString(2));
			
			GenderTypeModel.add(model);
		}
		return GenderTypeModel;
	}

});
	
}
//---------------------------------------------------------QUALIFICATION TYPE-------------------------------------------------------------------//

@Override
public List<EmployeeModel> getQualificationType() {
	List<EmployeeModel> qualificationTypeModel = new ArrayList<EmployeeModel>();
	String sql = "select pk_qualification_type_id,qualification_type from xpanion_supply_chain_management_system_dev.t_mst_scm_qualification_type where active_state_indicator='Y'";
	return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
	@Override
	public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			model.setQualificationId(rs.getInt("pk_qualification_type_id"));
			model.setQualificationType(rs.getString("qualification_type"));
			
			qualificationTypeModel.add(model);
		}
		return qualificationTypeModel;
	}

});
	
}
//---------------------------------------------END-------------------------------------------------------------------------

//------------------------------------------GetEmployeeDetails--------------------------------------------------------------
/*
 * (non-Javadoc)
 * @see com.xpanion.scm.dao.EmployeeDao#getEmployeeDetails()
 * @author:Aswathy Raj D
 * @date:04-13-2019
 */
/*@Override
public List<EmployeeModel> getEmployeeDetails(String  employeeFirstName,String employeeLastName,String email) {
	List<EmployeeModel> getEmployeeDetails = new ArrayList<EmployeeModel>();
	String sql = "select emp.pk_employee_id,employee_first_name,employee_last_name,employee_date_of_birth,employee_age,\n" + 
			"       mobile_number,joining_date,email,fk_gender_type_id,fk_designation_id,employee_address,\n" + 
			"       login.pk_login_id,lower(user_name),fk_user_type_id,qual.pk_employee_qualification_id,\n" + 
			"       fk_qualification_type_id,other_qualification,experience,gend.pk_gender_type_id,gender_type,\n" + 
			"       desig.pk_designation_type_id,designation_type,ut.pk_user_type_id,user_type,qut.pk_qualification_type_id,\n" + 
			"       qualification_type\n" + 
			"       from xpanion_supply_chain_management_system.t_mst_employee_details emp\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_det_login_details login on login.fk_employee_id=emp.pk_employee_id \n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_det_employee_qualification_details qual on qual.fk_employee_id=emp.pk_employee_id\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_mst_designation_type_details  desig on desig.pk_designation_type_id=emp.fk_designation_id\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_mst_gender_type_details gend on gend.pk_gender_type_id=emp.fk_gender_type_id\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_mst_qualification_type qut on qut.pk_qualification_type_id=qual.fk_qualification_type_id\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_mst_user_type_details ut on ut.pk_user_type_id=login.fk_user_type_id\n" + 
			"       where emp.active_state_indicator='Y' and emp.employee_first_name='"+employeeFirstName+"' and emp.employee_last_name='"+employeeLastName+"' and emp.email='"+email+"'\n" + 
			"       \n" + 
			"";
	return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
	@Override
	public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			model.setEmployeeId(rs.getInt("pk_employee_id"));
			model.setEmployeeFirstName(rs.getString("employee_first_name"));
			model.setEmployeeLastName(rs.getString("employee_last_name"));
			model.setDateOfBirth(rs.getString("employee_date_of_birth"));
			model.setEmployeeAge(rs.getString("employee_age"));
			model.setMobileNumber(rs.getString("mobile_number"));
			model.setJoiningDate(rs.getString("joining_date"));
			model.setEmail(rs.getString("email"));
			model.setGenderType(rs.getString("gender_type"));
			model.setDesignationType(rs.getString("designation_type"));
			model.setEmployeeAddress(rs.getString("employee_address"));
			model.setUserName(rs.getString(12));
			
			model.setUserType(rs.getString("user_type"));
			model.setOther_qualification(rs.getString("other_qualification"));
			model.setQualification_type(rs.getString("qualification_type"));
			model.setExperience(rs.getString("experience"));
			
			
			getEmployeeDetails.add(model);
		}
		return getEmployeeDetails;
	}

});
	
 }*/
//-------------------------------------------End-------------------------------------------------------------------------------
//-------------------------------------------START----------------------------------------------------------------------------------
/*
 * (non-Javadoc)
 * @see com.xpanion.scm.dao.EmployeeDao#getEmployeeUserDetails()
 * @author:ASWATHY RAJ.D
 * @date:04-16-2019
 * @purpose:To view Employee User Details
 */

/*@Override
public List<EmployeeModel> getEmployeeUserDetails() {
	List<EmployeeModel> getEmployeeUserDetails = new ArrayList<EmployeeModel>();
	String sql = "select emp.pk_employee_id,upper(employee_first_name),upper(employee_last_name),employee_date_of_birth,employee_age,\n" + 
			"       mobile_number,joining_date,email,fk_gender_type_id,fk_designation_id,employee_address,\n" + 
			"       login.pk_login_id,lower(user_name),fk_user_type_id,qual.pk_employee_qualification_id,\n" + 
			"       fk_qualification_type_id,other_qualification,experience,gend.pk_gender_type_id,gender_type,\n" + 
			"       desig.pk_designation_type_id,designation_type,ut.pk_user_type_id,user_type,qut.pk_qualification_type_id,\n" + 
			"       qualification_type\n" + 
			"       from xpanion_supply_chain_management_system.t_mst_employee_details emp\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_det_login_details login on login.fk_employee_id=emp.pk_employee_id \n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_det_employee_qualification_details qual on qual.fk_employee_id=emp.pk_employee_id\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_mst_designation_type_details  desig on desig.pk_designation_type_id=emp.fk_designation_id\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_mst_gender_type_details gend on gend.pk_gender_type_id=emp.fk_gender_type_id\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_mst_qualification_type qut on qut.pk_qualification_type_id=qual.fk_qualification_type_id\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_mst_user_type_details ut on ut.pk_user_type_id=login.fk_user_type_id\n" + 
			"       where emp.active_state_indicator='Y' and ut.user_type='user' ";
	return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
	@Override
	public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			model.setEmployeeId(rs.getInt("pk_employee_id"));
			model.setEmployeeFirstName(rs.getString(2));
			model.setEmployeeLastName(rs.getString(3));
			model.setDateOfBirth(rs.getString("employee_date_of_birth"));
			model.setEmployeeAge(rs.getString("employee_age"));
			model.setMobileNumber(rs.getString("mobile_number"));
			model.setJoiningDate(rs.getString("joining_date"));
			model.setEmail(rs.getString("email"));
			model.setGenderType(rs.getString("gender_type"));
			model.setDesignationType(rs.getString("designation_type"));
			model.setEmployeeAddress(rs.getString("employee_address"));
			model.setUserName(rs.getString(12));
			
			model.setUserType(rs.getString("user_type"));
			model.setOther_qualification(rs.getString("other_qualification"));
			model.setQualification_type(rs.getString("qualification_type"));
			model.setExperience(rs.getString("experience"));
			
			
			getEmployeeUserDetails.add(model);
		}
		return getEmployeeUserDetails;
	}

});
}*/
//----------------------------------------END-----------------------------------------------------------------------------------------
//----------------------------------------START---------------------------------------------------------------------------------------
/*
 * (non-Javadoc)
 * @see com.xpanion.scm.dao.EmployeeDao#getEmployeeAdminDetails()
 * @AUTHOR:ASWATHY RAJ D
 * @date:04-16-2019
 * @purpose:To View Admin Details
 */


/*@Override
public List<EmployeeModel> getEmployeeAdminDetails() {
	List<EmployeeModel> getEmployeeAdminDetails = new ArrayList<EmployeeModel>();
	String sql ="select emp.pk_employee_id,upper(employee_first_name),upper(employee_last_name),employee_date_of_birth,employee_age,\n" + 
			"       mobile_number,joining_date,email,fk_gender_type_id,fk_designation_id,employee_address,\n" + 
			"       login.pk_login_id,lower(user_name),fk_user_type_id,qual.pk_employee_qualification_id,\n" + 
			"       fk_qualification_type_id,other_qualification,experience,gend.pk_gender_type_id,gender_type,\n" + 
			"       desig.pk_designation_type_id,designation_type,ut.pk_user_type_id,user_type,qut.pk_qualification_type_id,\n" + 
			"       qualification_type\n" + 
			"       from xpanion_supply_chain_management_system.t_mst_employee_details emp\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_det_login_details login on login.fk_employee_id=emp.pk_employee_id \n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_det_employee_qualification_details qual on qual.fk_employee_id=emp.pk_employee_id\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_mst_designation_type_details  desig on desig.pk_designation_type_id=emp.fk_designation_id\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_mst_gender_type_details gend on gend.pk_gender_type_id=emp.fk_gender_type_id\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_mst_qualification_type qut on qut.pk_qualification_type_id=qual.fk_qualification_type_id\n" + 
			"       left join\n" + 
			"       xpanion_supply_chain_management_system.t_mst_user_type_details ut on ut.pk_user_type_id=login.fk_user_type_id\n" + 
			"       where emp.active_state_indicator='Y' and ut.user_type='admin' ";
	return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
	@Override
	public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			model.setEmployeeId(rs.getInt("pk_employee_id"));
			model.setEmployeeFirstName(rs.getString(2));
			model.setEmployeeLastName(rs.getString(3));
			model.setDateOfBirth(rs.getString("employee_date_of_birth"));
			model.setEmployeeAge(rs.getString("employee_age"));
			model.setMobileNumber(rs.getString("mobile_number"));
			model.setJoiningDate(rs.getString("joining_date"));
			model.setEmail(rs.getString("email"));
			model.setGenderType(rs.getString("gender_type"));
			model.setDesignationType(rs.getString("designation_type"));
			model.setEmployeeAddress(rs.getString("employee_address"));
			model.setUserName(rs.getString(12));
			
			model.setUserType(rs.getString("user_type"));
			model.setOther_qualification(rs.getString("other_qualification"));
			model.setQualification_type(rs.getString("qualification_type"));
			model.setExperience(rs.getString("experience"));
			
			
			getEmployeeAdminDetails.add(model);
		}
		return getEmployeeAdminDetails;
	}

});
}*/
//------------------------------------------END-----------------------------------------------------------------------------------
//------------------------------------------START---------------------------------------------------------------------------------
/*
 * (non-Javadoc)
 * @see com.xpanion.scm.dao.EmployeeDao#getSingleEmployeeDet(int)
 * @author:Aswathy Raj.D
 * @date:04-17-2019
 * @purpose: To get single Employee Details 
 */

/*@Override
public List<EmployeeModel> getSingleEmployeeDet(int employeeId) {
	List<EmployeeModel> getSingleEmpDetModel = new ArrayList<EmployeeModel>();
	String sql ="select emp.pk_employee_id,employee_first_name,employee_last_name,employee_date_of_birth,employee_age, \n" + 
			"						       mobile_number,joining_date,email,fk_gender_type_id,fk_designation_id,employee_address, \n" + 
			"						        login.pk_login_id,user_name,user_password,fk_user_type_id,dt.pk_designation_type_id,designation_type,\n" + 
			"						        ut.pk_user_type_id,user_type\n" + 
			"						       from xpanion_supply_chain_management_system.t_mst_employee_details emp \n" + 
			"						       left join  \n" + 
			"						       xpanion_supply_chain_management_system.t_det_login_details login on login.fk_employee_id=emp.pk_employee_id\n" + 
			"						       left join\n" + 
			"						       xpanion_supply_chain_management_system.t_mst_user_type_details ut on ut.pk_user_type_id=login.fk_user_type_id\n" + 
			"						       left join\n" + 
			"						       xpanion_supply_chain_management_system.t_mst_designation_type_details dt on dt.pk_designation_type_id=emp.fk_designation_id \n" + 
			"						       where pk_employee_id="+employeeId+" and emp.active_state_indicator='Y'  \n" + 
			"";
	return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
	@Override
	public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			model.setEmployeeId(rs.getInt("pk_employee_id"));
			model.setEmployeeFirstName(rs.getString("employee_first_name"));
			model.setEmployeeLastName(rs.getString("employee_last_name"));
			model.setDateOfBirth(rs.getString("employee_date_of_birth"));
			model.setEmployeeAge(rs.getString("employee_age"));
			model.setMobileNumber(rs.getString("mobile_number"));
			model.setJoiningDate(rs.getString("joining_date"));
			model.setEmail(rs.getString("email"));
			model.setGenderTypeId(rs.getInt("fk_gender_type_id"));
			model.setDesignationTypeId(rs.getInt("fk_designation_id"));
			model.setDesignationType(rs.getString("designation_type"));
			model.setEmployeeAddress(rs.getString("employee_address"));
			model.setLoginId(rs.getInt("pk_login_id"));
			model.setUserName(rs.getString("user_name"));
			model.setUserPassword(rs.getString("user_password"));
			model.setUserTypeId(rs.getInt("fk_user_type_id"));
			model.setUserType(rs.getString("user_type"));
			getSingleEmpDetModel.add(model);
		}
		return getSingleEmpDetModel;
	}

});
	
}
//-------------------------------------------------END-----------------------------------------------------------------------


@Override
public List<EmployeeModel> getUserName(String userName) {
	List<EmployeeModel> getuserName = new ArrayList<EmployeeModel>();
	String sql = " select   user_name FROM\n" + 
			"			    xpanion_supply_chain_management_system.t_det_login_details \n" + 
			"			    where user_name='"+userName+"' and active_state_indicator='Y'\n" + 
			"			";
	return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
	@Override
	public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			
			model.setUserName(rs.getString("user_name"));
			
			getuserName.add(model);
		}
		return getuserName;
	}

});
	
}*/
//-----------------------------------------USER TYPE----------------------------------------------------------------------------------

@Override
public List<EmployeeModel> getUserType() {
	List<EmployeeModel> getuserType = new ArrayList<EmployeeModel>();
	String sql = "select pk_user_type_id,user_type from xpanion_supply_chain_management_system_dev.t_mst_scm_user_type where active_state_indicaor='Y'";
			
	return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
	@Override
	public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			
			model.setUserTypeId(rs.getInt("pk_user_type_id"));
			model.setUserType(rs.getString("user_type"));
			getuserType.add(model);
		}
		return getuserType;
	}

});
	
}
//-----------------------------------------------END---------------------------------------------------------------


/*@Override
public List<EmployeeModel> getUserTypes(int employeeId) {
	List<EmployeeModel> getuserTypes = new ArrayList<EmployeeModel>();
	String sql = "select emp.pk_employee_id,login.pk_login_id,fk_user_type_id,ut.pk_user_type_id,user_type\n" + 
			"from xpanion_supply_chain_management_system.t_mst_employee_details emp\n" + 
			"left join\n" + 
			"xpanion_supply_chain_management_system.t_det_login_details login on login.fk_employee_id = emp.pk_employee_id \n" + 
			"left join\n" + 
			"xpanion_supply_chain_management_system.t_mst_user_type_details ut on ut.pk_user_type_id = login.fk_user_type_id\n" + 
			"where emp.pk_employee_id="+employeeId+" and emp.active_state_indicator='Y'\n" + 
			"";
	return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeModel>>() {
	@Override
	public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			EmployeeModel model = new EmployeeModel();
			
			model.setUserTypeId(rs.getInt("pk_user_type_id"));
			model.setUserType(rs.getString("user_type"));
			model.setEmployeeId(rs.getInt("pk_employee_id"));
			
			getuserTypes.add(model);
		}
		return getuserTypes;
	}

});
	
}*/
//---------------------------------------------------------------------------------------------------------------------





}




		
