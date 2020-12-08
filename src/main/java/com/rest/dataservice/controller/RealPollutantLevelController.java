package com.rest.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.RealPollutantLevelInfos;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.helper.RealParameterInfoHelper;
import com.rest.dataservice.helper.RealPollutantLevelHelper;
import com.rest.dataservice.model.StationDateLevelGraphRequest;
import com.rest.dataservice.service.RealPollutantLevelService;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

import io.swagger.annotations.Api;

@RestController
@Api(value="Real Pollutant Dashboard",description="Real pollutant data for dashboard trend")
public class RealPollutantLevelController {
	
	@Autowired
	private RealPollutantLevelService realPollutantLevelService;
	
	@GetMapping("/getRealPollutantLevelInfosAllData")
	public ResponseObject getRealPollutantLevelInfosAllData() {

		ResponseObject data = realPollutantLevelService.getRealPoulltantLevelAllData();
		return data;
		
	}

	
	
	@PostMapping("/getRealPollutantLevelInfos")
	public ResponseObject getRealPollutantLevelInfos(@RequestBody RealPollutantLevelInfos info) {

		ResponseObject data = realPollutantLevelService.getRealPoulltantLevelData(info);

		return data;
	}
	
	@PostMapping("/getRealPollutantLevelGraphData")
	public ResponseObject getRealPollutantLevelGraphData(@RequestBody RealPollutantLevelInfos info) {

		ResponseObject data = realPollutantLevelService.getRealPollutantLevelGraphData(info);

		return data;
	}
	
	@PostMapping("/getRealPollutantStationParamLevelInfos")
	public ResponseObject getRealPollutantStationParamLevelInfos(@RequestBody RealPollutantLevelInfos info) {

		ResponseObject data = realPollutantLevelService.getRealPollutantStationParamLevelInfos(info);

		return data;
	}
	
	@PostMapping("/getRealPoulltantStationDateLevelGraphData")
	public ResponseObject getRealPoulltantStationDateLevelGraphData(@RequestBody StationDateLevelGraphRequest request) {

		ResponseObject data = realPollutantLevelService.getRealPoulltantStationDateLevelGraphData(request);

		return data;
	}

}
