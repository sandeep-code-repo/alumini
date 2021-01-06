package com.bookstore.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.RealPollutantLevelInfos;

@Repository
public interface RealPollutantLevelInfosRepository extends JpaRepository<RealPollutantLevelInfos,Long>{

	
}
