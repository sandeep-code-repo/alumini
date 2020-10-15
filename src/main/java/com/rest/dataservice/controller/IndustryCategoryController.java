package com.rest.dataservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dataservice.entity.Industry;
import com.rest.dataservice.entity.IndustryCategory;
import com.rest.dataservice.service.IndustryCategoryService;
import com.rest.dataservice.util.AbstractMapper;
import com.rest.dataservice.util.RequestObject;
import com.rest.dataservice.util.ResponseObject;

@RestController
@RequestMapping("/industry")
public class IndustryCategoryController extends AbstractMapper{
	
	
	
	@Autowired
	IndustryCategoryService industryCategoryService;
	
	
	/**
	 * @return ResponseObject
	 */
	@PostMapping
	public ResponseObject addIndustryDetails(@RequestBody IndustryCategory industryCatagory) {
		//IndustryCatagory industry = (IndustryCatagory) getParsedObject(industryCatagory.getName(), IndustryCatagory.class);
		return industryCategoryService.addIndustryDetails(industryCatagory);
	}
	
	
	 @GetMapping(value ="/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
	  public @ResponseBody ResponseObject getindustrydtlsByCategory(@PathVariable("category")String category) {
		 System.out.println(category);
		
		 return industryCategoryService.getIndustryDetailsByCategory(category); 
	 
	 }
	 
	 /**
		 * @return ResponseObject
		 * Return all Category
	 */
	 @GetMapping
		public ResponseObject getIndustryList() {
			return industryCategoryService.getIndustryList();
		}

	 
	 
	 /**
		 * Category Edit By Name
	 */
	  
      @PutMapping(value ="/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
		  public ResponseObject editCategoryData(@PathVariable("name") String name) {
		  
			return industryCategoryService.editByEname(name);
		  
		  }
		 
      @GetMapping(value ="/dropdownIndustryList", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseObject getDropdownIndustryCategoryList() {
      	ResponseObject obj= industryCategoryService.getDropdownIndustryCategoryList();
			return obj;
		}

}
