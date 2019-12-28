package com.xpanion.scm.dao;

import java.util.List;

import com.xpanion.scm.model.WareHouseModel;

public interface WarehouseDao {
	
	int saveUpdateWarehouse(int warehouseId, String warehousecode, String warehouseName, String warehouseAddress,
			String mobileNumber, String warehouseemail,int createUserId, char activeStatus);
	
	
	public List<WareHouseModel> getwarehouseDetails();
	 public List<WareHouseModel> getEditwarehouseDetails(int warehouseId);

}
