package com.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.Entity.UserEntity;
import com.webapp.request.UserRequest;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	public UserEntity findByCity(String name);

}
