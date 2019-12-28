
package com.xpanion.scm.dao;

import java.util.List;

import com.xpanion.scm.model.AccountModel;


public interface AccountDao {
	
		int saveUpdateAccount(Integer accountId,String bankName,String branchName,String accountNo,String accountHolderName,
				String accountType,String ifsc,String upiId,int createUserId,char activeStateIndicator);
	
		
		 public List<AccountModel> getaccountedit(int accountId);
		 public List<AccountModel> getaccounts();
		 int deleteAccount(int accountId, char activeStateIndicator, int createUserId);// delete

}


//Ajay Shankar
//Ajay update
//haritha here