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

import com.xpanion.scm.dao.SalesOrderDao;
import com.xpanion.scm.model.OrderModel;


@Repository
public class OrderDaoImpl implements SalesOrderDao {

	public static final Logger LOGGER = LoggerFactory.getLogger(OrderDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	
	@Override
	    public List<OrderModel> getContactDetails() {
		List<OrderModel> OrderModel = new ArrayList<OrderModel>();
		String sql = "select pk_contact_id,company_name,contact_name,mobile_number,land_number from xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details";

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<OrderModel>>() {
			@Override
			public List<OrderModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					OrderModel model = new OrderModel();
					model.setContactId(rs.getInt(1));
					model.setCompanyName(rs.getString(2));
					model.setContactName(rs.getString(3));
					model.setMobileNumber(rs.getString(4));
					model.setLandNumber(rs.getString(5));
					OrderModel.add(model);
				}
				return OrderModel;
			}

		});
	}	
	//---------------------------------------------------------------------------------------------------//
	
	@Override
    public List<OrderModel> getItemDetails() {
	List<OrderModel> OrderModel = new ArrayList<OrderModel>();
	String sql = "select pk_product_id,product_name,maximum_retail_price from xpanion_supply_chain_management_system_dev.t_mst_scm_inventory_products";

	return jdbcTemplate.query(sql, new ResultSetExtractor<List<OrderModel>>() {
		@Override
		public List<OrderModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
			while (rs.next()) {
				OrderModel model = new OrderModel();
				model.setProductId(rs.getInt(1));
				model.setItemName(rs.getString(2));
				model.setMrp(rs.getDouble(3));
				
				OrderModel.add(model);
			}
			return OrderModel;
		}

	});
}	


}