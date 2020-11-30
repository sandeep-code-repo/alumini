package com.rest.dataservice.helper;

import java.util.List;

public class RealTimeStationParamMapper {
	
	 public List<RealParameterInfoHelper> emissionList;
	 public List<RealParameterInfoHelper> effluentList; 
	 public List<RealParameterInfoHelper> ambientList;
	 
	public List<RealParameterInfoHelper> getEmissionList() {
		return emissionList;
	}
	public void setEmissionList(List<RealParameterInfoHelper> emissionList) {
		this.emissionList = emissionList;
	}
	public List<RealParameterInfoHelper> getEffluentList() {
		return effluentList;
	}
	public void setEffluentList(List<RealParameterInfoHelper> effluentList) {
		this.effluentList = effluentList;
	}
	public List<RealParameterInfoHelper> getAmbientList() {
		return ambientList;
	}
	public void setAmbientList(List<RealParameterInfoHelper> ambientList) {
		this.ambientList = ambientList;
	}
	 
	 

}
