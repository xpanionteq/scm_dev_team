package com.xpanion.scm.dao;
/*
 * @author : ASHLIN ABRAHAM
 * @date : 02.04.2019
 * 
 */

import com.xpanion.scm.model.UserModel;

public interface LoginDao {
	public UserModel getLoginDetails(String userName, String userPassword);

}
