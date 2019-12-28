package com.xpanion.scm.model;
/*
 * @author:Aswathy Raj D
 * @date:04-05-2019
 * @purpose:model class for qualification details
 */

public class QualificationModel {

	private int qualificationId;
	private int employeeId;
	private int qualificationTypeId;
	private String qualificationType;
	private String otherQualification;
	private String experience;
	private int createUserId;
	private char activeStatus;
	private int qualificationDetId;

	
	
	public int getQualificationDetId() {
		return qualificationDetId;
	}

	public void setQualificationDetId(int qualificationDetId) {
		this.qualificationDetId = qualificationDetId;
	}

	public int getQualificationTypeId() {
		return qualificationTypeId;
	}

	public void setQualificationTypeId(int qualificationTypeId) {
		this.qualificationTypeId = qualificationTypeId;
	}

	public int getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

		public String getQualificationType() {
		return qualificationType;
	}

	public void setQualificationType(String qualificationType) {
		this.qualificationType = qualificationType;
	}

	public String getOtherQualification() {
		return otherQualification;
	}

	public void setOtherQualification(String otherQualification) {
		this.otherQualification = otherQualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
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
