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

/*
 * @author : ASHLIN ABRAHAM
 * @date : 27.03.2019
 */
import com.xpanion.scm.dao.AddressDao;
import com.xpanion.scm.model.AddressModel;
@Repository
public class AddressDaoImpl implements AddressDao{
public static final Logger LOGGER = LoggerFactory.getLogger(ContactDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
//--------------------------------------------------------------------START---------------------------------------------------------------------------
	
	@Override
	public List<AddressModel> getSingleCustomerAddress(int contactId) {
		List<AddressModel> addressDetModel = new ArrayList<AddressModel>();
		String sql = "select address.pk_address_type_details_id, fk_contact_details_id, building, locality, land_mark, city, zipcode, state, contact_mobile_number,route.contact_route,pk_route_id from xpanion_supply_chain_management_system.t_det_address_type_details address inner join xpanion_supply_chain_management_system.t_mst_contact_route route on address.fk_route_id=route.pk_route_id where address.fk_contact_details_id="+contactId+" and address.active_state_indicator='Y'";
			return jdbcTemplate.query(sql, new ResultSetExtractor<List<AddressModel>>() {
			@Override
			public List<AddressModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					AddressModel model = new AddressModel();
					model.setAddressId(rs.getInt("pk_address_type_details_id"));
					model.setContactId(rs.getInt("fk_contact_details_id"));
					model.setBuildingNo(rs.getString("building"));
					model.setLocality(rs.getString("locality"));
					model.setLandmark(rs.getString("land_mark"));
					model.setZipCode(rs.getString("zipcode"));
					model.setState(rs.getString("state"));
					model.setDistrict(rs.getString("city"));
					model.setContactNumber(rs.getString("contact_mobile_number"));
					model.setRoute(rs.getString("contact_route"));
					model.setRouteId(rs.getInt("pk_route_id"));
					addressDetModel.add(model);	
				
				}
				return addressDetModel;
			}
		});
	}
}
