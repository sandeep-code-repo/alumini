package com.rest.dataservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.rsocket.server.RSocketServer.Transport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.Role;
import com.rest.dataservice.entity.User;
import com.rest.dataservice.service.MailService;
import com.rest.dataservice.service.UserService;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.RSAUtil;
import com.rest.dataservice.util.ResponseObject;

/**
 * @author Jayashree
 *
 */


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;

	CommonApiStatus responseStatus;
	
	public final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
	
	CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
			ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
	
	CommonApiStatus errorApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS, HttpStatus.INTERNAL_SERVER_ERROR,
			ApplicationConstants.API_OVER_ALL_ERROR_STATUS);
	
	@PostMapping(value ="/login",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject loginByUserName(@RequestBody UserInfo user) throws java.security.InvalidKeyException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, java.security.NoSuchAlgorithmException, javax.crypto.NoSuchPaddingException
	
	{		
		//String plainTextPass = RSAUtil.decrypt(user.getPassword(), userService.getUserPrivateKey(user.getUserName()));
		  String plainTextPass = user.getPassword();
		if(user.getUserName().equals("hindalco") && plainTextPass.equals("hindalco@123")) {
			userService.findByUsername(user.getUserName(),plainTextPass);
			return new ResponseObject("User Logged in Successfully",new CommonApiStatus("success",HttpStatus.OK,"success"));
		}else
			return new ResponseObject("Invalid user",new CommonApiStatus("failed",HttpStatus.UNAUTHORIZED,"This is not a valid credential"));
	}
	
	
	
	/**
	 * 
	 * @param Role
	 * @return
	 * @description
	 * insert role name
	 */

	@PostMapping("/addRole")
	public ResponseObject insertEmployeeData(@RequestBody Role role) {
		
		ResponseObject entity = userService.insertRole(role);	   
	    return entity;
	}
	

	@PostMapping("/getPublicKey")
	public ResponseObject getPublicKey(@RequestBody UserInfo user) {
		
		String data = userService.getUserPublicKey(user.getUserName());
		
	    return new ResponseObject(data,successApiStatus);
	}
	
	@PostMapping(value = "/savePassword")
	public ResponseObject saveTempPassword(@RequestBody UserInfo userInfo) throws IOException {
		try {
		UserInfo details=userService.saveTempPassword(userInfo.getEmail(),userInfo.getTempPassword());
	    if(details.getUserName()==null || details.getUserName().isEmpty()) {
	    	return new ResponseObject("Email doesn't exists",errorApiStatus);
	    }
		//return mailService.sendEmail(details); 
	    return new ResponseObject("Password saved and mail initiated",successApiStatus);
		}catch(Exception e){
			return new ResponseObject(e.getMessage(),errorApiStatus);
			}
		
	}
	
	/*
	 * @RequestMapping(value = "/sendemail") public String sendEmail(UserInfo
	 * userInfo) throws IOException {
	 * 
	 * UserInfo userInfo= new UserInfo(); userInfo.setUserName("DemoUser");
	 * userInfo.setEmail("k.ksamal366@gmail.com");
	 * 
	 * mailService.sendEmail(userInfo); return "Email sent successfully"; }
	 */
	
	@GetMapping(value = "/reset-password")
	public String resetPassword(@RequestParam String fields,@RequestParam String username) throws IOException {
		try {
			String replaceString=null;
			if(fields!=null || fields!="") {
				replaceString=fields.replaceAll("\\s","+");
			}
		String plainTextData = RSAUtil.decrypt(replaceString, userService.getUserPrivateKey(username));
		String[] dataArr=plainTextData.split(",");
		
		String dateString= dataArr[1];
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ApplicationConstants.DATE_TIME_FORMATTER);  
        LocalDateTime now = LocalDateTime.now();  
        String currenDate=dtf.format(now);
        
        SimpleDateFormat sdf = new SimpleDateFormat(ApplicationConstants.DATE_TIME_FORMATTER);
        Date date1 = sdf.parse(dateString);
        Date date2 = sdf.parse(currenDate);

        boolean moreThanDay = Math.abs(date1.getTime() - date2.getTime()) > MILLIS_PER_DAY;
        if(moreThanDay) {
        	return "Link Expired";
        }
        
        UserInfo info = userService.getUserByEmail(dataArr[0]);
        
        if(info.getUserName()==null || info.getTempPassword()==null || info.getTempPassword().isEmpty() || !info.getUserName().equals(username)) {
        	return "Invalid Request";
        }
        
        String reponse=userService.replaceTempPassword(info.getUserName());
        if(!reponse.equals("success")) {
        	return "Invalid Request";
        }
	    return "Password changed successfully"; 
		}catch(Exception e){
			 return e.getMessage();
		}
	}
	
}



