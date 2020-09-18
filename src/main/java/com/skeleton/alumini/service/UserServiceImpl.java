package com.skeleton.alumini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeleton.alumini.entity.User;
import com.skeleton.alumini.repository.UserRepository;

/**
 * @Jayashree
 * @Date-17/09/2020
 */

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public User findByUsername(String username,String password) {
		return userRepository.findByUsername(username,password);
	}

}
