package com.rest.dataservice.helper;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LiveStatusHelper {
	
	private String siteId;
	private String siteName;
	private String siteLabel;
	private String street;
	private String city;
	private String district;
	private String state;
	private String country;
	private String postcode;
	private String ro;
	private String industryType;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateofConfiguration;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastSynchronizedsort;
	
	private String lastSynchronized;
	private String siteStatus;
	private String exceedance;
	private String vendor;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastSynchronizedtime;
	
	private String phonenumbers;
	private String cameraStatus;
	
	public LiveStatusHelper() {
	}

	public LiveStatusHelper(String siteId, String siteName, String siteLabel, String street, String city,
			String district, String state, String country, String postcode, String ro, String industryType,
			Date dateofConfiguration, Date lastSynchronizedsort, String lastSynchronized, String siteStatus,
			String exceedance, String vendor, Date lastSynchronizedtime, String phonenumbers, String cameraStatus) {
		super();
		this.siteId = siteId;
		this.siteName = siteName;
		this.siteLabel = siteLabel;
		this.street = street;
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
		this.postcode = postcode;
		this.ro = ro;
		this.industryType = industryType;
		this.dateofConfiguration = dateofConfiguration;
		this.lastSynchronizedsort = lastSynchronizedsort;
		this.lastSynchronized = lastSynchronized;
		this.siteStatus = siteStatus;
		this.exceedance = exceedance;
		this.vendor = vendor;
		this.lastSynchronizedtime = lastSynchronizedtime;
		this.phonenumbers = phonenumbers;
		this.cameraStatus = cameraStatus;
	}
	
	
	
	@Override
	public String toString() {
		return "LiveStatusHelper [siteId=" + siteId + ", siteName=" + siteName + ", siteLabel=" + siteLabel
				+ ", street=" + street + ", city=" + city + ", district=" + district + ", state=" + state + ", country="
				+ country + ", postcode=" + postcode + ", ro=" + ro + ", industryType=" + industryType
				+ ", dateofConfiguration=" + dateofConfiguration + ", lastSynchronizedsort=" + lastSynchronizedsort
				+ ", lastSynchronized=" + lastSynchronized + ", siteStatus=" + siteStatus + ", exceedance=" + exceedance
				+ ", vendor=" + vendor + ", lastSynchronizedtime=" + lastSynchronizedtime + ", phonenumbers="
				+ phonenumbers + ", cameraStatus=" + cameraStatus + "]";
	}




	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteLabel() {
		return siteLabel;
	}
	public void setSiteLabel(String siteLabel) {
		this.siteLabel = siteLabel;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getrO() {
		return ro;
	}
	public void setrO(String ro) {
		this.ro = ro;
	}
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	public Date getDateofConfiguration() {
		return dateofConfiguration;
	}
	public void setDateofConfiguration(Date dateofConfiguration) {
		this.dateofConfiguration = dateofConfiguration;
	}
	public Date getLastSynchronizedsort() {
		return lastSynchronizedsort;
	}
	public void setLastSynchronizedsort(Date lastSynchronizedsort) {
		this.lastSynchronizedsort = lastSynchronizedsort;
	}
	public String getLastSynchronized() {
		return lastSynchronized;
	}
	public void setLastSynchronized(String lastSynchronized) {
		this.lastSynchronized = lastSynchronized;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getExceedance() {
		return exceedance;
	}
	public void setExceedance(String exceedance) {
		this.exceedance = exceedance;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Date getLastSynchronizedtime() {
		return lastSynchronizedtime;
	}
	public void setLastSynchronizedtime(Date lastSynchronizedtime) {
		this.lastSynchronizedtime = lastSynchronizedtime;
	}
	public String getPhonenumbers() {
		return phonenumbers;
	}
	public void setPhonenumbers(String phonenumbers) {
		this.phonenumbers = phonenumbers;
	}
	public String getCameraStatus() {
		return cameraStatus;
	}
	public void setCameraStatus(String cameraStatus) {
		this.cameraStatus = cameraStatus;
	}
	
	

}
