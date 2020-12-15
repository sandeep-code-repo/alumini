package com.rest.dataservice.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StationDateLevelGraphRequest {
	
	private String plantId;
	
	private String stationId;
	
	private String fromDate;
	
	private String toDate;
	
	private String frequency;
	
	private String parameter;
	
	@Override
	public String toString() {
		return "StationDateLevelGraphRequest [plantId=" + plantId + ", stationId=" + stationId + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", frequency=" + frequency + ", parameter=" + parameter + "]";
	}
	
	public StationDateLevelGraphRequest() {
		super();
	}

	public StationDateLevelGraphRequest(String plantId, String stationId, String fromDate, String toDate, String frequency,
			String parameter) {
		super();
		this.plantId = plantId;
		this.stationId = stationId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.frequency = frequency;
		this.parameter = parameter;
	}

	public String getPlantId() {
		return plantId;
	}

	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

}
