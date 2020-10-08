package com.skeleton.alumini.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skeleton.alumini.entity.IndustryCatagory;
import com.skeleton.alumini.service.IndustryCategoryService;

@RestController
@RequestMapping("/alumini/show")
public class IndustryCategoryController {
	
	
	
	@Autowired
	IndustryCategoryService industryCategoryService;
	
	 @GetMapping(value ="/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
	  public @ResponseBody ResponseEntity<?> getindustrydtlsByCategory(@PathVariable("category")String category) {
		 System.out.println(category);
		
	  List<IndustryCatagory> entity = industryCategoryService.getIndustryDetailsByCategory(category); 
	  return new
	   ResponseEntity<Object>(entity, HttpStatus.OK); }

}
