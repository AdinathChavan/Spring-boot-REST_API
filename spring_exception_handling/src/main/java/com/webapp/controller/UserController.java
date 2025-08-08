package com.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.DTO.RequestDTO;
import com.webapp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@PostMapping("/info")
	public String information(@RequestBody RequestDTO request) {
		
		return service.userInformation();		
		
	}
	
	@GetMapping("/get")
	public String getInfo() {
		return service.data();
	}
	
	

}
