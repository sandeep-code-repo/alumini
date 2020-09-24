package com.skeleton.alumini.service;

import java.util.List;

import com.skeleton.alumini.entity.Employee;

public interface EmployeeService {

	Employee insertemp(Employee employee);

	Employee findEmpByName(String iName);

	List<Employee> getEmployeeList();

	Employee deleteUser(String iName, String status);

	Employee editByEname(String iName, Employee emp);

	

}
