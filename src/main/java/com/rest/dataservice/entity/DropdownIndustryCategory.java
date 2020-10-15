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
@Table(name = "dropdown_industry_category")
public class DropdownIndustryCategory {
	
	/**
	 * @Jayashree
	 * @Date-29/09/2020
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "industry_cat_id")
	private long industryCatId;
	
	@Column(name = "industry_cat_name",nullable=false)
	private String industryCatName;
	
	@Column(name = "industry_cat_status",nullable=false)
	private Boolean industryCatStatus=true;
	
	@Column(name = "created_by")
	private String  createdBy;
	
	@Column(name = "created_dt")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date  createdDt;
	
	@Column(name = "modified_by")
	private String  modifiedBy;
	
	@Column(name = "modified_dt")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date  modifiedDt;


	
	
	/**
	 * @return the industryCatId
	 */
	public long getIndustryCatId() {
		return industryCatId;
	}

	/**
	 * @param industryCatId the industryCatId to set
	 */
	public void setIndustryCatId(long industryCatId) {
		this.industryCatId = industryCatId;
	}

	/**
	 * @return the industryCatName
	 */
	public String getIndustryCatName() {
		return industryCatName;
	}

	/**
	 * @param industryCatName the industryCatName to set
	 */
	public void setIndustryCatName(String industryCatName) {
		this.industryCatName = industryCatName;
	}

	/**
	 * @return the industryCatStatus
	 */
	public Boolean getIndustryCatStatus() {
		return industryCatStatus;
	}

	/**
	 * @param industryCatStatus the industryCatStatus to set
	 */
	public void setIndustryCatStatus(Boolean industryCatStatus) {
		this.industryCatStatus = industryCatStatus;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDt
	 */
	public Date getCreatedDt() {
		return createdDt;
	}

	/**
	 * @param createdDt the createdDt to set
	 */
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedDt
	 */
	public Date getModifiedDt() {
		return modifiedDt;
	}

	/**
	 * @param modifiedDt the modifiedDt to set
	 */
	public void setModifiedDt(Date modifiedDt) {
		this.modifiedDt = modifiedDt;
	}

}
