package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.model.User;
import com.cg.repository.UserRepository;

public class UserServiceImpl  implements UserService{
	
	private UserRepository repository;
	
	@Autowired
	public UserServiceImpl(UserRepository user) {
		super();
		this.repository = user;
	}
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) repository.findAll();
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		User savedPatient = repository.save(user);
		return savedPatient;
	}

	@Override
	public void deleteUserByUserid(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
