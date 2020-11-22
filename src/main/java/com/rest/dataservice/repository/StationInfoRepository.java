package com.rest.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.StationInfo;

@Repository
public interface StationInfoRepository extends JpaRepository<StationInfo, Integer>{
	
	@Query("FROM StationInfo WHERE plantId=:plantId")
	List<StationInfo> findByplantId(@Param("plantId")Long plantId);

	@Query("FROM StationInfo WHERE plantId=:plantId and stationId=:stationId")
	StationInfo getStationInfo(@Param("plantId")Long plantId, @Param("stationId") String stationId);

	@Query(value="SELECT count(*) FROM station_info WHERE plant_id=:plantId",
			nativeQuery = true)
	int getStationCount(long plantId);

}
