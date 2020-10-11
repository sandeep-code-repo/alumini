package com.rest.dataservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.entity.User;
import com.rest.dataservice.repository.UserRepository;

/**
 * @Jayashree
 * @Date-17/09/2020
 */

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public UserInfo findByUsername(String userName,String password) {
		return userRepository.findByUsername(userName,password);
	}

}
