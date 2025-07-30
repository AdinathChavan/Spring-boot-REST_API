package com.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{
	
	Order findByGenderAndMobileno(String gender, long mobileno);
	
	
	

}
