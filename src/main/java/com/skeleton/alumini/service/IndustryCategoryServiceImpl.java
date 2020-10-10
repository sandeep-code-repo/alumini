package com.skeleton.alumini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.skeleton.alumini.constants.ApplicationConstants;
import com.skeleton.alumini.entity.IndustryCatagory;
import com.skeleton.alumini.repository.IndustryCategoryRepository;
import com.skeleton.alumini.util.CommonApiStatus;
import com.skeleton.alumini.util.RequestObject;
import com.skeleton.alumini.util.ResponseObject;

@Service
public class IndustryCategoryServiceImpl implements IndustryCategoryService{
	
	@Autowired
	IndustryCategoryRepository industryCategoryRepository;

	@Override
	public List<IndustryCatagory> getIndustryDetailsByCategory(String category) {
		return industryCategoryRepository.getIndustryDetailsByCategory(category);
	}

	@Override
	public ResponseObject addIndustryDetails(IndustryCatagory industryCatagory) {
		CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
				ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		IndustryCatagory instaCat = industryCategoryRepository.save(industryCatagory);
		
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
		IndustryCatagory editName = industryCategoryRepository.editByname(name);
		ResponseObject res = new ResponseObject(editName, SuccessApiStatus);
		return res;
	}



}
