package com.xpanion.scm.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * @author : ASHLIN ABRAHAM
 * @date : 17.07.2019
 */
@Component
@Scope("session")
public class CompanyModel {
	private int pkCompanyId;
	private String organizationName;
	private String organizationId;
	private String organizationAddress;
	private String contactNumber;
	private String emailId;
	private String gstin;
	private int industryId;
	private String industryType;
	private int createUserId;
	private char activeStatus;

	public int getPkCompanyId() {
		return pkCompanyId;
	}

	public void setPkCompanyId(int pkCompanyId) {
		this.pkCompanyId = pkCompanyId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationAddress() {
		return organizationAddress;
	}

	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public char getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(char activeStatus) {
		this.activeStatus = activeStatus;
	}

}
