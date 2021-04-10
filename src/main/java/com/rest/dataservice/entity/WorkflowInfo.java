package com.rest.dataservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "workflow_info")
public class WorkflowInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "plant_id")
	private String plantId;
	
	@Column(name = "event")
	private String event;
	
	@Column(name = "site_name")
	private String siteName;
	
	@Column(name = "site_category")
	private String siteCategory;
	
	@Column(name = "assigned_to")
	private String assignedTo;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "start_time", columnDefinition="TIMESTAMP")
	private Date startTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "end_time", columnDefinition="TIMESTAMP")
	private Date endTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "time_to_respond", columnDefinition="TIMESTAMP")
	private Date timeToRespond;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "time_to_action", columnDefinition="TIMESTAMP")
	private Date timeToAction;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "send_copy")
	private Boolean sendCopy;
	
	@Column(name = "created_by")
	private String  createdBy;
	
	@Column(name = "created_dt")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date  createdDt;
	
	@Column(name = "last_modified_by")
	private String  lastModifiedBy;
	
	@Column(name="last_modified_dt")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date lastModifiedDt;
	
	

	public WorkflowInfo() {
	}

	@Override
	public String toString() {
		return "WorkflowInfo [id=" + id + ", plantId=" + plantId + ", event=" + event + ", siteName=" + siteName
				+ ", siteCategory=" + siteCategory + ", assignedTo=" + assignedTo + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", timeToRespond=" + timeToRespond + ", timeToAction=" + timeToAction
				+ ", description=" + description + ", sendCopy=" + sendCopy + ", createdBy=" + createdBy
				+ ", createdDt=" + createdDt + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDt="
				+ lastModifiedDt + "]";
	}

	public WorkflowInfo(long id, String plantId, String event, String siteName, String siteCategory, String assignedTo,
			Date startTime, Date endTime, Date timeToRespond, Date timeToAction, String description, Boolean sendCopy,
			String createdBy, Date createdDt, String lastModifiedBy, Date lastModifiedDt) {
		super();
		this.id = id;
		this.plantId = plantId;
		this.event = event;
		this.siteName = siteName;
		this.siteCategory = siteCategory;
		this.assignedTo = assignedTo;
		this.startTime = startTime;
		this.endTime = endTime;
		this.timeToRespond = timeToRespond;
		this.timeToAction = timeToAction;
		this.description = description;
		this.sendCopy = sendCopy;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDt = lastModifiedDt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlantId() {
		return plantId;
	}

	public void setPlant_id(String plantId) {
		this.plantId = plantId;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDt() {
		return lastModifiedDt;
	}

	public void setLastModifiedDt(Date lastModifiedDt) {
		this.lastModifiedDt = lastModifiedDt;
	}

	


}
