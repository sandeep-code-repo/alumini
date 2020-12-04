package com.rest.dataservice.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.ParameterInfo;
import com.rest.dataservice.entity.PlantInfo;
import com.rest.dataservice.entity.RealPollutantLevelInfos;
import com.rest.dataservice.entity.StationInfo;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.helper.RealParameterInfoHelper;
import com.rest.dataservice.helper.RealPollutantLevelGraphHelper;
import com.rest.dataservice.helper.RealPollutantLevelHelper;
import com.rest.dataservice.helper.RealTimeStationParamLevelHelper;
import com.rest.dataservice.helper.RealTimeStationParamMapper;
import com.rest.dataservice.model.StationDateLevelGraphRequest;
import com.rest.dataservice.repository.ParameterInfoRepository;
import com.rest.dataservice.repository.PlantInfoRepository;
import com.rest.dataservice.repository.RealPollutantLevelInfosRepository;
import com.rest.dataservice.repository.StationInfoRepository;
import com.rest.dataservice.repository.UserRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

@Service
public class RealPollutantLevelServiceImpl implements RealPollutantLevelService{

	private static CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
			ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);

	private static CommonApiStatus errorApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_ERROR_STATUS, HttpStatus.INTERNAL_SERVER_ERROR,
			ApplicationConstants.API_OVER_ALL_ERROR_STATUS);

	@Autowired
	UserRepository userRepository;

	@Autowired
	PlantInfoRepository plantInfoRepository;

	@Autowired
	StationInfoRepository stationInfoRepository;

	@Autowired
	ParameterInfoRepository parameterInfoRepository;

	@Autowired
	RealPollutantLevelInfosRepository realPollutantLevelInfoRepository;

	@Override
	public ResponseObject getRealPoulltantLevelData(RealPollutantLevelInfos info) {

		try {

			List<RealParameterInfoHelper> listParameterInfo = new ArrayList<>();


			List<RealPollutantLevelInfos> listData = realPollutantLevelInfoRepository.getRealParamDataFromPlant(info.getPlantId());

			UserInfo userInfo = userRepository.findByUsername(listData.get(0).getPlantId());
			PlantInfo plantInfo= plantInfoRepository.getByPlantUser(userInfo.getUid());

			for (RealPollutantLevelInfos data : listData) {

				StationInfo stationInfo = stationInfoRepository.getStationInfo(plantInfo.getPid(),data.getStationId());
				ParameterInfo parameterInfo = parameterInfoRepository.getParamterInfo(data.getParameterCode(),data.getPlantId(),stationInfo.getSid());

				RealParameterInfoHelper parameterInfoHelper = new RealParameterInfoHelper();
				parameterInfoHelper.setUnit(parameterInfo.getUnit());
				parameterInfoHelper.setLimit(data.getThresholdLevel());
				parameterInfoHelper.setRange(parameterInfo.getMeasurmentMin()+"-"+parameterInfo.getMeasurmentMax());
				parameterInfoHelper.setParameter(data.getParameterCode());
				parameterInfoHelper.setParameterStatus(parameterInfo.getParameterStatus() == null ? true : parameterInfo.getParameterStatus());
				parameterInfoHelper.setRecordedLevel(data.getRecordedLevel());
				parameterInfoHelper.setRecordedTime(data.getRecordedTime());
				parameterInfoHelper.setThresholdLevel(data.getThresholdLevel());
				parameterInfoHelper.setStationName(stationInfo.getStationId()+" "+stationInfo.getProcessAttached()+" "+data.getParameterCode());
				parameterInfoHelper.setAnalyzer(data.getAnalyzer());
				parameterInfoHelper.setAggregation(data.getAggregation());
				listParameterInfo.add(parameterInfoHelper);

			}



			RealPollutantLevelHelper pollutantLevelHelper= new RealPollutantLevelHelper
					(plantInfo.getPlantName(), plantInfo.getCategory(), userInfo.getTown(), userInfo.getDistrict(), userInfo.getState(),stationInfoRepository.getStationCount(plantInfo.getPid()), listParameterInfo.size(), listParameterInfo);


			return new ResponseObject(pollutantLevelHelper,successApiStatus);

		}catch(Exception e) {

			return new ResponseObject("Error in fetching Real pollutant level data : "+e.getMessage(),errorApiStatus);

		}
	}


	@Override
	public ResponseObject getRealPollutantLevelGraphData(RealPollutantLevelInfos info) {

		try {

			List<RealPollutantLevelInfos> listData = new ArrayList<RealPollutantLevelInfos>();	
			if(info.getPlantId()==null || info.getParameterCode()==null) {

				return new ResponseObject("Error in fetching Real pollutant Graph level data : parameter ans plant id is manadatory",errorApiStatus);	

			}
			if(info.getRecordedTime()==null) {

				listData = realPollutantLevelInfoRepository.getRealParamDataFromParam(info.getPlantId(),info.getParameterCode());	

			}else {
				listData = realPollutantLevelInfoRepository.getRealParamDataFromParam(info.getPlantId(),info.getParameterCode(),info.getRecordedTime());
			}

			RealPollutantLevelGraphHelper pollutantLevelGraphHelper = new RealPollutantLevelGraphHelper();

			List<Date> recordedTime = new ArrayList<Date>();
			List<String> recordedLevel = new ArrayList<String>();
			List<String> thresholdLevel = new ArrayList<String>();
			List<String> aggregation = new ArrayList<String>();

			for (RealPollutantLevelInfos data : listData) {

				recordedTime.add(data.getRecordedTime());
				recordedLevel.add(data.getRecordedLevel());
				thresholdLevel.add(data.getThresholdLevel());
				aggregation.add(data.getAggregation());

			}

			pollutantLevelGraphHelper.setLabels(recordedTime);
			pollutantLevelGraphHelper.setEvents(recordedLevel);
			pollutantLevelGraphHelper.setThresholdLevel(thresholdLevel);
			pollutantLevelGraphHelper.setAggregation(aggregation);

			return new ResponseObject(pollutantLevelGraphHelper,successApiStatus);

		}catch(Exception e) {

			return new ResponseObject("Error in fetching Real pollutant Graph level data : "+e.getMessage(),errorApiStatus);

		}

	}

	@Override
	public ResponseObject getRealPollutantStationParamLevelInfos(RealPollutantLevelInfos info) {

		try {

			List<RealParameterInfoHelper> listParameterInfo = new ArrayList<>();
			List<String> listStationName = new ArrayList<>();


			List<RealPollutantLevelInfos> listData = realPollutantLevelInfoRepository.getRealParamDataFromPlant(info.getPlantId());

			UserInfo userInfo = userRepository.findByUsername(listData.get(0).getPlantId());
			PlantInfo plantInfo= plantInfoRepository.getByPlantUser(userInfo.getUid());

			List<RealParameterInfoHelper> emissionList = new ArrayList<>();
			List<RealParameterInfoHelper> effluentList = new ArrayList<>();
			List<RealParameterInfoHelper> ambientList = new ArrayList<>(); 

			for (RealPollutantLevelInfos data : listData) {

				StationInfo stationInfo = stationInfoRepository.getStationInfo(plantInfo.getPid(),data.getStationId());
				ParameterInfo parameterInfo = parameterInfoRepository.getParamterInfo(data.getParameterCode(),data.getPlantId(),stationInfo.getSid());

				RealParameterInfoHelper parameterInfoHelper = new RealParameterInfoHelper();
				parameterInfoHelper.setUnit(parameterInfo.getUnit());
				parameterInfoHelper.setLimit(data.getThresholdLevel());
				parameterInfoHelper.setRange(parameterInfo.getMeasurmentMin()+"-"+parameterInfo.getMeasurmentMax());
				parameterInfoHelper.setParameter(data.getParameterCode());
				parameterInfoHelper.setParameterStatus(parameterInfo.getParameterStatus() == null ? true : parameterInfo.getParameterStatus());
				parameterInfoHelper.setRecordedLevel(data.getRecordedLevel());
				parameterInfoHelper.setRecordedTime(data.getRecordedTime());
				parameterInfoHelper.setThresholdLevel(data.getThresholdLevel());
				parameterInfoHelper.setStationName(stationInfo.getStationId()+" "+stationInfo.getProcessAttached()+" "+data.getParameterCode());
				parameterInfoHelper.setAnalyzer(data.getAnalyzer());
				parameterInfoHelper.setAggregation(data.getAggregation());
				listParameterInfo.add(parameterInfoHelper);
				listStationName.add(stationInfo.getStationId()+" "+stationInfo.getProcessAttached()+" "+data.getParameterCode());

				if(stationInfo.getStnType().equalsIgnoreCase("Emission")) {

					emissionList.add(parameterInfoHelper);

				}else if(stationInfo.getStnType().equalsIgnoreCase("Effluent")) {

					effluentList.add(parameterInfoHelper);

				}else if(stationInfo.getStnType().equalsIgnoreCase("Ambient")) {

					ambientList.add(parameterInfoHelper);

				}

			}

			RealTimeStationParamMapper realTimeStationParamMapper= new RealTimeStationParamMapper();
			realTimeStationParamMapper.setEmissionList(emissionList);
			realTimeStationParamMapper.setEffluentList(effluentList);
			realTimeStationParamMapper.setAmbientList(ambientList);
			realTimeStationParamMapper.setEmissionListSize(emissionList.size());
			realTimeStationParamMapper.setEffluentListSize(effluentList.size());
			realTimeStationParamMapper.setAmbientListSize(ambientList.size());

			RealTimeStationParamLevelHelper realTimeStationParamLevelHelper= new RealTimeStationParamLevelHelper
					(plantInfo.getPlantName(), plantInfo.getCategory(), userInfo.getTown(), userInfo.getDistrict(), userInfo.getState(),stationInfoRepository.getStationCount(plantInfo.getPid()), listParameterInfo.size(),listStationName, realTimeStationParamMapper);


			return new ResponseObject(realTimeStationParamLevelHelper,successApiStatus);

		}catch(Exception e) {

			return new ResponseObject("Error in fetching Real Time Station Param Level data : "+e.getMessage(),errorApiStatus);

		}
	}

	@Override
	public ResponseObject getRealPoulltantStationDateLevelGraphData(StationDateLevelGraphRequest graphRequest) {

		try {

			List<RealPollutantLevelInfos> listData = new ArrayList<RealPollutantLevelInfos>();	
			if(graphRequest.getPlantId()==null || graphRequest.getParameter()==null || graphRequest.getStationId()==null) {

				return new ResponseObject("Error in fetching Real pollutant Graph level data : Station parameter and plant id is manadatory",errorApiStatus);	

			}
			if(graphRequest.getFromDate()==null || graphRequest.getToDate()==null) {

				//listData = realPollutantLevelInfoRepository.getRealStationWiseData(graphRequest.getPlantId(),graphRequest.getParameter(),graphRequest.getStationId(),graphRequest.getFrequency());	

			}else {
				listData = realPollutantLevelInfoRepository.getRealStationWiseDataFromDate(graphRequest.getPlantId(),graphRequest.getParameter(),graphRequest.getStationId(),graphRequest.getFromDate(),graphRequest.getToDate());
			}

			RealPollutantLevelGraphHelper pollutantLevelGraphHelper = new RealPollutantLevelGraphHelper();

			List<Date> recordedTime = new ArrayList<Date>();
			List<String> recordedLevel = new ArrayList<String>();
			List<String> thresholdLevel = new ArrayList<String>();
			List<String> aggregation = new ArrayList<String>();

			for (RealPollutantLevelInfos data : listData) {

				recordedTime.add(data.getRecordedTime());
				recordedLevel.add(data.getRecordedLevel());
				thresholdLevel.add(data.getThresholdLevel());
				aggregation.add(data.getAggregation());

			}

			pollutantLevelGraphHelper.setLabels(recordedTime);
			pollutantLevelGraphHelper.setEvents(recordedLevel);
			pollutantLevelGraphHelper.setThresholdLevel(thresholdLevel);
			pollutantLevelGraphHelper.setAggregation(aggregation);

			return new ResponseObject(pollutantLevelGraphHelper,successApiStatus);

		}catch(Exception e) {

			return new ResponseObject("Error in fetching Real pollutant Graph level data : "+e.getMessage(),errorApiStatus);

		}	
	}


}
