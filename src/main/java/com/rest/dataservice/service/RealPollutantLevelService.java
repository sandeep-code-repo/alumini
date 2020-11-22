package com.rest.dataservice.service;

import com.rest.dataservice.entity.RealPollutantLevelInfos;
import com.rest.dataservice.util.ResponseObject;

public interface RealPollutantLevelService {
	
	ResponseObject getRealPoulltantLevelData(RealPollutantLevelInfos info);

	ResponseObject getRealPoulltantLevelGraphData(RealPollutantLevelInfos info);
}
