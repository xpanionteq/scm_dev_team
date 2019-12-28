package com.xpanion.scm.dao;
/*
 * @author : ASHLIN ABRAHAM
 * @date : 29.04.2019
 * 
 */

import java.util.List;

import com.xpanion.scm.model.ProductModel;

public interface ProductDao {
	public List<ProductModel> getAllCategories();

	public List<ProductModel> getSubCategories(int categoryId);

	public List<ProductModel> getAllSubCategories();

	public List<ProductModel> getAllManufactures();

	public List<ProductModel> getAllUnits();

	public List<ProductModel> getAllGstValues();

	int saveUpdateProducts(int productId, int productGstId, int catSubCatId, String itemName, String itemDescription,
			double stockthreshold, double openingStock, double mrp, int hsnCode, String color, String size,
			String shape, String volume, String height, String weight, String length, String additionalAttribute,
			int unitId, int manfacturerId, int createUserId, int warehouseId, char activeStatus);

	public List<ProductModel> getProductDetails(int productId);

	public List<ProductModel> getCatSubCatDetails(int categoryId, int subcategoryId);
	
	public List<ProductModel> getitemedit(int productId);
}
