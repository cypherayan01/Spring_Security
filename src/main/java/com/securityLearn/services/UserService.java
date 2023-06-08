package com.securityLearn.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.securityLearn.models.Userd;

@Service
public class UserService  {

	List<Userd> list=new ArrayList<>();
	
	
	public UserService() {
		list.add(new Userd("ayan","ayan","ayan@gmail.com"));
		list.add(new Userd("abc","abc","abc@gmail.com"));
		
		
	}
	
	//get all user
	public List<Userd> getAllUsers(){
		return this.list;
	}
	
	//fetch one user
	public Userd getUser(String username) {
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	
	// add user	
	public Userd addUser(Userd user) {
		this.list.add(user);
		return user;
	}

	
	
	
	
}
