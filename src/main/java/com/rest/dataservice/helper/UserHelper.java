package com.rest.dataservice.helper;

import java.util.List;

import com.rest.dataservice.entity.ParameterInfo;
import com.rest.dataservice.entity.PlantInfo;
import com.rest.dataservice.entity.StationInfo;

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
