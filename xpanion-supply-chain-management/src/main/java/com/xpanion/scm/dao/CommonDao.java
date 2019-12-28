package com.xpanion.scm.dao;
/*
 * @author : ASHLIN ABRAHAM
 */

public interface CommonDao {

	int saveUpdateCategory(int catSubCatDetailsId, int categoryId, int subCategoryId, String categoryName,
			String subCategoryName, int createUserId, char activeStatus);

	int getCatSubCatDetailsId(int categoryId, int subCategoryId);
}
