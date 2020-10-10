package com.skeleton.alumini.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_alm_employee")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "industry_id")
	private Integer industryId;
	
	@Column(name = "industry_name")
	private String iName;
	
	@Column(name = "industry_catagory")
	private String indCatagory;
		
	@Column(name = "vendor")
	private String vendor;
	
	@Column(name = "existing_plant_id")
	private Integer plantId;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "regional_office")
	private String regOfc;
	
	@Column(name = "caaqms_station")
	private Integer caaqmsStation;
	
	@Column(name = "cems_station")
	private Integer cemsStation;
	
	@Column(name = "ceqms_station")
	private Integer ceqmsStation;
	
	@Column(name = "primary_contact")
	private String primaryCnt;
	
	@Column(name = "secondary_contact")
	private String secondaryCnt;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "data_transmision")
	private String dataTrasmision;
	
	@Column(name = "historical_data")
	private String historyData;
	
	@Column(name = "monitoring_type")
	private String mType;
	
	@Column(name = "station_name")
	private String stationName;
	
	@Column(name = "process_attached")
	private String processAttached;
	
	@Column(name = "process_vendor")
	private String proVendor;
	
	@Column(name = "analyser_make")
	private String analyserMake;
	
	@Column(name = "analyser_serial_no")
	private String analyserSerNo;
	
	@Column(name = "device_imsi_no")
	private String deviceNo;
	
	@Column(name = "mac_id")
	private String macId;
	
	@Column(name = "measurment_min")
	private String measurementMin;
	
	@Column(name = "measurment_max")
	private String measurementMax;
	
	@Column(name = "parameter")
	private String parameter;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "certification")
	private String certification;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "measurement_principle")
	private String measurementPriciple;
	
	@Column(name = "stack_height")
	private String stackheight;
	
	@Column(name = "stack_diameter")
	private String stackDiameter;
	
	@Column(name = "stack_velocity")
	private String stackVel;
	
	@Column(name = "gas_discharge_rate")
	private String gasDisRate;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "created_date")
	private Date createdDate;
	

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getIndCatagory() {
		return indCatagory;
	}

	public void setIndCatagory(String indCatagory) {
		this.indCatagory = indCatagory;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getRegOfc() {
		return regOfc;
	}

	public void setRegOfc(String regOfc) {
		this.regOfc = regOfc;
	}

	public Integer getCaaqmsStation() {
		return caaqmsStation;
	}

	public void setCaaqmsStation(Integer caaqmsStation) {
		this.caaqmsStation = caaqmsStation;
	}

	public Integer getCemsStation() {
		return cemsStation;
	}

	public void setCemsStation(Integer cemsStation) {
		this.cemsStation = cemsStation;
	}

	public Integer getCeqmsStation() {
		return ceqmsStation;
	}

	public void setCeqmsStation(Integer ceqmsStation) {
		this.ceqmsStation = ceqmsStation;
	}

	public String getPrimaryCnt() {
		return primaryCnt;
	}

	public void setPrimaryCnt(String primaryCnt) {
		this.primaryCnt = primaryCnt;
	}

	public String getSecondaryCnt() {
		return secondaryCnt;
	}

	public void setSecondaryCnt(String secondaryCnt) {
		this.secondaryCnt = secondaryCnt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDataTrasmision() {
		return dataTrasmision;
	}

	public void setDataTrasmision(String dataTrasmision) {
		this.dataTrasmision = dataTrasmision;
	}

	public String getHistoryData() {
		return historyData;
	}

	public void setHistoryData(String historyData) {
		this.historyData = historyData;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getProcessAttached() {
		return processAttached;
	}

	public void setProcessAttached(String processAttached) {
		this.processAttached = processAttached;
	}

	public String getProVendor() {
		return proVendor;
	}

	public void setProVendor(String proVendor) {
		this.proVendor = proVendor;
	}

	public String getAnalyserMake() {
		return analyserMake;
	}

	public void setAnalyserMake(String analyserMake) {
		this.analyserMake = analyserMake;
	}

	public String getAnalyserSerNo() {
		return analyserSerNo;
	}

	public void setAnalyserSerNo(String analyserSerNo) {
		this.analyserSerNo = analyserSerNo;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	public String getMeasurementMin() {
		return measurementMin;
	}

	public void setMeasurementMin(String measurementMin) {
		this.measurementMin = measurementMin;
	}

	public String getMeasurementMax() {
		return measurementMax;
	}

	public void setMeasurementMax(String measurementMax) {
		this.measurementMax = measurementMax;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getMeasurementPriciple() {
		return measurementPriciple;
	}

	public void setMeasurementPriciple(String measurementPriciple) {
		this.measurementPriciple = measurementPriciple;
	}

	public String getStackheight() {
		return stackheight;
	}

	public void setStackheight(String stackheight) {
		this.stackheight = stackheight;
	}

	public String getStackDiameter() {
		return stackDiameter;
	}

	public void setStackDiameter(String stackDiameter) {
		this.stackDiameter = stackDiameter;
	}

	public String getStackVel() {
		return stackVel;
	}

	public void setStackVel(String stackVel) {
		this.stackVel = stackVel;
	}

	public String getGasDisRate() {
		return gasDisRate;
	}

	public void setGasDisRate(String gasDisRate) {
		this.gasDisRate = gasDisRate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	

}
