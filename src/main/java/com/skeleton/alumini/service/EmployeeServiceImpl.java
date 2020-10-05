package com.skeleton.alumini.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skeleton.alumini.entity.Employee;
import com.skeleton.alumini.entity.ParameterInfo;
import com.skeleton.alumini.entity.PlantInfo;
import com.skeleton.alumini.entity.StationInfo;
import com.skeleton.alumini.helper.UserHelper;
import com.skeleton.alumini.repository.EmployeeRepository;
import com.skeleton.alumini.repository.ParameterInfoRepository;
import com.skeleton.alumini.repository.PlantInfoRepository;
import com.skeleton.alumini.repository.StationInfoRepository;

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
	public UserHelper insertPlantStationInfo(UserHelper user) {
		try {
			PlantInfo plantinfo = new PlantInfo();
			plantinfo.setPlantId(user.getPlantInfo().getPlantId());
			plantinfo.setPassword(user.getPlantInfo().getPassword());
			plantinfo.setPin(user.getPlantInfo().getPin());
			plantinfo.setPlantNm(user.getPlantInfo().getPlantNm());
			plantinfo.setTyp(user.getPlantInfo().getTyp());
			plantinfo.setDistrict(user.getPlantInfo().getDistrict());
			plantinfo.setTown(user.getPlantInfo().getTown());
			plantinfo.setStreet(user.getPlantInfo().getStreet());
			plantinfo.setState(user.getPlantInfo().getState());
			plantinfo.setEmail(user.getPlantInfo().getEmail());
			plantinfo.setWeb(user.getPlantInfo().getWeb());
			plantinfo.setUserId(user.getUserId());
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
			plantinfo.setCategory(user.getPlantInfo().getPlantName());
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
			plantInfoRepository.save(plantinfo);
			
			
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
			stationinfo.setUserId(user.getUserId());
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
			
			
			ParameterInfo parameterinfo = new ParameterInfo();
			/* parameterinfo.setSid(user.getParameterInfo().getSid()); */
			parameterinfo.setParamter(user.getParameterInfo().getParamter());
			parameterinfo.setAnalyserMake(user.getParameterInfo().getAnalyserMake());
			parameterinfo.setAnalyserModel(user.getParameterInfo().getAnalyserModel());
			parameterinfo.setAnalyserSerialNo(user.getParameterInfo().getAnalyserSerialNo());
			parameterinfo.setDevidceIMEINo(user.getParameterInfo().getDevidceIMEINo());
			parameterinfo.setMeasurmentRange(user.getParameterInfo().getMeasurmentRange());
			parameterinfo.setMacId(user.getParameterInfo().getMacId());
			parameterinfo.setUnit(user.getParameterInfo().getUnit());
			parameterInfoRepository.save(parameterinfo);
			
		} catch (Exception e) {
		}
		return user;
	}


	

}
