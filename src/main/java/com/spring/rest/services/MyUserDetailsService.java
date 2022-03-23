package com.spring.rest.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.rest.models.MyUserDetails;
import com.spring.rest.models.User;
import com.spring.rest.repository.UserRepository;
//import com.spring.rest.models.User;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
//		Optional<com.spring.rest.models.User> user=userRepository.findByUserName(userName);
		if(user==null) throw new UsernameNotFoundException("Not Found : "+userName);
//		user.orElseThrow(()-> new UsernameNotFoundException("Not Found : "+userName));
//		System.out.println(user.toString());
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
		
//		return new User("mehedi", "pass",new ArrayList<>());
	}
	
//	@Autowired
//	private User myUser;
	
	
//	public User save (MyUserDetails myUserDetails)
//	{
//		User newUser = new User();
//		newUser.setUserName(myUserDetails.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(myUserDetails.getPassword()));
//		return myUser.save(newUser);
//		
//		
//	}
	
	

}
