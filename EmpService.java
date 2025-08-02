package com.webapp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.Entity.EmpEntity;
import com.webapp.repository.EmpRepository;

@Service
public class EmpService {
	@Autowired
	EmpRepository repository;
	
	//[insert into emp_entity (city,email_id,gender,mobileno,name,pincode,position,emp_id)
	public String  empData(EmpEntity data){
		
		EmpEntity info = new EmpEntity();

		
//	   
		repository.save(data);
		
		return "Data added successfully...";
	}

	public EmpEntity getByIdEmp(int empId) {
		
		Optional<EmpEntity> data = repository.findById(empId);
		
		if(data.isPresent()) {
			EmpEntity info = data.get();
			return info;
		}
		else {
			return null;
		}
		
	}

	public List<EmpEntity> getEmailId(String emailId) {
		
		return repository.findByEmailId(emailId);
	}

}
