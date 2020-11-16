package com.rest.dataservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name = "recorded_time")
	private Date recordedTime;
	
	@Column(name = "recorded_level")
	private String recordedLevel;
	
	@Column(name = "aggregation")
	private String aggregation;
	
	@Column(name = "threshold_level")
	private String thresholdLevel;

}
