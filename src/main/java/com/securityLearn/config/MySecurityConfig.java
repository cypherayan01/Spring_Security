package com.securityLearn.config;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import com.securityLearn.services.UserService;

import jakarta.servlet.Filter;

@Configuration
public class MySecurityConfig  { //WebSecurityConfigurerAdapter
	
	@Autowired
	private UserService userService;
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails normalUser=User
				.withUsername("ayan")
				.password(passwordEncoder().encode("password"))
				.roles("NORMAL")
				.build();
		
		UserDetails adminUser=User
				.withUsername("ayan1")
				.password(passwordEncoder().encode("password"))
				.roles("ADMIN")
				.build();
		
		InMemoryUserDetailsManager inMemoryUserDetailsManager =new InMemoryUserDetailsManager(normalUser,adminUser);
		return inMemoryUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("/users/welcome")
					.permitAll()
					.anyRequest()
					.authenticated()
					.and()
					.formLogin();
		
		
		
		return httpSecurity.build();
	}
	
		
	
}
	






	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests(authorize -> authorize
//                .anyRequest().authenticated()
//            )
//            .httpBasic();
//        
//        return http.build();
//    }
//	
//
//
////	protected void configure(HttpSecurity http) throws Exception {
////	    http
////	        .authorizeRequests(authorize -> authorize
////	            .anyRequest().authenticated()
////	        )
////	        .httpBasic();
////	}
//
//
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//		.withUser("ayan")
//		.password("1234")
//		.roles("NORMAL");
//		
//		
//		auth.inMemoryAuthentication()
//		.withUser("debanjana")
//		.password("abc")
//		.roles("ADMIN");
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(10);
//	}

