package com.rest.dataservice.service;

import java.io.ByteArrayInputStream;
import java.text.ParseException;

import org.springframework.web.bind.annotation.RequestParam;

import com.rest.dataservice.entity.RealPollutantLevelInfos;
import com.rest.dataservice.model.StationDateLevelGraphRequest;
import com.rest.dataservice.util.ResponseObject;

public interface RealPollutantLevelService {
	
	ResponseObject getRealPoulltantLevelData(RealPollutantLevelInfos info);

	ResponseObject getRealPollutantLevelGraphData(RealPollutantLevelInfos info);

	ResponseObject getRealPollutantStationParamLevelInfos(RealPollutantLevelInfos info);

	ResponseObject getRealPoulltantStationDateLevelGraphData(StationDateLevelGraphRequest graphRequest);

	ResponseObject getRealPoulltantLevelAllData();
	
	ByteArrayInputStream getRealTimeReportInExcel( StationDateLevelGraphRequest graphRequest) throws ParseException;
	
	ResponseObject getSMSReport(StationDateLevelGraphRequest request);

	ByteArrayInputStream getSMSReportInExcel(String from, String to) throws ParseException;

	ResponseObject getSMSAllReport();

}
