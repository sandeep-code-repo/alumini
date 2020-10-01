package com.skeleton.alumini.helper;

import com.skeleton.alumini.entity.PlantInfo;
import com.skeleton.alumini.entity.StationInfo;

public class UserHelper {

	
	private PlantInfo  plantInfo;
	private StationInfo  stationInfo;
	private String userId;
	
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
	@Override
	public String toString() {
		return "UserHelper [plantInfo=" + plantInfo + ", stationInfo=" + stationInfo + ", useId=" + userId + "]";
	}
	
	
	
}
