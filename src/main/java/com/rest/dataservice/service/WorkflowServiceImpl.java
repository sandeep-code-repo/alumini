package com.rest.dataservice.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.PlantInfo;
import com.rest.dataservice.entity.RealPollutantLevelInfos;
import com.rest.dataservice.entity.StationInfo;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.entity.WorkflowInfo;
import com.rest.dataservice.helper.WorkflowHelper;
import com.rest.dataservice.helper.WorkflowInputMapper;
import com.rest.dataservice.repository.ParameterInfoRepository;
import com.rest.dataservice.repository.PlantInfoRepository;
import com.rest.dataservice.repository.RealPollutantLevelInfosRepository;
import com.rest.dataservice.repository.StationInfoRepository;
import com.rest.dataservice.repository.UserRepository;
import com.rest.dataservice.repository.WorkflowInfoRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

@Service
public class WorkflowServiceImpl implements WorkflowService {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	PlantInfoRepository plantInfoRepository;

	@Autowired
	StationInfoRepository stationInfoRepository;

	@Autowired
	ParameterInfoRepository parameterInfoRepository;
	
	@Autowired
	WorkflowInfoRepository workflowInfoRepository;

	@Autowired
	RealPollutantLevelInfosRepository realPollutantLevelInfoRepository;
	
	SimpleDateFormat sdf = new SimpleDateFormat(ApplicationConstants.DATE_TIME_FORMATTER); 
	
	private static final Logger logger = LoggerFactory.getLogger(WorkflowServiceImpl.class);
	
	private static CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
			ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
	
	CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
			  HttpStatus.EXPECTATION_FAILED, "failed");

	
	@Override
	public ResponseObject saveWorkflow(WorkflowInfo workflowinfo) {
		
		try {
	    workflowinfo.setCreatedBy(workflowinfo.getPlantId());
	    workflowinfo.setCreatedDt(new Date());
		WorkflowInfo info = workflowInfoRepository.save(workflowinfo);
		
		return new ResponseObject(info, successApiStatus);
		
		}catch(Exception e){
			return new ResponseObject("Failed to save Workflow info", failedApiStatus);
		}
	}


	@Override
	public ResponseObject getWorkflowDetails(WorkflowInputMapper inputMapper) {
		try {
			
			WorkflowHelper workflowHelper = new WorkflowHelper();
			
			
			UserInfo userInfo = userRepository.findByUsername(inputMapper.getPlantId());
			PlantInfo plantInfo= plantInfoRepository.getByPlantUser(userInfo.getUid());
			
			List<StationInfo> stationInfo = stationInfoRepository.findByplantId(plantInfo.getPid());
			
			if(inputMapper.getStatus().equalsIgnoreCase("All")) {
				inputMapper.setStatus("");
			}
			if(inputMapper.getSiteCategory().equalsIgnoreCase("All")) {
				inputMapper.setSiteCategory("");
			}
			if(inputMapper.getSiteName().equalsIgnoreCase("All")) {
				inputMapper.setSiteName("");
			}
			if(inputMapper.getAssignedTo().equalsIgnoreCase("All")) {
				inputMapper.setAssignedTo("");
			}
			
			List<WorkflowInfo> workflowInfo = workflowInfoRepository.getDetailsByParam(inputMapper.getPlantId(),sdf.parse(inputMapper.getFromDate()),sdf.parse(inputMapper.getToDate()),
					                    inputMapper.getSiteCategory(),inputMapper.getAssignedTo(),inputMapper.getSiteName());
			
			
			for (WorkflowInfo data : workflowInfo) {
				
			workflowHelper.setStationName(stationInfo.get(0).getStationId());
			workflowHelper.setStationType(stationInfo.get(0).getStnType());
			workflowHelper.setSiteName(plantInfo.getPlantName());
			workflowHelper.setLastActedBy(inputMapper.getPlantId());
			workflowHelper.setStatus("Active");
			workflowHelper.setCity(userInfo.getTown());
			workflowHelper.setEvent(data.getEvent());
			workflowHelper.setSiteCategory(data.getSiteCategory());
			workflowHelper.setAssignedTo(data.getAssignedTo());
		    workflowHelper.setStartTime(data.getStartTime());
			workflowHelper.setEndTime(data.getEndTime());
			workflowHelper.setTimeToRespond(data.getTimeToRespond());
			workflowHelper.setTimeToAction(data.getTimeToAction());
			workflowHelper.setDescription(data.getDescription());
		    workflowHelper.setSendCopy(data.getSendCopy());
			
			}
			return new ResponseObject(workflowHelper,successApiStatus);
			
			}catch(Exception e){
				return new ResponseObject("Failed to fetch Workflow info", failedApiStatus);
			}
	}

	
	

	



}
