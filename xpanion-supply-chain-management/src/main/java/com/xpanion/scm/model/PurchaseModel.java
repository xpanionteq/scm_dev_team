package com.xpanion.scm.model;
/*
 * @author:Aswathy Raj.D
 * @purpose:Model class for purchase order
 */

public class PurchaseModel {
    
	private int purchaseId;
	private int contactId;
	private String contactNames;
	private int statusId;
	private int warehouseId;
	private String expectedDeliveryDate;
	private String orderDate;
	private String productName;
	private int productId;
	private int purchaseProductDetId;
	private Double orderedQuantity;
    private int createUserId;
	private char activeStatus;
	
	
	public int getPurchaseProductDetId() {
		return purchaseProductDetId;
	}
	public void setPurchaseProductDetId(int purchaseProductDetId) {
		this.purchaseProductDetId = purchaseProductDetId;
	}
	public Double getOrderedQuantity() {
		return orderedQuantity;
	}
	public void setOrderedQuantity(Double orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getContactNames() {
		return contactNames;
	}
	public void setContactNames(String contactNames) {
		this.contactNames = contactNames;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}
	public void setExpectedDeliveryDate(String expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
}