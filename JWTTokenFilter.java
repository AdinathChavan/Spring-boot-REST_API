package com.webapp.sequrity;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTTokenFilter extends OncePerRequestFilter{
	
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired 
	SecurityUserAunthenticationService userAunthenticationService; 

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		
		//1. Token Available or not 
		// Header : Authorization : This Token Value 
		
		String JWTToken  = request.getHeader("Authorization");
		
		String userId = null; 
		
		if(JWTToken != null && !JWTToken.isBlank() && !JWTToken.isEmpty()) {
			System.out.println("JWTTokenFilter : Token Presented. : Incmoing Token : "+JWTToken);
			
			// VAlidate the token :  User Name && Token Expire 
			// Getting User Name From Token 
			userId = jwtUtil.getUserIdFromToken(JWTToken);
			System.out.println("JWTTokenFilter : Request Tooken Came From an User : "+userId);
			
		}else {
			System.out.println("JWTTokenFilter : Token Not Presented. Please Add Token. ");
		}
		
		// Token User Id is matching with Request User Id or not 
		
		if(userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			System.out.println("JWTTokenFilter : getting User Info from the DB by passing user Id : Got from the token");
			// get User Information from the database by passing user Id : Got from the token 
			UserDetails userDetails =   userAunthenticationService.loadUserByUsername(userId);
			
			// Now Passing User Id (came From DB )to the token validator
			System.out.println("JWTTokenFilter : Now validating token is expired or not & matching user Name");
			
			Boolean isValidToken = 	jwtUtil.isValidToken(JWTToken, userDetails.getUsername());
			
			System.out.println("JWTTokenFilter: Token Validation Result : Valid ? "+isValidToken);
			
			if(isValidToken) {
				System.out.println("JWTTokenFilter: Setting Security COntext for that user Id ");
				
				UsernamePasswordAuthenticationToken  authenticationToken = 
						new UsernamePasswordAuthenticationToken(userDetails, null, null); 
				
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				
			}else {
				System.out.println("JWTTokenFilter: Token Is Invalid, Please Try with Valid Token.");
			}
			
		}
		
		filterChain.doFilter(request, response);
		
	}

}