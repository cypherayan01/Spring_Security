package com.securityLearn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securityLearn.models.Userd;
import com.securityLearn.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	
	@GetMapping("/welcome")
	public String welcome() {
		String text="This is a private page";
		return text;
	}
	
	@GetMapping("/")
	public List<Userd> getAllUsers(){
		return this.userservice.getAllUsers();
	}
	
	@GetMapping("/{username}")
	public Userd getUser(@PathVariable("username") String username) {
		return this.userservice.getUser(username);
	}
	
	
	@PostMapping("/")
	public Userd add(@RequestBody Userd user) {
		return this.userservice.addUser(user);
	}

}
