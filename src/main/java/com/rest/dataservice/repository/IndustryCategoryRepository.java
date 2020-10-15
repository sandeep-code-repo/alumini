package com.rest.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.IndustryCategory;

@Repository
public interface IndustryCategoryRepository extends JpaRepository<IndustryCategory, Integer> {
	
	@Query("FROM IndustryCategory WHERE category=:category")
	List<IndustryCategory> getIndustryDetailsByCategory(@Param("category")String category);

	
	@Query("FROM IndustryCategory WHERE name=:name")
	IndustryCategory editByname(@Param("name")String name);

}
