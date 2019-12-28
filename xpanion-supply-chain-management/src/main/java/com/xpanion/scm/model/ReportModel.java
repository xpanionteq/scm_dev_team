package com.xpanion.scm.model;

public class ReportModel {
	private int itemId;
	private String itemName;
	private int mrp;
	private String manufacturer;
	private int stock;
	private int thresholdStock;
	private String ItemLogo;
	private String FromDate;
	private String ToDate;
	private String ItemType;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getMrp() {
		return mrp;
	}
	public void setMrp(int mrp) {
		this.mrp = mrp;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getThresholdStock() {
		return thresholdStock;
	}
	public void setThresholdStock(int thresholdStock) {
		this.thresholdStock = thresholdStock;
	}
	public String getItemLogo() {
		return ItemLogo;
	}
	public void setItemLogo(String itemLogo) {
		ItemLogo = itemLogo;
	}
	public String getFromDate() {
		return FromDate;
	}
	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}
	public String getToDate() {
		return ToDate;
	}
	public void setToDate(String toDate) {
		ToDate = toDate;
	}
	public String getItemType() {
		return ItemType;
	}
	public void setItemType(String itemType) {
		ItemType = itemType;
	}
	

}
