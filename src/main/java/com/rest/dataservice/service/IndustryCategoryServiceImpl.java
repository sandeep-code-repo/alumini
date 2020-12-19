package com.rest.dataservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.IndustryCategory;
import com.rest.dataservice.repository.DropdownIndustryCategoryRepository;
import com.rest.dataservice.repository.IndustryCategoryRepository;
import com.rest.dataservice.repository.SMSReportRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.RequestObject;
import com.rest.dataservice.util.ResponseObject;

@Service
public class IndustryCategoryServiceImpl implements IndustryCategoryService{
	
	@Autowired
	IndustryCategoryRepository industryCategoryRepository;
	
	@Autowired
	DropdownIndustryCategoryRepository dropdownIndustryCategoryRepository;
	
	@Autowired
	SMSReportRepository smsReportRepository;
	
	CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
			ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);

	@Override
	public ResponseObject getIndustryDetailsByCategory(String category) {
		
		return new ResponseObject(industryCategoryRepository.getIndustryDetailsByCategory(category),SuccessApiStatus);
	}

	@Override
	public ResponseObject addIndustryDetails(IndustryCategory IndustryCategory) {
		
		IndustryCategory instaCat = industryCategoryRepository.save(IndustryCategory);
		
		ResponseObject res = new ResponseObject(instaCat, SuccessApiStatus);
		return res;
	}

	@Override
	public ResponseObject getIndustryList() {
		
		return new ResponseObject(industryCategoryRepository.findAll(),SuccessApiStatus);
	}

	@Override
	public ResponseObject editByEname(String name) {
	
		IndustryCategory editName = industryCategoryRepository.editByname(name);
		ResponseObject res = new ResponseObject(editName, SuccessApiStatus);
		return res;
	}

	@Override
	public ResponseObject getDropdownIndustryCategoryList() {
		
		return new ResponseObject(dropdownIndustryCategoryRepository.findAll(),SuccessApiStatus);
	}

	@Override
	public ResponseObject getSMSReport() {
		
		return new ResponseObject(smsReportRepository.findAll(),SuccessApiStatus);
	}


}
