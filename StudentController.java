package com.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.request.RequestData;
import com.webapp.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	StudentService service;

	@GetMapping("/data")
	public ResponseEntity<RequestData> information(@RequestParam int id){
		
		RequestData result = service.info(id);
		
		HttpHeaders header = new HttpHeaders();
		
		if(result!=null) {
			
			ResponseEntity<RequestData> data = new ResponseEntity<>(result,header,HttpStatusCode.valueOf(200));
			return data;
			
		}else {
			
			ResponseEntity<RequestData> data = new ResponseEntity<>(result,header,HttpStatusCode.valueOf(404));
			return data;

		}
			
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addData(@RequestBody RequestData data ){
		String result = service.addInfo(data);
		
		HttpHeaders header = new HttpHeaders();
		
		ResponseEntity<String> response = new ResponseEntity<>(result, header, HttpStatusCode.valueOf(200));
		
		return response;
	}
}
