package com.skeleton.alumini.service;

import java.util.List;

import com.skeleton.alumini.entity.Employee;
import com.skeleton.alumini.entity.StationInfo;
import com.skeleton.alumini.helper.UserHelper;
import com.skeleton.alumini.util.ResponseObject;

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
