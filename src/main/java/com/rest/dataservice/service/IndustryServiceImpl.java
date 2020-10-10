package com.rest.dataservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.repository.IndustryRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

@Service
public class IndustryServiceImpl implements IndustryService{
	
	@Autowired
	IndustryRepository industryRepository;

	@Override
	public ResponseObject getIndustryList() {
		CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, 200,
				ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		return new ResponseObject(industryRepository.findAll(), SuccessApiStatus);
	}

	@Override
	public ResponseObject addIndustryDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
