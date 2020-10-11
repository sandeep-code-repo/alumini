package com.skeleton.alumini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skeleton.alumini.entity.IndustryCatagory;

@Repository
public interface IndustryCategoryRepository extends JpaRepository<IndustryCatagory, Integer> {
	
	@Query("FROM IndustryCatagory WHERE category=:category")
	List<IndustryCatagory> getIndustryDetailsByCategory(@Param("category")String category);

	
	@Query("FROM IndustryCatagory WHERE name=:name")
	IndustryCatagory editByname(@Param("name")String name);

}
