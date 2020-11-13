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
@Table(name = "parameter_info")
public class ParameterInfo implements Serializable{

	/**
	 * @Jayashree
	 * @Date-05/10/2020
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "para_id")
	private long paraId;
	
	
	@Column(name = "sid")
	private long sid;
	
	@Column(name = "paramter")
	private String paramter;
	
	@Column(name = "analyser_make")
	private String analyserMake;
	
	@Column(name = "analyser_model")
	private String analyserModel;
	
	@Column(name = "analyser_serial_number")
	private String analyserSerialNo;
	
	@Column(name = "devidce_IMEI_NUMBER")
	private String devidceIMEINo;
	
	@Column(name = "MAC_ID")
	private String macId;
	
	@Column(name = "measurement_MIN")
	private String measurmentMin;
	
	@Column(name = "measurement_MAX")
	private String measurmentMax;
	
	@Column(name = "Unit")
	private String Unit;
	
	@Column(name = "created_by")
	private String  createdBy;
	
	@Column(name = "created_dt")
	private Date  createdDt;
	
	@Column(name = "last_modified_by")
	private String  lastModifiedBy;
	
	@Column(name="last_modified_dt")
	private Date lastModifiedDt;

	public long getParaId() {
		return paraId;
	}

	public void setParaId(long paraId) {
		this.paraId = paraId;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getParamter() {
		return paramter;
	}

	public void setParamter(String paramter) {
		this.paramter = paramter;
	}

	public String getAnalyserMake() {
		return analyserMake;
	}

	public void setAnalyserMake(String analyserMake) {
		this.analyserMake = analyserMake;
	}

	public String getAnalyserModel() {
		return analyserModel;
	}

	public void setAnalyserModel(String analyserModel) {
		this.analyserModel = analyserModel;
	}

	public String getAnalyserSerialNo() {
		return analyserSerialNo;
	}

	public void setAnalyserSerialNo(String analyserSerialNo) {
		this.analyserSerialNo = analyserSerialNo;
	}

	public String getDevidceIMEINo() {
		return devidceIMEINo;
	}

	public void setDevidceIMEINo(String devidceIMEINo) {
		this.devidceIMEINo = devidceIMEINo;
	}

	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	

	public String getMeasurmentMin() {
		return measurmentMin;
	}

	public void setMeasurmentMin(String measurmentMin) {
		this.measurmentMin = measurmentMin;
	}

	public String getMeasurmentMax() {
		return measurmentMax;
	}

	public void setMeasurmentMax(String measurmentMax) {
		this.measurmentMax = measurmentMax;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
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



	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
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
	public Date getLastModifiedDt() {
		return lastModifiedDt;
	}

	/**
	 * @param date the lastModifiedDt to set
	 */
	public void setLastModifiedDt(Date date) {
		this.lastModifiedDt = date;
	}

	

	
	

}
