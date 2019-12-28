package com.xpanion.scm.model;

public class PurchaseProductsModel {

	private Double orderedQuantity;
	private int purchaseId;
	private int productId;
	private int purchaseorderproductsId;
	private int createUserId;
	private char activeStatus;

	
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Double getOrderedQuantity() {
		return orderedQuantity;
	}

	public void setOrderedQuantity(Double orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	
	public int getPurchaseorderproductsId() {
		return purchaseorderproductsId;
	}

	public void setPurchaseorderproductsId(int purchaseorderproductsId) {
		this.purchaseorderproductsId = purchaseorderproductsId;
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
