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
	@Transactional
	public Employee deleteUser(String iName, String status) {
		
		return employeeRepository.deleteUser(iName, status);
	}


	@Override
	public Employee editByEname(String iName, Employee emp) {
		Employee employee = employeeRepository.getEmpByName(iName);
		employee.setiName(emp.getiName());
		employee.setIndCatagory(emp.getIndCatagory());
		employee.setVendor(emp.getVendor());
		employee.setPlantId(emp.getPlantId());
		employee.setDistrict(emp.getDistrict());
		employee.setRegOfc(emp.getRegOfc());
		employee.setCaaqmsStation(emp.getCaaqmsStation());
		employee.setCemsStation(emp.getCemsStation());
		employee.setCeqmsStation(emp.getCeqmsStation());
		employee.setPrimaryCnt(emp.getPrimaryCnt());
		employee.setSecondaryCnt(emp.getSecondaryCnt());
		employee.setAddress(emp.getAddress());
		employee.setDataTrasmision(emp.getDataTrasmision());
		employee.setHistoryData(emp.getHistoryData());
		employee.setmType(emp.getmType());
		employee.setStationName(emp.getStationName());
		employee.setProcessAttached(emp.getProcessAttached());
		employee.setProVendor(emp.getProVendor());
		employee.setAnalyserMake(emp.getAnalyserMake());
		employee.setAnalyserSerNo(emp.getAnalyserSerNo());
		employee.setDeviceNo(emp.getDeviceNo());
		employee.setMacId(emp.getMacId());
		employee.setMeasurementMin(emp.getMeasurementMin());
		employee.setMeasurementMax(emp.getMeasurementMax());
		employee.setParameter(emp.getParameter());
		employee.setUnit(emp.getUnit());
		employee.setCertification(emp.getCertification());
		employee.setLatitude(emp.getLatitude());
		employee.setLongitude(emp.getLongitude());
		employee.setMeasurementPriciple(emp.getMeasurementPriciple());
		employee.setStackheight(emp.getStackheight());
		employee.setStackDiameter(emp.getStackDiameter());
		employee.setStackVel(emp.getStackVel());
		employee.setGasDisRate(emp.getGasDisRate());
		employee.setRemark(emp.getRemark());
		
		return employeeRepository.save(employee);
	}


	

}
