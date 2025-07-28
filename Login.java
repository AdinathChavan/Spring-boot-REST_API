package com.webapp.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
	
	
	@RequestMapping(method=RequestMethod.GET, path="/user/login")
	public String userLogin() {
		return "Login successfull pleaser kept it ";
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/user/register")
	public String userRegister() {
		return "registration successfull please take initiative";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="/user/delete")
	public String userlogRegister() {
		return "profile deleted";
	}
	@RequestMapping(method=RequestMethod.PUT, path="/user/update")
	public String userPutRegister() {
		return "profile updated";
	}

}
