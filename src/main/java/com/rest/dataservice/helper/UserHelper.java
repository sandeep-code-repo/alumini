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
	
	private List<StationInfoMapper>  stationInfoMapper;
	
	private UserInfoMapper userInfoMapper;
	
	private String regstatus;
	
	public PlantInfo getPlantInfo() {
		return plantInfo;
	}
	public void setPlantInfo(PlantInfo plantInfo) {
		this.plantInfo = plantInfo;
	}

	
	public List<StationInfoMapper> getStationInfoMapper() {
		return stationInfoMapper;
	}
	public void setStationInfoMapper(List<StationInfoMapper> stationInfoMapper) {
		this.stationInfoMapper = stationInfoMapper;
	}
	public UserInfoMapper getUserInfoMapper() {
		return userInfoMapper;
	}
	public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}
	public String getRegstatus() {
		return regstatus;
	}
	public void setRegstatus(String regstatus) {
		this.regstatus = regstatus;
	}
	
}
