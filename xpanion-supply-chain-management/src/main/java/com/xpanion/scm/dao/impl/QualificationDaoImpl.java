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

import com.xpanion.scm.dao.QualificationDao;
import com.xpanion.scm.model.QualificationModel;
@Repository
public class QualificationDaoImpl  implements QualificationDao{
public static final Logger LOGGER = LoggerFactory.getLogger(QualificationDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	/*
	 * (non-Javadoc)
	 * @see com.xpanion.scm.dao.EmployeeDao#getQualificationType()
	 * @author:ASWATHY RAJ D
	 * @purpose:Get Qualification Type
	 * @date::04-05-2019
	 */

		@Override
		public List<QualificationModel> getQualificationType() {
			List<QualificationModel> QualiModel = new ArrayList<QualificationModel>();
			String sql = "select pk_qualification_type_id,qualification_type from xpanion_supply_chain_management_system_dev.t_mst_scm_qualification_type where active_state_indicator='Y'";
			return jdbcTemplate.query(sql, new ResultSetExtractor<List<QualificationModel>>() {
			@Override
			public List<QualificationModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					QualificationModel model = new QualificationModel();
					model.setQualificationId(rs.getInt(1));
					model.setQualificationType(rs.getString(2));
					
					QualiModel.add(model);
				}
				return QualiModel;
			}

		});
	}
//-------------------------------------END----------------------------------------------------------------------------------------
//-------------------------------------START--------------------------------------------------------------------------------------
/*
 * (non-Javadoc)
 * @see com.xpanion.scm.dao.QualificationDao#getEmpQualiDet(int)
 * @author:Aswathy Raj D
 * @date:04-17-2019
 * @purpose:To get Employee Qualification Details
 */

		@Override
		public List<QualificationModel> getEmpQualiDet(int employeeId) {
			List<QualificationModel> getEmpQual = new ArrayList<QualificationModel>();
			String sql ="select qual.pk_employee_qualification_id,fk_qualification_type_id,other_qualification,experience,\r\n" + 
					"qt.pk_qualification_type_id,qualification_type \r\n" + 
					"from xpanion_supply_chain_management_system.t_det_employee_qualification_details qual\r\n" + 
					"left join\r\n" + 
					"xpanion_supply_chain_management_system.t_mst_qualification_type qt on qt.pk_qualification_type_id=qual.fk_qualification_type_id\r\n" + 
					"where fk_employee_id="+employeeId+"\r\n" + 
					"and  qual.active_state_indicator='Y'\r\n" + 
					"";
			return jdbcTemplate.query(sql, new ResultSetExtractor<List<QualificationModel>>() {
			@Override
			public List<QualificationModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					QualificationModel model = new QualificationModel();
					model.setQualificationId(rs.getInt("pk_employee_qualification_id"));
					model.setQualificationTypeId(rs.getInt("fk_qualification_type_id"));
					model.setOtherQualification(rs.getString("other_qualification"));
					model.setExperience(rs.getString("experience"));
					model.setQualificationType(rs.getString("qualification_type"));
					
					getEmpQual.add(model);
				}
				return getEmpQual;
			}

		});
	}

//-------------------------------------END------------------------------------------------------------------------------------------
}
