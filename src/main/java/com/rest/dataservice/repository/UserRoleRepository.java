package com.rest.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rest.dataservice.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
	
	@Query("FROM UserRole WHERE plantUserId =:plantUserId")
	List<UserRole> FindByUserId(@Param("plantUserId")Long plantUserId);

}
