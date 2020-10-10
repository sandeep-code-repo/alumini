package com.rest.dataservice.helper;

import com.rest.dataservice.entity.ParameterInfo;
import com.rest.dataservice.entity.PlantInfo;
import com.rest.dataservice.entity.StationInfo;

public class UserHelper {

	
	private PlantInfo  plantInfo;
	private StationInfo  stationInfo;
	private String userId;
	private ParameterInfo parameterInfo;
	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String useId) {
		this.userId = useId;
	}
	
	
	public ParameterInfo getParameterInfo() {
		return parameterInfo;
	}
	public void setParameterInfo(ParameterInfo parameterInfo) {
		this.parameterInfo = parameterInfo;
	}
	@Override
	public String toString() {
		return "UserHelper [plantInfo=" + plantInfo + ", stationInfo=" + stationInfo + ", useId=" + userId + "]";
	}
	
	
	
}
