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
		
		UserInfo saveuserinfo = insertUserinfo(user);

		PlantInfo plantSaveResult = insertPlantInfo(user);
		
		UserRole userrole = new UserRole();
		userrole.setPlantUserId(plantSaveResult.getPid());
		
		userrole.setRoleId(user.getUserrole().getRoleId() == null? "User" : user.getUserrole().getRoleId()); 
		
		userrole.setUserRoleStatus(true);
		userrole.setCreatedDt(new Date());
		userRoleRepository.save(userrole);
			
		
		/* PlantInfo plantSaveResult = plantInfoRepository.save(user.getPlantInfo()); */
		 if(plantSaveResult.getPlantUserName()==user.getUserName()) {
	
		  
			
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
		  CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.CREATED,
					ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
			return new ResponseObject("User Registered Successfully",SuccessApiStatus);
}

	public PlantInfo insertPlantInfo(UserHelper user) {
		PlantInfo plantinfo = new PlantInfo();
		plantinfo.setPlantUserName(user.getUserName());
		plantinfo.setPin(user.getPlantInfo().getPin());
		plantinfo.setTyp(user.getPlantInfo().getTyp());
		plantinfo.setDistrict(user.getPlantInfo().getDistrict());
		plantinfo.setTown(user.getPlantInfo().getTown());
		plantinfo.setStreet(user.getPlantInfo().getStreet());
		plantinfo.setState(user.getPlantInfo().getState());
		plantinfo.setEmail(user.getPlantInfo().getEmail());
		plantinfo.setWeb(user.getPlantInfo().getWeb());
		plantinfo.setZonal(user.getPlantInfo().getZonal());
		plantinfo.setGrdId(user.getPlantInfo().getGrdId());
		plantinfo.setTimeStamp(user.getPlantInfo().getTimeStamp());
		plantinfo.setAuthPerson(user.getPlantInfo().getAuthPerson());
		plantinfo.setAuthPersonDesig(user.getPlantInfo().getAuthPersonDesig());
		plantinfo.setAuthoPerMob(user.getPlantInfo().getAuthoPerMob());
		plantinfo.setCpcbUser(user.getPlantInfo().getCpcbUser());
		plantinfo.setCpcbUserEmail(user.getPlantInfo().getCpcbUserEmail());
		plantinfo.setCpcbUserMob(user.getPlantInfo().getCpcbUserMob());
		plantinfo.setCpcbUsr2(user.getPlantInfo().getCpcbUsr2());
		plantinfo.setCpcbUserEmail2(user.getPlantInfo().getCpcbUserEmail2());
		plantinfo.setCpcbUserMob2(user.getPlantInfo().getCpcbUserMob2());
		plantinfo.setLatLong(user.getPlantInfo().getLatLong());
		plantinfo.setConnected(user.getPlantInfo().getConnected());
		plantinfo.setDeptEmail(user.getPlantInfo().getDeptEmail());
		plantinfo.setCategory(user.getPlantInfo().getCategory());
		plantinfo.setPlantName(user.getPlantInfo().getPlantName());
		plantinfo.setAnalyzerCount(user.getPlantInfo().getAnalyzerCount());
		plantinfo.setHQOEmail(user.getPlantInfo().getHQOEmail());
		plantinfo.setInletUrl(user.getPlantInfo().getInletUrl());
		plantinfo.setOutletUrl(user.getPlantInfo().getOutletUrl());
		plantinfo.setRoUser(user.getPlantInfo().getRoUser());
		plantinfo.setRoUserEmail(user.getPlantInfo().getRoUserEmail());
		plantinfo.setRoUserMob(user.getPlantInfo().getRoUserMob());
		plantinfo.setPlantSlug(user.getPlantInfo().getPlantSlug());
		plantinfo.setAuthReq(user.getPlantInfo().getAuthReq());
		plantinfo.setStationCount(user.getPlantInfo().getStationCount());
		plantinfo.setPlantVendor(user.getPlantInfo().getPlantVendor());
		plantinfo.setCaaqmsStation(user.getPlantInfo().getCaaqmsStation());
		plantinfo.setCemsStation(user.getPlantInfo().getCemsStation());
		plantinfo.setCeqmsStation(user.getPlantInfo().getCeqmsStation());
		plantinfo.setSecdPerson(user.getPlantInfo().getSecdPerson());
		plantinfo.setSecdPersonDesig(user.getPlantInfo().getSecdPersonDesig());
		plantinfo.setSecdPersonMob(user.getPlantInfo().getSecdPersonMob());
		plantinfo.setSecdEmail(user.getPlantInfo().getSecdEmail());
		plantinfo.setCreatedDt(new Date());
		return plantInfoRepository.save(plantinfo);
	}

	public UserInfo insertUserinfo(UserHelper user) {

		UserInfo userinfo = new UserInfo();
		userinfo.setUserName(user.getUserName());
		userinfo.setPassword(user.getUserinfo().getPassword());
		userinfo.setEmail(user.getUserinfo().getEmail());
		userinfo.setDepartment(user.getUserinfo().getDepartment());
		userinfo.setMobNo(user.getUserinfo().getMobNo());
		userinfo.setUserType(user.getUserinfo().getUserType());
		userinfo.setPlantType(user.getUserinfo().getPlantType());
		userinfo.setCategory(user.getUserinfo().getCategory());
		userinfo.setDesignation(user.getUserinfo().getDesignation());
		userinfo.setReportto(user.getUserinfo().getReportto());
		userinfo.setRsaPrivateKey(user.getUserinfo().getRsaPrivateKey());
		userinfo.setRsaPublicKey(user.getUserinfo().getRsaPublicKey());
		return userRepository.save(userinfo);

	}

}
