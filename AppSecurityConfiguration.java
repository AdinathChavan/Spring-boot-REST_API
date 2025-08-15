package com.webapp.sequrity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class AppSecurityConfiguration {

	
	// Bean Object 
	@Bean
	AuthenticationManager getAuthenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		System.out.println("Creating an Instance Of AuthenticationManager");
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Autowired
	JWTTokenFilter jwtTokenFilter;
	
	
	// password encoder 
	@Bean
	BCryptPasswordEncoder getBCryptPasswordEncoder() {
		System.out.println("BCryptPasswordEncoder: Instance Creating");
		
		return new BCryptPasswordEncoder();
	}

	
	// Security Filter Chain : public/ protected api
	@Bean
	SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {

			System.out.println("AppSecurityConfiguration : Configuring the Security Rules :");
		
			httpSecurity
				.csrf(csrf -> csrf.disable()) // Not allowed form other sites 
				.cors(cors -> cors.disable()) 
				.authorizeHttpRequests(
							 reqs -> reqs.requestMatchers("/public/**", "/help/**")
							.permitAll() // No Security  // No Token Filter // Skip The Security Check  
							.anyRequest()
							.authenticated() // Security Check // Token Filter 
			    ).addFilterBefore(this.jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		
		
		return httpSecurity.build();
	}

}