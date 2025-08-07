package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.request.RequestDTO;
import com.webapp.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@PostMapping("/add")
	public String addData(@RequestBody RequestDTO data ) {
		
		return service.add(data);
	}
	
	@GetMapping("/get")
	public List<RequestDTO> getData() {
		
		 return service.getData();
	}
	
	@GetMapping("/get/id/{id}")
	public RequestDTO getById(@PathVariable  int id) {
		return service.byId(id);
	}
	
	@GetMapping("/id")
	public RequestDTO getByIdentity(@RequestParam int id) {
		return service.byId(id);
	}
	
	@DeleteMapping("/delete/id")
	public String delete(@RequestParam int id) {
		return service.deleteById(id);
	}
	
	@DeleteMapping("/delete/pincode")
	public String deleteByPin(@RequestParam int pincode) {
		return service.deleteByPincode(pincode);
	}
	

}
