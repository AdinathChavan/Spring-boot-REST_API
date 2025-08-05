package com.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {

}
