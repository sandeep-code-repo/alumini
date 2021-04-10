package com.rest.dataservice.service;

import com.rest.dataservice.entity.WorkflowInfo;
import com.rest.dataservice.helper.WorkflowInputMapper;
import com.rest.dataservice.util.ResponseObject;

public interface WorkflowService {
	
	ResponseObject saveWorkflow(WorkflowInfo workflowinfo);

	ResponseObject getWorkflowDetails(WorkflowInputMapper inputMapper);

}
