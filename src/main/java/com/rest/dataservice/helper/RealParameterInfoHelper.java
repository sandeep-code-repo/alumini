package com.rest.dataservice.helper;

public class RealParameterInfoHelper {

	private String parameterName;
	
	private String parameterCode;

	private String unit;

	private String limit;

	private String range;

	private String recordedTime;

	private String recordedLevel;
	
	private String thresholdLevel;
	
	private String aggregation;
	
	private String stationName;
	
	private String analyzer;

	private String parameterStatus;

	public RealParameterInfoHelper() {
		super();
	}


	public RealParameterInfoHelper(String parameterName, String parameterCode, String unit, String limit, String range,
			String recordedTime, String recordedLevel, String thresholdLevel, String aggregation, String stationName,
			String analyzer, String parameterStatus) {
		super();
		this.parameterName = parameterName;
		this.parameterCode = parameterCode;
		this.unit = unit;
		this.limit = limit;
		this.range = range;
		this.recordedTime = recordedTime;
		this.recordedLevel = recordedLevel;
		this.thresholdLevel = thresholdLevel;
		this.aggregation = aggregation;
		this.stationName = stationName;
		this.analyzer = analyzer;
		this.parameterStatus = parameterStatus;
	}



	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getRecordedTime() {
		return recordedTime;
	}

	public void setRecordedTime(String recordedTime) {
		this.recordedTime = recordedTime;
	}

	public String getThresholdLevel() {
		return thresholdLevel;
	}

	public void setThresholdLevel(String thresholdLevel) {
		this.thresholdLevel = thresholdLevel;
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

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(String analyzer) {
		this.analyzer = analyzer;
	}

	public String getParameterStatus() {
		return parameterStatus;
	}

	public void setParameterStatus(String parameterStatus) {
		this.parameterStatus = parameterStatus;
	}

	@Override
	public String toString() {
		return "RealParameterInfoHelper [parameterName=" + parameterName + ", parameterCode=" + parameterCode
				+ ", unit=" + unit + ", limit=" + limit + ", range=" + range + ", recordedTime=" + recordedTime
				+ ", recordedLevel=" + recordedLevel + ", thresholdLevel=" + thresholdLevel + ", aggregation="
				+ aggregation + ", stationName=" + stationName + ", analyzer=" + analyzer + ", parameterStatus="
				+ parameterStatus + "]";
	}

	
}
