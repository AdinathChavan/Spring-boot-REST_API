package com.webapp.component;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value="dev")
@Component
public class UserComponent {
	
	public UserComponent() {
		System.out.println("UserComponent bean for : default  ");
	}

}
