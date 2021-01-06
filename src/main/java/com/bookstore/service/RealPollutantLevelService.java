package com.bookstore.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bookstore.entity.Author;
import com.bookstore.entity.RealPollutantLevelInfos;
import com.bookstore.repository.AuthorRepository;
import com.bookstore.repository.RealPollutantLevelInfosRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RealPollutantLevelService {

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize;

    static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
    
    private final RealPollutantLevelInfosRepository realPollutantLevelInfosRepository;

    public RealPollutantLevelService(RealPollutantLevelInfosRepository realPollutantLevelInfosRepository) {
        this.realPollutantLevelInfosRepository = realPollutantLevelInfosRepository;
    }

    public void batchAuthors() {

        List<RealPollutantLevelInfos> realPollutantLevelInfos = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
        	
        	RealPollutantLevelInfos realPollutantLevelInfo = new RealPollutantLevelInfos();
        	
        	Random r = new Random();
        	int low = 10;
        	int high = 20;
        	int result = r.nextInt(high-low) + low;
        	
        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	

        	Calendar date = Calendar.getInstance();
        	long t= date.getTimeInMillis();
        	Date afterAddingTenMins=new Date(t + (i * ONE_MINUTE_IN_MILLIS));
           
        	realPollutantLevelInfo.setPlantId("hindalco_lpng");
        	realPollutantLevelInfo.setAnalyzer("AAQ");
        	realPollutantLevelInfo.setStationId("AAQMS-1");
        	realPollutantLevelInfo.setParameterCode("NO2");
        	realPollutantLevelInfo.setAggregation("1Hr");
        	realPollutantLevelInfo.setThresholdLevel("0.00");
        	realPollutantLevelInfo.setRecordedLevel(String.valueOf(result));
        	realPollutantLevelInfo.setRecordedTime(afterAddingTenMins);
        	
        	
        	
        	Author author = new Author();
            author.setId((long) i + 1);
            author.setName("Name_" + i);
            author.setGenre("Genre_" + i);
            author.setAge(18 + i);

            realPollutantLevelInfos.add(realPollutantLevelInfo);

            if (i % batchSize == 0 && i > 0) {
            	realPollutantLevelInfosRepository.saveAll(realPollutantLevelInfos);
            	realPollutantLevelInfos.clear();
            }
        }

        if (realPollutantLevelInfos.size() > 0) {
        	realPollutantLevelInfosRepository.saveAll(realPollutantLevelInfos);
            realPollutantLevelInfos.clear();
        }
    }
}
