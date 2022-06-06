package com.cg.service;

import java.util.List;

import com.cg.model.User;



public interface UserService {
	

    //post mapping
	public User addUser(User user);
	//get mapping
	public List<User> getAllUsers();
	//delete mapping
	public void deleteUserByUserid(int id);
    //put mapping
	public User updateUser(User user);

}
