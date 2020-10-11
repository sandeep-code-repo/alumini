package com.rest.dataservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plant_info")
public class PlantInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private long pid;
	
	@Column(name = "plant_id")
	private long  plantId;
	
	@Column(name = "password")
	private String  password;
	
	@Column(name = "pin")
	private String  pin;
	
	@Column(name = "plant_nm")
	private String  plantNm;
	
	@Column(name = "type")
	private String  typ;
	
	@Column(name = "district")
	private String  district;
	
	@Column(name = "town")
	private String  town;
	
	@Column(name = "street")
	private String  street;
	
	@Column(name = "state")
	private String  state;
	
	@Column(name = "email")
	private String  email;
	
	@Column(name = "web")
	private String  web;
	
	@Column(name = "zonal")
	private String  zonal;
	
	@Column(name = "group_id")
	private String  grdId;
	
	@Column(name = "date_time_stamp")
	private Date  timeStamp;
	
	@Column(name = "auth_person")
	private String  authPerson;
	
	@Column(name = "auth_person_mob")
	private String  authoPerMob;
	
	@Column(name = "auth_person_desig")
	private String  authPersonDesig;
	
	@Column(name = "cpcb_usr")
	private String  cpcbUser;
	
	@Column(name = "cpcb_usr_email")
	private String  cpcbUserEmail;
	
	@Column(name = "cpcb_usr_mob")
	private String  cpcbUserMob;
	
	@Column(name = "cpcb_usr2")
	private String  cpcbUsr2;
	
	@Column(name = "cpcb_usr_email2")
	private String  cpcbUserEmail2;

	@Column(name = "cpcb_usr_mob2")
	private String  cpcbUserMob2;
	
	@Column(name = "lat_long")
	private String  latLong;

	@Column(name = "connected")
	private String  connected;
	
	@Column(name = "dept_email")
	private String  deptEmail;
	
	@Column(name = "category")
	private String  category;
	
	@Column(name = "plant_name")
	private String  plantName;
	
	@Column(name = "analyzer_count")
	private String  analyzerCount;
	
	@Column(name = "HQO_email")
	private String  HQOEmail;
	
	@Column(name = "inlet_url")
	private String  inletUrl;
	
	@Column(name = "outlet_url")
	private String  outletUrl;
	
	@Column(name = "ro_usr")
	private String  roUser;
	
	@Column(name = "ro_usr_email")
	private String  roUserEmail;
	
	@Column(name = "ro_usr_mob")
	private String  roUserMob;
	
	@Column(name = "plant_slug")
	private String  plantSlug;
	
	@Column(name = "auth_req")
	private String  authReq;
	
	@Column(name = "station_count")
	private String  stationCount;
	
	@Column(name = "plant_vendor")
	private String  plantVendor;
	
	@Column(name = "CAAQMS_Station")
	private String  caaqmsStation;
	
	@Column(name = "CEMS_Station")
	private String  cemsStation;
	
	@Column(name = "CEQMS_Station")
	private String  ceqmsStation;
	
	@Column(name = "secd_person")
	private String  secdPerson;
	
	@Column(name = "secd_person_desig")
	private String  secdPersonDesig;
	
	@Column(name = "secd_person_mob")
	private String  secdPersonMob;
	
	@Column(name = "secd_email")
	private String  secdEmail;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name = "created_by")
	private String  createdBy;
	
	@Column(name = "created_dt")
	private String  createdDt;
	
	@Column(name = "last_modified_by")
	private String  lastModifiedBy;
	
	@Column(name="last_modified_dt")
	private String lastModifiedDt;

	

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	

	public long getPlantId() {
		return plantId;
	}

	public void setPlantId(long plantId) {
		this.plantId = plantId;
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

	public String getPlantNm() {
		return plantNm;
	}

	public void setPlantNm(String plantNm) {
		this.plantNm = plantNm;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getZonal() {
		return zonal;
	}

	public void setZonal(String zonal) {
		this.zonal = zonal;
	}

	public String getGrdId() {
		return grdId;
	}

	public void setGrdId(String grdId) {
		this.grdId = grdId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getAuthPerson() {
		return authPerson;
	}

	public void setAuthPerson(String authPerson) {
		this.authPerson = authPerson;
	}

	public String getAuthoPerMob() {
		return authoPerMob;
	}

	public void setAuthoPerMob(String authoPerMob) {
		this.authoPerMob = authoPerMob;
	}

	public String getAuthPersonDesig() {
		return authPersonDesig;
	}

	public void setAuthPersonDesig(String authPersonDesig) {
		this.authPersonDesig = authPersonDesig;
	}

	public String getCpcbUser() {
		return cpcbUser;
	}

	public void setCpcbUser(String cpcbUser) {
		this.cpcbUser = cpcbUser;
	}

	public String getCpcbUserEmail() {
		return cpcbUserEmail;
	}

	public void setCpcbUserEmail(String cpcbUserEmail) {
		this.cpcbUserEmail = cpcbUserEmail;
	}

	public String getCpcbUserMob() {
		return cpcbUserMob;
	}

	public void setCpcbUserMob(String cpcbUserMob) {
		this.cpcbUserMob = cpcbUserMob;
	}

	public String getCpcbUsr2() {
		return cpcbUsr2;
	}

	public void setCpcbUsr2(String cpcbUsr2) {
		this.cpcbUsr2 = cpcbUsr2;
	}

	public String getCpcbUserEmail2() {
		return cpcbUserEmail2;
	}

	public void setCpcbUserEmail2(String cpcbUserEmail2) {
		this.cpcbUserEmail2 = cpcbUserEmail2;
	}

	public String getCpcbUserMob2() {
		return cpcbUserMob2;
	}

	public void setCpcbUserMob2(String cpcbUserMob2) {
		this.cpcbUserMob2 = cpcbUserMob2;
	}

	public String getLatLong() {
		return latLong;
	}

	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}

	public String getConnected() {
		return connected;
	}

	public void setConnected(String connected) {
		this.connected = connected;
	}

	public String getDeptEmail() {
		return deptEmail;
	}

	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getAnalyzerCount() {
		return analyzerCount;
	}

	public void setAnalyzerCount(String analyzerCount) {
		this.analyzerCount = analyzerCount;
	}

	public String getHQOEmail() {
		return HQOEmail;
	}

	public void setHQOEmail(String hQOEmail) {
		HQOEmail = hQOEmail;
	}

	public String getInletUrl() {
		return inletUrl;
	}

	public void setInletUrl(String inletUrl) {
		this.inletUrl = inletUrl;
	}

	public String getOutletUrl() {
		return outletUrl;
	}

	public void setOutletUrl(String outletUrl) {
		this.outletUrl = outletUrl;
	}

	public String getRoUser() {
		return roUser;
	}

	public void setRoUser(String roUser) {
		this.roUser = roUser;
	}

	public String getRoUserEmail() {
		return roUserEmail;
	}

	public void setRoUserEmail(String roUserEmail) {
		this.roUserEmail = roUserEmail;
	}

	public String getRoUserMob() {
		return roUserMob;
	}

	public void setRoUserMob(String roUserMob) {
		this.roUserMob = roUserMob;
	}

	public String getPlantSlug() {
		return plantSlug;
	}

	public void setPlantSlug(String plantSlug) {
		this.plantSlug = plantSlug;
	}

	public String getAuthReq() {
		return authReq;
	}

	public void setAuthReq(String authReq) {
		this.authReq = authReq;
	}

	public String getStationCount() {
		return stationCount;
	}

	public void setStationCount(String stationCount) {
		this.stationCount = stationCount;
	}

	public String getPlantVendor() {
		return plantVendor;
	}

	public void setPlantVendor(String plantVendor) {
		this.plantVendor = plantVendor;
	}

	public String getCaaqmsStation() {
		return caaqmsStation;
	}

	public void setCaaqmsStation(String caaqmsStation) {
		this.caaqmsStation = caaqmsStation;
	}

	public String getCemsStation() {
		return cemsStation;
	}

	public void setCemsStation(String cemsStation) {
		this.cemsStation = cemsStation;
	}

	public String getCeqmsStation() {
		return ceqmsStation;
	}

	public void setCeqmsStation(String ceqmsStation) {
		this.ceqmsStation = ceqmsStation;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getCreatedDt() {
		return createdDt;
	}

	/**
	 * @param createdDt the createdDt to set
	 */
	public void setCreatedDt(String createdDt) {
		this.createdDt = createdDt;
	}

	/**
	 * @return the lastModifiedBy
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy the lastModifiedBy to set
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * @return the lastModifiedDt
	 */
	public String getLastModifiedDt() {
		return lastModifiedDt;
	}

	/**
	 * @param lastModifiedDt the lastModifiedDt to set
	 */
	public void setLastModifiedDt(String lastModifiedDt) {
		this.lastModifiedDt = lastModifiedDt;
	}

	@Override
	public String toString() {
		return "PlantInfo [pid=" + pid + ", plantId=" + plantId + ", password=" + password + ", pin=" + pin
				+ ", plantNm=" + plantNm + ", typ=" + typ + ", district=" + district + ", town=" + town + ", street="
				+ street + ", state=" + state + ", email=" + email + ", web=" + web + ", zonal=" + zonal + ", grdId="
				+ grdId + ", timeStamp=" + timeStamp + ", authPerson=" + authPerson + ", authoPerMob=" + authoPerMob
				+ ", authPersonDesig=" + authPersonDesig + ", cpcbUser=" + cpcbUser + ", cpcbUserEmail=" + cpcbUserEmail
				+ ", cpcbUserMob=" + cpcbUserMob + ", cpcbUsr2=" + cpcbUsr2 + ", cpcbUserEmail2=" + cpcbUserEmail2
				+ ", cpcbUserMob2=" + cpcbUserMob2 + ", latLong=" + latLong + ", connected=" + connected
				+ ", deptEmail=" + deptEmail + ", category=" + category + ", plantName=" + plantName
				+ ", analyzerCount=" + analyzerCount + ", HQOEmail=" + HQOEmail + ", inletUrl=" + inletUrl
				+ ", outletUrl=" + outletUrl + ", roUser=" + roUser + ", roUserEmail=" + roUserEmail + ", roUserMob="
				+ roUserMob + ", plantSlug=" + plantSlug + ", authReq=" + authReq + ", stationCount=" + stationCount
				+ ", plantVendor=" + plantVendor + ", caaqmsStation=" + caaqmsStation + ", cemsStation=" + cemsStation
				+ ", ceqmsStation=" + ceqmsStation + ", secdPerson=" + secdPerson + ", secdPersonDesig="
				+ secdPersonDesig + ", secdPersonMob=" + secdPersonMob + ", secdEmail=" + secdEmail + ", userName="
				+ userName + ", createdBy=" + createdBy + ", createdDt=" + createdDt + ", lastModifiedBy="
				+ lastModifiedBy + ", lastModifiedDt=" + lastModifiedDt + "]";
	}
	
	

}
