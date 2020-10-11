package com.skeleton.alumini.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skeleton.alumini.entity.Industry;

@Repository
public interface IndustryRepository extends CrudRepository<Industry,Long>{

}
