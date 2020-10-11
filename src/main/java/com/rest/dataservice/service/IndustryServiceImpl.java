package com.skeleton.alumini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.skeleton.alumini.constants.ApplicationConstants;
import com.skeleton.alumini.repository.IndustryRepository;
import com.skeleton.alumini.util.CommonApiStatus;
import com.skeleton.alumini.util.ResponseObject;

@Service
public class IndustryServiceImpl implements IndustryService{
	
	@Autowired
	IndustryRepository industryRepository;

	@Override
	public ResponseObject getIndustryList() {
		CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
				ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		return new ResponseObject(industryRepository.findAll(), SuccessApiStatus);
	}

	@Override
	public ResponseObject addIndustryDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
