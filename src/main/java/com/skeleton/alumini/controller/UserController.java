package com.skeleton.alumini.controller;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skeleton.alumini.entity.User;
import com.skeleton.alumini.service.UserService;

/**
 * @author Jayashree
 *
 */


@RestController
@RequestMapping("/alumini")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value ="/login",produces = MediaType.APPLICATION_JSON_VALUE)
	
	public String loginByUserName(@RequestParam("username")String username,@RequestParam("password")String password)
	{
		User user = userService.findByUsername(username,password);
		return "success";
	}
	

}
