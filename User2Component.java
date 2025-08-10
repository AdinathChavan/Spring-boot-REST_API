package com.webapp.component;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value="prod")
@Component
public class User2Component {

	
	public User2Component() {
		System.out.println("User 2 Component for :  PROD profile");
	}
	
}
