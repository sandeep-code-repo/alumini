package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rest.dataservice.entity.Employee;

public interface PlantRegistrationRepository extends JpaRepository<Employee, Integer> {

	@Query("FROM Employee WHERE iName=:iName")
	Employee getEmpByName(@Param("iName") String iName);

	@Query("FROM Employee WHERE iName=:iName")
	Employee editByEname(@Param("iName") String iName);
	
	@Modifying
	@Query("UPDATE Employee SET status =:status WHERE iName=:iName")
	Employee deleteUser(@Param("iName")String iName, @Param("status")String status);
	
	

}
