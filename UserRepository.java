package com.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.Entity.UserEntity;
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	public List<UserEntity> findByCity(String name);
	
	public List<UserEntity> findByPincodeAndCity(int pincode, String city);
	
	

}
