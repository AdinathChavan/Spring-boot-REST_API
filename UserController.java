package com.webapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.request.UserRequest;
import com.webapp.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService service;

	@PostMapping("/new")
	public String addUser(@RequestBody UserRequest request) {
		
		return service.addNewUser(request);
		
	}
	
	
	@GetMapping("/get/{city}")
	public UserRequest getData(@PathVariable String city) {
		
		return service.getUser(city);
	}
	
	@GetMapping("/id/{id}")
	public UserRequest getId(@PathVariable int id) {
		return service.getById(id);
	}
	
	
	
}
