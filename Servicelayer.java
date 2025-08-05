package com.webapp.service;

import org.springframework.stereotype.Service;

import com.webapp.request.RequestData;


@Service
public class Servicelayer {

	public RequestData getData(String name) {
		
		return new RequestData(123,"Adinath Chavan", 849343f, 416107);
	}
		

}
