package com.xpanion.scm.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.xpanion.scm.dao.EmployeeDao;
import com.xpanion.scm.model.EmployeeModel;
import com.xpanion.scm.model.QualificationModel;

@Service
public class EmployeeService {
	


		@Autowired
		EmployeeDao employeeDao;

		ObjectMapper mapper = new ObjectMapper();

		public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
		
		int returnEmployeeId;
		
		
		List<QualificationModel> employeequalificationList;
// -------------------------------------------------------START------------------------------------------------------------------------------
	//	public int EmployeeServiceOperation(employeeId,employeeFirstName, employeeLastName, dateOfBirth, employeeAge, mobileNumber, email, employeeAddress, genderTypeId, joiningDate, designationTypeId,loginId,userTypeId,userName,userPassword,createUserId, activeStatus,employeequalificationList) {	
				/*throws JsonParseException, JsonMappingException, IOException {
		try {
				if (employeeId >= 0 && activeStatus == 'Y') {
						if(employeequalificationList != null && activeStatus == 'Y'){
							
							qualificationList = mapper.readValue(employeequalificationList, new TypeReference<List<QualificationModel>>() {});
							
						}
						else{
							qualificationList = null;
					   }
						
			        returnEmployeeId =employeeDao.saveUpdateEmployee(employeeId, employeeFirstName, employeeLastName, dateOfBirth, employeeAge, mobileNumber, email, employeeAddress, genderTypeId, joiningDate, designationTypeId,loginId,userTypeId,userName,userPassword,createUserId, activeStatus, employeequalificationList);					
				    return returnEmployeeId;
				  }if(employeeId > 0 && activeStatus == 'N') {
						System.out.println("inside delete");
						employeeFirstName = null;
						employeeLastName = null;
						dateOfBirth = null;
						employeeAge = null;
						mobileNumber = null;
						email = null;
						employeeAddress=null;
						genderTypeId=0;
						joiningDate=null;
						designationTypeId=0;
						loginId = 0;
						userTypeId=0;
						userName=null;
						userPassword=null;
						qualificationList=null;
						
						returnEmployeeId =employeeDao.saveUpdateEmployee(employeeId, employeeFirstName, employeeLastName, dateOfBirth, employeeAge, mobileNumber, email, employeeAddress, genderTypeId, joiningDate, designationTypeId,loginId,userTypeId,userName,userPassword,createUserId, activeStatus, employeequalificationList);					
					    return returnEmployeeId;
					 
					}
					

			} catch (Exception e) {
				LOGGER.info("Issue in EmployeeServiceOperation " + e);
				return 0;
			}
			return returnEmployeeId;
			

		}*/
// --------------------------------------------------------END------------------------------------------------------------------------------

	

}
//}