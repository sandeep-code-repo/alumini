package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.entity.User;

/**
 * @Jayashree
 * @Date-17/09/2020
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query("FROM UserInfo WHERE username=:username and password =:password")
	UserInfo findByUsername(String username,String password);

}
