package com.rest.dataservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.HelpFeedback;
import com.rest.dataservice.repository.HelpFeedbackRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

@Service
public class HelpFeedbackServiceImpl implements HelpFeedbackService {

    @Autowired
	HelpFeedbackRepository helpFeedbackRepository;
    
    private static CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
			ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
	
	@Override
	public HelpFeedback addHelpDetails(HelpFeedback help) {
		
		help.setCreatedBy(help.getUserName());
		help.setCreatedDt(new Date());
		HelpFeedback feedback = helpFeedbackRepository.save(help);
		
		return feedback;
		}

	@Override
	public ResponseObject getHelpFeedbackList() {
        
		List<HelpFeedback> feedbackList = helpFeedbackRepository.findAll();
		return new ResponseObject(feedbackList,successApiStatus);
	}

}
