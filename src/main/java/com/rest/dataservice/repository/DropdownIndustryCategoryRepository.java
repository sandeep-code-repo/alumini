package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.DropdownIndustryCategory;


@Repository
public interface DropdownIndustryCategoryRepository extends JpaRepository<DropdownIndustryCategory, Integer>{

}