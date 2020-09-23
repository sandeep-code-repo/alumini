package com.skeleton.alumini.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skeleton.alumini.entity.Employee;
import com.skeleton.alumini.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee insertemp(Employee employee) {
		employee.setCreatedDate(new Date());
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findEmpByName(String iName) {
		return employeeRepository.getEmpByName(iName);
	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee editByEname(String iName) {
		return employeeRepository.editByEname(iName);
	}

	@Override
	@Transactional
	public Integer deleteUser(String iName, String status) {
		
		return employeeRepository.deleteUser(iName, status);
	}

	

}
