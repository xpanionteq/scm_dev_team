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

import com.xpanion.scm.dao.PurchaseDao;
import com.xpanion.scm.model.PurchaseModel;
import com.xpanion.scm.model.PurchaseProductsModel;

/* @author:Aswathy Raj.D
 * @purpose:Purchase Order
 * 
*/ 

@Repository
public class PurchaseDaoImpl implements PurchaseDao{
	
public static final Logger LOGGER = LoggerFactory.getLogger(PurchaseDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	int returnPurchaseId;
    int returnPurchaseProductId;
	
	
//-------------------------------------------------------------------------------------------------------------------------------

/* * (non-Javadoc)
 * @see com.xpanion.scm.dao.PurchaseDao#getContactNames()
 * @author:aswathy Raj.D
 * @purpose:To display contact names
*/ 
    @Override
	public List<PurchaseModel>  getContactNames()  {
		List<PurchaseModel> getContact = new ArrayList<PurchaseModel>();
		String sql ="select cont.pk_contact_id,upper(contact_name), \r\n" + 
				"					ct.pk_contact_type_id,contact_type\r\n" + 
				"					from xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details cont\r\n" + 
				"					left join \r\n" + 
				"					xpanion_supply_chain_management_system_dev.t_mst_scm_contact_type ct on ct.pk_contact_type_id=cont.fk_contact_type_id \r\n" + 
				"                    where  cont.fk_contact_type_id=1 and cont.active_state_indicator='Y';";
			return jdbcTemplate.query(sql, new ResultSetExtractor<List<PurchaseModel>>() {
			@Override
			public List<PurchaseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					PurchaseModel model = new PurchaseModel();
					model.setContactId(rs.getInt("pk_contact_id"));
					model.setContactNames(rs.getString(2));
					
					getContact.add(model);
				}
				return getContact;
			}

		});
	}
//---------------------------------------------------------------------------------------------------------------------
    
/*     * (non-Javadoc)
     * @see com.xpanion.scm.dao.PurchaseDao#saveUpdatePurchaseOrder(int, int, int, int, java.lang.String, int, char, java.util.List)
     * @author:Aswathy Raj.D
     * @purpose:To save,update,delete purchase order 
*/     
	@Override
	public int saveUpdatePurchaseOrder(int purchaseId, int contactId, int warehouseId, int statusId,
			String expectedDeliveryDate, int createUserId, char activeStatus,
			List<PurchaseProductsModel> PurchaseProductsmodel) {
		SqlParameterSource in;
		SimpleJdbcCall savePurchaseJdbcCall = null;
		SimpleJdbcCall savePurchaseProductJdbcCall=null;
		
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;
		try {
			LOGGER.info("saveUpdatePurchase()");
			savePurchaseJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("xpanion_supply_chain_management_system_dev")
					.withFunctionName("fn_save_update_purchase_order_details");
			inParamMap.put("p_purchase_id",Integer.valueOf(purchaseId));
			inParamMap.put("p_contact_id", Integer.valueOf(contactId));
			inParamMap.put("p_warehouse_id",Integer.valueOf(warehouseId));
			inParamMap.put("p_status_id",Integer.valueOf(statusId));
			inParamMap.put("p_expected_delivery_date",String.valueOf(expectedDeliveryDate));
			inParamMap.put("p_user_id",Integer.valueOf(createUserId));
			inParamMap.put("p_active_status",Character.valueOf(activeStatus));
			in = new MapSqlParameterSource(inParamMap);
			saveJdbcCallResult = savePurchaseJdbcCall.execute(in);
			saveJdbcCallResult.entrySet().forEach(System.out::println);
			saveJdbcCallResult.forEach((key, value) -> returnPurchaseId = (int) value);
			LOGGER.info("id of the purchase " + returnPurchaseId);
			if(returnPurchaseId > 0 ) {
				
		  		LOGGER.info("saveAndUpdateProductDetails()");
		  		savePurchaseProductJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_purchase_order_product_details");
				for ( PurchaseProductsModel purchaseProduct:PurchaseProductsmodel) {
				 
					inParamMap.put("p_product_order_det_id", purchaseProduct.getPurchaseorderproductsId());
					inParamMap.put("p_purchase_id",returnPurchaseId);
					inParamMap.put("p_product_id",purchaseProduct.getProductId());
					inParamMap.put("p_ordered_quantity",purchaseProduct.getOrderedQuantity());
				    inParamMap.put("p_user_id", createUserId);
					inParamMap.put("p_active_status", activeStatus);
					in = new MapSqlParameterSource(inParamMap);
					saveJdbcCallResult = savePurchaseProductJdbcCall.execute(in);
					saveJdbcCallResult.entrySet().forEach(System.out::println);
					saveJdbcCallResult.forEach((key, value) -> returnPurchaseProductId = (int) value);
			  		LOGGER.info("Purchase Product id  " + returnPurchaseProductId);
			   }
          
			}
		  
		return returnPurchaseId;
        }
	catch(Exception e) {
	LOGGER.info("error in saveUpdatePurchases()"+e);
	return 0;
}
}

	
//--------------------------------- get purchase Id--------------------------------------------------------------------------
  
