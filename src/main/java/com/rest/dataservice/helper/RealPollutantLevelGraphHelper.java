package com.rest.dataservice.helper;

import java.util.List;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RealPollutantLevelGraphHelper {
	
	 @DateTimeFormat(iso = ISO.DATE_TIME)
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	 public List<String> labels;
	 public List<String> events;
	 public List<String> thresholdLevel; 
	 public List<String> aggregation;
	 public String parameter;
	 
	public RealPollutantLevelGraphHelper() {
		super();
	}


	public RealPollutantLevelGraphHelper(List<String> labels, List<String> events,
			List<String> thresholdLevel, List<String> aggregation, String parameter) {
		super();
		this.labels = labels;
		this.events = events;
		this.thresholdLevel = thresholdLevel;
		this.aggregation = aggregation;
		this.parameter = parameter;
	}
	
	
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
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
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}


	@Override
	public String toString() {
		return "RealPollutantLevelGraphHelper [labels=" + labels + ", events=" + events + ", thresholdLevel="
				+ thresholdLevel + ", aggregation=" + aggregation + ", parameter=" + parameter + "]";
	}
	
}
