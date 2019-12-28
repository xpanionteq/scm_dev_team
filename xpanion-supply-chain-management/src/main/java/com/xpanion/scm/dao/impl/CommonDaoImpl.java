package com.xpanion.scm.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.xpanion.scm.dao.CommonDao;

@Repository
public class CommonDaoImpl implements CommonDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	int returnedId;
	int returnCategoryId;
	Integer detId = 0;

	public static final Logger LOGGER = LoggerFactory.getLogger(CommonDaoImpl.class);
//----------------------------------------------START---------------------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date : 25.07.2019
	 */

	@Override
	public int saveUpdateCategory(int catSubCatDetailsId, int categoryId, int subCategoryId, String categoryName,
			String subCategoryName, int createUserId, char activeStatus) {
		SqlParameterSource in;
		SimpleJdbcCall saveCategoryJdbcCall = null;
		SimpleJdbcCall saveSubCategoryJdbcCall = null;
		SimpleJdbcCall saveAllCategoryJdbcCall = null;
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;
		try {
			if (categoryId == 0 && activeStatus == 'Y') {
				saveCategoryJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						.withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_category_details");
				inParamMap.put("p_category_id", Integer.valueOf(categoryId));
				inParamMap.put("p_product_category_name", String.valueOf(categoryName));
				inParamMap.put("p_user_id", Integer.valueOf(createUserId));
				inParamMap.put("p_active_status", Character.valueOf(activeStatus));
				in = new MapSqlParameterSource(inParamMap);
				saveJdbcCallResult = saveCategoryJdbcCall.execute(in);
				saveJdbcCallResult.entrySet().forEach(System.out::println);
				saveJdbcCallResult.forEach((key, value) -> returnCategoryId = (int) value);
				if (returnCategoryId == -2) {
					return 0;
				}
				categoryId = returnCategoryId;
			}
			if (subCategoryId == 0) {
				saveSubCategoryJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						.withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_subcategory_details");
				inParamMap.put("p_sub_category_id", Integer.valueOf(subCategoryId));
				inParamMap.put("p_product_subcategory_name", String.valueOf(subCategoryName));
				inParamMap.put("p_user_id", Integer.valueOf(createUserId));
				inParamMap.put("p_active_status", Character.valueOf(activeStatus));
				in = new MapSqlParameterSource(inParamMap);
				saveJdbcCallResult = saveSubCategoryJdbcCall.execute(in);
				saveJdbcCallResult.entrySet().forEach(System.out::println);
				saveJdbcCallResult.forEach((key, value) -> returnCategoryId = (int) value);
				if (returnCategoryId == -2) {
					return 0;
				}
				subCategoryId = returnCategoryId;
			}
			if (catSubCatDetailsId == 0 && categoryId > 0 && subCategoryId > 0) {
				saveAllCategoryJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						.withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_product_category_subcategory_details");
				inParamMap.put("p_product_category_subcategory_id", Integer.valueOf(catSubCatDetailsId));
				inParamMap.put("p_category_id", Integer.valueOf(categoryId));
				inParamMap.put("p_subcategory_id", Integer.valueOf(subCategoryId));
				inParamMap.put("p_user_id", Integer.valueOf(createUserId));
				inParamMap.put("p_active_status", Character.valueOf(activeStatus));
				in = new MapSqlParameterSource(inParamMap);
				saveJdbcCallResult = saveAllCategoryJdbcCall.execute(in);
				saveJdbcCallResult.entrySet().forEach(System.out::println);
				saveJdbcCallResult.forEach((key, value) -> returnedId = (int) value);

			}
			return returnedId;

		} catch (Exception e) {
			LOGGER.info("issue in saveUpdateCategory()" + e);
			return 0;
		}

	}
//-----------------------------------------------------------END--------------------------------------------------------
	
	@Override
	public int getCatSubCatDetailsId(int categoryId, int subCategoryId) {
		String sql = "select pk_category_subcategory_id from xpanion_supply_chain_management_system_dev.t_det_scm_category_subcategory_details\n" + 
				"where fk_product_category_id="+categoryId+" and fk_product_subcategory_id="+subCategoryId;
		try {
			 detId = jdbcTemplate.queryForObject(sql, Integer.class);
			
		}
		catch(EmptyResultDataAccessException e) {
			detId = 0;
			LOGGER.error("resultset returns "+ e);
			
		}
		return detId;
	}
}
