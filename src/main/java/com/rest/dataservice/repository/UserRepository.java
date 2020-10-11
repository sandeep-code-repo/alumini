package com.skeleton.alumini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skeleton.alumini.entity.UseInfo;
import com.skeleton.alumini.entity.User;

/**
 * @Jayashree
 * @Date-17/09/2020
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query("FROM UseInfo WHERE userName=:userName and password =:password")
	UseInfo findByUsername(String userName,String password);

}
