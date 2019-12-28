package com.xpanion.scm.dao.impl;
/*
 * @author : ASHLIN ABRAHAM
 * @date : 29.04.2019
 * 
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.xpanion.scm.dao.ProductDao;
import com.xpanion.scm.model.ProductModel;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	int returnedId;

	public static final Logger LOGGER = LoggerFactory.getLogger(ProductDaoImpl.class);
//------------------------------------------------------START------------------------------------------------------	
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date : 18.07.2019
	 * 
	 * @purpose : Select all categories
	 * 
	 * @exception : SQLException, DataAccessException
	 * 
	 */

	@Override
	public List<ProductModel> getAllCategories() {
		List<ProductModel> categoryModel = new ArrayList<ProductModel>();
		String sql = "select pk_product_category_id,upper(product_category_name) from xpanion_supply_chain_management_system_dev.t_det_scm_product_category where active_state_indicator = 'Y'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProductModel>>() {
			@Override
			public List<ProductModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ProductModel model = new ProductModel();
					model.setCategoryId(rs.getInt(1));
					model.setCategoryName(rs.getString(2));
					categoryModel.add(model);
				}
				return categoryModel;
			}

		});
	}

//------------------------------------------------------END------------------------------------------------------	
//------------------------------------------------------START------------------------------------------------------	
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date :
	 * 
	 * @purpose : get sub categories of a specific category.
	 */
	@Override
	public List<ProductModel> getSubCategories(int categoryId) {
		List<ProductModel> subCatModel = new ArrayList<ProductModel>();
		String sql = "select catSub.fk_product_subcategory_id, sub.pk_product_subcategory_id,subcategory_name\n"
				+ "from xpanion_supply_chain_management_system_dev.t_det_scm_category_subcategory_details catSub \n"
				+ "inner join xpanion_supply_chain_management_system_dev.t_det_scm_product_subcategory_details sub\n"
				+ "on catSub.fk_product_subcategory_id = sub.pk_product_subcategory_id\n"
				+ "where fk_product_category_id=" + categoryId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProductModel>>() {
			@Override
			public List<ProductModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ProductModel model = new ProductModel();
					model.setSubCatId(rs.getInt("pk_product_subcategory_id"));
					model.setSubCatName(rs.getString("subcategory_name").toUpperCase());
					subCatModel.add(model);
				}
				return subCatModel;
			}

		});
	}

//------------------------------------------------------END------------------------------------------------------	
//------------------------------------------------------START------------------------------------------------------	
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date :
	 * 
	 * @purpose : get manufacturers name
	 */
	@Override
	public List<ProductModel> getAllManufactures() {
		List<ProductModel> manModel = new ArrayList<ProductModel>();
		String sql = "select pk_brand_id,upper(brand_name) from xpanion_supply_chain_management_system_dev.t_mst_scm_product_brand where active_status_indicator = 'Y'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProductModel>>() {
			@Override
			public List<ProductModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ProductModel model = new ProductModel();
					model.setManufacturerId(rs.getInt(1));
					model.setManufacturerName(rs.getString(2));
					manModel.add(model);
				}
				return manModel;
			}

		});
	}

//------------------------------------------------------END------------------------------------------------------	
//------------------------------------------------------START------------------------------------------------------	
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date :
	 * 
	 * @purpose : get all unit types from db
	 */
	@Override
	public List<ProductModel> getAllUnits() {
		List<ProductModel> unitModel = new ArrayList<ProductModel>();
		String sql = "select pk_unit_of_measurement_id,upper(unit_of_measurement) from xpanion_supply_chain_management_system_dev.t_mst_scm_unit_of_measurement where active_state_indicator = 'Y'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProductModel>>() {
			@Override
			public List<ProductModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ProductModel model = new ProductModel();
					model.setUnitId(rs.getInt(1));
					model.setUnitType(rs.getString(2));
					unitModel.add(model);
				}
				return unitModel;
			}

		});
	}

