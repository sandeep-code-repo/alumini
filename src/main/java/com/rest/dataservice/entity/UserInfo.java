package com.rest.dataservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private Long uid;
	
	@Column(name = "user_name", unique = true, nullable=false)
	private String  userName;
	
	@Column(name = "password", nullable=false)
	private String  password;
	
	@Column(name = "pin")
	private String  pin;
	
	@Column(name = "district")
	private String  district;
	
	@Column(name = "town")
	private String  town;
	
	@Column(name = "street")
	private String  street;
	
	@Column(name = "state")
	private String  state;
	
	@Column(name = "email" , unique=true, nullable=false)
	private String  email;
	
	@Column(name = "mob_no",unique = true, nullable=false)
	private String  mobNo;
	
	@Column(name = "auth_person")
	private String  authPerson;
	
	@Column(name = "secd_person")
	private String  secdPerson;
	
	@Column(name = "secd_person_desig")
	private String  secdPersonDesig;
	
	@Column(name = "secd_person_mob")
	private String  secdPersonMob;
	
	@Column(name = "secd_email")
	private String  secdEmail;
	
	@Column(name = "designation")
	private String  designation;
	
	
	@Column(name = "rsa_public_key",length=500)
	private String rsaPublicKey;
	
	@Column(name = "rsa_private_key",length=1000)
	private String rsaPrivateKey;
	
	@Column(name = "temp_password",length=1000)
	private String tempPassword;
	
	@Column(name = "created_by")
	private String  createdBy;
	
	@Column(name = "created_dt")
	private Date  createdDt;
	
	@Column(name = "last_modified_by")
	private String  lastModifiedBy;
	
	@Column(name="last_modified_dt")
	private String lastModifiedDt;
	
	@Column(name="reg_status")
	private Boolean regStatus;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getAuthPerson() {
		return authPerson;
	}

	public void setAuthPerson(String authPerson) {
		this.authPerson = authPerson;
	}

	public String getSecdPerson() {
		return secdPerson;
	}

	public void setSecdPerson(String secdPerson) {
		this.secdPerson = secdPerson;
	}

	public String getSecdPersonDesig() {
		return secdPersonDesig;
	}

	public void setSecdPersonDesig(String secdPersonDesig) {
		this.secdPersonDesig = secdPersonDesig;
	}

	public String getSecdPersonMob() {
		return secdPersonMob;
	}

	public void setSecdPersonMob(String secdPersonMob) {
		this.secdPersonMob = secdPersonMob;
	}

	public String getSecdEmail() {
		return secdEmail;
	}

	public void setSecdEmail(String secdEmail) {
		this.secdEmail = secdEmail;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRsaPublicKey() {
		return rsaPublicKey;
	}

	public void setRsaPublicKey(String rsaPublicKey) {
		this.rsaPublicKey = rsaPublicKey;
	}

	public String getRsaPrivateKey() {
		return rsaPrivateKey;
	}

	public void setRsaPrivateKey(String rsaPrivateKey) {
		this.rsaPrivateKey = rsaPrivateKey;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
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

	public String getLastModifiedDt() {
		return lastModifiedDt;
	}

	public void setLastModifiedDt(String lastModifiedDt) {
		this.lastModifiedDt = lastModifiedDt;
	}

	public Boolean getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(Boolean regStatus) {
		this.regStatus = regStatus;
	}

	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", userName=" + userName + ", password=" + password + ", pin=" + pin
				+ ", district=" + district + ", town=" + town + ", street=" + street + ", state=" + state + ", email="
				+ email + ", mobNo=" + mobNo + ", authPerson=" + authPerson + ", secdPerson=" + secdPerson
				+ ", secdPersonDesig=" + secdPersonDesig + ", secdPersonMob=" + secdPersonMob + ", secdEmail="
				+ secdEmail + ", designation=" + designation + ", rsaPublicKey=" + rsaPublicKey + ", rsaPrivateKey="
				+ rsaPrivateKey + ", tempPassword=" + tempPassword + ", createdBy=" + createdBy + ", createdDt="
				+ createdDt + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDt=" + lastModifiedDt
				+ ", regStatus=" + regStatus + "]";
	}

	
	

}
