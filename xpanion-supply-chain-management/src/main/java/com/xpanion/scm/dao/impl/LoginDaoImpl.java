package com.xpanion.scm.dao.impl;
/*
 * @author : ASHLIN ABRAHAM
 * @date : 02.04.2019
 * 
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.xpanion.scm.dao.LoginDao;
import com.xpanion.scm.model.UserModel;
@Repository
public class LoginDaoImpl implements LoginDao{
	
public static final Logger LOGGER = LoggerFactory.getLogger(LoginDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//--------------------------------------------------START------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * @see com.xpanion.scm.dao.LoginDao#getLoginDetails(java.lang.String, java.lang.String)
	 * @author : ASHLIN ABRAHAM
	 * @date : 02.04.2019
	 * @purpose : validate login credentials
	 * @exception : 
	 */
	@Override
	public UserModel getLoginDetails(String userName, String userPassword) {
		String sql = "select login.fk_user_type_id, upper(utype.user_type) ,emp.pk_employee_id,employee_first_name,employee_last_name ,desig.designation_type from xpanion_supply_chain_management_system.t_det_login_details login inner join xpanion_supply_chain_management_system.t_mst_user_type_details utype on login.fk_user_type_id = utype.pk_user_type_id inner join xpanion_supply_chain_management_system.t_mst_employee_details emp on emp.pk_employee_id = login.fk_employee_id inner join xpanion_supply_chain_management_system.t_mst_designation_type_details desig on desig.pk_designation_type_id=emp.fk_designation_id where lower(login.user_name) =lower('"+userName+"') and user_password ='"+userPassword+"' and login.active_state_indicator='Y'";
		UserModel userModel = new UserModel();
		return jdbcTemplate.query(sql, new ResultSetExtractor<UserModel>() {
			@Override
			public UserModel extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					userModel.setUserTypeId(rs.getInt(1));
					userModel.setUserType(rs.getString(2));
					userModel.setUserId(rs.getInt(3));
					userModel.setFirstName(rs.getString(4));
					userModel.setLastName(rs.getString(5));
					userModel.setDesignation(rs.getString(6));
				}
				return userModel;
			}

		});

	}
//----------------------------------------------------END------------------------------------------------------
}
