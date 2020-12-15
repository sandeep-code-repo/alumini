package com.rest.dataservice.constants;

import java.text.SimpleDateFormat;

public class ApplicationConstants {
	
	public static final String API_OVER_ALL_SUCCESS_STATUS = "success";
	public static final String API_OVER_ALL_ERROR_STATUS = "error";
	public static final String DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMATTER = "yyyy-MM-dd";
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMATTER); 

}
