package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.dataservice.entity.SteelPlant;

public interface SteelPlantRepository extends JpaRepository<SteelPlant, Long> {
	
}