/*   * @author:Aswathy Raj.D
   * (non-Javadoc)
   * @see com.xpanion.scm.dao.PurchaseDao#getPurchaseId()
*/   
	
	@Override
	public List<PurchaseModel> getPurchaseId() {
		
		List<PurchaseModel> getPurchaseId = new ArrayList<PurchaseModel>();
		String sql = "select po.pk_purchase_id,fk_contact_id,order_date::date,expected_delivery_date,\r\n" + 
				"con.pk_contact_id,contact_name\r\n" + 
				"from xpanion_supply_chain_management_system_dev.t_det_scm_purchase_order po\r\n" + 
				"left join\r\n" + 
				"xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details con on con.pk_contact_id=po.fk_contact_id\r\n" + 
				"where  po.fk_status_id = 1 and po.active_state_indicator='Y'";
		    return jdbcTemplate.query(sql, new ResultSetExtractor<List<PurchaseModel>>() {
			@Override
			public List<PurchaseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					PurchaseModel model = new PurchaseModel();
					model.setPurchaseId(rs.getInt("pk_purchase_id"));
				    model.setOrderDate(rs.getString("order_date"));
				    model.setExpectedDeliveryDate(rs.getString("expected_delivery_date"));
				    model.setContactNames(rs.getString("contact_name"));
					getPurchaseId.add(model);
				}
				return getPurchaseId;
			}

		});

	}
//-----------------------------------------------------------------------------------------------------------------------------
	
