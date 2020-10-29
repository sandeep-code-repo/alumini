package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.PlantInfo;

@Repository
public interface PlantInfoRepository extends JpaRepository<PlantInfo, Integer>{

	 @Query("FROM PlantInfo WHERE  userId=:userId ") 
	  PlantInfo getByPlantUser(@Param("userId")Long userId);
}
