package com.rest.dataservice.service;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.util.ResponseObject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rest.dataservice.entity.Role;
import com.rest.dataservice.entity.User;

/**
 * @Kamal
 * @Date-17/09/2020
 */

public interface UserService {
	
	UserInfo findByUsername(String userName,String password);
	
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
	ResponseObject insertRole(Role role);
	
	String getUserPublicKey(String userName);
	
	String getUserPrivateKey(String userName);

	UserInfo getUserByEmail(String email);

	String replaceTempPassword(String userName);

	UserInfo saveTempPassword(String email, String tempPwd);
}
