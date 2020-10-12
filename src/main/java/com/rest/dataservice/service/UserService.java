package com.rest.dataservice.service;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.util.ResponseObject;
import com.rest.dataservice.entity.Role;
import com.rest.dataservice.entity.User;

/**
 * @Jayashree
 * @Date-17/09/2020
 */

public interface UserService {
	
	UserInfo findByUsername(String userName,String password);
	
	ResponseObject insertRole(Role role);
}
