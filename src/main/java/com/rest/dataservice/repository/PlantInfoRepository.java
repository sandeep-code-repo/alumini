package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.PlantInfo;

@Repository
public interface PlantInfoRepository extends JpaRepository<PlantInfo, Integer>{

}
