

package com.xpanion.scm.controller;

import static com.xpanion.scm.util.CommonConstants.FAILED;
import static com.xpanion.scm.util.CommonConstants.SUCCESS;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.xpanion.scm.dao.AccountDao;
import com.xpanion.scm.model.AccountModel;
import com.xpanion.scm.model.EmployeeModel;
import com.xpanion.scm.model.HomeModel;
import com.xpanion.scm.util.ScmWebResponse;

@RestController
public class AccountController {
	
	@Autowired
	AccountDao accountdao;
	
	@Autowired
	ScmWebResponse response;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	
//---------------------------------------------insertion------------------------------------------------------------------------------//
	
	@RequestMapping(value = "/accountOperations", method = RequestMethod.POST)
	public @ResponseBody ScmWebResponse saveUpdateAccount(
			@RequestParam(value = "accountId", required = false) Integer accountId,
			@RequestParam(value = "bankName", required = false) String bankName,
			@RequestParam(value = "branchName", required = false) String branchName,
			@RequestParam(value = "accountNo", required = false) String accountNo,
			@RequestParam(value = "accountHolderName", required = false) String accountHolderName,
			@RequestParam(value = "accountType", required = false) String accountType,
			@RequestParam(value = "ifsc", required = false) String ifsc,
			@RequestParam(value = "upiId", required = false) String upiId,
			@RequestParam(value = "activeStateIndicator", required = false) Character activeStateIndicator) 
		throws JsonParseException, JsonMappingException, IOException {
		try {

	int createUserId=1;
	if(activeStateIndicator=='N' && accountId >0) {
		int accountDetails= accountdao.deleteAccount(accountId,activeStateIndicator,createUserId);
		
		if(accountDetails>=1) {
			response.setStatus(SUCCESS);
			response.setMessage(null);
			response.setData(null);
			
		}else if(accountDetails== -2) {
			
			response.setStatus(FAILED);
			response.setData(null);
			response.setMessage("-2");
			
		}
		else {
			response.setStatus(FAILED);
			response.setData(null);
			
		}
	}

			int accountDetails = accountdao.saveUpdateAccount(accountId,bankName,branchName,accountNo,accountHolderName,accountType,ifsc,upiId,createUserId,activeStateIndicator);
			if (accountDetails > 0) {
				response.setStatus(SUCCESS);
				response.setMessage("accountDetails");
			} else {
				response.setStatus(FAILED);
				response.setMessage("0");
			}
		} catch (Exception e) {
			response.setStatus(FAILED);
			response.setMessage("0");
			LOGGER.info("Issue in saveUpdateAccount" + e);
		}
		return response;

	}
	//-----------------------------------------------------------------------------------------------------------------------------------//

	@RequestMapping(value = "/geteditaccount")
	public @ResponseBody ScmWebResponse getaccountedit(
			@RequestParam(value="accountId",required = false)Integer accountId) {
		
		try {
			List<AccountModel> acnlist = accountdao.getaccountedit(accountId);
			response.setStatus(SUCCESS);
			response.setData(acnlist);

		} catch (Exception e) {
			LOGGER.error("Issue in getaccountedit() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}

//--------------------------------------------------------------------------------------------------------//
	
	@RequestMapping(value = "/getaccountdetails")
	public @ResponseBody ScmWebResponse getaccounts() {
		try {
			List<AccountModel> accountlist = accountdao.getaccounts();
			response.setStatus(SUCCESS);
			response.setData(accountlist);

		} catch (Exception e) {
			LOGGER.error("Issue in getaccounts() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}

//-----------------------------------------------------------------------------------------------------------//

//--------------------------------------------------------------------------------------------------------//
}
