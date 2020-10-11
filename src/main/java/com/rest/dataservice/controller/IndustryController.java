package com.rest.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dataservice.entity.Industry;
import com.rest.dataservice.service.IndustryService;
import com.rest.dataservice.util.AbstractMapper;
import com.rest.dataservice.util.RequestObject;
import com.rest.dataservice.util.ResponseObject;



/**
 * @author sandeep.dash
 *
 */
@RestController
public class IndustryController extends AbstractMapper{
	
	@Autowired
	IndustryService industryService;
	
	
	/**
	 * @return ResponseObject
	 */
	@PostMapping
	public ResponseObject addIndustryDetails(@RequestBody RequestObject requestObject) {
		Industry industry = (Industry) getParsedObject(requestObject.getRequestdata(), Industry.class);
		return industryService.addIndustryDetails();
	}
	
	/**
	 * @return ResponseObject
	 */
	@GetMapping
	public ResponseObject getIndustryList() {
		return industryService.getIndustryList();
	}
	
	

}
