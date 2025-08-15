package com.webapp.sequrity;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.webapp.entity.UserInformation;
import com.webapp.repository.UserRepository;

@Component
public class SecurityUserAunthenticationService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {

		// load data from DB for a specific user :
		System.out.println("SecurityUserAunthenticationService : loading data from DB of email :" + emailId);

		Optional<UserInformation> userInfo = userRepository.findById(emailId);
		if (userInfo.isPresent()) {
			System.out.println("SecurityUserAunthenticationService : Email Id Found in Database : " + emailId);
			return userInfo.get();
		} else {

			System.err.println("SecurityUserAunthenticationService : Email Id Not Found in Database : " + emailId);
			throw new UsernameNotFoundException("SecurityUserAunthenticationService: Email Id Not Found in Database : " + emailId);
		}

	}

}


