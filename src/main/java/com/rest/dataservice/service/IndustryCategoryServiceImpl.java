package com.rest.dataservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.IndustryCategory;
import com.rest.dataservice.repository.DropdownIndustryCategoryRepository;
import com.rest.dataservice.repository.IndustryCategoryRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.RequestObject;
import com.rest.dataservice.util.ResponseObject;

@Service
public class IndustryCategoryServiceImpl implements IndustryCategoryService{
	
	@Autowired
	IndustryCategoryRepository industryCategoryRepository;
	
	@Autowired
	DropdownIndustryCategoryRepository dropdownIndustryCategoryRepository;

	@Override
	public ResponseObject getIndustryDetailsByCategory(String category) {
		CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
				ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		return new ResponseObject(industryCategoryRepository.getIndustryDetailsByCategory(category),SuccessApiStatus);
	}

	@Override
	public ResponseObject addIndustryDetails(IndustryCategory IndustryCategory) {
		CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
				ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		IndustryCategory instaCat = industryCategoryRepository.save(IndustryCategory);
		
		ResponseObject res = new ResponseObject(instaCat, SuccessApiStatus);
		return res;
	}

	@Override
	public ResponseObject getIndustryList() {
		CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
				ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		return new ResponseObject(industryCategoryRepository.findAll(),SuccessApiStatus);
	}

	@Override
	public ResponseObject editByEname(String name) {
		CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
				ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		IndustryCategory editName = industryCategoryRepository.editByname(name);
		ResponseObject res = new ResponseObject(editName, SuccessApiStatus);
		return res;
	}

	@Override
	public ResponseObject getDropdownIndustryCategoryList() {
		CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
				ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		return new ResponseObject(dropdownIndustryCategoryRepository.findAll(),SuccessApiStatus);
	}


}
