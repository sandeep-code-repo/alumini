package com.skeleton.alumini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skeleton.alumini.entity.StationInfo;

@Repository
public interface StationInfoRepository extends JpaRepository<StationInfo, Integer>{

}
