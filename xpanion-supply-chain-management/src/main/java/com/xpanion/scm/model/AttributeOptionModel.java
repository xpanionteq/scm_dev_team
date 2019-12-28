package com.xpanion.scm.model;

import java.util.List;

public class AttributeOptionModel {
	private int productId;
	private int attributeId;
	private String attributeType;
	private int numberOfOptions;
	private List<OptionsModel> options;

	public int getNumberOfOptions() {
		return numberOfOptions;
	}

	public void setNumberOfOptions(int numberOfOptions) {
		this.numberOfOptions = numberOfOptions;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	public List<OptionsModel> getOptions() {
		return options;
	}

	public void setOptions(List<OptionsModel> options) {
		this.options = options;
	}

}
