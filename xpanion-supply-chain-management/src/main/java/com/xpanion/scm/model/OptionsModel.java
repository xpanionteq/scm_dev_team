package com.xpanion.scm.model;
/*
 * @author : ASHLIN ABRAHAM
 * @date : 29.04.2019
 * 
 */

public class OptionsModel {
	private int optionId;
	private String option;
	private int attributeId;
	private String attribute;

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

}
