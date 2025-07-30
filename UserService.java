package com.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.DTO.OrderDto;
import com.webapp.entity.Order;
import com.webapp.inputclass.Ids;
import com.webapp.pojo.Details;
import com.webapp.repository.OrderRepo;

@Service
public class UserService {
	@Autowired
	OrderRepo repository;

	
	public String userDataFetch(Details data ) {
		
		Order info = new Order();
		
		info.setAdderess(data.getAdderess());
		info.setGender(data.getGender());
		info.setId(data.getId());
		info.setMobileno(data.getMobileno());
		info.setPrize(data.getPrize());
		info.setProduct(data.getProduct());
		
		repository.save(info);
		
		return "Data inserted successfully....";
		
	}
	
//	public OrderDto userData(Ids id) {
//		
//		Order data = repository.findByGenderAndMobileno("male",);
//		
//		OrderDto info = new OrderDto();
//		info.setAdderess(data.getAdderess());
//		info.setMobileno(data.getMobileno());
//		info.setPrize(data.getPrize());
//		info.setProduct(data.getProduct());
//		info.setGender(data.getGender());
//		
//		return info;
//	}
//	
	
	public OrderDto userDataPrinting(int id) {
    Order info  = repository.findById(id).orElseThrow();
	  
	  OrderDto dt = new OrderDto();
	  dt.setAdderess(info.getAdderess());
	  dt.setGender(info.getGender());
	  dt.setMobileno(info.getMobileno());
	  dt.setPrize(info.getPrize());
	  dt.setProduct(info.getProduct());
	  
	  return dt;
	}
}
