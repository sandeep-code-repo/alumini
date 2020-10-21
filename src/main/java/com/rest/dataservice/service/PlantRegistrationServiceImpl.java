package com.rest.dataservice.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.exception.ConstraintViolationException;
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
import com.rest.dataservice.helper.StationInfoMapper;
import com.rest.dataservice.helper.UserHelper;
import com.rest.dataservice.helper.UserInfoMapper;
import com.rest.dataservice.repository.PlantRegistrationRepository;
import com.rest.dataservice.repository.ParameterInfoRepository;
import com.rest.dataservice.repository.PlantInfoRepository;
import com.rest.dataservice.repository.StationInfoRepository;
import com.rest.dataservice.repository.UserRepository;
import com.rest.dataservice.repository.UserRoleRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.RSAKeyPairGenerator;
import com.rest.dataservice.util.ResponseObject;

@Service
public class PlantRegistrationServiceImpl implements PlantRegistrationService {

	private static final Logger logger = LoggerFactory.getLogger(PlantRegistrationServiceImpl.class);

	private static final String ERROR_IN_USER_REGISTRATION = "Error in User Registration";

	private static final String USER_REGISTERED_SUCCESSFULLY = "User Registered Successfully";

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

		try {

			UserHelper responseobj = new UserHelper();

			
			  PlantInfo checkRegStatus =plantInfoRepository.findSavedRegistration(user.getPlantInfo().getPlantUserName(),user.getPlantInfo().getEmail()); 
			  if(checkRegStatus == null) {
			 

			PlantInfo plantSaveResult = plantInfoRepository.save(user.getPlantInfo());

			if (plantSaveResult.getPlantUserName() != null) {

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
				userinfo.setCreatedDt(new Date());
				userinfo.setCreatedBy(plantSaveResult.getPlantUserName());
				/* if (user.getRegstatus().equalsIgnoreCase("Saved")) { */
				userinfo.setRegStatus(true);

				RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();
				userinfo.setRsaPrivateKey(
						Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded()));
				userinfo.setRsaPublicKey(
						Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded()));
				System.out.println(userinfo.getRsaPrivateKey());
				userRepository.save(userinfo);
			}

			user.getUserInfo().getUserRole().parallelStream().forEach(record -> {
				UserRole userRole = new UserRole();
				userRole.setPlantUserId(plantSaveResult.getPid());
				userRole.setRoleId(record.getRoleId() == null ? 1 : record.getRoleId());
				userRole.setUserRoleStatus(true);
				userRole.setCreatedDt(new Date());
				userRoleRepository.save(userRole);
			});

			if (plantSaveResult.getPlantUserName() != null) {

				user.getStationInfo().parallelStream().forEach(record -> {
					StationInfo stationinfo = new StationInfo();
					stationinfo.setPlantId(plantSaveResult.getPid());

					stationinfo.setStationId(record.getStationId());
					stationinfo.setAnalyzer(record.getAnalyzer());
					stationinfo.setAnalyzerv2(record.getAnalyzerv2());
					stationinfo.setShortName(record.getShortName());
					stationinfo.setLocation(record.getLocation());
					stationinfo.setInstallDt(record.getInstallDt());
					stationinfo.setToken(record.getToken());
					stationinfo.setMacNo(record.getMacNo());
					stationinfo.setStationNo(record.getStationNo());
					stationinfo.setStnType(record.getStnType());
					stationinfo.setHasThresold(record.getHasThresold());
					stationinfo.setPid(record.getPid());
					stationinfo.setStationVendor(record.getStationVendor());
					stationinfo.setCertification(record.getCertification());
					stationinfo.setLatitude(record.getLatitude());
					stationinfo.setLongitute(record.getLongitute());
					stationinfo.setMeasurementPrinciple(record.getMeasurementPrinciple());
					stationinfo.setStackHeight(record.getStackHeight());
					stationinfo.setStackDiameter(record.getStackDiameter());
					stationinfo.setStackVelocity(record.getStackVelocity());
					stationinfo.setGasDischargeRate(record.getGasDischargeRate());
					stationinfo.setRemarks(record.getRemarks());
					stationinfo.setCreatedDt(new Date());
					stationInfoRepository.save(stationinfo);

					user.getStationInfo().get(0).getParameterInfo().parallelStream().forEach(record1 -> {
						ParameterInfo param = new ParameterInfo();
						param.setSid(stationinfo.getSid());
						param.setParamter(record1.getParamter());
						param.setAnalyserMake(record1.getAnalyserMake());
						param.setAnalyserModel(record1.getAnalyserModel());
						param.setAnalyserSerialNo(record1.getAnalyserSerialNo());
						param.setDevidceIMEINo(record1.getDevidceIMEINo());
						param.setMacId(record1.getMacId());
						param.setMeasurmentMin(record1.getMeasurmentMin());
						param.setMeasurmentMax(record1.getMeasurmentMax());
						param.setUnit(record1.getUnit());
						parameterInfoRepository.save(param);
					});

				});
				PlantInfo plant = plantInfoRepository.getByPlantUser(plantSaveResult.getPlantUserName());

				responseobj.setPlantInfo(plant);

				UserInfo userinfo = userRepository.findByUser(plant.getPlantUserName());
				responseobj.setUserInfo(parseToMapperUserinfo(userinfo));

				List<StationInfo> stationinfo = stationInfoRepository.findByplantId(plant.getPid());
				responseobj.setStationInfo(parseToMapperObject(stationinfo));

			}

			CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS,
					HttpStatus.CREATED, ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
			return new ResponseObject(responseobj, SuccessApiStatus);
			 } 
			
			  else {
			  //logger.info("FOUND DUPLICATE USERNAME :: FOR :: "+user.getPlantInfo(). getPlantUserName());
			 
			  
			  CommonApiStatus failedApiStatus = new
			  CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
			  HttpStatus.ALREADY_REPORTED, ApplicationConstants.API_OVER_ALL_ERROR_STATUS);
			  return new ResponseObject("User Already Exist!", failedApiStatus); }
			 

		}
		

		catch (Exception e) {
			// logger.info("THROWING ERROR DUPLICATE USERNAME :: FOR :: " +
			// user.getPlantInfo().getPlantUserName());
			CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
					HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			return new ResponseObject("Errors in Registration page", failedApiStatus);
		}

	}

	@Override
	public ResponseObject findByUserName(UserHelper user) {

		PlantInfo plant1 = plantInfoRepository.getByPlantUser(user.getPlantUserName());

		user.setPlantInfo(plant1);

		if (plant1.getPlantUserName() != null) {
			UserInfo userinfo = userRepository.findByUser(plant1.getPlantUserName());

			user.setUserInfo(parseToMapperUserinfo(userinfo));
		}

		List<StationInfo> stationinfo = stationInfoRepository.findByplantId(plant1.getPid());

		user.setStationInfo(parseToMapperObject(stationinfo));

		CommonApiStatus SuccessApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS,
				HttpStatus.CREATED, ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		return new ResponseObject(user, SuccessApiStatus);
	}

	private UserInfoMapper parseToMapperUserinfo(UserInfo userinfo) {
		UserInfoMapper mapper = new UserInfoMapper();

		mapper.setUid(userinfo.getUid());
		mapper.setUserName(userinfo.getUserName());
		mapper.setPassword(userinfo.getPassword());

		mapper.setEmail(userinfo.getEmail());
		mapper.setDepartment(userinfo.getDepartment());
		mapper.setMobNo(userinfo.getMobNo());
		mapper.setUserType(userinfo.getUserType());
		mapper.setPlantType(userinfo.getPlantType());
		mapper.setCategory(userinfo.getCategory());
		mapper.setDesignation(userinfo.getDesignation());
		mapper.setReportto(userinfo.getReportto());
		mapper.setRegStatus(userinfo.getRegStatus());

		List<UserRole> userrole = userRoleRepository.FindByUserId(userinfo.getUid());
		mapper.setUserRole(userrole);

		return mapper;
	}

	private List<StationInfoMapper> parseToMapperObject(List<StationInfo> stations) {
		List<StationInfoMapper> mappers = new ArrayList<>();
		for (StationInfo station : stations) {
			StationInfoMapper stationMapper = new StationInfoMapper();
			stationMapper.setSid(station.getSid());
			stationMapper.setStationId(station.getStationId());
			stationMapper.setAnalyzer(station.getAnalyzer());
			stationMapper.setAnalyzerv2(station.getAnalyzerv2());
			stationMapper.setShortName(station.getShortName());
			stationMapper.setLocation(station.getLocation());
			stationMapper.setInstallDt(station.getInstallDt());
			stationMapper.setToken(station.getToken());
			stationMapper.setMacNo(station.getMacNo());
			stationMapper.setStationNo(station.getStationNo());
			stationMapper.setStnType(station.getStnType());
			stationMapper.setHasThresold(station.getHasThresold());
			stationMapper.setPid(station.getPid());
			stationMapper.setStationVendor(station.getStationVendor());
			stationMapper.setCertification(station.getCertification());
			stationMapper.setLatitude(station.getLatitude());
			stationMapper.setLongitute(station.getLongitute());
			stationMapper.setMeasurementPrinciple(station.getMeasurementPrinciple());
			stationMapper.setStackHeight(station.getStackHeight());
			stationMapper.setStackDiameter(station.getStackDiameter());
			stationMapper.setStackVelocity(station.getStackVelocity());
			stationMapper.setGasDischargeRate(station.getGasDischargeRate());
			stationMapper.setRemarks(station.getRemarks());

			// get setter

			// parameter info call to paramRepo = with sid will get a list set it into the
			// setter method
			List<ParameterInfo> paramId = parameterInfoRepository.findBySId(stationMapper.getSid());
			//System.out.println("jjjjjj" + paramId.get(0).getSid());
			stationMapper.setParameterInfo(paramId);

			mappers.add(stationMapper);
		}
		return mappers;

	}
}
	
	 

	