//---------------------------------------------------END----------------------------------------------------------
//----------------------------------------------------START----------------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date : 31.07.2019
	 * 
	 * @purpose : get GST values from its table
	 */
	@Override
	public List<ProductModel> getAllGstValues() {
		List<ProductModel> gstModel = new ArrayList<ProductModel>();
		String sql = "select pk_product_gst_id,product_gst from xpanion_supply_chain_management_system_dev.t_mst_scm_inventory_products_gst_details where active_state_indicator = 'Y'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProductModel>>() {
			@Override
			public List<ProductModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ProductModel model = new ProductModel();
					model.setGstId(rs.getInt(1));
					model.setGst(rs.getDouble(2));
					gstModel.add(model);
				}
				return gstModel;
			}

		});
	}

//----------------------------------------------------END-----------------------------------------------------------
//-------------------------------------------------------START----------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date : 19.07.2019
	 * 
	 * @purpose : save, update , delete products
	 * 
	 */
	@Override
	public int saveUpdateProducts(int productId, int productGstId, int catSubCatId, String itemName,
			String itemDescription, double stockthreshold, double openingStock, double mrp, int hsnCode, String color,
			String size, String shape, String volume, String height, String weight, String length,
			String additionalAttribute, int unitId, int manfacturerId, int createUserId, int warehouseId,
			char activeStatus) {
		SqlParameterSource in;
		SimpleJdbcCall saveProductJdbcCall = null;
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;

		try {
			LOGGER.info("saveUpdateProducts()");
			saveProductJdbcCall = new SimpleJdbcCall(jdbcTemplate)
					.withSchemaName("xpanion_supply_chain_management_system_dev")
					.withFunctionName("fn_save_update_inventory_product_details");
			inParamMap.put("p_product_id", Integer.valueOf(productId));
			inParamMap.put("p_product_name", String.valueOf(itemName));
			inParamMap.put("p_stock_threshold", Double.valueOf(stockthreshold));
			inParamMap.put("p_maximum_retail_price", Double.valueOf(mrp));
			inParamMap.put("p_product_hsn_code", Integer.valueOf(hsnCode));
			inParamMap.put("p_opening_stock", Double.valueOf(openingStock));
			inParamMap.put("p_product_gst_id", Integer.valueOf(productGstId));
			inParamMap.put("p_product_category_subcategory_id", Integer.valueOf(catSubCatId));
			inParamMap.put("p_unit_measurment_id", Integer.valueOf(unitId));
			inParamMap.put("p_warehouse_id", Integer.valueOf(warehouseId));
			inParamMap.put("p_brand_id", Integer.valueOf(manfacturerId));
			inParamMap.put("p_item_description", String.valueOf(itemDescription));
			inParamMap.put("p_color", String.valueOf(color));
			inParamMap.put("p_product_size", String.valueOf(size));
			inParamMap.put("p_shape", String.valueOf(shape));
			inParamMap.put("p_volume", String.valueOf(volume));
			inParamMap.put("p_product_length", String.valueOf(length));
			inParamMap.put("p_product_height", String.valueOf(height));
			inParamMap.put("p_product_weight", String.valueOf(weight));
			inParamMap.put("p_additional_attributes", String.valueOf(additionalAttribute));
			inParamMap.put("p_user_id", Integer.valueOf(createUserId));
			inParamMap.put("p_active_status", String.valueOf(activeStatus));
			in = new MapSqlParameterSource(inParamMap);
			saveJdbcCallResult = saveProductJdbcCall.execute(in);
			saveJdbcCallResult.forEach((key, value) -> returnedId = (int) value);
			LOGGER.info("id : " + returnedId);
			return returnedId;
		} catch (Exception e) {
			LOGGER.info("error in saveUpdateProducts()" + e);
			return 0;
		}

	}

