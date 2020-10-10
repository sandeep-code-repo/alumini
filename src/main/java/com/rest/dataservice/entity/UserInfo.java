package com.rest.dataservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable{

	/**
	 * @Jayashree
	 * @Date-29/09/2020
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid")
	private Integer uid;
	
	@Column(name = "user_id")
	private String  userId;
	
	@Column(name = "username")
	private String  username;
	
	@Column(name = "password")
	private String  password;
	
	@Column(name = "email")
	private String  email;
	
	@Column(name = "department")
	private String  department;
	
	@Column(name = "mob_no")
	private String  mobNo;
	
	@Column(name = "user_type")
	private String  userType;
	
	@Column(name = "plant_type")
	private String  plantType;
	
	@Column(name = "category")
	private String  category;
	
	@Column(name = "designation")
	private String  designation;
	
	@Column(name = "reportto")
	private String  reportto;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPlantType() {
		return plantType;
	}

	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getReportto() {
		return reportto;
	}

	public void setReportto(String reportto) {
		this.reportto = reportto;
	}
	
	
	

}
