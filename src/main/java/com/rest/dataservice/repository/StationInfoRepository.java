package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.StationInfo;

@Repository
public interface StationInfoRepository extends JpaRepository<StationInfo, Integer>{

}
