package com.skeleton.alumini.util;

import java.io.Serializable;

public class CommonApiStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	private String overallStatus;
	private int statusCode;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CommonApiStatus(String overallStatus, int statusCode, String message) {
		super();
		this.overallStatus = overallStatus;
		this.statusCode = statusCode;
		this.message = message;
	}

	public String getOverallStatus() {
		return overallStatus;
	}

	public void setOverallStatus(String overallStatus) {
		this.overallStatus = overallStatus;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