/*	 * @author:Aswathy Raj.D
	 * @purpose:To edit purchase order product details 
	 * (non-Javadoc)
	 * @see com.xpanion.scm.dao.PurchaseDao#getPurchaseProductDetails()
*/	 
	@Override
	public List<PurchaseModel> getPurchaseProductDetails(int purchaseId) {
		List<PurchaseModel> getPurchaseProductDetails = new ArrayList<PurchaseModel>();
		String sql = "select pu.pk_purchase_id,fk_contact_id,order_date,expected_delivery_date,\r\n" + 
				"				       po.pk_purchase_order_det_id,fk_purchase_id,fk_product_id,ordered_quantity,\r\n" + 
				"				       pdname.pk_product_id,product_name,con.pk_contact_id,contact_name\r\n" + 
				"				       from xpanion_supply_chain_management_system_dev.t_det_scm_purchase_order pu\r\n" + 
				"				       left join \r\n" + 
				"				       xpanion_supply_chain_management_system_dev.t_det_scm_purchase_order_product_details po on po.fk_purchase_id=pu.pk_purchase_id \r\n" + 
				"				      left join\r\n" + 
				"				      xpanion_supply_chain_management_system_dev.t_mst_scm_inventory_products pdname  on pdname.pk_product_id=po.fk_product_id\r\n" + 
				"				      left join\r\n" + 
				"				      xpanion_supply_chain_management_system_dev.t_mst_scm_contact_details con on con.pk_contact_id=pu.fk_contact_id \r\n" + 
				"				      where pu.pk_purchase_id="+purchaseId+" and pu.active_state_indicator ='Y'\r\n" + 
				"";
			return jdbcTemplate.query(sql, new ResultSetExtractor<List<PurchaseModel>>() {
			@Override
			public List<PurchaseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					PurchaseModel model = new PurchaseModel();
					model.setPurchaseId(rs.getInt("pk_purchase_id"));
				    model.setOrderDate(rs.getString("order_date"));
				    model.setExpectedDeliveryDate(rs.getString("expected_delivery_date"));
				    model.setContactId(rs.getInt("fk_contact_id"));
				    model.setPurchaseProductDetId(rs.getInt("pk_purchase_order_det_id"));
				    model.setProductId(rs.getInt("fk_product_id"));
				    model.setOrderedQuantity(rs.getDouble("ordered_quantity"));
				    model.setProductName(rs.getString("product_name"));
				    model.setContactNames(rs.getString("contact_name"));
				    getPurchaseProductDetails.add(model);
				}
				return getPurchaseProductDetails;
			}

		});

	}
//------------------------------------------------------------------------------------------------------------------------------
/*	@author:Aswathy Raj.D
	 * (non-Javadoc)
	 * @see com.xpanion.scm.dao.PurchaseDao#getProductNames()
	 * 
*/	 
	@Override
	public List<PurchaseModel> getProductNames() {
		List<PurchaseModel> getProductName = new ArrayList<PurchaseModel>();
		String sql = "select  pk_product_id,product_name from xpanion_supply_chain_management_system_dev.t_mst_scm_inventory_products where active_state_indicator='Y';\r\n" + 
				"";
			return jdbcTemplate.query(sql, new ResultSetExtractor<List<PurchaseModel>>() {
			@Override
			public List<PurchaseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					PurchaseModel model = new PurchaseModel();
					model.setProductId(rs.getInt("pk_product_id"));
					model.setProductName(rs.getString("product_name"));
				    getProductName.add(model);
				}
				return getProductName;
			}

		});

	}
//----------------------------------------------------------------------------------------------------------------------------	
/*	@author:Aswathy Raj.D
	 * (non-Javadoc)
	 * @see com.xpanion.scm.dao.PurchaseDao#getProductDetails(int)
*/	 
	@Override
	public List<PurchaseModel> getProductDetails(int purchaseProductDetId) {
		List<PurchaseModel> getProductList = new ArrayList<PurchaseModel>();
		String sql = "select pk_purchase_order_det_id,fk_purchase_id,fk_product_id,ordered_quantity \r\n" + 
				"       from xpanion_supply_chain_management_system_dev.t_det_scm_purchase_order_product_details\r\n" + 
				"       where pk_purchase_order_det_id="+purchaseProductDetId+"\r\n" + 
				"      \r\n" + 
				"   ";
			return jdbcTemplate.query(sql, new ResultSetExtractor<List<PurchaseModel>>() {
			@Override
			public List<PurchaseModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					PurchaseModel model = new PurchaseModel();
					model.setPurchaseProductDetId(rs.getInt("pk_purchase_order_det_id"));
					model.setProductId(rs.getInt("fk_product_id"));
					model.setOrderedQuantity(rs.getDouble("ordered_quantity"));
					model.setPurchaseId(rs.getInt("fk_purchase_id"));
					getProductList.add(model);
				}
				return getProductList;
			}

		});

	}
//-------------------------------------------------------------------------------------------------------------------------------
}
