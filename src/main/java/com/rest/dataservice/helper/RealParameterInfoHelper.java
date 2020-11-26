package com.rest.dataservice.helper;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RealParameterInfoHelper {

	private String parameter;
	
	private String unit;

	private String limit;

	private String range;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date recordedTime;

	private String recordedLevel;
	
	private String thresholdLevel;
	
	private String aggregation;
	
	private String stationName;
	
	private String analyzer;

	private Boolean parameterStatus;

	public RealParameterInfoHelper() {
		super();
	}

	public RealParameterInfoHelper(String parameter, String unit, String limit, String range, Date recordedTime,
			String recordedLevel, String thresholdLevel, String aggregation, String stationName, String analyzer,
			Boolean parameterStatus) {
		super();
		this.parameter = parameter;
		this.unit = unit;
		this.limit = limit;
		this.range = range;
		this.recordedTime = recordedTime;
		this.recordedLevel = recordedLevel;
		this.thresholdLevel = thresholdLevel;
		this.aggregation = aggregation;
		this.stationName = stationName;
		this.analyzer = analyzer;
		this.parameterStatus = parameterStatus;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public Date getRecordedTime() {
		return recordedTime;
	}

	public void setRecordedTime(Date recordedTime) {
		this.recordedTime = recordedTime;
	}

	public String getRecordedLevel() {
		return recordedLevel;
	}

	public void setRecordedLevel(String recordedLevel) {
		this.recordedLevel = recordedLevel;
	}

	public String getThresholdLevel() {
		return thresholdLevel;
	}

	public void setThresholdLevel(String thresholdLevel) {
		this.thresholdLevel = thresholdLevel;
	}

	public String getAggregation() {
		return aggregation;
	}

	public void setAggregation(String aggregation) {
		this.aggregation = aggregation;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(String analyzer) {
		this.analyzer = analyzer;
	}

	public Boolean getParameterStatus() {
		return parameterStatus;
	}

	public void setParameterStatus(Boolean parameterStatus) {
		this.parameterStatus = parameterStatus;
	}

	@Override
	public String toString() {
		return "RealParameterInfoHelper [parameter=" + parameter + ", unit=" + unit + ", limit=" + limit + ", range="
				+ range + ", recordedTime=" + recordedTime + ", recordedLevel=" + recordedLevel + ", thresholdLevel="
				+ thresholdLevel + ", aggregation=" + aggregation + ", stationName=" + stationName + ", analyzer="
				+ analyzer + ", parameterStatus=" + parameterStatus + "]";
	}

	
	
	
}
