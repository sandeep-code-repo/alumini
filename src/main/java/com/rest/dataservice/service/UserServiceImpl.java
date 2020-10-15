package com.rest.dataservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.Role;
import com.rest.dataservice.entity.User;
import com.rest.dataservice.repository.RoleRepository;
import com.rest.dataservice.repository.UserRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

/**
 * @Jayashree
 * @Date-17/09/2020
 */

@Service
public class UserServiceImpl implements UserService{
	
	private static CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
			ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

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
	
    public ResponseObject getUserPublicKey(String userName) {
		
    	String publicKey = userRepository.findPublicKeyByUsername(userName);
    	System.out.println(publicKey);
    	return new ResponseObject(publicKey, successApiStatus);
     }
    
    public String getUserPrivateKey(String userName) {
    	
    	return userRepository.findPrivateKeyByUsername(userName);
    	
    }

}
