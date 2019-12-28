package com.xpanion.scm.model;

public class WareHouseModel {
	
	private int warehouseId;
	private int organizationId;	
	private String warehousecode;
	private String warehouseName;
	private String warehouseAddress;
	private String mobileNumber;
	private String warehouseemail;
	private String activeStatus;
	private String rackName;
	private int rackId;
	private  int sectionId;
	private String sectionName;
	
	public String getRackName() {
		return rackName;
	}
	public void setRackName(String rackName) {
		this.rackName = rackName;
	}
	public int getRackId() {
		return rackId;
	}
	public void setRackId(int rackId) {
		this.rackId = rackId;
	}
	
	
	
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getWarehousecode() {
		return warehousecode;
	}
	public void setWarehousecode(String warehousecode) {
		this.warehousecode = warehousecode;
	}
	public String getWarehouseemail() {
		return warehouseemail;
	}
	public void setWarehouseemail(String warehouseemail) {
		this.warehouseemail = warehouseemail;
	}
	public int getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getWarehouseAddress() {
		return warehouseAddress;
	}
	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	
	
	
	
	
	

}
