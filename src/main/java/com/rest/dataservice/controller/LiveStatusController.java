package com.rest.dataservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.service.LiveStatusService;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

@RestController
public class LiveStatusController {
	
	private static final Logger logger = LoggerFactory.getLogger(LiveStatusController.class);
	
	CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
			  HttpStatus.EXPECTATION_FAILED, "failed");
	
	CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS,
			  HttpStatus.OK, "Success");
	
	@Autowired
	private LiveStatusService liveStatusService;
	
	
	@GetMapping("/getAllLiveStatus")
	 public ResponseObject getAllLiveStatus(@RequestParam String plantId,@RequestParam String plantStatus,@RequestParam String exceedanceStatus) {
	 
		ResponseObject entity = liveStatusService.getAllLiveStatus(plantId,plantStatus,exceedanceStatus);
	 
	 return entity;
	 }
	


}
