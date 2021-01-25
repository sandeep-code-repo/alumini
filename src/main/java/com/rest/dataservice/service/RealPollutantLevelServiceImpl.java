package com.rest.dataservice.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

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
import com.rest.dataservice.util.DateFormatUtil;
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

				if(parameterInfo!=null && stationInfo!=null) {
					
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

			List<String> recordedTime = new ArrayList<String>();
			List<String> recordedLevel = new ArrayList<String>();
			List<String> thresholdLevel = new ArrayList<String>();
			List<String> aggregation = new ArrayList<String>();

			for (RealPollutantLevelInfos data : listData) {

				recordedTime.add(DateFormatUtil.dateFormatString(data.getRecordedTime()));
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

				if(parameterInfo!=null && stationInfo!=null) {
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

			SimpleDateFormat sdf = new SimpleDateFormat(ApplicationConstants.DATE_TIME_FORMATTER); 
			SimpleDateFormat sdf_date = new SimpleDateFormat(ApplicationConstants.DATE_FORMATTER);

			List<RealPollutantLevelInfos> listData = new ArrayList<RealPollutantLevelInfos>();
			List<RealPollutantLevelGraphHelper> pollutantGraphList = new ArrayList<RealPollutantLevelGraphHelper>();
			
			
			String[] param=graphRequest.getParameter().split(",");
			for (int i=0; i < param.length; i++){
		    
			if(graphRequest.getPlantId()==null || graphRequest.getParameter()==null || graphRequest.getStationId()==null) {

				return new ResponseObject("Error in fetching Real pollutant Graph level data : Station parameter and plant id is manadatory",errorApiStatus);	

			}else if(graphRequest.getFromDate()==null || graphRequest.getToDate()==null) {

				return new ResponseObject("Error in fetching Real pollutant Graph level data : From and to date",errorApiStatus);	

			}else {
				listData = realPollutantLevelInfoRepository.getRealStationWiseDataFromDate(graphRequest.getPlantId(),param[i],graphRequest.getStationId(),sdf.parse(graphRequest.getFromDate()),sdf.parse(graphRequest.getToDate()));
			}

			List<String> distinctTime = realPollutantLevelInfoRepository.getDistinctTime(graphRequest.getPlantId(),param[i],graphRequest.getStationId(),sdf.parse(graphRequest.getFromDate()),sdf.parse(graphRequest.getToDate()));
			List<String> distinctMonth = realPollutantLevelInfoRepository.getDistinctMonth(graphRequest.getPlantId(),param[i],graphRequest.getStationId(),sdf.parse(graphRequest.getFromDate()),sdf.parse(graphRequest.getToDate()));

			RealPollutantLevelGraphHelper pollutantLevelGraphHelper = new RealPollutantLevelGraphHelper();
			
			List<String> recordedTime = new ArrayList<String>();
			List<String> recordedLevel = new ArrayList<String>();
			List<String> thresholdLevel = new ArrayList<String>();
			List<String> aggregation = new ArrayList<String>();
			

			if(graphRequest.getFrequency().equalsIgnoreCase("15 Minutes")){

				for (RealPollutantLevelInfos data : listData) {

					long diff_in_time = sdf.parse(graphRequest.getFromDate()).getTime()- sdf.parse(DateFormatUtil.dateFormatString(data.getRecordedTime())).getTime();

					long difference_In_Minutes 
					= (diff_in_time 
							/ (1000 * 60)) 
					% 60;
					if(difference_In_Minutes%15L==0) {
						recordedTime.add(DateFormatUtil.dateFormatString(data.getRecordedTime()));
						recordedLevel.add(data.getRecordedLevel());
						thresholdLevel.add(data.getThresholdLevel());
						aggregation.add(data.getAggregation());
					}
					
				}

			}else if(graphRequest.getFrequency().equalsIgnoreCase("1 Day")){



				for (String info : distinctTime) { 
					List<Double> recordedLevelTemp = new ArrayList<Double>();
					List<Double> thresholdLevelTemp = new ArrayList<Double>();
					for (RealPollutantLevelInfos data : listData) {

						if(sdf_date.parse(sdf_date.format(data.getRecordedTime())).compareTo(sdf_date.parse(info))==0) {
							recordedLevelTemp.add(Double.parseDouble(data.getRecordedLevel()));
							thresholdLevelTemp.add(Double.parseDouble(data.getThresholdLevel()));
						}

					}

					double recordedLevelAvg = recordedLevelTemp.stream().mapToDouble(a->a).average().orElse(0);
					double thresholdLevelAvg = thresholdLevelTemp.stream().mapToDouble(a->a).average().orElse(0);

					recordedTime.add(info);
					recordedLevel.add(Double.toString(recordedLevelAvg));
					thresholdLevel.add(Double.toString(thresholdLevelAvg));

				}


			}else if(graphRequest.getFrequency().equalsIgnoreCase("1 Month")){



				for (String month : distinctMonth) { 
					List<Double> recordedLevelTemp = new ArrayList<Double>();
					List<Double> thresholdLevelTemp = new ArrayList<Double>();
					for (RealPollutantLevelInfos data : listData) {

						if(sdf_date.format(data.getRecordedTime()).substring(0,7).equalsIgnoreCase(month)) {
							recordedLevelTemp.add(Double.parseDouble(data.getRecordedLevel()));
							thresholdLevelTemp.add(Double.parseDouble(data.getThresholdLevel()));
						}

					}

					double recordedLevelAvg = recordedLevelTemp.stream().mapToDouble(a->a).average().orElse(0);
					double thresholdLevelAvg = thresholdLevelTemp.stream().mapToDouble(a->a).average().orElse(0);

					recordedTime.add(month+"-01");
					recordedLevel.add(Double.toString(recordedLevelAvg));
					thresholdLevel.add(Double.toString(thresholdLevelAvg));

			}


			}else{
				for (RealPollutantLevelInfos data : listData) {
					recordedTime.add(DateFormatUtil.dateFormatString(data.getRecordedTime()));
					recordedLevel.add(data.getRecordedLevel());
					thresholdLevel.add(data.getThresholdLevel());
					aggregation.add(data.getAggregation());
				}

			}


			pollutantLevelGraphHelper.setLabels(recordedTime);
			pollutantLevelGraphHelper.setEvents(recordedLevel);
			pollutantLevelGraphHelper.setThresholdLevel(thresholdLevel);
			pollutantLevelGraphHelper.setAggregation(aggregation);
			pollutantLevelGraphHelper.setParameter(param[i]);
			
			pollutantGraphList.add(pollutantLevelGraphHelper);
			
		    }

			return new ResponseObject(pollutantGraphList,successApiStatus);

		}catch(Exception e) {

			return new ResponseObject("Error in fetching Real pollutant Graph level data : "+e.getMessage(),errorApiStatus);

		}	
	}


	@Override
	public ResponseObject getRealPoulltantLevelAllData() {
		return new ResponseObject(realPollutantLevelInfoRepository.findAll(),successApiStatus);
	}


}
