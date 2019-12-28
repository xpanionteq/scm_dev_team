

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

import com.xpanion.scm.dao.AccountDao;
import com.xpanion.scm.model.AccountModel;




@Repository
public class AccountDaoImpl implements AccountDao  {
	
public static final Logger LOGGER = LoggerFactory.getLogger(AccountDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	int returnAccountId;
	//----------------------------------------------------------------------------//
	
	
	
	//----------------------------------------------------------Account INSERTION-----------------------------------------//
	
	@Override
	public int saveUpdateAccount(Integer accountId,String bankName,String branchName,String accountNo,String accountHolderName,String accountType,String ifsc,String upiId,int createUserId,char activeStateIndicator) { 
	
		SqlParameterSource in;
		SimpleJdbcCall saveAccountJdbcCall = null;
		
		Map<String, Object> inParamMap = new HashMap<>();
		Map<String, Object> saveJdbcCallResult = null;
		try {
			LOGGER.info("saveUpdateaccount()");
			
			saveAccountJdbcCall = new SimpleJdbcCall(jdbcTemplate)
						.withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_new_account_details");
				inParamMap.put("p_account_id", Integer.valueOf(accountId));
				inParamMap.put("p_bank_name", String.valueOf(bankName));
				inParamMap.put("p_branch_name", String.valueOf(branchName));
				inParamMap.put("p_account_number", String.valueOf(accountNo));
				inParamMap.put("p_account_holder_name", String.valueOf(accountHolderName));
				inParamMap.put("p_account_type", String.valueOf(accountType));
				inParamMap.put("p_ifsc", String.valueOf(ifsc));
				inParamMap.put("p_upiid", String.valueOf(upiId));
			    inParamMap.put("p_user_id", Integer.valueOf(createUserId));
				inParamMap.put("p_active_state", Character.valueOf(activeStateIndicator));
				
				in = new MapSqlParameterSource(inParamMap);
				saveJdbcCallResult = saveAccountJdbcCall.execute(in);
				saveJdbcCallResult.entrySet().forEach(System.out::println);
				saveJdbcCallResult.forEach((key, value) -> returnAccountId = (int) value);
				LOGGER.info("id of the account " + returnAccountId);
				LOGGER.info("id of the account " + bankName);
				
			if (accountId > 0) {
				return accountId;
			}
			return returnAccountId;
		}catch (Exception e) {
				LOGGER.info("error in saveUpdateaccount()" + e);
				return 0;
			}
		
	
		
	
}
//--------------------------------------------------edit------------------------------------------------------------//
	@Override
	public List<AccountModel> getaccountedit(int accountId) {
		List<AccountModel> accountmodel = new ArrayList<AccountModel>();
		String sql = "select pk_account_id,bank_name,branch_name,account_number,account_holder_name,account_type,ifsc,upiid from xpanion_supply_chain_management_system_dev.t_mst_scm_new_account where active_state_indicator='Y' and pk_account_id="+accountId;

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<AccountModel>>() {
			@Override
			public List<AccountModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					AccountModel model = new AccountModel();
					model.setAccountId(rs.getInt("pk_account_id"));
					model.setBankName(rs.getString("bank_name"));
					model.setBranchName(rs.getString("branch_name"));
					model.setAccountNo(rs.getString("account_number"));
					model.setAccountHolderName(rs.getString("account_holder_name"));
					model.setAccountType(rs.getString("account_type"));
					model.setIfsc(rs.getString("ifsc"));
					model.setUpiId(rs.getString("upiid"));
					accountmodel.add(model);
				}
				return accountmodel;
			}

		});
	}



//---------------------------------------------------------------------------------------------------------------//
	
	@Override
	public List<AccountModel> getaccounts() {
		List<AccountModel> accountsmodel = new ArrayList<AccountModel>();
		String sql = "select pk_account_id,bank_name,branch_name,account_number,account_holder_name,account_type,ifsc,upiid from xpanion_supply_chain_management_system_dev.t_mst_scm_new_account where active_state_indicator='Y'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<AccountModel>>() {
			@Override
			public List<AccountModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					AccountModel model = new AccountModel();
					model.setAccountId(rs.getInt("pk_account_id"));
					model.setBankName(rs.getString("bank_name"));
					model.setBranchName(rs.getString("branch_name"));
					model.setAccountNo(rs.getString("account_number"));
					model.setAccountHolderName(rs.getString("account_holder_name"));
					model.setAccountType(rs.getString("account_type"));
					model.setIfsc(rs.getString("ifsc"));
					model.setUpiId(rs.getString("upiid"));
					accountsmodel.add(model);
				}
				return accountsmodel;
			}

		});
	}
	//----------------------------------delete----------------------------------------------------//
	
		/*
		 * @see com.xpanion.SCM.dao.AccountDao#deleteAccount(int,
		 * java.lang.String)
		 * 
		 * @author : Seema k r
		 * 
		 * @date :16.12.2019
		 * 
		 * @purpose : delete account
		 * 
		 * @return :
		 * 
		 * @exception : SQLException, DataAccessException
		 */
		@Override
		public int deleteAccount(int accountId, char activeStateIndicator, int createUserId) {//from AccountDao
			SqlParameterSource in;
			SimpleJdbcCall deleteAccountJdbcCall = null;
			Map<String, Object> inParamMap = new HashMap<>();
			Map<String, Object> saveJdbcCallResult = null;

			try {
				LOGGER.info("saveUpdateAccount()");// we gives name
				deleteAccountJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("xpanion_supply_chain_management_system_dev")
						.withFunctionName("fn_save_update_new_account_details");
				inParamMap.put("p_account_id", Integer.valueOf(accountId));
				inParamMap.put("p_bank_name", null);//p_bank_name from data base
				inParamMap.put("p_branch_name", null);
				inParamMap.put("p_account_number", null);
				inParamMap.put("p_account_holder_name", null);
				inParamMap.put("p_account_type", null);
				inParamMap.put("p_ifsc", null);
				inParamMap.put("p_upiid", null);			
				
				inParamMap.put("p_user_id", Integer.valueOf(createUserId));
				inParamMap.put("p_active_state", Character.valueOf(activeStateIndicator));
				
				in = new MapSqlParameterSource(inParamMap);
				saveJdbcCallResult = deleteAccountJdbcCall.execute(in);
				saveJdbcCallResult.entrySet().forEach(System.out::println);
				saveJdbcCallResult.forEach((key, value) -> returnAccountId = (int) value);
				LOGGER.info("id of the account " + returnAccountId);
				return returnAccountId;

			} catch (Exception e) {
				LOGGER.info("error in deleteAccount()" + e);
				return 0;
			}

		}
//------------------------------------------------------------------------------------------------------------------//
	




//----------------------------------------------------------------------------------------------------------------//
}


