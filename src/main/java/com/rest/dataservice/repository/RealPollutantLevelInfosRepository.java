package com.rest.dataservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.ParameterInfo;
import com.rest.dataservice.entity.RealPollutantLevelInfos;
import com.rest.dataservice.entity.SMSReport;
import com.rest.dataservice.helper.RealPollutantLevelGraphHelper;

@Repository
public interface RealPollutantLevelInfosRepository extends JpaRepository<RealPollutantLevelInfos,Long>{

	//@Query("FROM RealPollutantLevelInfos WHERE plantId=:plantId")
	@Query(value = "SELECT * from (select max(recorded_time) maxTime, parameter_code from alumini.real_pollutant_level_infos group by parameter_code) maxTimeParam inner join alumini.real_pollutant_level_infos ed on ed.parameter_code = maxTimeParam.parameter_code and ed.recorded_time = maxTimeParam.maxTime WHERE plant_id=:plantId", 
		    nativeQuery = true)
	List<RealPollutantLevelInfos> getRealParamDataFromPlant(@Param("plantId") String plantId);

	@Query(value = "SELECT * FROM alumini.real_pollutant_level_infos WHERE recorded_time >= (select max(recorded_time) from alumini.real_pollutant_level_infos where plant_id=:plantId and parameter_code=:parameterCode) - INTERVAL 1 DAY and plant_id=:plantId and parameter_code=:parameterCode ORDER BY recorded_time", 
		    nativeQuery = true)
	List<RealPollutantLevelInfos> getRealParamDataFromParam(@Param("plantId") String plantId,@Param("parameterCode") String parameterCode);
	
	@Query(value = "SELECT * FROM alumini.real_pollutant_level_infos WHERE recorded_time >= :date - INTERVAL 1 DAY and plant_id=:plantId and parameter_code=:parameterCode ORDER BY recorded_time", 
		    nativeQuery = true)
	List<RealPollutantLevelInfos> getRealParamDataFromParam(String plantId, String parameterCode, Date date);

	//List<RealPollutantLevelGraphHelper> getRealStationWiseData(String plantId, String parameter, String stationId, String frequency);

	@Query(value = "SELECT * FROM alumini.real_pollutant_level_infos WHERE recorded_time between :fromDate AND :toDate AND plant_id=:plantId AND station_id=:stationId AND parameter_code=:parameter ORDER BY recorded_time",
			 nativeQuery = true)
	List<RealPollutantLevelInfos> getRealStationWiseDataFromDate(String plantId, String parameter, String stationId,Date fromDate, Date toDate);

	@Query(value = "SELECT DISTINCT(DATE(rpli.recorded_time)) FROM alumini.real_pollutant_level_infos rpli WHERE recorded_time between :fromDate AND :toDate AND plant_id=:plantId AND station_id=:stationId AND parameter_code=:parameter ORDER BY recorded_time",
			 nativeQuery = true)
	List<String> getDistinctTime(@Param("plantId") String plantId, @Param("parameter") String parameter, @Param("stationId") String stationId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query(value = "SELECT DISTINCT SUBSTRING(recorded_time, 1, 7) FROM alumini.real_pollutant_level_infos rpli WHERE recorded_time between :fromDate AND :toDate AND plant_id=:plantId AND station_id=:stationId AND parameter_code=:parameter ORDER BY recorded_time",
			 nativeQuery = true)
	List<String> getDistinctMonth(@Param("plantId") String plantId, @Param("parameter") String parameter, @Param("stationId") String stationId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);


}
