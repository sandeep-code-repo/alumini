package com.rest.dataservice.helper;

import java.util.List;

import com.rest.dataservice.entity.ParameterInfo;
import com.rest.dataservice.entity.StationInfo;

public class RealPollutantLevelHelper {
	
    private String plantName;
    
    private String industryCategory;
    
    private String city;
    
    private String district;
    
    private String state;
    
    private int countStation;
     
    private int countParameter;
	
	private List<RealParameterInfoHelper> realParameterInfo;

	public RealPollutantLevelHelper() {
		super();
	}

	public RealPollutantLevelHelper(String plantName, String industryCategory, String city, String district,
			String state, int countStation, int countParameter, List<RealParameterInfoHelper> realParameterInfo) {
		super();
		this.plantName = plantName;
		this.industryCategory = industryCategory;
		this.city = city;
		this.district = district;
		this.state = state;
		this.countStation = countStation;
		this.countParameter = countParameter;
		this.realParameterInfo = realParameterInfo;
	}

	@Override
	public String toString() {
		return "RealPollutantLevelHelper [plantName=" + plantName + ", industryCategory=" + industryCategory + ", city="
				+ city + ", district=" + district + ", state=" + state + ", countStation=" + countStation
				+ ", countParameter=" + countParameter + ", realParameterInfo=" + realParameterInfo + "]";
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getIndustryCategory() {
		return industryCategory;
	}

	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCountStation() {
		return countStation;
	}

	public void setCountStation(int countStation) {
		this.countStation = countStation;
	}

	public int getCountParameter() {
		return countParameter;
	}

	public void setCountParameter(int countParameter) {
		this.countParameter = countParameter;
	}

	public List<RealParameterInfoHelper> getRealParameterInfo() {
		return realParameterInfo;
	}

	public void setRealParameterInfo(List<RealParameterInfoHelper> realParameterInfo) {
		this.realParameterInfo = realParameterInfo;
	}
	
	

}
