package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.ParameterInfo;


@Repository
public interface ParameterInfoRepository extends JpaRepository<ParameterInfo,Integer>{

}
