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

import com.xpanion.scm.dao.RouteDao;
import com.xpanion.scm.model.HomeModel;
import com.xpanion.scm.model.RouteModel;
@Repository
public class RouteDaoImpl implements RouteDao {

	public static final Logger LOGGER = LoggerFactory.getLogger(RouteDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	int returnRouteId;

	// -------------------------------------------------START-----------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xpanion.scm.dao.RouteDao#getRouteDetails()
	 * 
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date : 13.04.2019
	 * 
	 * @purpose : get route ID and TYPE
	 */
	@Override
	public List<RouteModel> getRouteDetails() {
		List<RouteModel> routeModel = new ArrayList<RouteModel>();
		String sql = "SELECT pk_shipment_route_id,upper(shipment_route) from xpanion_supply_chain_management_system_dev.t_mst_scm_shipment_routes where active_state_indicator='Y'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<RouteModel>>() {
			@Override
			public List<RouteModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					RouteModel model = new RouteModel();
					model.setRouteId(rs.getInt(1));
					model.setRoute(rs.getString(2));
					routeModel.add(model);
				}
				return routeModel;
			}

		});
	}
	// --------------------------------------------------------END-----------------------------------------------------------
//-------------------------------------------------insertion----------------------------------------------------------------------//

	@Override
	public  int saveUpdateroute(int routeId,String route,String startingRoute,String finalRoute,String via,int createUserId,char activeStatusIndicator) {
		SqlParameterSource in;
		SimpleJdbcCall savePhoneJdbcCall = null;
		
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;
		try {
			LOGGER.info("saveUpdateroute()");
			
				savePhoneJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						.withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_shipment_route_details");
				inParamMap.put("p_shipment_route_id", Integer.valueOf(routeId));
			    inParamMap.put("p_shipment_route", String.valueOf(route));
				inParamMap.put("p_start_route", String.valueOf(startingRoute));
				inParamMap.put("p_final_route", String.valueOf(finalRoute));
				inParamMap.put("p_via", String.valueOf(via));
				inParamMap.put("p_user_id", Integer.valueOf(createUserId));
				inParamMap.put("p_active_status", Character.valueOf(activeStatusIndicator));
				
				in = new MapSqlParameterSource(inParamMap);
				saveJdbcCallResult = savePhoneJdbcCall.execute(in);
				saveJdbcCallResult.entrySet().forEach(System.out::println);
				saveJdbcCallResult.forEach((key, value) -> returnRouteId = (int) value);
				LOGGER.info("id of the contact " + returnRouteId);
			
			if (routeId > 0) {
				return routeId;
			}
			return returnRouteId;
		}catch (Exception e) {
				LOGGER.info("error in saveUpdateroute()" + e);
				return 0;
			}
		
	
		
	
}
	//-----------------------------------------------delete---------------------------------------------------------//
	@Override
	public  int deleteroute(int routeId,char activeStatusIndicator,int createUserId) {
		SqlParameterSource in;
		SimpleJdbcCall deleterouteJdbcCall = null;
		
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;
		try {
			LOGGER.info("deleteroute()");
			
				deleterouteJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						.withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_shipment_route_details");
				inParamMap.put("p_shipment_route_id", Integer.valueOf(routeId));
			    inParamMap.put("p_shipment_route",null);
				inParamMap.put("p_start_route", null);
				inParamMap.put("p_final_route",null);
				inParamMap.put("p_via", null);
				inParamMap.put("p_user_id", Integer.valueOf(createUserId));
				inParamMap.put("p_active_status", Character.valueOf(activeStatusIndicator));
				
				in = new MapSqlParameterSource(inParamMap);
				saveJdbcCallResult = deleterouteJdbcCall.execute(in);
				saveJdbcCallResult.entrySet().forEach(System.out::println);
				saveJdbcCallResult.forEach((key, value) -> returnRouteId = (int) value);
				LOGGER.info("id of the route " + returnRouteId);
			
			
			return returnRouteId;
		}catch (Exception e) {
				LOGGER.info("error in deleteroute()" + e);
				return 0;
			}
		
	
		
	
}
	//--------------------------------------------------------------------------------------------------------//

	
	
	
//--------------------------------------------edit--------------------------------------------------------------------//
	
	@Override
	public List<RouteModel> geteditroute(int routeId) {
		List<RouteModel> routemodel = new ArrayList<RouteModel>();
		String sql = "select pk_shipment_route_id,shipment_route,starting_route,final_route,via from xpanion_supply_chain_management_system_dev.t_mst_scm_shipment_routes where active_state_indicator='Y' and pk_shipment_route_id="+routeId;

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<RouteModel>>() {
			@Override
			public List<RouteModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					RouteModel model = new RouteModel();
					model.setRouteId(rs.getInt("pk_shipment_route_id"));
					model.setRoute(rs.getString("shipment_route"));
					model.setStartingRoute(rs.getString("starting_route"));
					model.setFinalRoute(rs.getString("final_route"));
					model.setVia(rs.getString("via"));
				routemodel.add(model);
				}
				return routemodel;
			}

		});
	}
	
	
	
	
	
	
//------------------------------------------------------end-----------------------------------------------------------------------//

}



