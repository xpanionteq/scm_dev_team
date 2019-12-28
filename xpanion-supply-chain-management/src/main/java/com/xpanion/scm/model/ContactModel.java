package com.xpanion.scm.model;
/*
 * @author : Aswathy Raj.D
 * @purpose : model class for contact details
 */

public class ContactModel {
	private int contactTypeId;
	private String contactType;	private int contactId;
	private String companyName;
	private String contactName;
	private String landNumber;
	private String mobileNumber;
	private String email;
	private String building;
	private String locality;
	private String zipcode;
	private String state;
	private String city;
	private String landmark;
	private String route;
	private int contactAddressId;
	public int shipmentRouteId;
    public String contactNumber;
	private String gstIdentificationNumber;
	private int createUserId;
	private char activeStatus;

   
	
	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public int getContactAddressId() {
		return contactAddressId;
	}

	public void setContactAddressId(int contactAddressId) {
		this.contactAddressId = contactAddressId;
	}

	public int getShipmentRouteId() {
		return shipmentRouteId;
	}

	public void setShipmentRouteId(int shipmentRouteId) {
		this.shipmentRouteId = shipmentRouteId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
   
	
	public String getGstIdentificationNumber() {
		return gstIdentificationNumber;
	}

	public void setGstIdentificationNumber(String gstIdentificationNumber) {
		this.gstIdentificationNumber = gstIdentificationNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getContactTypeId() {
		return contactTypeId;
	}

	public void setContactTypeId(int contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

		public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLandNumber() {
		return landNumber;
	}

	public void setLandNumber(String landNumber) {
		this.landNumber = landNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

}
