package com.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.Entity.EmpEntity;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity,Integer>{

	
	public List<EmpEntity> findByEmailId(String email);
}
