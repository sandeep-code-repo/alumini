package com.rest.dataservice.service;

import java.util.List;

import com.rest.dataservice.entity.Employee;
import com.rest.dataservice.entity.StationInfo;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.helper.UserHelper;
import com.rest.dataservice.util.ResponseObject;

public interface PlantRegistrationService {

	/* StationInfo insertemp(StationInfo employee); */

	/*
	 * Employee findEmpByName(String iName);
	 * 
	 * List<Employee> getEmployeeList();
	 * 
	 * Employee deleteUser(String iName, String status);
	 * 
	 * Employee editByEname(String iName, Employee emp);
	 */

	ResponseObject insertPlantStationInfo(UserHelper plantReg);
	
	
	/* ResponseObject insertPlantStationInfoByRegStatus(UserHelper user); */

	ResponseObject findByUserName(UserInfo user);

	ResponseObject insertUserInfo(UserInfo userInfo);

	ResponseObject updatePlantStationInfo(UserHelper plantRegistration);

	

}
