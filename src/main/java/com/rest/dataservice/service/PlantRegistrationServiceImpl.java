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


	@Override
	@Transactional
	public ResponseObject insertPlantStationInfo(UserHelper user) {
		try {
			UserHelper responseobj = new UserHelper();
			Boolean checkRegStatus = false;
			List<StationInfoMapper>  stationInfoMapper;
			
			if(user.getRegstatus().equalsIgnoreCase("register")) {
			
				checkRegStatus=checkDuplicateEntry(user);
			}
			  if(!checkRegStatus) {
			 
				user.getUserInfoMapper().getUserInfo().setCreatedDt(new Date());
				user.getUserInfoMapper().getUserInfo().setCreatedBy(user.getUserInfoMapper().getUserInfo().getUserName());
				user.getUserInfoMapper().getUserInfo().setRegStatus(user.getUserInfoMapper().getUserInfo().getRegStatus() == null ? false : user.getUserInfoMapper().getUserInfo().getRegStatus());

				RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();
				user.getUserInfoMapper().getUserInfo().setRsaPrivateKey(
						Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded()));
				user.getUserInfoMapper().getUserInfo().setRsaPublicKey(
						Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded()));
				UserInfo userSaveResult=userRepository.save(user.getUserInfoMapper().getUserInfo());
				
				user.getUserInfoMapper().getUserRole().parallelStream().forEach(record -> {
					UserRole userRole = new UserRole();
					userRole.setPlantUserId(user.getUserInfoMapper().getUserInfo().getUid());
					userRole.setRoleId(record.getRoleId() == null ? 3 : record.getRoleId());
					userRole.setUserRoleStatus(true);
					userRole.setCreatedDt(new Date());
					userRoleRepository.save(userRole);
				});
				
				
				if (userSaveResult.getUserName() .equals(user.getUserInfoMapper().getUserInfo().getUserName())) {
					
				user.getPlantInfo().setUserId(user.getUserInfoMapper().getUserInfo().getUid());
				user.getPlantInfo().setCreatedDt(new Date());
				user.getPlantInfo().setCreatedBy(user.getUserInfoMapper().getUserInfo().getUserName());
				PlantInfo plantSaveResult = plantInfoRepository.save(user.getPlantInfo());	
				

				    user.getStationInfoMapper().parallelStream().forEach(record -> {
				    	record.getStationInfo().setPlantId(plantSaveResult.getPid());
				    	record.getStationInfo().setCreatedDt(new Date());
				    	record.getStationInfo().setCreatedBy(user.getUserInfoMapper().getUserInfo().getUserName());
				    	stationInfoRepository.save(record.getStationInfo());
				    	

					user.getStationInfoMapper().get(0).getParameterInfo().parallelStream().forEach(record1 -> {
						record1.setSid(record.getStationInfo().getSid());
						record1.setCreatedDt(new Date());
				    	record1.setCreatedBy(user.getUserInfoMapper().getUserInfo().getUserName());
						parameterInfoRepository.save(record1);
					});
					
					

				});

			}

			return findByUserName(userSaveResult);
			
			 }else {
			  
			  CommonApiStatus failedApiStatus = new
			  CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
			  HttpStatus.ALREADY_REPORTED, ApplicationConstants.API_OVER_ALL_ERROR_STATUS);
			  return new ResponseObject("User Already Exist!", failedApiStatus); }
			 
		}catch (ConstraintViolationException e) {
			CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
					HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			return new ResponseObject("User Already Exist!", failedApiStatus);
		}catch (Exception e) {
			CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
					HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			return new ResponseObject("Errors in Registration page", failedApiStatus);
		}

	}

	private Boolean checkDuplicateEntry(UserHelper user) {
		
		try {
		UserInfo infoName= userRepository.findByUsername(user.getUserInfoMapper().getUserInfo().getUserName());
		UserInfo infoEmail= userRepository.findUserByEmail(user.getUserInfoMapper().getUserInfo().getEmail());
		UserInfo infoMob= userRepository.getUserByMob(user.getUserInfoMapper().getUserInfo().getMobNo());
		
		if(infoName!=null || infoEmail!=null || infoMob!=null) {
			return true;
		}
		
		}catch(Exception e){
			return false;
		}
		
		
		return false;
	}

	@Override
	public ResponseObject findByUserName(UserInfo info) {

		try {
			
			CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS,
					HttpStatus.OK, ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
        UserHelper user = new UserHelper();

		if (info.getUserName() != null) {
			UserInfo userInfo = userRepository.findByUser(info.getUserName());

			if (userInfo == null) {
				CommonApiStatus errorApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
						HttpStatus.INTERNAL_SERVER_ERROR, "Invalid Username");
				return new ResponseObject("Please enter a valid username", errorApiStatus);
			}
			
			user.setUserInfoMapper(parseToMapperUserinfo(userInfo));
			
			
			PlantInfo plantInfo = plantInfoRepository.getByPlantUser(userInfo.getUid());
			
			if(plantInfo==null) {
				return new ResponseObject(user, successApiStatus);
			}
			user.setPlantInfo(plantInfo);
			
			List<StationInfo> stationinfo = stationInfoRepository.findByplantId(plantInfo.getPid());
			if(stationinfo==null) {
				return new ResponseObject(user, successApiStatus);
			}
			user.setStationInfoMapper(parseToMapperObject(stationinfo));
			
			return new ResponseObject(user, successApiStatus);
		}else {
			
			CommonApiStatus errorApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
					HttpStatus.INTERNAL_SERVER_ERROR, "Invalid Username");
			return new ResponseObject("Please enter a valid username", errorApiStatus);
			
		}
		
		}catch(Exception e){
			
			CommonApiStatus errorApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
					HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			return new ResponseObject("Failed to get user data", errorApiStatus);
			
		}
			
		
	}

	private UserInfoMapper parseToMapperUserinfo(UserInfo userinfo) {
		UserInfoMapper mapper = new UserInfoMapper();

		mapper.setUserInfo(userinfo);
		List<UserRole> userrole = userRoleRepository.FindByUserId(userinfo.getUid());
		mapper.setUserRole(userrole);

		return mapper;
	}

	private List<StationInfoMapper> parseToMapperObject(List<StationInfo> stations) {
		List<StationInfoMapper> mappers = new ArrayList<>();
		for (StationInfo station : stations) {
			StationInfoMapper stationMapper = new StationInfoMapper();
			
			stationMapper.setStationInfo(station);
			// get setter

			// parameter info call to paramRepo = with sid will get a list set it into the
			// setter method
			List<ParameterInfo> paramId = parameterInfoRepository.findBySId(station.getSid());
			stationMapper.setParameterInfo(paramId);

			mappers.add(stationMapper);
		}
		return mappers;

	}

	@Override
	public ResponseObject insertUserInfo(UserInfo user) {
		
	try {
		UserHelper helper = new UserHelper();
		Boolean checkRegStatus = false;
		UserInfoMapper mapper = new UserInfoMapper();
		mapper.setUserInfo(user);
		helper.setUserInfoMapper(mapper);
		
		if(user.getRegStatus()) {
			
			checkRegStatus=checkDuplicateEntry(helper);
		}
		  if(!checkRegStatus) {
		 
			  helper.getUserInfoMapper().getUserInfo().setCreatedDt(new Date());
			  helper.getUserInfoMapper().getUserInfo().setCreatedBy(helper.getUserInfoMapper().getUserInfo().getUserName());
			  helper.getUserInfoMapper().getUserInfo().setRegStatus(true);

			RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();
			helper.getUserInfoMapper().getUserInfo().setRsaPrivateKey(
					Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded()));
			helper.getUserInfoMapper().getUserInfo().setRsaPublicKey(
					Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded()));
			UserInfo userSaveResult=userRepository.save(helper.getUserInfoMapper().getUserInfo());
			
				UserRole userRole = new UserRole();
				userRole.setPlantUserId(helper.getUserInfoMapper().getUserInfo().getUid());
				userRole.setRoleId(3L); //for User role as default
				userRole.setUserRoleStatus(true);
				userRole.setCreatedDt(new Date());
				userRoleRepository.save(userRole);
		
		
		CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS,
				HttpStatus.CREATED, ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		user.setUid(userSaveResult.getUid());
		user.setRsaPublicKey(null);
		user.setRsaPrivateKey(null);
		return new ResponseObject(user, successApiStatus);
	}else {
		
		 CommonApiStatus failedApiStatus = new
				  CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
				  HttpStatus.ALREADY_REPORTED, ApplicationConstants.API_OVER_ALL_ERROR_STATUS);
				  return new ResponseObject("User Already Exist!", failedApiStatus);
	}
		  
	}catch (ConstraintViolationException e) {
		CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
				HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		return new ResponseObject("User Already Exist!", failedApiStatus);
	}catch (Exception e) {
		CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
				HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		return new ResponseObject("Errors in Registration page", failedApiStatus);
	}
 }

	@Override
	@Transactional
	public ResponseObject updatePlantStationInfo(UserHelper user) {
		try {
			UserHelper responseobj = new UserHelper();
			Boolean checkRegStatus = false;
			List<StationInfoMapper>  stationInfoMapper;
			CommonApiStatus failedApiStatus = new
					  CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
					  HttpStatus.ALREADY_REPORTED, ApplicationConstants.API_OVER_ALL_ERROR_STATUS);
			
			ResponseObject obj= findByUserName(user.getUserInfoMapper().getUserInfo());
			
			if(!obj.getData().toString().contains("UserHelper") ) {
				
				return new ResponseObject("Invalid User Details!", failedApiStatus); 
				
			} 
				
			  responseobj=(UserHelper) obj.getData();
			  
			  if(responseobj.getUserInfoMapper().getUserInfo().getUid()!=null) {
			 
				//user.getUserInfoMapper().setUserInfo(responseobj.getUserInfoMapper().getUserInfo());
						
				user.getUserInfoMapper().getUserInfo().setUid(responseobj.getUserInfoMapper().getUserInfo().getUid());
				user.getUserInfoMapper().getUserInfo().setLastModifiedDt(new Date());
				user.getUserInfoMapper().getUserInfo().setLastModifiedBy(user.getUserInfoMapper().getUserInfo().getUserName());
				user.getUserInfoMapper().getUserInfo().setRegStatus(user.getUserInfoMapper().getUserInfo().getRegStatus() == null ? false : user.getUserInfoMapper().getUserInfo().getRegStatus());

				UserInfo userSaveResult=userRepository.save(user.getUserInfoMapper().getUserInfo());
				
				if(user.getUserInfoMapper().getUserRole()!=null) {
					user.getUserInfoMapper().setUserRole(responseobj.getUserInfoMapper().getUserRole());
					user.getUserInfoMapper().getUserRole().parallelStream().forEach(record -> {
					UserRole userRole = new UserRole();
					userRole.setPlantUserId(user.getUserInfoMapper().getUserInfo().getUid());
					userRole.setRoleId(record.getRoleId() == null ? 3 : record.getRoleId());
					userRole.setUserRoleStatus(true);
					userRole.setModifiedDt(new Date());
					userRole.setModifiedBy(user.getUserInfoMapper().getUserInfo().getUserName());;
					userRoleRepository.save(userRole);
				});
				
				}
				
				
				if (user.getPlantInfo()!=null) {
					if(responseobj.getPlantInfo()!=null) {
						user.getPlantInfo().setPid(responseobj.getPlantInfo().getPid());
				}
				//user.getPlantInfo().setPid(responseobj.getPlantInfo().getPid());
				user.getPlantInfo().setUserId(user.getUserInfoMapper().getUserInfo().getUid());
				user.getPlantInfo().setLastModifiedDt(new Date());
				user.getPlantInfo().setLastModifiedBy(user.getUserInfoMapper().getUserInfo().getUserName());
 				PlantInfo plantSaveResult = plantInfoRepository.save(user.getPlantInfo());	
				
				if (user.getStationInfoMapper()!=null) {
					if(responseobj.getStationInfoMapper()!=null) {
						user.setStationInfoMapper(responseobj.getStationInfoMapper());
						}
					
				        user.getStationInfoMapper().parallelStream().forEach(record -> {
				    	record.getStationInfo().setPlantId(plantSaveResult.getPid());
				    	record.getStationInfo().setLastModifiedDt(new Date());
				    	record.getStationInfo().setLastModifiedBy(user.getUserInfoMapper().getUserInfo().getUserName());
				    	stationInfoRepository.save(record.getStationInfo());
				   if (user.getStationInfoMapper().get(0).getParameterInfo()!=null) { 	
					user.getStationInfoMapper().get(0).getParameterInfo().parallelStream().forEach(record1 -> {
						record1.setSid(record.getStationInfo().getSid());
						record1.setLastModifiedDt(new Date());
				    	record1.setLastModifiedBy(user.getUserInfoMapper().getUserInfo().getUserName());
						parameterInfoRepository.save(record1);
					});
				   }
					
					

				});
			 }

			}

			return findByUserName(userSaveResult);
			
			 }else {
			  
			  return new ResponseObject("Invalid User Details!", failedApiStatus); }
			 
		}catch (ConstraintViolationException e) {
			CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
					HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			return new ResponseObject("Invalid User Details!", failedApiStatus);
		}catch (Exception e) {
			CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
					HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			return new ResponseObject("Errors in Update user data", failedApiStatus);
		}
	}
	
}
	
	 

	