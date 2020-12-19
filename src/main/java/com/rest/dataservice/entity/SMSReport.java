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
@Table(name = "sms_report")
public class SMSReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "industry_category")
	private String industryCategory;
	
	@Column(name = "industry_code")
	private String industryCode;
	
	@Column(name = "industry_name")
	private String industryName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "sms_contact_no")
	private String smsContactNo;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "station_name")
	private String stationName;
	
	@Column(name = "param_limit")
	private String paramLimit;
	
	@Column(name = "parameter")
	private String parameter;
	
	@Column(name = "exceedence")
	private String exceedence;
	
	@Column(name = "total_sms")
	private String totalSMS;
	
	@Column(name = "in_ganga_basin_status")
	private String inGangaBasinStatus;
	
	@Column(name = "created_by")
	private String  createdBy;
	
	@Column(name = "created_dt")
	private Date  createdDt;
	
	@Column(name = "last_modified_by")
	private String  lastModifiedBy;
	
	@Column(name="last_modified_dt")
	private Date lastModifiedDt;

	public SMSReport() {
		super();
	}

	@Override
	public String toString() {
		return "sms_report [id=" + id + ", industryCategory=" + industryCategory + ", industryCode=" + industryCode
				+ ", industryName=" + industryName + ", address=" + address + ", smsContactNo=" + smsContactNo
				+ ", state=" + state + ", stationName=" + stationName + ", paramLimit=" + paramLimit + ", parameter="
				+ parameter + ", exceedence=" + exceedence + ", totalSMS=" + totalSMS + ", inGangaBasinStatus="
				+ inGangaBasinStatus + ", createdBy=" + createdBy + ", createdDt=" + createdDt + ", lastModifiedBy="
				+ lastModifiedBy + ", lastModifiedDt=" + lastModifiedDt + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIndustryCategory() {
		return industryCategory;
	}

	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}

	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSmsContactNo() {
		return smsContactNo;
	}

	public void setSmsContactNo(String smsContactNo) {
		this.smsContactNo = smsContactNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getParamLimit() {
		return paramLimit;
	}

	public void setParamLimit(String paramLimit) {
		this.paramLimit = paramLimit;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getExceedence() {
		return exceedence;
	}

	public void setExceedence(String exceedence) {
		this.exceedence = exceedence;
	}

	public String getTotalSMS() {
		return totalSMS;
	}

	public void setTotalSMS(String totalSMS) {
		this.totalSMS = totalSMS;
	}

	public String getInGangaBasinStatus() {
		return inGangaBasinStatus;
	}

	public void setInGangaBasinStatus(String inGangaBasinStatus) {
		this.inGangaBasinStatus = inGangaBasinStatus;
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
