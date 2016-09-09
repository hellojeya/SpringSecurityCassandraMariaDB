package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.service.UserService;

@RestController
@RequestMapping("/api/usr")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		User newUser=userService.addUser(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user) {
		User updateUser=userService.updateUser(user);
		return new ResponseEntity<User>(updateUser, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/{userid}",method=RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable long userid) {
		userService.deleteUser(userid);
		return new ResponseEntity<User>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/{userid}", method=RequestMethod.GET)
	public ResponseEntity<User> findeOne(@PathVariable long userid) {
		User findUser = userService.findUser(userid);
		return new ResponseEntity<User>(findUser,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findeAll() {
		return new ResponseEntity<List<User>>(userService.findAll(),HttpStatus.ACCEPTED);
	}

}
