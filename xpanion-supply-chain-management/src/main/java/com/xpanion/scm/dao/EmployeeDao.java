package com.xpanion.scm.dao;

import java.util.List;


import com.xpanion.scm.model.EmployeeModel;

import com.xpanion.scm.model.QualificationModel;

/*
 * @author : ASWATHY RAJ.D
 * @date : 02.04.2019
 * 
 */
public interface EmployeeDao {
//	public List<EmployeeModel> getEmployeePageInformation(integer employeeId);
	
    public int saveUpdateEmployee(int employeeId,String employeeFirstName,String employeeLastName,String email,String mobileNumber,String joiningDate,String dateOfBirth,
    		int genderTypeId,
		String employeeAddress,int designationTypeId,int loginId,int userTypeId,String userName,String userPassword,
		int createUserId,char activeStatus,List<QualificationModel>qualificationList);

    
    public List<EmployeeModel>getDesignationType();
      public List<EmployeeModel> getGenderTypes();
      public List<EmployeeModel> getQualificationType();
   /* public List<EmployeeModel> getEmployeeFirstNames();
	public List<EmployeeModel> getEmployeeLastNames();
		public List<EmployeeModel> getEmployeeDetails(String  employeeFirstName,String employeeLastName,String email);
    public List<EmployeeModel> getEmployeeUserDetails();
    public List<EmployeeModel> getEmployeeAdminDetails();
    public List<EmployeeModel> getSingleEmployeeDet(integer employeeId);
    public List<EmployeeModel> getUserName(String userName);
    public List<EmployeeModel> getUserType();
    public List<EmployeeModel> getUserTypes(integer employeeId);
    */
    public List<EmployeeModel> getemployee();
    public List<EmployeeModel> getUserType();
    public List<EmployeeModel> getemployees(int employeeId);
    int deleteemployee(int employeeId,int createUserId,char activeStatus);
} 
