package com.rest.dataservice.model;

import java.io.Serializable;

import com.rest.dataservice.util.ResponseObject;

public class TokenResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final ResponseObject plantDetails;
	private final String token;
	

	public TokenResponse(ResponseObject plantDetails,String jwttoken) {
		this.plantDetails = plantDetails;
		this.token = jwttoken;
	}

	public ResponseObject getPlantDetails() {
		return plantDetails;
	}
	
	public String getToken() {
		return token;
	}

	

	
}