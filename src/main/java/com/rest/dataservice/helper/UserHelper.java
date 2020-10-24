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
	private List<StationInfoMapper>  stationInfo;
	
	
	private UserInfoMapper userInfo;
	
	private String regstatus;
	
	public PlantInfo getPlantInfo() {
		return plantInfo;
	}
	public void setPlantInfo(PlantInfo plantInfo) {
		this.plantInfo = plantInfo;
	}

	
	public List<StationInfoMapper> getStationInfo() {
		return stationInfo;
	}
	public void setStationInfo(List<StationInfoMapper> stationInfo) {
		this.stationInfo = stationInfo;
	}
	public UserInfoMapper getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoMapper userInfo) {
		this.userInfo = userInfo;
	}
	public String getRegstatus() {
		return regstatus;
	}
	public void setRegstatus(String regstatus) {
		this.regstatus = regstatus;
	}
	
}
