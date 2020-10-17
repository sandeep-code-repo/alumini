package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.MailHeader;

/**
 * @Kamal
 * @Date-17/09/2020
 */

@Repository
public interface MailHeaderRepository extends JpaRepository<MailHeader,Integer>{
	
	
	@Query("FROM MailHeader WHERE mailFilter=:filter")
	MailHeader findByFilter(String filter);

}
