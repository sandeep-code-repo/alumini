package com.rest.dataservice.service;

import com.rest.dataservice.entity.HelpFeedback;
import com.rest.dataservice.util.ResponseObject;

public interface HelpFeedbackService {

	 HelpFeedback addHelpDetails(HelpFeedback help);
	 ResponseObject getHelpFeedbackList();
}
