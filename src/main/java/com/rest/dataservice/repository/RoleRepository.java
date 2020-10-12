package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
