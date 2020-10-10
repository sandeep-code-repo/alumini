package com.rest.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.rest.dataservice.util.SecurityKeyUtil;



/**
 * @author sandeep.dash
 *
 */
@RestController
@RequestMapping("/industry")
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
