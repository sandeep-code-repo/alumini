package com.rest.dataservice.model;

import java.io.Serializable;

public class TokenResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String userName;
	private final String token;
	

	public TokenResponse(String userName,String jwttoken) {
		this.userName = userName;
		this.token = jwttoken;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getToken() {
		return token;
	}

	

	
}