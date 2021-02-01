package com.rest.dataservice.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/getRelPollutantReport/download")
	public ResponseEntity<Resource> getFile(@RequestParam String frequency,@RequestParam String from,
			@RequestParam String to,@RequestParam String plantId,@RequestParam String stationId,
			@RequestParam String parameter) throws ParseException {
		String filename = "RealPollutantReport.xlsx";
		
		StationDateLevelGraphRequest graphRequest = new StationDateLevelGraphRequest();
		graphRequest.setFrequency(frequency);
		graphRequest.setFromDate(from);
		graphRequest.setToDate(to);
		graphRequest.setPlantId(plantId);
		graphRequest.setStationId(stationId);
		graphRequest.setParameter(parameter);

		InputStreamResource file = new InputStreamResource(realPollutantLevelService.getRealTimeReportInExcel(graphRequest));

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}

}
