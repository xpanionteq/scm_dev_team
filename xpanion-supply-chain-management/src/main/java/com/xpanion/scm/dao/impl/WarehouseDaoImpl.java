package com.xpanion.scm.dao.impl;

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

import com.xpanion.scm.dao.WarehouseDao;
import com.xpanion.scm.model.AddressModel;
import com.xpanion.scm.model.HomeModel;
import com.xpanion.scm.model.OrderModel;
import com.xpanion.scm.model.WareHouseModel;


@Repository
public class WarehouseDaoImpl  implements WarehouseDao {
	
	

	public static final Logger LOGGER = LoggerFactory.getLogger(WarehouseDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	int returnWarehouseId;
	
	
	
	
//------------------------------------------------------------------------------------------------------------------------//

	
	  @Override public int saveUpdateWarehouse(int warehouseId, String
	  warehousecode, String warehouseName, String warehouseAddress, String
	  mobileNumber, String warehouseemail, int createUserId, char activeStatus) {
		  
		  
		  
		  
		    SqlParameterSource in;
			SimpleJdbcCall saveWarehouseJdbcCall = null;
			
			Map<String, Object> inParamMap = new HashMap<>();
			Map<String, Object> saveJdbcCallResult = null;
			try {
				LOGGER.info("saveUpdateWarehouse()");
				
					saveWarehouseJdbcCall = new SimpleJdbcCall(jdbcTemplate)
							
	               .withSchemaName("xpanion_supply_chain_management_system_dev")
	               .withFunctionName("fn_save_update_warehouse_details");
	  
	  inParamMap.put("p_warehouse_id", Integer.valueOf(warehouseId));
	  inParamMap.put("p_warehouse_code", String.valueOf(warehousecode));
	  inParamMap.put("p_warehouse_name", String.valueOf(warehouseName));
	  inParamMap.put("p_warehouse_address", String.valueOf(warehouseAddress));
	 inParamMap.put("p_mobile_number", String.valueOf(mobileNumber));
	 inParamMap.put("p_warehouse_email", String.valueOf(warehouseemail));
	  
	  inParamMap.put("p_user_id", Integer.valueOf(createUserId));
	  inParamMap.put("p_active_status", Character.valueOf(activeStatus)); in = new
	  MapSqlParameterSource(inParamMap); saveJdbcCallResult =
	  saveWarehouseJdbcCall.execute(in);
	  saveJdbcCallResult.entrySet().forEach(System.out::println);
	  saveJdbcCallResult.forEach((key, value) -> returnWarehouseId = (int) value);
	  LOGGER.info("id of the contact " + returnWarehouseId); 
	  
	  if (warehouseId > 0) 
	  { 
		  return warehouseId;
		  
	  } return returnWarehouseId; 
	  }
	  catch (Exception e) { LOGGER.info("error in saveUpdateWarehouse()" + e);
	   return 0; 
	 }
	  }
	 

//------------------------------------------------------------------------------------------------------------------------//
	  
	  
	  
		
		@Override
	    public List<WareHouseModel> getwarehouseDetails() {
		List<WareHouseModel> OrderModel = new ArrayList<WareHouseModel>();
		String sql = "select pk_warehouse_id,warehouse_code,warehouse_name from xpanion_supply_chain_management_system_dev.t_det_scm_warehouse_details";

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<WareHouseModel>>() {
			@Override
			public List<WareHouseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					WareHouseModel model = new WareHouseModel();
					model.setWarehouseId(rs.getInt("pk_warehouse_id"));
					model.setWarehousecode(rs.getString("warehouse_code"));
					model.setWarehouseName(rs.getString("warehouse_name"));
					
					OrderModel.add(model);
				}
				return OrderModel;
			}

		});
	}

	
	  //---------------------------------------------------------------------------------------------------------------//
		
		
		

		@Override
		public List<WareHouseModel> getEditwarehouseDetails(int warehouseId) {
			List<WareHouseModel> warehousemodel = new ArrayList<WareHouseModel>();
			String sql = "select pk_warehouse_id,warehouse_code,warehouse_name,warehouse_address,mobile_number,warehouse_email from xpanion_supply_chain_management_system_dev.t_det_scm_warehouse_details where active_state_indicator='Y' and pk_warehouse_id="+warehouseId;

			return jdbcTemplate.query(sql, new ResultSetExtractor<List<WareHouseModel>>() {
				@Override
				public List<WareHouseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while (rs.next()) {
						WareHouseModel model = new WareHouseModel();
						model.setWarehouseId(rs.getInt(1));
						model.setWarehousecode(rs.getString(2));
						model.setWarehouseName(rs.getString(3));
						model.setWarehouseAddress(rs.getString(4));
						model.setMobileNumber(rs.getString(5));
						model.setWarehouseemail(rs.getString(6));
						warehousemodel.add(model);
					}
					return warehousemodel;
				}

			});
		}
	  
	  
	  
	  
	
	
	
	
	
	
	
	
	
	
}
