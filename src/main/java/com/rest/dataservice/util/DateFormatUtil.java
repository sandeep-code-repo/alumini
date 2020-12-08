package com.rest.dataservice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.rest.dataservice.constants.ApplicationConstants;

public class DateFormatUtil {
	
	public static String dateFormatString(Date date, String pattern) {
	    if (date != null) {
	        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	        return formatter.format(date);
	    }
	    return null;
	}
	
	public static String dateFormatString(Date date) {
	    if (date != null) {
	        SimpleDateFormat formatter = new SimpleDateFormat(ApplicationConstants.DATE_TIME_FORMATTER);
	        return formatter.format(date);
	    }
	    return null;
	}

}
