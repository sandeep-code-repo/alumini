package com.rest.dataservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.entity.User;
import com.rest.dataservice.service.UserService;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

/**
 * @author Jayashree
 *
 */


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
    CommonApiStatus responseStatus;
	
	@PostMapping(value ="/login",produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseObject loginByUserName(@RequestBody UserInfo user)
	{
		if(user.getUserName().equals("hindalco") && user.getPassword().equals("hindalco@123")) {
			userService.findByUsername(user.getUserName(),user.getPassword());
			return new ResponseObject("User Logged in Successfully",new CommonApiStatus("success",HttpStatus.OK,"success"));
			}else
				return new ResponseObject("Invalid user",new CommonApiStatus("failed",HttpStatus.UNAUTHORIZED,"This is not a valid credential"));
		}
		
	}
	


