package com.rest.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.ParameterInfo;


@Repository
public interface ParameterInfoRepository extends JpaRepository<ParameterInfo,Integer>{
	
	@Query("FROM ParameterInfo WHERE sid=:sid")
	List<ParameterInfo> findBySId(@Param("sid")Long sid);

}
