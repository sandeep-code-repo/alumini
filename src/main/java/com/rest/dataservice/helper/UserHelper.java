package com.rest.dataservice.helper;

import java.util.List;

import com.rest.dataservice.entity.ParameterInfo;
import com.rest.dataservice.entity.PlantInfo;
import com.rest.dataservice.entity.Role;
import com.rest.dataservice.entity.StationInfo;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.entity.UserRole;

public class UserHelper {

	
	private PlantInfo  plantInfo;
	private StationInfoMapper  stationInfo;
	
	private UserInfoMapper userInfo;
	
	public PlantInfo getPlantInfo() {
		return plantInfo;
	}
	public void setPlantInfo(PlantInfo plantInfo) {
		this.plantInfo = plantInfo;
	}
	public StationInfoMapper getStationInfo() {
		return stationInfo;
	}
	public void setStationInfo(StationInfoMapper stationInfo) {
		this.stationInfo = stationInfo;
	}

	public UserInfoMapper getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoMapper userInfo) {
		this.userInfo = userInfo;
	}
	
	
	
	
	
	
	
	
	
}
