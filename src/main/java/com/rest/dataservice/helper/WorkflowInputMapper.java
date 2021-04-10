package com.rest.dataservice.helper;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkflowInputMapper {
	
	private String plantId;
	private String status;
	private String siteName;
	private String siteCategory;
	private String assignedTo;
	private String fromDate;
	private String toDate;
	
	@Override
	public String toString() {
		return "WorkflowInputMapper [plantId=" + plantId + ", status=" + status + ", siteName=" + siteName
				+ ", siteCategory=" + siteCategory + ", assignedTo=" + assignedTo + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}

	public WorkflowInputMapper(String plantId, String status, String siteName, String siteCategory, String assignedTo,
			String fromDate, String toDate) {
		super();
		this.plantId = plantId;
		this.status = status;
		this.siteName = siteName;
		this.siteCategory = siteCategory;
		this.assignedTo = assignedTo;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public String getPlantId() {
		return plantId;
	}

	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
	
	
	
}
