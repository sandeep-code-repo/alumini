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
@Table(name = "station_info")
public class StationInfo implements Serializable{

	/**
	 * @Jayashree
	 * @Date-29/09/2020
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private Integer sid;
	
	@Column(name = "plant_id")
	private String plantId;
	
	@Column(name = "station_id")
	private String stationId;
	
	@Column(name = "analyzer")
	private String analyzer;
	
	@Column(name = "analyzerv2")
	private String analyzerv2;
	
	@Column(name = "short_name")
	private String shortName;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "install_date")
	private Date installDt;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "imei_mac_number")
	private String macNo;
	
	@Column(name = "station_number")
	private Integer stationNo;
	
	@Column(name = "stn_type")
	private String stnType;
	
	@Column(name = "has_threshold")
	private Integer hasThresold;
	
	@Column(name = "pid")
	private Integer pid;
	
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name = "station_vendor")
	private String stationVendor;
	
	@Column(name = "certification")
	private String certification;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitute")
	private String longitute;
	
	@Column(name = "measurement_Principle")
	private String measurementPrinciple;
	
	@Column(name = "stack_Height")
	private String stackHeight;
	
	@Column(name = "stack_Diameter")
	private String stackDiameter;
	
	@Column(name = "stack_Velocity")
	private String stackVelocity;
	
	@Column(name = "flue_gas_discharge_rate")
	private String gasDischargeRate;
	
	@Column(name = "remarks")
	private String remarks;
	
	

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getPlantId() {
		return plantId;
	}

	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(String analyzer) {
		this.analyzer = analyzer;
	}

	public String getAnalyzerv2() {
		return analyzerv2;
	}

	public void setAnalyzerv2(String analyzerv2) {
		this.analyzerv2 = analyzerv2;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getInstallDt() {
		return installDt;
	}

	public void setInstallDt(Date installDt) {
		this.installDt = installDt;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMacNo() {
		return macNo;
	}

	public void setMacNo(String macNo) {
		this.macNo = macNo;
	}

	public Integer getStationNo() {
		return stationNo;
	}

	public void setStationNo(Integer stationNo) {
		this.stationNo = stationNo;
	}

	public String getStnType() {
		return stnType;
	}

	public void setStnType(String stnType) {
		this.stnType = stnType;
	}

	public Integer getHasThresold() {
		return hasThresold;
	}

	public void setHasThresold(Integer hasThresold) {
		this.hasThresold = hasThresold;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	

	public String getStationVendor() {
		return stationVendor;
	}

	public void setStationVendor(String stationVendor) {
		this.stationVendor = stationVendor;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitute() {
		return longitute;
	}

	public void setLongitute(String longitute) {
		this.longitute = longitute;
	}

	public String getMeasurementPrinciple() {
		return measurementPrinciple;
	}

	public void setMeasurementPrinciple(String measurementPrinciple) {
		this.measurementPrinciple = measurementPrinciple;
	}

	public String getStackHeight() {
		return stackHeight;
	}

	public void setStackHeight(String stackHeight) {
		this.stackHeight = stackHeight;
	}

	public String getStackDiameter() {
		return stackDiameter;
	}

	public void setStackDiameter(String stackDiameter) {
		this.stackDiameter = stackDiameter;
	}

	public String getStackVelocity() {
		return stackVelocity;
	}

	public void setStackVelocity(String stackVelocity) {
		this.stackVelocity = stackVelocity;
	}

	public String getGasDischargeRate() {
		return gasDischargeRate;
	}

	public void setGasDischargeRate(String gasDischargeRate) {
		this.gasDischargeRate = gasDischargeRate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "StationInfo [sid=" + sid + ", plantId=" + plantId + ", stationId=" + stationId + ", analyzer="
				+ analyzer + ", analyzerv2=" + analyzerv2 + ", shortName=" + shortName + ", location=" + location
				+ ", installDt=" + installDt + ", token=" + token + ", macNo=" + macNo + ", stationNo=" + stationNo
				+ ", stnType=" + stnType + ", hasThresold=" + hasThresold + ", pid=" + pid + ", userId=" + userId + "]";
	}


	
	
	
	

}
