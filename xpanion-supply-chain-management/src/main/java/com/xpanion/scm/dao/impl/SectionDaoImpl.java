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

import com.xpanion.scm.dao.SectionDao;
import com.xpanion.scm.model.WareHouseModel;



@Repository
public class SectionDaoImpl implements SectionDao{
	
	public static final Logger LOGGER = LoggerFactory.getLogger(SectionDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	int returnSectionId;
	
	
	@Override
	public int saveUpdateSection(int sectionId,int warehouseId, String sectionName, int createUserId, char activeStatus) {
	    SqlParameterSource in;
		SimpleJdbcCall saveSectionJdbcCall = null;
		
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;
		try {
			LOGGER.info("saveUpdateSection()");
			
				saveSectionJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						
               .withSchemaName("xpanion_supply_chain_management_system_dev")
               .withFunctionName("fn_save_update_section_details");
  
  inParamMap.put("p_warehouse_section_id", Integer.valueOf(sectionId));
  inParamMap.put("p_warehouse_id", Integer.valueOf(warehouseId));
  inParamMap.put("p_section_name", String.valueOf(sectionName)); 
  inParamMap.put("p_user_id", Integer.valueOf(createUserId));
  inParamMap.put("p_active_status", Character.valueOf(activeStatus));
  
  in = new MapSqlParameterSource(inParamMap);
  saveJdbcCallResult = saveSectionJdbcCall.execute(in);
  saveJdbcCallResult.entrySet().forEach(System.out::println);
  saveJdbcCallResult.forEach((key, value) -> returnSectionId = (int) value);
  LOGGER.info("id of the contact " + returnSectionId); 
  
  if (sectionId > 0) 
  { 
	  return sectionId;
	  
  } 
  return returnSectionId; 
  }
  catch (Exception e) {
	  LOGGER.info("error in saveUpdateSection()" + e);
  
	return 0;
	}
		
	}
	
	//------------------------------------------------------------------------------------------------------------------//
	
	

	@Override
    public List<WareHouseModel> getsectionrackDetails(int warehouseId) {
	List<WareHouseModel> OrderModel = new ArrayList<WareHouseModel>();
	String sql = "select ck.pk_warehouse_id,warehouse_name,co.pk_warehouse_section_id,fk_warehouse_id,section_name from xpanion_supply_chain_management_system_dev.t_det_scm_warehouse_details ck left join xpanion_supply_chain_management_system_dev.t_det_scm_warehouse_section_details co on ck.pk_warehouse_id=co.fk_warehouse_id where ck.active_state_indicator='Y' and pk_warehouse_id="+warehouseId;

	return jdbcTemplate.query(sql, new ResultSetExtractor<List<WareHouseModel>>() {
		@Override
		public List<WareHouseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
			while (rs.next()) {
				WareHouseModel model = new WareHouseModel();
				model.setWarehouseId(rs.getInt(1));
				model.setWarehouseName(rs.getString(2));
				model.setSectionId(rs.getInt(3));
				model.setWarehouseId(rs.getInt(4));
				model.setSectionName(rs.getString(5));
				
				OrderModel.add(model);
			}
			return OrderModel;
		}

	});
}

	//--------------------------------------------------------------------------------------------------------------------//
	
	


	@Override
	public List<WareHouseModel> getEditsectionDetails(int sectionId) {
		List<WareHouseModel> warehousemodel = new ArrayList<WareHouseModel>();
		String sql = "select pk_warehouse_section_id,fk_warehouse_id,section_name from xpanion_supply_chain_management_system_dev.t_det_scm_warehouse_section_details where active_state_indicator='Y' and pk_warehouse_section_id="+sectionId;

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<WareHouseModel>>() {
			@Override
			public List<WareHouseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					WareHouseModel model = new WareHouseModel();
					model.setSectionId(rs.getInt(1));
					model.setWarehouseId(rs.getInt(2));
					model.setSectionName(rs.getString(3));
					
					warehousemodel.add(model);
				}
				return warehousemodel;
			}

		});
	}
  
	
	
	
	
	
	
	
	
	
}