//--------------------------------------------------START------------------------------------------------------------
	/*
	 * 
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date : 20.07.2019
	 * 
	 * @purpose : get all product details
	 * 
	 */
	@Override
	public List<ProductModel> getProductDetails(int productId) {
		List<ProductModel> productModel = new ArrayList<ProductModel>();
		String sql;
		if (productId > 0) {
			sql = "SELECT  pro.active_state_indicator,pk_product_id,product_name,\n"
					+ "stock_threshold,maximum_retail_price,fk_category_subcategory_id,fk_product_gst_id,\n"
					+ "gst.pk_product_gst_id,gst.product_gst,\n"
					+ "det.pk_product_details_id,fk_unit_of_measurment_id,fk_brand_id,item_description,\n"
					+ "color,product_size,shape,volume,product_length,product_weight,product_height,additional_attributes,product_hsn_code,\n"
					+ "op.opening_stock,\n" + "brand.brand_name,\n" + "unit.unit_of_measurement,\n"
					+ "catsubcat.fk_product_category_id,fk_product_subcategory_id,\n" + "cat.product_category_name,\n"
					+ "subcat.subcategory_name\n"
					+ "FROM xpanion_supply_chain_management_system_dev.t_det_scm_inventory_product_details det\n"
					+ "INNER JOIN xpanion_supply_chain_management_system_dev.t_mst_scm_inventory_products pro ON \n"
					+ "pro.pk_product_id = det.fk_product_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_mst_scm_inventory_products_gst_details gst\n"
					+ "on gst.pk_product_gst_id = pro.fk_product_gst_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_det_scm_inventory_product_opening_stock_details op\n"
					+ "on op.fk_product_id = pro.pk_product_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_mst_scm_product_brand brand\n"
					+ "on brand.pk_brand_id = det.fk_brand_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_mst_scm_unit_of_measurement unit\n"
					+ "on unit.pk_unit_of_measurement_id = det.fk_unit_of_measurment_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_det_scm_category_subcategory_details catsubcat\n"
					+ "on catsubcat.pk_category_subcategory_id = det.fk_category_subcategory_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_det_scm_product_category cat\n"
					+ "on cat.pk_product_category_id=catsubcat.fk_product_category_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_det_scm_product_subcategory_details subcat\n"
					+ "on subcat.pk_product_subcategory_id=catsubcat.fk_product_subcategory_id\n"
					+ "where pro.pk_product_id=" + productId;

		} else {
			sql = "SELECT  pro.active_state_indicator,pk_product_id,product_name,\n"
					+ "stock_threshold,maximum_retail_price,fk_category_subcategory_id,fk_product_gst_id,\n"
					+ "gst.pk_product_gst_id,gst.product_gst,\n"
					+ "det.pk_product_details_id,fk_unit_of_measurment_id,fk_brand_id,item_description,\n"
					+ "color,product_size,shape,volume,product_length,product_weight,product_height,additional_attributes,product_hsn_code,\n"
					+ "op.opening_stock,\n" + "brand.brand_name,\n" + "unit.unit_of_measurement,\n"
					+ "catsubcat.fk_product_category_id,fk_product_subcategory_id,\n" + "cat.product_category_name,\n"
					+ "subcat.subcategory_name\n"
					+ "FROM xpanion_supply_chain_management_system_dev.t_det_scm_inventory_product_details det\n"
					+ "INNER JOIN xpanion_supply_chain_management_system_dev.t_mst_scm_inventory_products pro ON \n"
					+ "pro.pk_product_id = det.fk_product_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_mst_scm_inventory_products_gst_details gst\n"
					+ "on gst.pk_product_gst_id = pro.fk_product_gst_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_det_scm_inventory_product_opening_stock_details op\n"
					+ "on op.fk_product_id = pro.pk_product_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_mst_scm_product_brand brand\n"
					+ "on brand.pk_brand_id = det.fk_brand_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_mst_scm_unit_of_measurement unit\n"
					+ "on unit.pk_unit_of_measurement_id = det.fk_unit_of_measurment_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_det_scm_category_subcategory_details catsubcat\n"
					+ "on catsubcat.pk_category_subcategory_id = det.fk_category_subcategory_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_det_scm_product_category cat\n"
					+ "on cat.pk_product_category_id=catsubcat.fk_product_category_id\n"
					+ "left join xpanion_supply_chain_management_system_dev.t_det_scm_product_subcategory_details subcat\n"
					+ "on subcat.pk_product_subcategory_id=catsubcat.fk_product_subcategory_id";
		}
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProductModel>>() {
			@Override
			public List<ProductModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ProductModel model = new ProductModel();
					model.setProductId(rs.getInt("pk_product_id"));
					model.setItemName(rs.getString("product_name"));
					model.setStockThreshold(rs.getDouble("stock_threshold"));
					model.setOpeningStock(rs.getDouble("opening_stock"));
					model.setMrp(rs.getDouble("maximum_retail_price"));
					model.setGstId(rs.getInt("fk_product_gst_id"));
					model.setGst(rs.getDouble("product_gst"));
					model.setHsnCode(rs.getString("product_hsn_code"));
					model.setProductDetailsId(rs.getInt("pk_product_details_id"));
					model.setUnitId(rs.getInt("fk_unit_of_measurment_id"));
					model.setUnitType(rs.getString("unit_of_measurement"));
					model.setManufacturerId(rs.getInt("fk_brand_id"));
					model.setManufacturerName(rs.getString("brand_name"));
					model.setCategoryId(rs.getInt("fk_product_category_id"));
					model.setCategoryName(rs.getString("product_category_name"));
					model.setSubCatId(rs.getInt("fk_product_subcategory_id"));
					model.setSubCatName(rs.getString("subcategory_name"));
					model.setCatSubCatDetailsId(rs.getInt("fk_category_subcategory_id"));
					model.setItemDescription(rs.getString("item_description"));
					model.setColor(rs.getString("color"));
					model.setShape(rs.getString("shape"));
					model.setSize(rs.getString("product_size"));
					model.setVolume(rs.getString("volume"));
					model.setWeight(rs.getString("product_weight"));
					model.setHeight(rs.getString("product_height"));
					model.setLength(rs.getString("product_length"));
					model.setAdditionalAttribute(rs.getString("additional_attributes"));

					model.setActiveStatus(rs.getString("active_state_indicator"));
					productModel.add(model);
				}
				return productModel;
			}

		});
	}

