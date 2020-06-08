package com.sarg.tutorial.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sarg.tutorial.model.User;
import com.sarg.tutorial.repository.UserRepository;

@RequestMapping("/api/v1")
public class UserController {
	
	UserRepository userRepository;
	
	//get All Users
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	
	//getUsers -get 
	//createUsers - POST
	

}
