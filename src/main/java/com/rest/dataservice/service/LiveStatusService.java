package com.rest.dataservice.service;

import com.rest.dataservice.util.ResponseObject;

public interface LiveStatusService {
	
	ResponseObject getAllLiveStatus(String plantId, String plantStatus, String exceedenceStatus);

}
