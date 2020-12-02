package com.rest.dataservice.helper;

import java.util.List;

public class RealTimeStationParamMapper {
	
	 public List<RealParameterInfoHelper> emissionList;
	 public List<RealParameterInfoHelper> effluentList; 
	 public List<RealParameterInfoHelper> ambientList;
	 
	 public int emissionListSize;
	 public int effluentListSize; 
	 public int ambientListSize;
	 
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
	public int getEmissionListSize() {
		return emissionListSize;
	}
	public void setEmissionListSize(int emissionListSize) {
		this.emissionListSize = emissionListSize;
	}
	public int getEffluentListSize() {
		return effluentListSize;
	}
	public void setEffluentListSize(int effluentListSize) {
		this.effluentListSize = effluentListSize;
	}
	public int getAmbientListSize() {
		return ambientListSize;
	}
	public void setAmbientListSize(int ambientListSize) {
		this.ambientListSize = ambientListSize;
	}
	
}
