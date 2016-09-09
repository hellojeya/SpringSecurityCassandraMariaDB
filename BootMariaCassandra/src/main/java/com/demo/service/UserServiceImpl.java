package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired(required=false)
	UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>)userRepository.findAll();
	}

	@Override
	public User findUser(long userid) {
		// TODO Auto-generated method stub
		return userRepository.findOne(userid);
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.saveAndFlush(user);
	}

	@Override
	public void deleteUser(long userid) {
		// TODO Auto-generated method stub
		 userRepository.delete(userid);
	}

}
