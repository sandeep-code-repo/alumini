package com.skeleton.alumini.helper;

import java.util.List;

import com.skeleton.alumini.entity.ParameterInfo;
import com.skeleton.alumini.entity.PlantInfo;
import com.skeleton.alumini.entity.StationInfo;

public class UserHelper {

	
	private PlantInfo  plantInfo;
	private StationInfoMapper  stationInfo;
	//private List<ParameterInfo> parameterInfo;
	private String userName;
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

	/*
	 * public List<ParameterInfo> getParameterInfo() { return parameterInfo; }
	 * public void setParameterInfo(List<ParameterInfo> parameterInfo) {
	 * this.parameterInfo = parameterInfo; }
	 */
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserHelper [plantInfo=" + plantInfo + ", stationInfo=" + stationInfo +", userName=" + userName + "]";
	}
	
	
	
	
}
