package com.rest.dataservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.Industry;

@Repository
public interface IndustryRepository extends CrudRepository<Industry,Long>{

}
