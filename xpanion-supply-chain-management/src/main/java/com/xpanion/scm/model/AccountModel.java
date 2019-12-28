
package com.xpanion.scm.model;

public class AccountModel {
	
	private int accountId;
    private String bankName;
	private String branchName;
	private String accountNo;
	private String accountHolderName;
	private String accountType;
	private String ifsc;
	private String upiId;
	private int createUserId;
	private char activeStateIndicator;
	//-------------------------------------------//
	    
	public int getAccountId() {
		return accountId;
	}
	public int getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}
	
	
	public char getActiveStateIndicator() {
		return activeStateIndicator;
	}
	public void setActiveStateIndicator(char activeStateIndicator) {
		this.activeStateIndicator = activeStateIndicator;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getUpiId() {
		return upiId;
	}
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	
	

}
