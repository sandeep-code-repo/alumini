package com.rest.dataservice.helper;


import java.util.Date;
import java.util.List;



import com.rest.dataservice.entity.ParameterInfo;
import com.rest.dataservice.entity.StationInfo;

public class StationInfoMapper {

	/**
	 * @Jayashree
	 * @Date-29/09/2020
	 */

	private StationInfo stationInfo;
	
	private List<ParameterInfo> parameterInfo;

	/**
	 * @return the parameterInfo
	 */
	public List<ParameterInfo> getParameterInfo() {
		return parameterInfo;
	}

	/**
	 * @param parameterInfo the parameterInfo to set
	 */
	public void setParameterInfo(List<ParameterInfo> parameterInfo) {
		this.parameterInfo = parameterInfo;
	}

	public StationInfo getStationInfo() {
		return stationInfo;
	}

	public void setStationInfo(StationInfo stationInfo) {
		this.stationInfo = stationInfo;
	}

	


}
