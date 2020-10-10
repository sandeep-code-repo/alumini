package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.UserAuth;

/**
 * @Jayashree
 * @Date-17/09/2020
 */

@Repository
public interface UserRepository extends JpaRepository<UserAuth,Long>{
	
	UserAuth findByUsername(String uname);

}
