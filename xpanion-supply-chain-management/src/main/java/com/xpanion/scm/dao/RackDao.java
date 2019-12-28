package com.xpanion.scm.dao;

import java.util.List;

import com.xpanion.scm.model.WareHouseModel;

public interface RackDao {


	int saveUpdateRack(int rackId,int warehouseId ,int sectionId,String rackName,int createUserId, char activeStatus);
	
	 public List<WareHouseModel> getrackDetails( int sectionId);
	 
	 public List<WareHouseModel> getrack( int sectionId); 
	 
}
