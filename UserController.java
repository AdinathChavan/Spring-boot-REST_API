package com.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.DTO.OrderDto;
import com.webapp.inputclass.Ids;
import com.webapp.pojo.Details;
import com.webapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@PostMapping(path="/order")
	public String getData(@RequestBody Details data) {
		
		String result = service.userDataFetch(data);
		
		return result;
		
	}
	
	@PostMapping(path="/info")
	public OrderDto  information(Ids id) {
		
		OrderDto object = service.userDataPrinting(8879);
		
	        return object;
		
//		OrderDto object= service.userData(id);
//		
//		return object;
//		
		
	}

}
