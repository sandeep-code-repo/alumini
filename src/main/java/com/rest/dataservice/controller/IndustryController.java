package com.skeleton.alumini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skeleton.alumini.entity.Industry;
import com.skeleton.alumini.service.IndustryService;
import com.skeleton.alumini.util.AbstractMapper;
import com.skeleton.alumini.util.RequestObject;
import com.skeleton.alumini.util.ResponseObject;



/**
 * @author sandeep.dash
 *
 */
@RestController
@RequestMapping("/alumini")
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
