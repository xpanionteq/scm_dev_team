package com.xpanion.scm.controller;

import static com.xpanion.scm.util.CommonConstants.FAILED;
import static com.xpanion.scm.util.CommonConstants.SUCCESS;

import java.util.List;
import java.util.Map;

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
import com.xpanion.scm.dao.EmployeeDao;
import com.xpanion.scm.dao.QualificationDao;
import com.xpanion.scm.model.EmployeeModel;
import com.xpanion.scm.model.HomeModel;
import com.xpanion.scm.model.QualificationModel;
import com.xpanion.scm.service.EmployeeService;
import com.xpanion.scm.util.ScmWebResponse;
/*
 * @author:ASWATHY RAJ D
 * @purpose:Employee Details
 * @date::04-05-2019
 */
@RestController
public class EmployeeController {
	@Autowired
	ScmWebResponse response;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	QualificationDao qualificationDao;

	//@Autowired
	//EmployeeService employeeService;
	ObjectMapper mapper = new ObjectMapper();
	public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	//----------------------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/getemployee")
	public @ResponseBody ScmWebResponse getemployee() {
		try {
			List<EmployeeModel> emplist = employeeDao.getemployee();
			response.setStatus(SUCCESS);
			response.setData(emplist);

		} catch (Exception e) {
			LOGGER.error("Issue in getemployee() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
//-----------------------------------------------------------------------------------//
	@RequestMapping(value = "/geteditemployee")
	public @ResponseBody ScmWebResponse getemployees(
			@RequestParam(value="employeeId",required = false)Integer employeeId) {
		
		try {
			List<EmployeeModel> emplist = employeeDao.getemployees(employeeId);
			response.setStatus(SUCCESS);
			response.setData(emplist);

		} catch (Exception e) {
			LOGGER.error("Issue in getemployee() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}


// --------------------------------------------------------START---------------------------------------------------------------------------------
	@RequestMapping(value = "/employeeOperations", method = RequestMethod.POST)
	public @ResponseBody ScmWebResponse saveUpdateEmployee(
			@RequestParam(value = "employeeId", required = false) Integer employeeId,
			@RequestParam(value = "employeeFirstName", required = false) String employeeFirstName,
			@RequestParam(value = "employeeLastName", required = false) String employeeLastName,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "mobileNumber", required = false) String mobileNumber,
			@RequestParam(value = "joiningDate", required = false) String joiningDate,
			@RequestParam(value = "dateOfBirth", required = false) String dateOfBirth,
			@RequestParam(value = "genderTypeId", required = false) Integer genderTypeId,
			@RequestParam(value = "employeeAddress", required = false) String employeeAddress,
			@RequestParam(value = "designationTypeId", required = false) Integer designationTypeId,
			//@RequestParam(value = "loginId", required = false) Integer  loginId,
			//@RequestParam(value = "userTypeId", required = false) Integer  userTypeId,
			@RequestParam(value = "userName", required = false) String  userName,
			@RequestParam(value = "userPassword", required = false) String  userPassword,
			@RequestParam(value = "activeStatus", required = false) Character activeStatus,
			@RequestParam(value = "qualificationList", required = false) String qualificationList) {
		try {
			int createUserId = 1;
			int loginId=0;
			int userTypeId=1;
			
			List<QualificationModel> employeequalificationList;
		
			
			if(employeeId > 0 && activeStatus == 'N') {
			int EmployeeDetails=employeeDao.deleteemployee(employeeId,createUserId,activeStatus);
			
			
				if(EmployeeDetails >=1) {
				response.setStatus(SUCCESS);
				response.setMessage(null);
				response.setData(null);
			} else if(EmployeeDetails == -2){
				response.setStatus(FAILED);
				response.setData(null);
				response.setMessage("-2");
			
			         }else {
			        	 response.setStatus(FAILED);
			        	 response.setData(null);
			        	 
			         }
		}
			if(qualificationList != null && activeStatus=='Y') {
			employeequalificationList = mapper.readValue(qualificationList,new TypeReference<List<QualificationModel>>() {})	;
		
			}else {
				employeequalificationList=null;
			}
			
		          
			if (employeeId >= 0 && activeStatus == 'Y') {
			  int EmployeeDetails = employeeDao.saveUpdateEmployee(employeeId,employeeFirstName,employeeLastName,email,mobileNumber,joiningDate,dateOfBirth,genderTypeId,
						 employeeAddress,designationTypeId,loginId,userTypeId,userName,userPassword,createUserId,activeStatus,employeequalificationList);
				
				if(EmployeeDetails >=1) {
				response.setStatus(SUCCESS);
				response.setMessage(""+EmployeeDetails+"");
			}
			
			 else if(EmployeeDetails == 0){
				response.setStatus(FAILED);
				response.setData(null);
				response.setMessage("0");
			
			 }
		    }
	   
		    }
			catch (Exception e) {
			response.setStatus(FAILED);
			response.setMessage("0");
			LOGGER.info("Issue in saveUpdateEmployees " + e);
		}
		return response;

	}

//-----------------------------------------------------END----------------------------------------------------------------------------------------
//---------------------------------------------QUALIFICATION TYPE--------------------------------------------------------------------
	/*
	* @author:ASWATHY RAJ D
	 * @purpose:Get Qualification Type
	 * @date::04-05-2019
	 */
		@RequestMapping(value = "/getQualificationType", method = RequestMethod.GET)
		public @ResponseBody ScmWebResponse getQualificationType(){
			try {
				List<QualificationModel> qual = qualificationDao.getQualificationType();
				response.setStatus(SUCCESS);
				response.setData(qual);

			} catch (Exception e) {
				LOGGER.error("Issue in getQualificationType() ", e);
				response.setData(null);
				response.setStatus(FAILED);
			}

			return response;
		}

//--------------------------------------------------END---------------------------------------------------------------	
//---------------------------------------------DESIGNATION TYPE---------------------------------------------------------
		
 /* @author:ASWATHY RAJ D
  * @purpose:Get Qualification Type
  * @date::04-05-2019
  */
			@RequestMapping(value = "/getDesignationType", method = RequestMethod.GET)
			public @ResponseBody ScmWebResponse getDesignationType(){
				try {
					List<EmployeeModel> desig = employeeDao.getDesignationType();
					response.setStatus(SUCCESS);
					response.setData(desig);

				} catch (Exception e) {
					LOGGER.error("Issue in getDesignationType() ", e);
					response.setData(null);
					response.setStatus(FAILED);
				}

				return response;
			}

//--------------------------------------------------END---------------------------------------------------------------	
//--------------------------------------------------GENDER TYPE-------------------------------------------------------------
	/* @author:ASWATHY RAJ D
	 * @purpose:Get Qualification Type
	 * @date::04-05-2019
	 */
			@RequestMapping(value = "/getGenderType", method = RequestMethod.GET)
				public @ResponseBody ScmWebResponse getGenderType(){
				try {
					List<EmployeeModel> gender = employeeDao.getGenderTypes();
					response.setStatus(SUCCESS);
					response.setData(gender);

					} catch (Exception e) {
						LOGGER.error("Issue in getGenderType() ", e);
						response.setData(null);
						response.setStatus(FAILED);
					}

				return response;
			}

			
//---------------------------------------------------END-----------------------------------------------------------------			
//-------------------------------------------GET EMPLOYEE DETAILS-----------------------------------------------------------
	/* @author:ASWATHY RAJ D
	 * @purpose:Get Employee Details
	 * @date:04-13-2019
	*/		
			
			/*@RequestMapping(value = "/getEmployeeDetails", method = RequestMethod.GET)
			public @ResponseBody ScmWebResponse getEmployeeDetails(
					@RequestParam(value = "employeeFirstName", required = false) String employeeFirstName,
					@RequestParam(value = "employeeLastName", required = false) String employeeLastName,
					@RequestParam(value = "email", required = false) String email){
			try {
				List<EmployeeModel> employee = employeeDao.getEmployeeDetails(employeeFirstName, employeeLastName, email);
				if (employee.isEmpty()) {
					LOGGER.info("no data");
					response.setData(employee);
					response.setStatus(SUCCESS);
					response.setMessage("not found");
				} else {
					LOGGER.info("data found");
					response.setData(employee);
					response.setStatus(SUCCESS);
					response.setMessage("found");
				}

			} catch (Exception e) {
				LOGGER.error("Issue in getEmployeeDetails() ", e);
				response.setData(null);
				response.setStatus(FAILED);
				response.setMessage(null);
			}

			return response;
		}*/

	
			
			
//----------------------------------------------END--------------------------------------------------------------------------			
//-------------------------------------------GET EMPLOYEE FIRST NAMES-----------------------------------------------------------
	/* @author:ASWATHY RAJ D
	 * @purpose:Get Employee First Name
	 * @date:04-13-2019
	*/		
					
					/*@RequestMapping(value = "/getEmployeeFirstNames", method = RequestMethod.GET)
					public @ResponseBody ScmWebResponse getEmployeeFirstNames(){
					try {
						List<EmployeeModel> employeeFirstNames = employeeDao.getEmployeeFirstNames();
						response.setStatus(SUCCESS);
						response.setData(employeeFirstNames);

						} catch (Exception e) {
							LOGGER.error("Issue in getEmployeeFirstName() ", e);
							response.setData(null);
							response.setStatus(FAILED);
						}

					return response;
				}*/
//------------------------------------------END--------------------------------------------------------------------------------
//--------------------------------------GET EMPLOYEE LAST NAMES----------------------------------------------------------------
	/* @author:ASWATHY RAJ D
	 * @purpose:Get Employee First Name
	 * @date:04-13-2019
	*/		
									
				/*@RequestMapping(value = "/getEmployeeLastNames", method = RequestMethod.GET)
					public @ResponseBody ScmWebResponse getEmployeeLastNames(){
					try {
						List<EmployeeModel> employeeLastNames = employeeDao.getEmployeeLastNames();
						response.setStatus(SUCCESS);
						response.setData(employeeLastNames);

						} catch (Exception e) {
							LOGGER.error("Issue in getEmployeeLastNames() ", e);
							response.setData(null);
							response.setStatus(FAILED);
							}

							return response;
						}*/
					
					
//------------------------------------------END--------------------------------------------------------------------------------					
					
//-------------------------------------------GET USER EMPLOYEE DETAILS-----------------------------------------------------------
	/* @author:ASWATHY RAJ D
	 * @purpose:Get User Employee Details
	 * @date:04-16-2019
	*/		
						
			/*@RequestMapping(value = "/getEmployeeUserDetails", method = RequestMethod.GET)
			public @ResponseBody ScmWebResponse getEmployeeUserDetails(){
			try {
				List<EmployeeModel> employeeUser = employeeDao.getEmployeeUserDetails();
				response.setStatus(SUCCESS);
				response.setData(employeeUser);
			} catch (Exception e) {
				LOGGER.error("Issue in getEmployeeUserDetails() ", e);
				response.setData(null);
				response.setStatus(FAILED);
			}

			return response;
			}*/
				
						
						
//----------------------------------------------END--------------------------------------------------------------------------			
//-------------------------------------------GET ADMIN EMPLOYEE DETAILS-----------------------------------------------------------
	/* @author:ASWATHY RAJ D
	 * @purpose:Get User Employee Details
	 * @date:04-16-2019
	 */		
								
		/*@RequestMapping(value = "/getEmployeeAdminDetails", method = RequestMethod.GET)
		public @ResponseBody ScmWebResponse getEmployeeAdminDetails(){
			try {
				List<EmployeeModel> employeeAdmin = employeeDao.getEmployeeAdminDetails();
				response.setStatus(SUCCESS);
				response.setData(employeeAdmin);
				} catch (Exception e) {
				LOGGER.error("Issue in getEmployeeAdminDetails() ", e);
				response.setData(null);
				response.setStatus(FAILED);
				}

				return response;
			}
						
								
								
//----------------------------------------------END--------------------------------------------------------------------------			
//-------------------------------------------GET SINGLE EMPLOYEE DETAILS-----------------------------------------------------------
	/* @author:ASWATHY RAJ D
	 * @purpose:Get User Employee Details
	 *  @date:04-17-2019
	*/		
							
				/*@RequestMapping(value = "/getSingleEmpDet")
				public @ResponseBody ScmWebResponse getSingleEmpDet(
						@RequestParam(value = "employeeId", required = false) Integer employeeId){
				try {
					List<EmployeeModel> singleEmpDet = employeeDao.getSingleEmployeeDet(employeeId);
					response.setStatus(SUCCESS);
					response.setData(singleEmpDet);
				} catch (Exception e) {
					LOGGER.error("Issue in getSingleEmpDet() ", e);
					response.setData(null);
					response.setStatus(FAILED);
				}

				return response;
				}
					
							
							
//----------------------------------------------END--------------------------------------------------------------------------			
//-------------------------------------------GET SINGLE EMPLOYEE DETAILS-----------------------------------------------------------
	/* @author:ASWATHY RAJ D
	 * @purpose:Get  Employee qualification Details
	 *  @date:04-17-2019
	*/		
										
							/*@RequestMapping(value = "/getSingleEmpQualDet")
							public @ResponseBody ScmWebResponse getSingleEmpQualDet(
									@RequestParam(value = "employeeId", required = false) Integer employeeId){
							try {
								List<QualificationModel> singleEmpQualDet = qualificationDao.getEmpQualiDet(employeeId);
								if (singleEmpQualDet.isEmpty()) {
									response.setData(singleEmpQualDet);
									response.setStatus(SUCCESS);
									response.setMessage("not found");
								} else {
									response.setData(singleEmpQualDet);
									response.setStatus(SUCCESS);
									response.setMessage("found");
								}

							} catch (Exception e) {
								LOGGER.error("Issue in getSingleEmpQualDet() ", e);
								response.setData(null);
								response.setStatus(FAILED);
								response.setMessage(null);
							}

							return response;
						}
										
//----------------------------------------------END--------------------------------------------------------------------------			


							@RequestMapping(value = "/getuserNames", method = RequestMethod.GET)
							public @ResponseBody ScmWebResponse getuserNames(
									@RequestParam(value = "userName", required = false) String userName ){
							try {
								List<EmployeeModel> employeeuserNames= employeeDao.getUserName(userName);
								if (employeeuserNames.isEmpty()) {
								response.setStatus(SUCCESS);
								response.setData(employeeuserNames);
								response.setMessage("not found");
								} else {
										response.setData(employeeuserNames);
										response.setStatus(SUCCESS);
										response.setMessage("found");
									}

								} catch (Exception e) {
									LOGGER.error("Issue in employeeuserNames() ", e);
									response.setData(null);
									response.setStatus(FAILED);
									
								}

							return response;
						}*/
//-----------------------------------------------------------------------------------------------------------------------------
	/* @author:ASWATHY RAJ D
	 * @purpose:Get user type
	 * @date:04-26-2019
	*/		
											
			@RequestMapping(value = "/getUserType", method = RequestMethod.GET)
					public @ResponseBody ScmWebResponse getUserType(){
					try {
					List<EmployeeModel> UserType = employeeDao.getUserType();
					response.setStatus(SUCCESS);
					response.setData(UserType);
					
			    } catch (Exception e) {
				LOGGER.error("Issue in getUserType() ", e);
				response.setData(null);
				response.setStatus(FAILED);
				}
				return response;
				}
//-------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------
			/* @author:ASWATHY RAJ D
			 * @purpose:Get user type based on employee id
			 * @date:04-26-2019
			*/		
													
				/*	@RequestMapping(value = "/getUserTypeId", method = RequestMethod.GET)
							public @ResponseBody ScmWebResponse getUserTypeId(
									@RequestParam(value = "employeeId", required = false) Integer employeeId){
							try {
							List<EmployeeModel> UserTypeId = employeeDao.getUserTypes(employeeId);
							response.setStatus(SUCCESS);
							response.setData(UserTypeId);
							
					    } catch (Exception e) {
						LOGGER.error("Issue in getUserTypeId() ", e);
						response.setData(null);
						response.setStatus(FAILED);
						}
						return response;
						}*/
//-------------------------------------------------------------------------------------------------------------------------------
			
}
