package com.xpanion.scm.dao;
/*
 * @author : ASHLIN ABRAHAM
 * @date : 27.03.2019
 * 
 */

import java.util.List;

import com.xpanion.scm.model.AddressModel;

public interface AddressDao {
	public List<AddressModel> getSingleCustomerAddress(int contactId);
}

//Ajay
