package com.webapp.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.request.RequestData;
import com.webapp.service.Servicelayer;

@RestController
@RequestMapping("/user")
public class Controller {
	
	@Autowired
	Servicelayer service;
	
	
	@GetMapping("/info/{name}")
	public ResponseEntity<RequestData> information(@PathVariable String name) {
		
		RequestData result = service.getData(name);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Security-token", UUID.randomUUID().toString());
		
		 ResponseEntity<RequestData> info = new ResponseEntity<RequestData>(result, headers,HttpStatusCode.valueOf(404
				 ));
		 
		 return info;
	}

}
