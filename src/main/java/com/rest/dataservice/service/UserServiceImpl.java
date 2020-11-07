package com.rest.dataservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.Role;
import com.rest.dataservice.repository.RoleRepository;
import com.rest.dataservice.repository.UserRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

/**
 * @Jayashree
 * @Date-17/09/2020
 */

@Service
public class UserServiceImpl implements UserService,UserDetailsService{

	private static CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
			ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	private static final String USER_NOT_FOUND_WITH_USERNAME = "User not found with username: ";


	/**
	 * fin user by username
	 */

	@Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		UserInfo user =userRepository.findByUsername(username); if (user == null) { throw new UsernameNotFoundException(USER_NOT_FOUND_WITH_USERNAME + username); } 
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(), new ArrayList<>());  
		}

	@Override
	public UserInfo findByUsername(String userName,String password) {
		return userRepository.findByUsername(userName,password);
	}

	@Override
	public ResponseObject insertRole(Role role) {

		Role rName= roleRepository.save(role);
		ResponseObject res = new ResponseObject(rName, successApiStatus);
		return res;
	}

	public String getUserPublicKey(String userName) {

		String publicKey = userRepository.findPublicKeyByUsername(userName);
		//System.out.println(publicKey);
		return publicKey;
	}

	public String getUserPrivateKey(String userName) {

		return userRepository.findPrivateKeyByUsername(userName);

	}

	@Override
	public UserInfo getUserByEmail(String email) {

		return userRepository.findUserByEmail(email);
	}

	@Override
	public UserInfo saveTempPassword(String email,String tempPwd) {
		try {
			UserInfo editUser = getUserByEmail(email);
			editUser.setTempPassword(tempPwd);
			userRepository.save(editUser);

			return editUser;
		}catch(Exception e){
			return new UserInfo();
		}
	}

	@Override
	public String replaceTempPassword(String userName) {

		UserInfo editUser = userRepository.findByUsername(userName);

		editUser.setPassword(editUser.getTempPassword());
		editUser.setTempPassword(null);

		userRepository.save(editUser);

		if(userRepository.findByUsername(userName).getTempPassword()!=null) {
			return "error";
		}
		return "success";
	}

}
