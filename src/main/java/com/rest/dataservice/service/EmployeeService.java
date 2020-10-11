package com.rest.dataservice.service;

import java.util.List;

import com.rest.dataservice.entity.Employee;
import com.rest.dataservice.entity.StationInfo;
import com.rest.dataservice.helper.UserHelper;
import com.rest.dataservice.util.ResponseObject;

public interface EmployeeService {

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

	

}
