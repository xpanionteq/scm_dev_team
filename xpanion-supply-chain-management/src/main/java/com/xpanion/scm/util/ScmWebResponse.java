package com.xpanion.scm.util;

import java.util.List;

import org.springframework.stereotype.Component;

/*
 * @author : Ashlin Abraham
 * @date : 25.03.2019
 * 
 */
@Component
public class ScmWebResponse {
	private String message;
	private String status;
	private List<?> data;

	public ScmWebResponse() {
	}

	public ScmWebResponse(String message, String status, List<?> data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the data
	 */
	public List<?> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(List<?> data) {
		this.data = data;
	}

}
