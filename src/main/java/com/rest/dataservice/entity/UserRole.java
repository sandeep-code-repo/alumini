package com.rest.dataservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user_role")
public class UserRole {
	
	/**
	 * @Jayashree
	 * @Date-29/09/2020
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id")
	private Long userRoleId;
	
	@Column(name = "plant_user_id",nullable=false)
	private Long plantUserId;
	
	@Column(name = "role_id",nullable=false)
	private String roleId;
	
	@Column(name = "user_role_status",nullable=false)
	private Boolean userRoleStatus=false;
	
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
	
	


	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}




	public Long getPlantUserId() {
		return plantUserId;
	}

	public void setPlantUserId(Long plantUserId) {
		this.plantUserId = plantUserId;
	}

	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the userRoleStatus
	 */
	public Boolean getUserRoleStatus() {
		return userRoleStatus;
	}

	/**
	 * @param userRoleStatus the userRoleStatus to set
	 */
	public void setUserRoleStatus(Boolean userRoleStatus) {
		this.userRoleStatus = userRoleStatus;
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

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", plantUserId=" + plantUserId + ", roleId=" + roleId
				+ ", userRoleStatus=" + userRoleStatus + ", createdBy=" + createdBy + ", createdDt=" + createdDt
				+ ", modifiedBy=" + modifiedBy + ", modifiedDt=" + modifiedDt + "]";
	}
	
	
	

}
