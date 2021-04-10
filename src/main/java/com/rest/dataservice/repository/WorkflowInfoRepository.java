package com.rest.dataservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.IndustryCategory;
import com.rest.dataservice.entity.RealPollutantLevelInfos;
import com.rest.dataservice.entity.SMSReport;
import com.rest.dataservice.entity.WorkflowInfo;

@Repository
public interface WorkflowInfoRepository extends JpaRepository<WorkflowInfo, Integer> {

	
	@Query(value = "SELECT * from alumini.workflow_info WHERE plant_id like :plantId%", 
		    nativeQuery = true)
	WorkflowInfo getDetailsByPlantId(@Param("plantId") String plantId);
	
	@Query(value = "SELECT * from alumini.workflow_info WHERE plant_id like :plantId% AND created_dt between :fromDate AND :toDate AND site_category like :siteCategory% AND assigned_to like :assignedTo% AND site_name like :siteName%", 
		    nativeQuery = true)
	List<WorkflowInfo> getDetailsByParam(@Param("plantId") String plantId,@Param("fromDate") Date fromDate,@Param("toDate") Date toDate,@Param("siteCategory") String siteCategory,@Param("assignedTo") String assignedTo,@Param("siteName") String siteName);

	
}
