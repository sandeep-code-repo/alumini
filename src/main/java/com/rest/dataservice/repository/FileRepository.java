package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.dataservice.entity.FilePath;

public interface FileRepository extends JpaRepository<FilePath, Integer> {

}
