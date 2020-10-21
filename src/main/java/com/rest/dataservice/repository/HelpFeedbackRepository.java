package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.entity.HelpFeedback;
import com.rest.dataservice.entity.PlantInfo;
import com.rest.dataservice.entity.User;

/**
 * @Kamal
 * @Date-17/09/2020
 */

@Repository
public interface HelpFeedbackRepository extends JpaRepository<HelpFeedback,Integer>{
	

}
