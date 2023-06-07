package com.securityLearn.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.securityLearn.models.User;

@Service
public class UserService {

	List<User> list=new ArrayList<>();
	
	
	public UserService() {
		list.add(new User("ayan","ayan","ayan@gmail.com"));
		list.add(new User("abc","abc","abc@gmail.com"));
		
		
	}
	
	//get all user
	public List<User> getAllUsers(){
		return this.list;
	}
	
	//fetch one user
	public User getUser(String username) {
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	
	// add user	
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
	
	
}
