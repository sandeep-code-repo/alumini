package com.rest.dataservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.Role;
import com.rest.dataservice.service.MailService;
import com.rest.dataservice.service.UserService;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.RSAUtil;
import com.rest.dataservice.util.ResponseObject;

/**
 * @author Kamal
 *
 */


@RestController
public class UserController {

	private static final String APPLICATION_URL = "applicationUrl";

	private static final String BODY = "body";

	private static final String USER = "user";

	private static final String SUCCESS = "success";

	private static final String ACCOUNT_PASSWORD_HAS_BEEN_CHANGED_SUCCESSFULLY = "Account password has been changed successfully!";

	private static final String INTERNAL_SERVER_ERROR_PLEASE_CONTACT_SYSTEM_ADMINISTRATOR = "Internal Server error, Please contact System Administrator";

	private static final String EMAIL_DOESN_T_EXISTS = "Email doesn't exists";

	private static final String FAILED = "failed";

	private static final String LOGGED_IN_SUCCESSFULLY = " Logged in Successfully";

	private static final String INVALID_CREDENTIAL = "Invalid Credential";

	private static final String PASSWORD_CHANGED_SUCCESSFULLY = "Password changed successfully";

	private static final String INVALID_REQUEST = "Invalid Request";

	private static final String LINK_EXPIRED = "Link Expired";

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	@Autowired
	private SpringTemplateEngine templateEngine;

	@Value("${app.login.url}")
	String appUrl;


	public final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;

	CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
			ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);

	CommonApiStatus errorApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS, HttpStatus.INTERNAL_SERVER_ERROR,
			ApplicationConstants.API_OVER_ALL_ERROR_STATUS);

	@PostMapping(value ="/login",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject loginByUserName(@RequestBody UserInfo user) throws java.security.InvalidKeyException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, java.security.NoSuchAlgorithmException, javax.crypto.NoSuchPaddingException

	{		try {
		//String plainTextPass = RSAUtil.decrypt(user.getPassword(), userService.getUserPrivateKey(user.getUserName()));
		String plainTextPass = user.getPassword();
		UserInfo userInfo=userService.findByUsername(user.getUserName(),plainTextPass);
		return new ResponseObject(userInfo.getUserName()+LOGGED_IN_SUCCESSFULLY,successApiStatus);
	}catch(Exception e){
		return new ResponseObject(INVALID_CREDENTIAL,new CommonApiStatus(FAILED,HttpStatus.UNAUTHORIZED,e.getMessage()));
	}

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
				return new ResponseObject(EMAIL_DOESN_T_EXISTS,errorApiStatus);
			}
			return mailService.sendEmail(details); 
			//return new ResponseObject("Password saved and mail initiated",successApiStatus);
		}catch(Exception e){
			return new ResponseObject(e.getMessage(),errorApiStatus);
		}

	}

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

			UserInfo user = userService.getUserByEmail(dataArr[0]);
			Context context = new Context();
			Map<String, Object> model = new HashMap<>();
			model.put(USER, user);
			model.put(BODY,ACCOUNT_PASSWORD_HAS_BEEN_CHANGED_SUCCESSFULLY);
			model.put(APPLICATION_URL,appUrl);

			boolean moreThanDay = Math.abs(date1.getTime() - date2.getTime()) > MILLIS_PER_DAY;
			if(moreThanDay) {

				model.put(BODY,LINK_EXPIRED);
				context.setVariables(model);
				return templateEngine.process("change-pwd-error", context);
			}else if(user.getUserName()==null || user.getTempPassword()==null || user.getTempPassword().isEmpty() || !user.getUserName().equals(username)) {
				model.put(BODY,INVALID_REQUEST);
				context.setVariables(model);
				return templateEngine.process("change-pwd-error", context);
			}

			String reponse=userService.replaceTempPassword(user.getUserName());

			if(!reponse.equals(SUCCESS)) {
				model.put(BODY,INVALID_REQUEST);
				context.setVariables(model);
				return templateEngine.process("change-pwd-error", context);
			}

			context.setVariables(model);
			return templateEngine.process("change-pwd-success", context);

			//return PASSWORD_CHANGED_SUCCESSFULLY; 
		}catch(Exception e){
			Context context = new Context();
			Map<String, Object> model = new HashMap<>();
			UserInfo user = new UserInfo();
			user.setUserName(username);
			model.put(USER, user);
			model.put(BODY,INTERNAL_SERVER_ERROR_PLEASE_CONTACT_SYSTEM_ADMINISTRATOR);
			model.put("appUrl",appUrl);
			String errorHtml = templateEngine.process("change-pwd-error", context);
			return errorHtml;
		}
	}
	
	@GetMapping(value = "/seacrhByEmail")
	public ResponseObject seacrhByEmail(@RequestParam String email) throws IOException {
		try {
			

			UserInfo user = userService.getUserByEmail(email);
			return new ResponseObject(user,successApiStatus);
			
		}catch(Exception e){
			
			return new ResponseObject(e.getMessage(),errorApiStatus);
		}
			
	}

}



