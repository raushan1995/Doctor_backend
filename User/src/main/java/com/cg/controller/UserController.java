package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.model.User;
import com.cg.repository.UserRepository;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	//from patient service
	
		@Autowired
		private UserRepository repository;
		
		//post mapping
		@PostMapping("/addUser")
		public String saveUser(@RequestBody User user) {
			repository.save(user);
			return "add with name: "+ user.getFullName();
		}
			//get mapping
		
		@GetMapping("/findAll")
		public List<User> getUsers(){
			return repository.findAll();
		}

}
