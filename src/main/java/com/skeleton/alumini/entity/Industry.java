package com.skeleton.alumini.entity;

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
@Table(name = "industry")
public class Industry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "industry_id")
	private Integer industryId;
	
	private String industryName;
	
	private String industryDescription;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date industryCreatedDate;
	
	private String industryCreateBy;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date industryModifiedDate;
	
	private String industryModifiedBy;
	
	private String industryStatus;

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getIndustryDescription() {
		return industryDescription;
	}

	public void setIndustryDescription(String industryDescription) {
		this.industryDescription = industryDescription;
	}

	public Date getIndustryCreatedDate() {
		return industryCreatedDate;
	}

	public void setIndustryCreatedDate(Date industryCreatedDate) {
		this.industryCreatedDate = industryCreatedDate;
	}

	public String getIndustryCreateBy() {
		return industryCreateBy;
	}

	public void setIndustryCreateBy(String industryCreateBy) {
		this.industryCreateBy = industryCreateBy;
	}

	public Date getIndustryModifiedDate() {
		return industryModifiedDate;
	}

	public void setIndustryModifiedDate(Date industryModifiedDate) {
		this.industryModifiedDate = industryModifiedDate;
	}

	public String getIndustryModifiedBy() {
		return industryModifiedBy;
	}

	public void setIndustryModifiedBy(String industryModifiedBy) {
		this.industryModifiedBy = industryModifiedBy;
	}

	public String getIndustryStatus() {
		return industryStatus;
	}

	public void setIndustryStatus(String industryStatus) {
		this.industryStatus = industryStatus;
	}
	
	

}
