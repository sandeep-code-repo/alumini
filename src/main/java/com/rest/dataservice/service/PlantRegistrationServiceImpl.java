package com.rest.dataservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.Employee;
import com.rest.dataservice.entity.ParameterInfo;
import com.rest.dataservice.entity.PlantInfo;
import com.rest.dataservice.entity.StationInfo;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.entity.UserRole;
import com.rest.dataservice.helper.UserHelper;
import com.rest.dataservice.repository.PlantRegistrationRepository;
import com.rest.dataservice.repository.ParameterInfoRepository;
import com.rest.dataservice.repository.PlantInfoRepository;
import com.rest.dataservice.repository.StationInfoRepository;
import com.rest.dataservice.repository.UserRepository;
import com.rest.dataservice.repository.UserRoleRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

@Service
public class PlantRegistrationServiceImpl implements PlantRegistrationService {

	@Autowired
	PlantRegistrationRepository employeeRepository;

	@Autowired
	PlantInfoRepository plantInfoRepository;

	@Autowired
	StationInfoRepository stationInfoRepository;

	@Autowired
	ParameterInfoRepository parameterInfoRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

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
		  
		if(plantSaveResult.getPlantUserName() != null) {
			
		  UserInfo userinfo = new UserInfo();
		  userinfo.setUserName(plantSaveResult.getPlantUserName());
		  userinfo.setPassword(user.getUserInfo().getPassword());
		
		  userinfo.setEmail(user.getUserInfo().getEmail());
		  userinfo.setDepartment(user.getUserInfo().getDepartment());
		  userinfo.setMobNo(user.getUserInfo().getMobNo());
		  userinfo.setUserType(user.getUserInfo().getUserType());
		  userinfo.setPlantType(user.getUserInfo().getPlantType());
		  userinfo.setCategory(user.getUserInfo().getCategory());
		  userinfo.setDesignation(user.getUserInfo().getDesignation());
		  userinfo.setReportto(user.getUserInfo().getReportto());
		  userinfo.setRsaPrivateKey(user.getUserInfo().getRsaPrivateKey());
		  userinfo.setRsaPublicKey(user.getUserInfo().getRsaPublicKey());
		  userinfo.setCreatedDt(new Date());
		  userRepository.save(userinfo);
		}
		  
		  

		  
		  user.getUserInfo().getUserRole().parallelStream().forEach(record -> {
			  UserRole userRole = new UserRole();
			  userRole.setPlantUserId(plantSaveResult.getPid());
			  userRole.setRoleId(record.getRoleId() == null ? "User" : record.getRoleId());
			  userRole.setUserRoleStatus(true);
			  userRole.setCreatedDt(new Date());
			  userRoleRepository.save(userRole);
			});
		  
		 
		if (plantSaveResult.getPlantUserName() != null ) {
			StationInfo stationinfo = new StationInfo();
			stationinfo.setPlantId(plantSaveResult.getPid());
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
			stationinfo.setCreatedDt(new Date());

			stationInfoRepository.save(stationinfo);

			user.getStationInfo().getParameterInfo().parallelStream().forEach(record -> {
				ParameterInfo param = new ParameterInfo();
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
				parameterInfoRepository.save(param);
			});

			// parameterInfoRepository.saveAll(paramInfoList);

		}
		CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS,
				HttpStatus.CREATED, ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		return new ResponseObject("User Registered Successfully", SuccessApiStatus);
	}

	

}