//-----------------------------------------------------START---------------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date :
	 * 
	 * @purpose : get all sub categories of all categories
	 */
	@Override
	public List<ProductModel> getAllSubCategories() {
		List<ProductModel> subCatModel = new ArrayList<ProductModel>();
		String sql = "select pk_product_subcategory_id,upper(subcategory_name) from xpanion_supply_chain_management_system_dev.t_det_scm_product_subcategory_details where active_state_indicator = 'Y'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProductModel>>() {
			@Override
			public List<ProductModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ProductModel model = new ProductModel();
					model.setSubCatId(rs.getInt("pk_product_subcategory_id"));
					model.setSubCatName(rs.getString(2));

					subCatModel.add(model);
				}
				return subCatModel;
			}

		});

	}

//----------------------------------------------------END-----------------------------------------------------------
//---------------------------------------------------START-------------------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date : 31.07.2019
	 * 
	 * @purpose : get pk_category_subcategory_id using category ID and sub category
	 * ID
	 */
	@Override
	public List<ProductModel> getCatSubCatDetails(int categoryId, int subcategoryId) {
		List<ProductModel> catSubCatModel = new ArrayList<ProductModel>();
		String sql = "select pk_category_subcategory_id from xpanion_supply_chain_management_system_dev.t_det_scm_category_subcategory_details "
				+ "where fk_product_subcategory_id = " + subcategoryId + " and fk_product_category_id=" + categoryId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProductModel>>() {
			@Override
			public List<ProductModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					ProductModel model = new ProductModel();
					model.setCatSubCatDetailsId(rs.getInt("pk_category_subcategory_id"));
					catSubCatModel.add(model);
				}
				return catSubCatModel;
			}

		});
	}
