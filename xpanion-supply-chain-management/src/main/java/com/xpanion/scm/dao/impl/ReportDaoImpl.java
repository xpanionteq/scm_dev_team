package com.xpanion.scm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.xpanion.scm.dao.ReportDao;

import com.xpanion.scm.model.ReportModel;
@Repository
public class ReportDaoImpl implements ReportDao {
public static final Logger LOGGER = LoggerFactory.getLogger(ReportDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//---------------------------------------------------------------------------------------------------------//
	@Override
    public List<ReportModel> getitems() {
	List<ReportModel> itemModel = new ArrayList<ReportModel>();
	String sql = "select pk_product_id,product_name from xpanion_supply_chain_management_system_dev.t_mst_scm_inventory_products";

	return jdbcTemplate.query(sql, new ResultSetExtractor<List<ReportModel>>() {
		@Override
		public List<ReportModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
			while (rs.next()) {
				ReportModel model = new ReportModel();
				model.setItemId(rs.getInt(1));
				model.setItemName(rs.getString(2));
				
				
				itemModel.add(model);
			}
			return itemModel;
		}

	});
}	
//----------------------------------------------------------------------------------------//
	@Override
    public List<ReportModel> getitemtype( int itemId) {
	List<ReportModel> apachepoiModel = new ArrayList<ReportModel>();
	String sql = "select pk_product_id,product_name,maximum_retail_price from xpanion_supply_chain_management_system_dev.t_mst_scm_inventory_products";

	return jdbcTemplate.query(sql, new ResultSetExtractor<List<ReportModel>>() {
		@Override
		public List<ReportModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
			while (rs.next()) {
				ReportModel model = new ReportModel();
				model.setItemId(rs.getInt(1));
				model.setItemName(rs.getString(2));
				model.setMrp(rs.getInt(3));
				
				
				apachepoiModel.add(model);
			}
			return apachepoiModel;
		}

	});
}	


}

