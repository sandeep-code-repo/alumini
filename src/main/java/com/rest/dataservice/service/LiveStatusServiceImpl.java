package com.rest.dataservice.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.PlantInfo;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.helper.LiveStatusHelper;
import com.rest.dataservice.repository.ParameterInfoRepository;
import com.rest.dataservice.repository.PlantInfoRepository;
import com.rest.dataservice.repository.RealPollutantLevelInfosRepository;
import com.rest.dataservice.repository.StationInfoRepository;
import com.rest.dataservice.repository.UserRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

@Service
public class LiveStatusServiceImpl implements LiveStatusService {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	PlantInfoRepository plantInfoRepository;

	@Autowired
	StationInfoRepository stationInfoRepository;

	@Autowired
	ParameterInfoRepository parameterInfoRepository;

	@Autowired
	RealPollutantLevelInfosRepository realPollutantLevelInfoRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(LiveStatusServiceImpl.class);
	
	private static CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
			ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
	
	CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
			  HttpStatus.EXPECTATION_FAILED, "failed");
	

	@Override
	public ResponseObject getAllLiveStatus(String plantId, String plantStatus, String exceedanceStatus) {
		
		LiveStatusHelper liveStatusHelper = new LiveStatusHelper();
		
		try {
		
		UserInfo userInfo = userRepository.findByUsername(plantId);
		PlantInfo plantInfo= plantInfoRepository.getByPlantUser(userInfo.getUid());
		
		liveStatusHelper.setSiteId(plantId);
		liveStatusHelper.setSiteName(plantInfo.getPlantName());
		liveStatusHelper.setSiteLabel(plantInfo.getPlantName());
		liveStatusHelper.setrO(plantInfo.getRoUser());
		liveStatusHelper.setStreet(userInfo.getStreet());
		liveStatusHelper.setCity(userInfo.getTown());
		liveStatusHelper.setState(userInfo.getState());
		liveStatusHelper.setCountry("INDIA");
		liveStatusHelper.setDistrict(userInfo.getDistrict());
		liveStatusHelper.setPostcode(userInfo.getPin());
		liveStatusHelper.setPhonenumbers(userInfo.getMobNo());
		liveStatusHelper.setIndustryType(plantInfo.getPlantType());
		liveStatusHelper.setVendor(plantInfo.getPlantVendor());
		liveStatusHelper.setCameraStatus("No Camera");
		
		
		  liveStatusHelper.setDateofConfiguration(new Date());
		  liveStatusHelper.setLastSynchronized("6 Minutes ago");
		  liveStatusHelper.setLastSynchronizedsort(new Date());
		  liveStatusHelper.setLastSynchronizedtime(new Date());
		  liveStatusHelper.setSiteStatus("Active");
		  liveStatusHelper.setExceedance("NO");
		
		
		}catch(Exception e){
			
			logger.error("Error in fetching getAllLiveStatus ",e.getMessage());
			
		}
		
		return new ResponseObject(liveStatusHelper,successApiStatus);
		
	}



}
