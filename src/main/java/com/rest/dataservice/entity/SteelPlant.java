package com.rest.dataservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "steel_plants")
public class SteelPlant {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plant_id")
	private Integer plantId;
	
	@Column(name = "plant_name")
	private String plantName;
	
	@Column(name = "plant_addr")
	private String plantAddress;
	
	@Column(name = "plant_status")
	private String plantStatus;
	
	public SteelPlant() {
	
	}


	/**
	 * @param plantId
	 * @param plantName
	 * @param plantAddress
	 * @param plantStatus
	 */
	public SteelPlant(Integer plantId, String plantName, String plantAddress, String plantStatus) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
		this.plantAddress = plantAddress;
		this.plantStatus = plantStatus;
	}




	/**
	 * @return the plantId
	 */
	public Integer getPlantId() {
		return plantId;
	}


	/**
	 * @param plantId the plantId to set
	 */
	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}


	/**
	 * @return the plantName
	 */
	public String getPlantName() {
		return plantName;
	}


	/**
	 * @param plantName the plantName to set
	 */
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}


	/**
	 * @return the plantDescription
	 */
	public String getPlantAddress() {
		return plantAddress;
	}


	/**
	 * @param plantDescription the plantDescription to set
	 */
	public void setPlantAddress(String plantAddress) {
		this.plantAddress = plantAddress;
	}


	/**
	 * @return the plantStatus
	 */
	public String getPlantStatus() {
		return plantStatus;
	}


	/**
	 * @param plantStatus the plantStatus to set
	 */
	public void setPlantStatus(String plantStatus) {
		this.plantStatus = plantStatus;
	}


	@Override
	public String toString() {
		return "SteelPlant [plantId=" + plantId + ", plantName=" + plantName + ", plantAddress=" + plantAddress
				+ ", plantStatus=" + plantStatus + "]";
	}

	

}
