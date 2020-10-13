package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.dataservice.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

}
