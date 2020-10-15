package com.rest.dataservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dataservice.entity.IndustryCategory;
import com.rest.dataservice.repository.IndustryCategoryRepository;
import com.rest.dataservice.util.ResponseObject;

@Service
public class IndustryCategoryImpl{
	
	@Autowired
	IndustryCategoryRepository industryCategoryRepository;

	/*
	 * @Override public List<IndustryCatagory> getIndustryDetailsByCategory(String
	 * category) { return
	 * industryCategoryRepository.getIndustryDetailsByCategory(category); }
	 * 
	 * @Override public ResponseObject addIndustryDetails(IndustryCatagory
	 * industryCatagory) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public ResponseObject getIndustryList() { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public ResponseObject editByEname(String name) { // TODO
	 * Auto-generated method stub return null; }
	 */
}
