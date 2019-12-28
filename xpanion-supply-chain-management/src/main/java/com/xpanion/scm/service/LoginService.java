package com.xpanion.scm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xpanion.scm.dao.LoginDao;
import com.xpanion.scm.model.UserModel;

/*
 * @author : ASHLIN ABRAHAM
 * @date : 04.04.2019
 * 
 */
@Service
@Scope("session")
public class LoginService {
	@Autowired 
	LoginDao loginDao;
	
	@Autowired
	UserModel userSession;
	
	boolean loginStatus;
	public static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
//---------------------------------------------------START-----------------------------------------------------
	public boolean loginUserService(String userName, String userPassword) {
		try {
			UserModel log = loginDao.getLoginDetails(userName, userPassword);
			if(log != null) {
				if(log.getUserId() > 0) {
					userSession.setUserId(log.getUserId());
					userSession.setFirstName(log.getFirstName());
					userSession.setLastName(log.getLastName());
					userSession.setUserType(log.getUserType());
					userSession.setDesignation(log.getDesignation());
					loginStatus = true;
				}
				else {
					loginStatus = false;
				}
				
				
			}else {
				loginStatus = false;
			}
				
			
		}
		catch(Exception e) {
			e.printStackTrace();
			loginStatus = false;
		}
		return loginStatus;
}
}