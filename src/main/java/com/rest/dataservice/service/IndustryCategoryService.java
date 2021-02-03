package com.rest.dataservice.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

import com.rest.dataservice.entity.IndustryCategory;
import com.rest.dataservice.model.StationDateLevelGraphRequest;
import com.rest.dataservice.util.RequestObject;
import com.rest.dataservice.util.ResponseObject;

public interface IndustryCategoryService {
	
	ResponseObject addIndustryDetails(IndustryCategory industryCatagory);
	
	ResponseObject getIndustryList();
	
	ResponseObject getIndustryDetailsByCategory(String category);

	ResponseObject editByEname(String name);
	
	ResponseObject getDropdownIndustryCategoryList();


}
