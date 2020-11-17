package com.rest.dataservice.helper;

import java.util.List;

import com.rest.dataservice.entity.ParameterInfo;
import com.rest.dataservice.entity.StationInfo;

public class RealPollutantLevelHelper {
	
    private String plantName;
    
    private String regionalOffice;
    
    private String industryCategory;
    
    private String state;
    
    private String city;
    
    private String countStation;
     
    private String countParameter;
	
	private List<RealParameterInfoHelper> realParameterInfo;
	
	

	public RealPollutantLevelHelper() {
		super();
	}

	public RealPollutantLevelHelper(String plantName, String regionalOffice, String industryCategory, String state,
			String city, String countStation, String countParameter, List<RealParameterInfoHelper> realParameterInfo) {
		super();
		this.plantName = plantName;
		this.regionalOffice = regionalOffice;
		this.industryCategory = industryCategory;
		this.state = state;
		this.city = city;
		this.countStation = countStation;
		this.countParameter = countParameter;
		this.realParameterInfo = realParameterInfo;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getRegionalOffice() {
		return regionalOffice;
	}

	public void setRegionalOffice(String regionalOffice) {
		this.regionalOffice = regionalOffice;
	}

	public String getIndustryCategory() {
		return industryCategory;
	}

	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountStation() {
		return countStation;
	}

	public void setCountStation(String countStation) {
		this.countStation = countStation;
	}

	public String getCountParameter() {
		return countParameter;
	}

	public void setCountParameter(String countParameter) {
		this.countParameter = countParameter;
	}

	public List<RealParameterInfoHelper> getRealParameterInfo() {
		return realParameterInfo;
	}

	public void setRealParameterInfo(List<RealParameterInfoHelper> realParameterInfo) {
		this.realParameterInfo = realParameterInfo;
	}

	@Override
	public String toString() {
		return "RealPollutantLevelHelper [plantName=" + plantName + ", regionalOffice=" + regionalOffice
				+ ", industryCategory=" + industryCategory + ", state=" + state + ", city=" + city + ", countStation="
				+ countStation + ", countParameter=" + countParameter + ", realParameterInfo=" + realParameterInfo
				+ "]";
	}
	
	

}
