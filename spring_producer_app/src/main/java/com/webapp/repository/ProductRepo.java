package com.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer>{
	
	public int deleteByPincode(int pincode);

}
