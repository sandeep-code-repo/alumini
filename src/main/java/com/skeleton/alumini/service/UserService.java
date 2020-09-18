package com.skeleton.alumini.service;

import com.skeleton.alumini.entity.User;

/**
 * @Jayashree
 * @Date-17/09/2020
 */

public interface UserService {
	
	User findByUsername(String username,String password);
}
