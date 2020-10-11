package com.skeleton.alumini.util;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class CommonApiStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	private String overallStatus;
	private HttpStatus statusCode;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CommonApiStatus(String overallStatus, HttpStatus statusCode, String message) {
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

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
}
