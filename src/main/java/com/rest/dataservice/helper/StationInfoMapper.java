package com.skeleton.alumini.helper;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.skeleton.alumini.entity.ParameterInfo;

public class StationInfoMapper {

	/**
	 * @Jayashree
	 * @Date-29/09/2020
	 */

	private long sid;
	
	private long plantId;
	
	private long stationId;
	
	private String analyzer;
	
	private String analyzerv2;
	
	private String shortName;
	
	private String location;
	
	private Date installDt;
	
	private String token;
	
	private String macNo;
	
	private Integer stationNo;
	
	private String stnType;
	
	private Integer hasThresold;
	
	private Integer pid;
	
	private String stationVendor;
	
	private String certification;
	
	private String latitude;
	
	private String longitute;
	
	private String measurementPrinciple;
	
	private String stackHeight;
	
	private String stackDiameter;
	
	private String stackVelocity;
	
	private String gasDischargeRate;
	
	private String remarks;
	
	private String  createdBy;
	
	private String  createdDt;
	
	private String  lastModifiedBy;
	
	private String lastModifiedDt;
	
	private List<ParameterInfo> parameterInfo;

	/**
	 * @return the parameterInfo
	 */
	public List<ParameterInfo> getParameterInfo() {
		return parameterInfo;
	}

	/**
	 * @param parameterInfo the parameterInfo to set
	 */
	public void setParameterInfo(List<ParameterInfo> parameterInfo) {
		this.parameterInfo = parameterInfo;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public long getPlantId() {
		return plantId;
	}

	public void setPlantId(long plantId) {
		this.plantId = plantId;
	}

	public long getStationId() {
		return stationId;
	}

	public void setStationId(long stationId) {
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
		return "StationInfo [sid=" + sid + ", plantId=" + plantId + ", stationId=" + stationId + ", analyzer="
				+ analyzer + ", analyzerv2=" + analyzerv2 + ", shortName=" + shortName + ", location=" + location
				+ ", installDt=" + installDt + ", token=" + token + ", macNo=" + macNo + ", stationNo=" + stationNo
				+ ", stnType=" + stnType + ", hasThresold=" + hasThresold + ", pid=" + pid + ", stationVendor="
				+ stationVendor + ", certification=" + certification + ", latitude=" + latitude + ", longitute="
				+ longitute + ", measurementPrinciple=" + measurementPrinciple + ", stackHeight=" + stackHeight
				+ ", stackDiameter=" + stackDiameter + ", stackVelocity=" + stackVelocity + ", gasDischargeRate="
				+ gasDischargeRate + ", remarks=" + remarks + ", createdBy=" + createdBy + ", createdDt=" + createdDt
				+ ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDt=" + lastModifiedDt + "]";
	}

	
	
	
	

}
