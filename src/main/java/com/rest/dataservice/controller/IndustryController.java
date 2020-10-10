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
import com.skeleton.alumini.util.SecurityKeyUtil;



/**
 * @author sandeep.dash
 *
 */
@RestController
@RequestMapping("/alumini")
public class IndustryController extends AbstractMapper{
	
	@Autowired
	IndustryService industryService;
	
	@Autowired
    private SecurityKeyUtil passwordEncoderDecoder;
	
	
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
	 * @throws Exception 
	 */
	@GetMapping
	public ResponseObject getIndustryList() throws Exception {
		String industryDescEncoded=passwordEncoderDecoder.encrypt("test");
		System.out.println("industryDesc encoded :"+industryDescEncoded);
		String industryDescDecoded=passwordEncoderDecoder.decrypt(industryDescEncoded);
		System.out.println("industryDesc decoded :"+industryDescDecoded);
		return industryService.getIndustryList();
	}
	
	

}
