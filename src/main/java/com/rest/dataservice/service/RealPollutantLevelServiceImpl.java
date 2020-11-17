package com.rest.dataservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.RealPollutantLevelInfos;
import com.rest.dataservice.helper.RealParameterInfoHelper;
import com.rest.dataservice.helper.RealPollutantLevelHelper;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

@Service
public class RealPollutantLevelServiceImpl implements RealPollutantLevelService{
	
	private static CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
			ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);

	@Override
	public ResponseObject getRealPoulltantLevelData(RealPollutantLevelInfos info) {
		
		RealParameterInfoHelper parameterInfoHelper1 = new RealParameterInfoHelper
				("CEMS1_DRI KILN 3-4", "NO2", "mg/Nm3", "0-100", "0-1000", "2020-11-13 21:16:00.0", "13.36", "0.00", "1Hr", "Station 1", "AAQ", "Active");
		
		RealParameterInfoHelper parameterInfoHelper2 = new RealParameterInfoHelper
				("CEMS2_DRI PKCS 5-7", "PM", "mg/Nm3", "0-100", "0-1000", "2020-10-11 23:12:00.0", "6.73", "0.00", "1Hr", "Station 2", "Stack", "Active");
		
		RealParameterInfoHelper parameterInfoHelper3 = new RealParameterInfoHelper
				("CEMS3_DRI NTFD 6-8", "PH", "mg/Nm3", "0-100", "0-1000", "2020-08-26 11:24:00.0", "7.09", "0.00", "1Hr", "Station 3", "Water", "Active");
		
		List<RealParameterInfoHelper> listParameterInfo = new ArrayList<RealParameterInfoHelper>();
		listParameterInfo.add(parameterInfoHelper1);
		listParameterInfo.add(parameterInfoHelper2);
		listParameterInfo.add(parameterInfoHelper3);
		
		RealPollutantLevelHelper pollutantLevelHelper= new RealPollutantLevelHelper
				("Power Plant India Ltd", "Bhubaneswar", "Power Plant", "ODISHA", "Bhubaneswar", "3", "3", listParameterInfo);
		
		ResponseObject obj = new ResponseObject(pollutantLevelHelper,successApiStatus);
		
		return obj;
	}

}
