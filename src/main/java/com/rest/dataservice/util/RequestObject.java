package com.skeleton.alumini.util;

import java.io.Serializable;

public class RequestObject implements Serializable {

	private static final long serialVersionUID = 1L;
	private Object requestdata;

	public RequestObject() {
		super();
	}

	public RequestObject(Object requestdata) {
		super();
		this.requestdata = requestdata;
	}

	public Object getRequestdata() {
		return requestdata;
	}

	public void setRequestdata(Object requestdata) {
		this.requestdata = requestdata;
	}

}
