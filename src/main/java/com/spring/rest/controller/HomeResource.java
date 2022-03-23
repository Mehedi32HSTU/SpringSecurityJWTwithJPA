package com.spring.rest.controller;

//package com.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.models.AuthenticationRequest;
import com.spring.rest.models.AuthenticationResponse;
import com.spring.rest.services.MyUserDetailsService;
import com.spring.rest.util.JwtUtil;

@RestController
public class HomeResource {
	
	@Autowired
	AuthenticationManager authenticationManager; 
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	
	@RequestMapping({"/home"})
	public String home()
	{
		return "Hello, this is home page.";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		
		System.out.println(authenticationRequest.toString());
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
					);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password",e);
		}
		final UserDetails userDetails = myUserDetailsService
				.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	
	

}
