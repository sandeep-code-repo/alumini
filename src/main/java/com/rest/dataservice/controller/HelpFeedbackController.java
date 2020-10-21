package com.rest.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.HelpFeedback;
import com.rest.dataservice.entity.Industry;
import com.rest.dataservice.service.HelpFeedbackService;
import com.rest.dataservice.service.IndustryService;
import com.rest.dataservice.util.AbstractMapper;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.RequestObject;
import com.rest.dataservice.util.ResponseObject;



/**
 * @author sandeep.dash
 *
 */
@RestController
public class HelpFeedbackController extends AbstractMapper{

	@Autowired
	HelpFeedbackService helpFeedbackService;

	private static CommonApiStatus errorApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS, HttpStatus.INTERNAL_SERVER_ERROR,
			ApplicationConstants.API_OVER_ALL_ERROR_STATUS);

	/**
	 * @return ResponseObject
	 */
	@PostMapping("/addFeedbackDetails")
	public ResponseObject addHelpDetails(@RequestBody HelpFeedback helpFeedback) {

		try {
			//HelpFeedback helpFeedback = (HelpFeedback) getParsedObject(obj.getRequestdata(), HelpFeedback.class);
			return helpFeedbackService.addHelpDetails(helpFeedback);
		} catch (Exception e) {

			return new ResponseObject(e.getStackTrace(),errorApiStatus);
		}
	}

	/**
	 * @return ResponseObject
	 */
	@GetMapping("/getAllFeedback")
	public ResponseObject getAllHelp() {
		try {
			return helpFeedbackService.getHelpFeedbackList();
		} catch (Exception e) {

			return new ResponseObject(e.getStackTrace(),errorApiStatus);
		}
	}



}
