package com.rest.dataservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "user_id")
	private Long  userId;
	
	@Column(name = "web")
	private String  web;
	
	@Column(name = "zonal")
	private String  zonal;
	
	@Column(name = "group_id")
	private String  grdId;
	
	@Column(name = "date_time_stamp")
	private Date  timeStamp;
	
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
	
	@Column(name = "plant_type")
	private String  plantType;
	
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
	
	@Column(name = "created_by")
	private String  createdBy;
	
	@Column(name = "created_dt")
	private Date  createdDt;
	
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
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long long1) {
		this.userId = long1;
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

	public String getPlantType() {
		return plantType;
	}

	public void setPlantType(String plantType) {
		this.plantType = plantType;
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

}
