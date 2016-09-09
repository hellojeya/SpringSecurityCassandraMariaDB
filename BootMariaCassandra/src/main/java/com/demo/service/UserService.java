package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserService 
{
	List<User> findAll();
	
	User findUser(long userid);
	
	User addUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(long userid);
	

}
