package com.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.entity.StudentEntity;
import com.webapp.repository.StudentRepo;
import com.webapp.request.RequestData;

@Service
public class StudentService {
	@Autowired
	StudentRepo repository;
	
	public RequestData info(int id) {
		
		Optional<StudentEntity> data = repository.findById(id);
		
		if(data.isPresent()) {
			
			StudentEntity one = data.get();
			
			RequestData info = new RequestData();
			
			info.setId(one.getId());
			info.setMarks(one.getMarks());
			info.setMobileno(one.getMobileno());
			info.setName(one.getName());
			info.setVillage(one.getVillage());
			
			return info;
		}
		else {
			return null;
		}
		
	}

	public String addInfo(RequestData info) {
		
		StudentEntity data = new StudentEntity();
		
		data.setId(info.getId());
		data.setMarks(info.getMarks());
		data.setMobileno(info.getMobileno());
		data.setName(info.getName());
		data.setVillage(info.getVillage());
		
		repository.save(data);
		
		return "data added successfully";
		
	}

}
