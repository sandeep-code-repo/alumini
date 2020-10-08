package com.skeleton.alumini.service;

import java.util.List;

import com.skeleton.alumini.entity.IndustryCatagory;

public interface IndustryCategoryService {
	
	List<IndustryCatagory>getIndustryDetailsByCategory(String category);

}
