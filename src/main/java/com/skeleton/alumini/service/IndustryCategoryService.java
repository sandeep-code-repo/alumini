package com.skeleton.alumini.service;

import java.util.List;

import com.skeleton.alumini.entity.IndustryCatagory;
import com.skeleton.alumini.util.RequestObject;
import com.skeleton.alumini.util.ResponseObject;

public interface IndustryCategoryService {
	
	ResponseObject addIndustryDetails(IndustryCatagory industryCatagory);
	
	ResponseObject getIndustryList();
	
	List<IndustryCatagory>getIndustryDetailsByCategory(String category);

	ResponseObject editByEname(String name);

}
