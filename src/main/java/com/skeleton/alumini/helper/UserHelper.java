package com.skeleton.alumini.helper;

import com.skeleton.alumini.entity.ParameterInfo;
import com.skeleton.alumini.entity.PlantInfo;
import com.skeleton.alumini.entity.StationInfo;

public class UserHelper {

	
	private PlantInfo  plantInfo;
	private StationInfo  stationInfo;
	private ParameterInfo parameterInfo;
	private String userName;
	
	public PlantInfo getPlantInfo() {
		return plantInfo;
	}
	public void setPlantInfo(PlantInfo plantInfo) {
		this.plantInfo = plantInfo;
	}
	public StationInfo getStationInfo() {
		return stationInfo;
	}
	public void setStationInfo(StationInfo stationInfo) {
		this.stationInfo = stationInfo;
	}

	
	
	public ParameterInfo getParameterInfo() {
		return parameterInfo;
	}
	public void setParameterInfo(ParameterInfo parameterInfo) {
		this.parameterInfo = parameterInfo;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserHelper [plantInfo=" + plantInfo + ", stationInfo=" + stationInfo + ", parameterInfo="
				+ parameterInfo + ", userName=" + userName + "]";
	}
	
	
	
	
}
