package com.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.Entity.UserEntity;
import com.webapp.repository.UserRepository;
import com.webapp.request.UserRequest;

//@Id
//private int id;
//
//private String name;
//
//private double salary;
//
//private String city;
//
//private String mobileno;
//
//private int pincode;
//

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public String addNewUser(UserRequest request) {
		
		
		UserEntity one = new UserEntity();
		
		one.setId(request.getId());
		one.setName(request.getName());
		one.setSalary(request.getSalary());
		one.setCity(request.getCity());
		one.setMobileno(request.getMobileno());
		one.setPincode(request.getPincode());
		
		
		repository.save(one);
		
		return "User added successfully..........";
	}

	public UserRequest getUser(String city) {
		
		UserEntity info = repository.findByCity(city);
		
		if(info!=null) {
		UserRequest out = new UserRequest();
		  out.setCity(info.getCity());
		  out.setId(info.getId());
		  out.setMobileno(info.getMobileno());
		  out.setName(info.getName());
		  out.setPincode(info.getPincode());
		  out.setSalary(info.getSalary());
		  
		  return out;
		
		}else {
			return null;
		}
		
	}

	public UserRequest getById(int id) {
	
				Optional<UserEntity> data = repository.findById(id);
			
				if(data!=null) {
		UserEntity info = 	data.get();
		
		  UserRequest out = new UserRequest();
		  out.setCity(info.getCity());
		  out.setId(info.getId());
		  out.setMobileno(info.getMobileno());
		  out.setName(info.getName());
		  out.setPincode(info.getPincode());
		  out.setSalary(info.getSalary());
		  
		  		return out;
				}else {
					return null;
				}
			
	}

}
