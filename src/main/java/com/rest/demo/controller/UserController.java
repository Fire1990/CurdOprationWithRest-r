package com.rest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.model.User;
import com.rest.demo.service.UserDaoService;

@RestController
public class UserController {
	@Autowired
	private UserDaoService service;
	
	
	@GetMapping("/test")
	public String test() {
		return "working fine";
	}
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retriveUserById(@PathVariable int id) {
				User user = service.findOne(id);
				if(user==null)
					throw new UserNotFoundException("id-"+id);
				
				return user;
	}
	
	@PostMapping("/users")
	public void creatUser(@RequestBody User user) {
		service.save(user);
	}

}
