package com.skeleton.alumini.entity;

import java.io.Serializable;

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
	private Integer paraId;
	
	@Column(name = "sid")
	private Integer sid;
	
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
	
	@Column(name = "measurement_Range")
	private String measurmentRange;
	
	@Column(name = "Unit")
	private String Unit;

	public Integer getParaId() {
		return paraId;
	}

	public void setParaId(Integer paraId) {
		this.paraId = paraId;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
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

	public String getMeasurmentRange() {
		return measurmentRange;
	}

	public void setMeasurmentRange(String measurmentRange) {
		this.measurmentRange = measurmentRange;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}
	
	
	
	
	
	
	

}
