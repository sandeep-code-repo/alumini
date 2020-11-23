package com.rest.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.ParameterInfo;
import com.rest.dataservice.entity.RealPollutantLevelInfos;


@Repository
public interface ParameterInfoRepository extends JpaRepository<ParameterInfo,Integer>{
	
	@Query("FROM ParameterInfo WHERE sid=:sid")
	List<ParameterInfo> findBySId(@Param("sid")Long sid);

	//@Query("unit FROM ParameterInfo WHERE parameter=:parameter and createdBy=:userId")
	//String getParamUnit(@Param("parameter")String parameter,@Param("userId")String userId);

	//@Query("measurmentMin FROM ParameterInfo WHERE parameter=:parameter and createdBy=:userId")
	//String getLowerLimit(String parameterCode, String plantId);

	//@Query("measurmentMax FROM ParameterInfo WHERE parameter=:parameter and createdBy=:userId")
	//String getHigherLimit(String parameterCode, String plantId);

	@Query("FROM ParameterInfo WHERE paramter=:parameter and createdBy=:userId and sid=:sid")
	ParameterInfo getParamterInfo(@Param("parameter")String parameter,@Param("userId")String userId,@Param("sid")long sid);
	
	@Query(value ="SELECT * FROM alumini.parameter_info where sid in (select sid from alumini.station_info where stn_type=:stnType and plant_id =(select pid from alumini.plant_info where user_id=(select uid from alumini.user_info where user_name=:userId)))",
			nativeQuery = true)
	List<ParameterInfo> getParamterFromStation(@Param("userId")String userId,@Param("stnType")String stnType);

}
