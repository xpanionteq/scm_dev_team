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

import com.xpanion.scm.dao.RackDao;
import com.xpanion.scm.model.WareHouseModel;

@Repository
public class RackDaoImpl implements RackDao{

	
	public static final Logger LOGGER = LoggerFactory.getLogger(RackDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	int returnRackId;
	
	
	
	@Override
	public int saveUpdateRack(int rackId, int warehouseId, int sectionId, String rackName, int createUserId,
			char activeStatus) {
		
		
	    SqlParameterSource in;
		SimpleJdbcCall saveRackJdbcCall = null;
		
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;
		try {
			LOGGER.info("saveUpdateRack()");
			
				saveRackJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						
               .withSchemaName("xpanion_supply_chain_management_system_dev")
               .withFunctionName("fn_save_update_rack_details");
  
  inParamMap.put("p_warehouse_rack_id", Integer.valueOf(rackId));
  inParamMap.put("p_warehouse_id", Integer.valueOf(warehouseId));
  inParamMap.put("p_warehouse_section_id", Integer.valueOf(sectionId));
  inParamMap.put("p_rack_name", String.valueOf(rackName));
  inParamMap.put("p_user_id", Integer.valueOf(createUserId));
  inParamMap.put("p_active_status", Character.valueOf(activeStatus));
  
  in = new MapSqlParameterSource(inParamMap);
  saveJdbcCallResult = saveRackJdbcCall.execute(in);
  saveJdbcCallResult.entrySet().forEach(System.out::println);
  saveJdbcCallResult.forEach((key, value) -> returnRackId = (int) value);
  LOGGER.info("id of the contact " + returnRackId); 
  
  if (rackId > 0) 
  { 
	  return rackId;
	  
  } 
  return returnRackId; 
  }
  catch (Exception e) {
	  LOGGER.info("error in saveUpdateRack()" + e);

		
		return 0;
  }
	}
	
	
	
	
//------------------------------------------------------------------------------------------------------------//	
	 
	  
	  
	  @Override public List<WareHouseModel> getrack(int sectionId) {
		  List<WareHouseModel> OrderModel = new ArrayList<WareHouseModel>(); 
		  String sql = 
				  "select pk_warehouse_rack_id,fk_warehouse_section_id,rack_name from  xpanion_supply_chain_management_system_dev.t_det_scm_warehouse_rack_details  where active_state_indicator='Y' and fk_warehouse_section_id="+sectionId;
		  
		  return jdbcTemplate.query(sql, new ResultSetExtractor<List<WareHouseModel>>()
		  {
		  
		  @Override public List<WareHouseModel> extractData(ResultSet rs) throws
		  SQLException, DataAccessException { while (rs.next()) { 
			  WareHouseModel model = new WareHouseModel(); 
			  
		  model.setRackId(rs.getInt("pk_warehouse_rack_id"));
		  model.setSectionId(rs.getInt("fk_warehouse_section_id"));
		  model.setRackName(rs.getString("rack_name"));
		  
		  OrderModel.add(model); } return OrderModel; }
		  
		  });
		 
		 }
	
	
	//---------------------------------------------------------------------------------------------------------------------------//
	
	 
	 
	  @Override public List<WareHouseModel> getrackDetails(int sectionId) {
	  List<WareHouseModel> OrderModel = new ArrayList<WareHouseModel>(); 
	  String sql = 
			 " select ak.pk_warehouse_id,warehouse_name,cd.pk_warehouse_section_id,section_name,ab.pk_warehouse_rack_id,fk_warehouse_section_id,rack_name from xpanion_supply_chain_management_system_dev.t_det_scm_warehouse_details ak left join xpanion_supply_chain_management_system_dev.t_det_scm_warehouse_section_details cd on cd.fk_warehouse_id=ak.pk_warehouse_id left join xpanion_supply_chain_management_system_dev.t_det_scm_warehouse_rack_details ab  on ab.fk_warehouse_id=ak.pk_warehouse_id where cd.active_state_indicator='Y' and pk_warehouse_section_id="+sectionId;
	  
	  return jdbcTemplate.query(sql, new ResultSetExtractor<List<WareHouseModel>>()
	  {
	  
	  @Override public List<WareHouseModel> extractData(ResultSet rs) throws
	  SQLException, DataAccessException { while (rs.next()) { 
		  WareHouseModel model = new WareHouseModel(); 
		  
	  model.setRackId(rs.getInt("pk_warehouse_section_id"));
	  model.setWarehouseId(rs.getInt("pk_warehouse_id"));
	  model.setWarehouseName(rs.getString("warehouse_name"));
	  model.setSectionName(rs.getString("section_name"));
	  model.setSectionId(rs.getInt("pk_warehouse_rack_id"));
	  model.setRackName(rs.getString("rack_name"));
	  
	  OrderModel.add(model); } return OrderModel; }
	  
	  });
	 
	 }
	 
	
	
	
	

}
