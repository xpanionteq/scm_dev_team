package com.xpanion.scm.dao;

import java.util.List;

import com.xpanion.scm.model.ContactModel;
import com.xpanion.scm.model.HomeModel;

public interface HomeDao {
	 int saveUpdatephone( int phoneId,String contactName,String mobileNumber, String email,int createUserId, char activeStatus);

	
	 public List <HomeModel> getphonedetails();
	
	 public List<HomeModel> getphoneedit(int phoneId);
	 
	 int deletephone(int phoneId,int createUserId,char activeStatus);
	
		 
}