//------------------------------------------------END-----------------------------------------------------------

	public List<ProductModel>getitemedit(int productId) {
		List<ProductModel> detailModels = new ArrayList<ProductModel>();
		String sql ="select pro.active_state_indicator,pk_product_id,product_name,stock_threshold,maximum_retail_price,fk_category_subcategory_id,fk_product_gst_id, gst.pk_product_gst_id,product_gst,det.pk_product_details_id,fk_unit_of_measurment_id,fk_brand_id,item_description,color,product_size,shape,volume,product_length,product_weight,product_height,additional_attributes,product_hsn_code,op.opening_stock,brand.brand_name,unit.unit_of_measurement,catsubcat.fk_product_category_id,fk_product_subcategory_id,cat.product_category_name,subcat.subcategory_name from xpanion_supply_chain_management_system_dev.t_det_scm_inventory_product_details det INNER JOIN xpanion_supply_chain_management_system_dev.t_mst_scm_inventory_products pro on pro.pk_product_id = det.fk_product_id left join xpanion_supply_chain_management_system_dev.t_mst_scm_inventory_products_gst_details gst on gst.pk_product_gst_id = pro.fk_product_gst_id left join xpanion_supply_chain_management_system_dev.t_det_scm_inventory_product_opening_stock_details op on op.fk_product_id = pro.pk_product_id left join xpanion_supply_chain_management_system_dev.t_mst_scm_product_brand brand on brand.pk_brand_id = det.fk_brand_id left join xpanion_supply_chain_management_system_dev.t_mst_scm_unit_of_measurement unit on unit.pk_unit_of_measurement_id = det.fk_unit_of_measurment_id left join xpanion_supply_chain_management_system_dev.t_det_scm_category_subcategory_details catsubcat on catsubcat.pk_category_subcategory_id = det.fk_category_subcategory_id left join xpanion_supply_chain_management_system_dev.t_det_scm_product_category cat on cat.pk_product_category_id=catsubcat.fk_product_category_id left join xpanion_supply_chain_management_system_dev.t_det_scm_product_subcategory_details subcat on subcat.pk_product_subcategory_id=catsubcat.fk_product_subcategory_id where pro.active_state_indicator='Y' and pro.pk_product_id=" + productId; 
									
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProductModel>>() {
		@Override
		public List<ProductModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
		ProductModel models= new ProductModel();
		    models.setItemName(rs.getString("product_name"));
		    models.setStockThreshold(rs.getDouble("stock_threshold"));
			models.setMrp(rs.getDouble("maximum_retail_price"));
			models.setProductId(rs.getInt("pk_product_id"));
			models.setGstId(rs.getInt("pk_product_gst_id"));
			models.setProductDetailsId(rs.getInt("pk_product_details_id"));
			models.setGst(rs.getDouble("product_gst"));
			models.setItemDescription(rs.getString("item_description"));
			models.setColor(rs.getString("color"));
			models.setSize(rs.getString("product_size"));
			models.setShape(rs.getString("shape"));
			models.setVolume(rs.getString("volume"));
			
			models.setLength(rs.getString("product_length"));
			models.setWeight(rs.getString("product_weight"));
			models.setHeight(rs.getString("product_height"));
			models.setAdditionalAttribute(rs.getString("additional_attributes"));
			models.setHsnCode(rs.getString("product_hsn_code"));
			models.setOpeningStock(rs.getDouble("opening_stock"));
			models.setManufacturerName(rs.getString("brand_name"));
			models.setManufacturerId(rs.getInt("fk_brand_id"));
			models.setUnitType(rs.getString("unit_of_measurement"));
			models.setUnitId(rs.getInt("fk_unit_of_measurment_id"));
			models.setCategoryId(rs.getInt("fk_product_category_id"));
			models.setCategoryName(rs.getString("product_category_name"));
			models.setCategoryId(rs.getInt("fk_product_subcategory_id"));
			models.setSubCatName(rs.getString("subcategory_name"));
			
			
			

		detailModels.add(models);
		}
		return detailModels;
		}
		});
		}
	}



