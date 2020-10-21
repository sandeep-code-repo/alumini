package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.PlantInfo;

@Repository
public interface PlantInfoRepository extends JpaRepository<PlantInfo, Integer>{

	 @Query("FROM PlantInfo WHERE  plantUserName=:plantUserName AND email=:email") 
	  PlantInfo findSavedRegistration(@Param("plantUserName")String plantUserName,@Param("email")String email);
	 
	 @Query("FROM PlantInfo WHERE  plantUserName=:plantUserName ") 
	  PlantInfo getByPlantUser(@Param("plantUserName")String plantUserName);
}
