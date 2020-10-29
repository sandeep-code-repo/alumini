package com.rest.dataservice.helper;

import java.util.List;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.entity.UserRole;

public class UserInfoMapper {
	
	private UserInfo userInfo;
	
	private List<UserRole> userRole;

	public List<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
