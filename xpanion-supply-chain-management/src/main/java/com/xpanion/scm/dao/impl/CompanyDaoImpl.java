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

import com.xpanion.scm.dao.CompanyDao;
import com.xpanion.scm.model.CompanyModel;

/*
 * @author : ASHLIN ABRAHAM
 * @date : 23.04.2019
 * @purpose : 
 */
@Repository
public class CompanyDaoImpl implements CompanyDao {
	public static final Logger LOGGER = LoggerFactory.getLogger(CompanyDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
// ------------------------------------------------START---------------------------------------------------------------
/*
 * @author : ASHLIN ABRAHAM
 * @date : 17.07.2019
 * @purpose : get industry types
 * @exception : SQLException, DataAccessException
 * 
 */
	@Override
	public List<CompanyModel> getIndustryTypes() {
		List<CompanyModel> industryModel = new ArrayList<CompanyModel>();
		String sql = "select pk_industry_type_id,industry_type from xpanion_supply_chain_management_system_dev.t_mst_scm_industry_type";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<CompanyModel>>() {
			@Override
			public List<CompanyModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					CompanyModel model = new CompanyModel();
					model.setIndustryId(rs.getInt(1));
					model.setIndustryType(rs.getString(2));
					industryModel.add(model);
				}
				return industryModel;
			}

		});
	}

//--------------------------------------------------------------------------------------------------------------------
}
