package com.rest.dataservice.helper;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkflowHelper {
	
	private String city;
	private String stationType;
	private String stationName;
	private String lastActedBy;
	private String visibility;
	private String status;
	private String event;
	private String siteName;
	private String siteCategory;
	private String assignedTo;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date timeToRespond;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date timeToAction;
	private String description;
	private Boolean sendCopy;
	
	
	

	@Override
	public String toString() {
		return "WorkflowHelper [city=" + city + ", stationType=" + stationType + ", stationName=" + stationName
				+ ", lastActedBy=" + lastActedBy + ", visibility=" + visibility + ", status=" + status + ", event="
				+ event + ", siteName=" + siteName + ", siteCategory=" + siteCategory + ", assignedTo=" + assignedTo
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", timeToRespond=" + timeToRespond
				+ ", timeToAction=" + timeToAction + ", description=" + description + ", sendCopy=" + sendCopy + "]";
	}

	public WorkflowHelper() {
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getLastActedBy() {
		return lastActedBy;
	}

	public void setLastActedBy(String lastActedBy) {
		this.lastActedBy = lastActedBy;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteCategory() {
		return siteCategory;
	}

	public void setSiteCategory(String siteCategory) {
		this.siteCategory = siteCategory;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getTimeToRespond() {
		return timeToRespond;
	}

	public void setTimeToRespond(Date timeToRespond) {
		this.timeToRespond = timeToRespond;
	}

	public Date getTimeToAction() {
		return timeToAction;
	}

	public void setTimeToAction(Date timeToAction) {
		this.timeToAction = timeToAction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getSendCopy() {
		return sendCopy;
	}

	public void setSendCopy(Boolean sendCopy) {
		this.sendCopy = sendCopy;
	}


}
