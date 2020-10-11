package com.rest.dataservice.service;

import java.util.List;

import com.rest.dataservice.entity.IndustryCatagory;
import com.rest.dataservice.util.RequestObject;
import com.rest.dataservice.util.ResponseObject;

public interface IndustryCategoryService {
	
	ResponseObject addIndustryDetails(IndustryCatagory industryCatagory);
	
	ResponseObject getIndustryList();
	
	List<IndustryCatagory>getIndustryDetailsByCategory(String category);

	ResponseObject editByEname(String name);

}
