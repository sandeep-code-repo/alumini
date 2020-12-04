package com.rest.dataservice.service;

import com.rest.dataservice.entity.RealPollutantLevelInfos;
import com.rest.dataservice.model.StationDateLevelGraphRequest;
import com.rest.dataservice.util.ResponseObject;

public interface RealPollutantLevelService {
	
	ResponseObject getRealPoulltantLevelData(RealPollutantLevelInfos info);

	ResponseObject getRealPollutantLevelGraphData(RealPollutantLevelInfos info);

	ResponseObject getRealPollutantStationParamLevelInfos(RealPollutantLevelInfos info);

	ResponseObject getRealPoulltantStationDateLevelGraphData(StationDateLevelGraphRequest graphRequest);

}
