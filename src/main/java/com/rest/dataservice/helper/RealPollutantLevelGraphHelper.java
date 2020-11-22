package com.rest.dataservice.helper;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RealPollutantLevelGraphHelper {
	
	 @DateTimeFormat(iso = ISO.DATE_TIME)
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	 public List<Date> recordedTime;
	 public List<String> recordedLevel;
	 public List<String> thresholdLevel;
	 public List<String> aggregation;
	 
	public RealPollutantLevelGraphHelper() {
		super();
	}


	public RealPollutantLevelGraphHelper(List<Date> recordedTime, List<String> recordedLevel,
			List<String> thresholdLevel, List<String> aggregation) {
		super();
		this.recordedTime = recordedTime;
		this.recordedLevel = recordedLevel;
		this.thresholdLevel = thresholdLevel;
		this.aggregation = aggregation;
	}
	
	
	public List<Date> getRecordedTime() {
		return recordedTime;
	}
	public void setRecordedTime(List<Date> recordedTime) {
		this.recordedTime = recordedTime;
	}
	public List<String> getRecordedLevel() {
		return recordedLevel;
	}
	public void setRecordedLevel(List<String> recordedLevel) {
		this.recordedLevel = recordedLevel;
	}
	public List<String> getThresholdLevel() {
		return thresholdLevel;
	}
	public void setThresholdLevel(List<String> thresholdLevel) {
		this.thresholdLevel = thresholdLevel;
	}
	public List<String> getAggregation() {
		return aggregation;
	}
	public void setAggregation(List<String> aggregation) {
		this.aggregation = aggregation;
	}
	
	@Override
	public String toString() {
		return "RealPollutantLevelGraphHelper [recordedTime=" + recordedTime + ", recordedLevel=" + recordedLevel
				+ ", thresholdLevel=" + thresholdLevel + ", aggregation=" + aggregation + "]";
	}
	 
	 

}
