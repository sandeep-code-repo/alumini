package com.rest.dataservice.service;

import java.util.List;

import com.rest.dataservice.entity.IndustryCategory;
import com.rest.dataservice.util.RequestObject;
import com.rest.dataservice.util.ResponseObject;

public interface IndustryCategoryService {
	
	ResponseObject addIndustryDetails(IndustryCategory industryCatagory);
	
	ResponseObject getIndustryList();
	
	ResponseObject getIndustryDetailsByCategory(String category);

	ResponseObject editByEname(String name);
	
	ResponseObject getDropdownIndustryCategoryList();
	
	

}
