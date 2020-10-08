package com.skeleton.alumini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skeleton.alumini.entity.ParameterInfo;


@Repository
public interface ParameterInfoRepository extends JpaRepository<ParameterInfo,Integer>{

}
