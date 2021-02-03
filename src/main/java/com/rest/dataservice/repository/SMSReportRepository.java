package com.rest.dataservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.IndustryCategory;
import com.rest.dataservice.entity.SMSReport;

@Repository
public interface SMSReportRepository extends JpaRepository<SMSReport, Integer> {

	@Query(value = "SELECT * FROM alumini.sms_report WHERE created_dt between :fromDate AND :toDate ORDER BY created_dt",
			 nativeQuery = true)
	List<SMSReport> getReportInRange(Date fromDate, Date toDate);

	@Query(value = "SELECT * FROM alumini.sms_report WHERE created_dt between :fromDate AND :toDate and industry_code=:plantId and parameter in (:params) AND station_name in (:stations);",
			 nativeQuery = true)
	List<SMSReport> getSMSReportDataFromDate(String plantId, List<String> params, List<String> stations, Date fromDate, Date toDate);
	
}
