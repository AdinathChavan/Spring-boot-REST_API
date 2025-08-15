package com.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.entity.UserInformation;

public interface UserRepository extends JpaRepository<UserInformation, String>{

	public UserInformation findByUserNameAndPassword(String username, String password);
	
}
