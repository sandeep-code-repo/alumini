package com.skeleton.alumini.controller;

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

import com.skeleton.alumini.entity.UseInfo;
import com.skeleton.alumini.entity.User;
import com.skeleton.alumini.service.UserService;
import com.skeleton.alumini.util.CommonApiStatus;
import com.skeleton.alumini.util.ResponseObject;

/**
 * @author Jayashree
 *
 */


@RestController
@RequestMapping("/alumini")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    CommonApiStatus responseStatus;
	
	@PostMapping(value ="/login",produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseObject loginByUserName(@RequestBody UseInfo user)
	{
		userService.findByUsername(user.getUserName(),user.getPassword());
		
		//CommonApiStatus responseStatus=new CommonApiStatus("success",200,"message");
		return new ResponseObject(new CommonApiStatus("success",HttpStatus.OK,"success"));
	}
	

}
