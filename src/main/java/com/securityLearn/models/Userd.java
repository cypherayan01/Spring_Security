package com.securityLearn.models;



public class Userd {
	String username;
	String email;
	String password;
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Userd(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Userd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userd(String username2, String email2, Object password2) {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
