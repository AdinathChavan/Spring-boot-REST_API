package com.webapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Company {
	
	@Value("${user.email}")
	private String email;
	
	public void printing() {
		System.out.println("hello "+email);
	}

	

}
