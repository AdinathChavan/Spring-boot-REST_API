package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.Entity.EmpEntity;
import com.webapp.service.EmpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmpService service;
	
	@PostMapping("/new")
	public String getData(@Valid @RequestBody EmpEntity data){
	 String result = service.empData(data);
	 
	 return result;
	}
	
	
	@GetMapping("/get/{emailId}")
	public List<EmpEntity> getEmail(@PathVariable String emailId)
	{
		 return service.getEmailId(emailId);
	}
}
