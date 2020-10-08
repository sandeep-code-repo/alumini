package com.skeleton.alumini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeleton.alumini.entity.IndustryCatagory;
import com.skeleton.alumini.repository.IndustryCategoryRepository;

@Service
public class IndustryCategoryImpl implements IndustryCategoryService{
	
	@Autowired
	IndustryCategoryRepository industryCategoryRepository;

	@Override
	public List<IndustryCatagory> getIndustryDetailsByCategory(String category) {
		return industryCategoryRepository.getIndustryDetailsByCategory(category);
	}

}
