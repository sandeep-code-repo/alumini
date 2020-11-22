package com.rest.dataservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "real_pollutant_level_infos")
public class RealPollutantLevelInfos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "plant_id")
	private String plantId;
	
	@Column(name = "analyzer")
	private String analyzer;
	
	@Column(name = "station_id")
	private String stationId;
	
	@Column(name = "parameter_code") 
	private String parameterCode;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "recorded_time")
	private Date recordedTime;
	
	@Column(name = "recorded_level")
	private String recordedLevel;
	
	@Column(name = "aggregation")
	private String aggregation;
	
	@Column(name = "threshold_level")
	private String thresholdLevel;

	public RealPollutantLevelInfos(long id, String plantId, String analyzer, String stationId, String parameterCode,
			Date recordedTime, String recordedLevel, String aggregation, String thresholdLevel) {
		super();
		this.id = id;
		this.plantId = plantId;
		this.analyzer = analyzer;
		this.stationId = stationId;
		this.parameterCode = parameterCode;
		this.recordedTime = recordedTime;
		this.recordedLevel = recordedLevel;
		this.aggregation = aggregation;
		this.thresholdLevel = thresholdLevel;
	}

	public RealPollutantLevelInfos() {
		super();
	}

	@Override
	public String toString() {
		return "RealPollutantLevelInfos [id=" + id + ", plantId=" + plantId + ", analyzer=" + analyzer + ", stationId="
				+ stationId + ", parameterCode=" + parameterCode + ", recordedTime=" + recordedTime + ", recordedLevel="
				+ recordedLevel + ", aggregation=" + aggregation + ", thresholdLevel=" + thresholdLevel + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlantId() {
		return plantId;
	}

	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}

	public String getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(String analyzer) {
		this.analyzer = analyzer;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}

	public Date getRecordedTime() {
		return recordedTime;
	}

	public void setRecordedTime(Date recordedTime) {
		this.recordedTime = recordedTime;
	}

	public String getRecordedLevel() {
		return recordedLevel;
	}

	public void setRecordedLevel(String recordedLevel) {
		this.recordedLevel = recordedLevel;
	}

	public String getAggregation() {
		return aggregation;
	}

	public void setAggregation(String aggregation) {
		this.aggregation = aggregation;
	}

	public String getThresholdLevel() {
		return thresholdLevel;
	}

	public void setThresholdLevel(String thresholdLevel) {
		this.thresholdLevel = thresholdLevel;
	}
	

}
