package com.skeleton.alumini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skeleton.alumini.entity.PlantInfo;

@Repository
public interface PlantInfoRepository extends JpaRepository<PlantInfo, Integer>{

}
