package com.rest.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.entity.PlantInfo;
import com.rest.dataservice.entity.User;

/**
 * @Jayashree
 * @Date-17/09/2020
 */

@Repository
public interface UserRepository extends JpaRepository<UserInfo,Integer>{
	
	@Query("FROM UserInfo WHERE userName=:username and password =:password")
	UserInfo findByUsername(String username,String password);

	@Query("select rsaPublicKey FROM UserInfo WHERE userName=:username")
	String findPublicKeyByUsername(String username);
	
	@Query("select rsaPrivateKey FROM UserInfo WHERE userName=:username")
	String findPrivateKeyByUsername(String username);

	@Query("FROM UserInfo WHERE email=:email")
	UserInfo findUserByEmail(String email);
	
	@Query("FROM UserInfo WHERE userName=:username")
	UserInfo findByUsername(String username);
	
	@Query("FROM UserInfo WHERE userName=:userName")
	UserInfo findByUser(@Param("userName")String userName);
	
	@Query("FROM PlantInfo WHERE  userName=:userName AND regStatus= 0") 
	UserInfo findRegStatus(@Param("userName")String userName);

	@Query("FROM UserInfo WHERE mobNo=:mobNo")
	UserInfo getUserByMob(String mobNo);

	@Query("FROM UserInfo WHERE uid=:userId")
	UserInfo findByUserId(Long userId);

}
