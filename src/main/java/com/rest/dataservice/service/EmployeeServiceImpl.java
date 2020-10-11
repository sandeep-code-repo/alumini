package com.skeleton.alumini.service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skeleton.alumini.constants.ApplicationConstants;
import com.skeleton.alumini.entity.Employee;
import com.skeleton.alumini.entity.ParameterInfo;
import com.skeleton.alumini.entity.PlantInfo;
import com.skeleton.alumini.entity.StationInfo;
import com.skeleton.alumini.helper.UserHelper;
import com.skeleton.alumini.repository.EmployeeRepository;
import com.skeleton.alumini.repository.ParameterInfoRepository;
import com.skeleton.alumini.repository.PlantInfoRepository;
import com.skeleton.alumini.repository.StationInfoRepository;
import com.skeleton.alumini.util.CommonApiStatus;
import com.skeleton.alumini.util.ResponseObject;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PlantInfoRepository plantInfoRepository;
	
	@Autowired
	StationInfoRepository stationInfoRepository;
	
	@Autowired
	ParameterInfoRepository parameterInfoRepository;

	/*
	 * @Override public Employee insertemp(Employee employee) {
	 * employee.setCreatedDate(new Date()); return
	 * employeeRepository.save(employee); }
	 */

	/*
	 * @Override public Employee findEmpByName(String iName) { return
	 * employeeRepository.getEmpByName(iName); }
	 */

	/*
	 * @Override public List<Employee> getEmployeeList() { return
	 * employeeRepository.findAll(); }
	 */


	/*
	 * @Override
	 * 
	 * @Transactional public Employee deleteUser(String iName, String status) {
	 * 
	 * return employeeRepository.deleteUser(iName, status); }
	 */


	/*
	 * @Override public Employee editByEname(String iName, Employee emp) { Employee
	 * employee = employeeRepository.getEmpByName(iName);
	 * employee.setiName(emp.getiName());
	 * employee.setIndCatagory(emp.getIndCatagory());
	 * employee.setVendor(emp.getVendor()); employee.setPlantId(emp.getPlantId());
	 * employee.setDistrict(emp.getDistrict()); employee.setRegOfc(emp.getRegOfc());
	 * employee.setCaaqmsStation(emp.getCaaqmsStation());
	 * employee.setCemsStation(emp.getCemsStation());
	 * employee.setCeqmsStation(emp.getCeqmsStation());
	 * employee.setPrimaryCnt(emp.getPrimaryCnt());
	 * employee.setSecondaryCnt(emp.getSecondaryCnt());
	 * employee.setAddress(emp.getAddress());
	 * employee.setDataTrasmision(emp.getDataTrasmision());
	 * employee.setHistoryData(emp.getHistoryData());
	 * employee.setmType(emp.getmType());
	 * employee.setStationName(emp.getStationName());
	 * employee.setProcessAttached(emp.getProcessAttached());
	 * employee.setProVendor(emp.getProVendor());
	 * employee.setAnalyserMake(emp.getAnalyserMake());
	 * employee.setAnalyserSerNo(emp.getAnalyserSerNo());
	 * employee.setDeviceNo(emp.getDeviceNo()); employee.setMacId(emp.getMacId());
	 * employee.setMeasurementMin(emp.getMeasurementMin());
	 * employee.setMeasurementMax(emp.getMeasurementMax());
	 * employee.setParameter(emp.getParameter()); employee.setUnit(emp.getUnit());
	 * employee.setCertification(emp.getCertification());
	 * employee.setLatitude(emp.getLatitude());
	 * employee.setLongitude(emp.getLongitude());
	 * employee.setMeasurementPriciple(emp.getMeasurementPriciple());
	 * employee.setStackheight(emp.getStackheight());
	 * employee.setStackDiameter(emp.getStackDiameter());
	 * employee.setStackVel(emp.getStackVel());
	 * employee.setGasDisRate(emp.getGasDisRate());
	 * employee.setRemark(emp.getRemark());
	 * 
	 * return employeeRepository.save(employee); }
	 */

	@Override
	public ResponseObject insertPlantStationInfo(UserHelper user) {
		 PlantInfo plantSaveResult = plantInfoRepository.save(user.getPlantInfo());
		  
		  if(plantSaveResult.getPlantId()==user.getPlantInfo().getPlantId()) {
		  //StationInfoMapper stationinfo = insertStationInfo(user);
		  
			
			  StationInfo stationinfo = new StationInfo();
			  stationinfo.setPlantId(user.getPlantInfo().getPlantId());
			  stationinfo.setStationId(user.getStationInfo().getStationId());
			  stationinfo.setAnalyzer(user.getStationInfo().getAnalyzer());
			  stationinfo.setAnalyzerv2(user.getStationInfo().getAnalyzerv2());
			  stationinfo.setShortName(user.getStationInfo().getShortName());
			  stationinfo.setLocation(user.getStationInfo().getLocation());
			  stationinfo.setInstallDt(user.getStationInfo().getInstallDt());
			  stationinfo.setToken(user.getStationInfo().getToken());
			  stationinfo.setMacNo(user.getStationInfo().getMacNo());
			  stationinfo.setStationNo(user.getStationInfo().getStationNo());
			  stationinfo.setStnType(user.getStationInfo().getStnType());
			  stationinfo.setHasThresold(user.getStationInfo().getHasThresold());
			  stationinfo.setPid(user.getStationInfo().getPid());
			  stationinfo.setStationVendor(user.getStationInfo().getStationVendor());
			  stationinfo.setCertification(user.getStationInfo().getCertification());
			  stationinfo.setLatitude(user.getStationInfo().getLatitude());
			  stationinfo.setLongitute(user.getStationInfo().getLongitute());
			  stationinfo.setMeasurementPrinciple(user.getStationInfo().getMeasurementPrinciple());
			  stationinfo.setStackHeight(user.getStationInfo().getStackHeight());
			  stationinfo.setStackDiameter(user.getStationInfo().getStackDiameter());
			  stationinfo.setStackVelocity(user.getStationInfo().getStackVelocity());
			  stationinfo.setGasDischargeRate(user.getStationInfo().getGasDischargeRate());
			  stationinfo.setRemarks(user.getStationInfo().getRemarks());
			 
			  
			stationInfoRepository.save(stationinfo);
			
			user.getStationInfo().getParameterInfo().parallelStream().forEach(record -> { ParameterInfo
				  param = new ParameterInfo(); 
				  param.setSid(stationinfo.getSid());
				  param.setParamter(record.getParamter());
				  param.setAnalyserMake(record.getAnalyserMake());
				  param.setAnalyserModel(record.getAnalyserModel());
				  param.setAnalyserSerialNo(record.getAnalyserSerialNo());
				  param.setDevidceIMEINo(record.getDevidceIMEINo());
				  param.setMacId(record.getMacId());
				  param.setMeasurmentMin(record.getMeasurmentMin());
				  param.setMeasurmentMax(record.getMeasurmentMax());
				  param.setUnit(record.getUnit()); 
				  parameterInfoRepository.save(param); });
			
			//parameterInfoRepository.saveAll(paramInfoList);
		 
		  }
		CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
				ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		return new ResponseObject(user,SuccessApiStatus);
}
	
	


	public StationInfo insertStationInfo(UserHelper user) {
//		try {
		System.out.println("insertStationInfo");
			StationInfo stationinfo = new StationInfo();
			stationinfo.setPlantId(user.getStationInfo().getPlantId());
			stationinfo.setStationId(user.getStationInfo().getStationId());
			stationinfo.setAnalyzer(user.getStationInfo().getAnalyzer());
			stationinfo.setAnalyzerv2(user.getStationInfo().getAnalyzerv2());
			stationinfo.setShortName(user.getStationInfo().getShortName());
			stationinfo.setLocation(user.getStationInfo().getLocation());
			stationinfo.setInstallDt(user.getStationInfo().getInstallDt());
			stationinfo.setToken(user.getStationInfo().getToken());
			stationinfo.setMacNo(user.getStationInfo().getMacNo());
			stationinfo.setStationNo(user.getStationInfo().getStationNo());
			stationinfo.setStnType(user.getStationInfo().getStnType());
			stationinfo.setHasThresold(user.getStationInfo().getHasThresold());
			stationinfo.setPid(user.getStationInfo().getPid());
			stationinfo.setStationVendor(user.getStationInfo().getStationVendor());
			stationinfo.setCertification(user.getStationInfo().getCertification());
			stationinfo.setLatitude(user.getStationInfo().getLatitude());
			stationinfo.setLongitute(user.getStationInfo().getLongitute());
			stationinfo.setMeasurementPrinciple(user.getStationInfo().getMeasurementPrinciple());
			stationinfo.setStackHeight(user.getStationInfo().getStackHeight());
			stationinfo.setStackDiameter(user.getStationInfo().getStackDiameter());
			stationinfo.setStackVelocity(user.getStationInfo().getStackVelocity());
			stationinfo.setGasDischargeRate(user.getStationInfo().getGasDischargeRate());
			stationinfo.setRemarks(user.getStationInfo().getRemarks());
			return stationInfoRepository.save(stationinfo);
//		} catch (Exception e) {
//			return null;
//		}
	}
	
	
	
}
