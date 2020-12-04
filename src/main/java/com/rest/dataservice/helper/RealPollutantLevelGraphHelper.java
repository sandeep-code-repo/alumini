package com.rest.dataservice.helper;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RealPollutantLevelGraphHelper {
	
	 @DateTimeFormat(iso = ISO.DATE_TIME)
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	 public List<Date> labels;
	 public List<String> events;
	 public List<String> thresholdLevel; 
	 public List<String> aggregation;
	 
	public RealPollutantLevelGraphHelper() {
		super();
	}


	public RealPollutantLevelGraphHelper(List<Date> labels, List<String> events,
			List<String> thresholdLevel, List<String> aggregation) {
		super();
		this.labels = labels;
		this.events = events;
		this.thresholdLevel = thresholdLevel;
		this.aggregation = aggregation;
	}
	
	
	public List<Date> getLabels() {
		return labels;
	}
	public void setLabels(List<Date> labels) {
		this.labels = labels;
	}
	public List<String> getEvents() {
		return events;
	}
	public void setEvents(List<String> events) {
		this.events = events;
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
		return "RealPollutantLevelGraphHelper [recordedTime=" + labels + ", recordedLevel=" + events
				+ ", thresholdLevel=" + thresholdLevel + ", aggregation=" + aggregation + "]";
	}
	 
	 

}
