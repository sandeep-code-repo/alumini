package com.rest.dataservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.WorkflowInfo;
import com.rest.dataservice.helper.UserHelper;
import com.rest.dataservice.helper.WorkflowInputMapper;
import com.rest.dataservice.service.LiveStatusService;
import com.rest.dataservice.service.WorkflowService;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

@RestController
public class WorkflowController {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkflowController.class);
	
	CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
			  HttpStatus.EXPECTATION_FAILED, "failed");
	
	CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS,
			  HttpStatus.OK, "Success");
	
	@Autowired
	private WorkflowService workflowService;
	
	
	 @PostMapping("/saveWorkflow")
	 public ResponseObject saveWorkflow(@RequestBody WorkflowInfo workflow ) {
	 
		ResponseObject obj = workflowService.saveWorkflow(workflow);
	 
	     return obj;
	 }
	 
	 @PostMapping("/getWorkflowDetails")
	 public ResponseObject getWorkflowDetails(@RequestBody WorkflowInputMapper inputMapper) {
	 
		ResponseObject entity = workflowService.getWorkflowDetails(inputMapper);
	 
	 return entity;
	 }
	


}
