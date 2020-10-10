package com.rest.dataservice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rest.dataservice.entity.UserAuth;
import com.rest.dataservice.entity.UserInfo;

/**
 * @Kamal
 * @Date-09/10/2020
 */


public interface UserService {
	
	public UserAuth findByUsername(String userName);

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

	public Object save(UserAuth user);
}
