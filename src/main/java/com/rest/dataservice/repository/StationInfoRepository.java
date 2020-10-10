package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.dataservice.entity.StationInfo;

public interface StationInfoRepository extends JpaRepository<StationInfo, Integer>{

}
