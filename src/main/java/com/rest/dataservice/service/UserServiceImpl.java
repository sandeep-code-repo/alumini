package com.rest.dataservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.dataservice.entity.User;
import com.rest.dataservice.entity.UserAuth;
import com.rest.dataservice.repository.UserRepository;

/**
 * @Kamal
 * @Date-09/10/2020
 */

@Service
public class UserServiceImpl implements UserService,UserDetailsService{
	
	private static final String USER_NOT_FOUND_WITH_USERNAME = "User not found with username: ";

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

	public static final String VALID = "valid";

	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	
	/**
	 * fin user by username
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAuth user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(USER_NOT_FOUND_WITH_USERNAME + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	/**
	 * Save User Auth data
	 */
	public UserAuth save(UserAuth user) {
		UserAuth newUser = new UserAuth();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(newUser);
	}

	/**
	 *find profile by username
	 */
	@Override
	public UserAuth findByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}


}
