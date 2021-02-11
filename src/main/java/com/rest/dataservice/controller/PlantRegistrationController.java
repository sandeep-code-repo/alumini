package com.rest.dataservice.controller;
import org.springframework.http.MediaType;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.Employee;
import com.rest.dataservice.entity.PlantInfo;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.helper.StationInfoMapper;
import com.rest.dataservice.helper.UserHelper;
import com.rest.dataservice.helper.UserInfoMapper;
import com.rest.dataservice.service.ExcelService;
import com.rest.dataservice.service.PlantRegistrationService;
import com.rest.dataservice.service.RealPollutantLevelService;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ExcelUtil;
import com.rest.dataservice.util.ResponseObject;

@RestController
public class PlantRegistrationController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PlantRegistrationController.class);
	
	private static final String PLEASE_UPLOAD_AN_EXCEL_FILE = "Please upload an excel file!";

	private static final String COULD_NOT_UPLOAD_THE_FILE = "Could not upload the file: ";

	private static final String UPLOADED_THE_FILE_SUCCESSFULLY = "Uploaded the file successfully: ";
	
	CommonApiStatus failedApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS,
			  HttpStatus.EXPECTATION_FAILED, "failed");
	
	CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS,
			  HttpStatus.OK, "Success");
	
	@Autowired
	private PlantRegistrationService registrationService;
	
	@Autowired
	private RealPollutantLevelService realPollutantLevelService;
	
	@Autowired
	ExcelService excelService;
	
	/**
	 * 
	 * @param Plant
	 * @return
	 * @description
	 * insert Plant details
	 */
	
	@PostMapping("/register")
	public ResponseObject insertEmployeeData(@RequestBody UserHelper plantRegistration) {
		
			ResponseObject entity = registrationService.insertPlantStationInfo(plantRegistration);
    	
		//logger.info("REQUEST RECV : " + plantRegistration);
			    		
	    return entity;
	}
	
	/**
	 * 
	 * @param Plant
	 * @return
	 * @description
	 * insert Plant details
	 */
	
	@PutMapping("/updateUser")
	public ResponseObject updateEmployeeData(@RequestBody UserHelper plantRegistration) {
		
			ResponseObject entity = registrationService.updatePlantStationInfo(plantRegistration);
    	
		//logger.info("Inside Method  updateEmployeeData" + plantRegistration);
			    		
	    return entity;
	}
	
	@PostMapping("/getPlantDetails")
	 public ResponseObject getUserByName(@RequestBody UserInfo info) {
	 
		ResponseObject entity = registrationService.findByUserName(info); 
	 
	 return entity;
	 }
	
	@GetMapping("/getAllPlants")
	 public ResponseObject getUserByName(@RequestParam(defaultValue = "All") String category) {
	 
		ResponseObject entity = registrationService.findByCategory(category); 
	 
	 return entity;
	 }
	
	@GetMapping("/getPrameterFromStation")
	 public ResponseObject getPrameterFromStation(@RequestParam String plantId,@RequestParam String stnType) {
	 
		ResponseObject entity = registrationService.getParamDataFromStation(plantId,stnType);
	 
	 return entity;
	 }
	
	 /**
	 * @param file
	 * @return ResponseEntity
	 */
	@PostMapping("/saveExcelRegistration")
	  public ResponseObject uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (ExcelUtil.hasExcelFormat(file)) {
	      try {
	    	  UserHelper userHelper = new UserHelper();
	        UserInfo userInfo= excelService.store(file);
	        userInfo.setRegStatus(true);
	        ResponseObject entity = registrationService.insertUserInfo(userInfo);
	        return entity;
			/*
			 * message = UPLOADED_THE_FILE_SUCCESSFULLY + file.getOriginalFilename(); return
			 * new ResponseObject(entity, successApiStatus);
			 */
	      } catch (Exception e) {
	    	  
	    	  message = COULD_NOT_UPLOAD_THE_FILE + file.getOriginalFilename() + "!";
	    	  failedApiStatus.setMessage(e.getMessage());
			  return new ResponseObject(message, failedApiStatus);
	        
	      }
	    }

	    message = PLEASE_UPLOAD_AN_EXCEL_FILE;
	    failedApiStatus.setStatusCode(HttpStatus.BAD_REQUEST);
	    return new ResponseObject(message, failedApiStatus);
	  }
}
	
	
	/*
	 * @PostMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<?> test(@RequestBody UserHelper emp) {
	 * 
	 * logger.info("REQUEST RECV : " + emp); return new
	 * ResponseEntity<UserHelper>(emp, new HttpHeaders(), HttpStatus.CREATED); }
	 */
	
	
	/**
	 * 
	 * @param employee
	 * @return
	 * @description
	 * Update employee By Employee Id
	 */
	
	/*
	 * @PutMapping(value ="/{iName}", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<?> editEmployeeData(@RequestBody Employee
	 * emp,@PathVariable("iName") String iName) {
	 * 
	 * Employee entity = employeeService.editByEname(iName,emp);
	 * 
	 * return new ResponseEntity<Employee>(entity, new HttpHeaders(),
	 * HttpStatus.OK); }
	 */
	

	/**
	 * 
	 * @param employee
	 * @return
	 * @description
	 * Get employee By Employee Name
	 */
	
	/*
	 * @GetMapping(value ="/{iName}", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<?> getEmpByName(@PathVariable("iName") String iName) {
	 * 
	 * Employee entity = employeeService.findEmpByName(iName); return new
	 * ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK); }
	 */
	
	/**
	 * 
	 * @param employee
	 * @return
	 * @description
	 * Get employee By Employee details
	 */
	/*
	 * @GetMapping(value ="/", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public @ResponseBody ResponseEntity<?> getEmpDetails() {
	 * 
	 * List<Employee> entity = employeeService.getEmployeeList(); return new
	 * ResponseEntity<Object>(entity, HttpStatus.OK); }
	 */
	
	/**
	 * Delete employee By Employee Name
	 */
	
	/*
	 * @DeleteMapping(value ="/{iName}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<?>
	 * deleteUser(@PathVariable("iName") String iName){
	 * 
	 * String Status="INACTIVE"; Employee result =
	 * employeeService.deleteUser(iName,Status); return new
	 * ResponseEntity<Object>(result, HttpStatus.OK); }
	 */
	
	
	

