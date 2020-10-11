package com.rest.dataservice.util;

import java.io.Serializable;

public class ResponseObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private Object data;
	private CommonApiStatus apiStatus;

	public ResponseObject() {
		super();
	}

	public ResponseObject(Object data, CommonApiStatus apiStatus) {
		super();
		this.data = data;
		this.apiStatus = apiStatus;
	}

	public ResponseObject(CommonApiStatus statusFailure) {
		this.apiStatus = statusFailure;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public CommonApiStatus getApiStatus() {
		return apiStatus;
	}

	public void setApiStatus(CommonApiStatus apiStatus) {
		this.apiStatus = apiStatus;
	}

}
