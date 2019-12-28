package com.xpanion.scm.dao;

import java.util.List;

import com.xpanion.scm.model.WareHouseModel;

public interface SectionDao {
	

	int saveUpdateSection(int sectionId,int warehouseId ,String sectionName,int createUserId, char activeStatus);
	public List<WareHouseModel> getsectionrackDetails(int warehouseId);
	
	 public List<WareHouseModel> getEditsectionDetails(int sectionId);
	
}
