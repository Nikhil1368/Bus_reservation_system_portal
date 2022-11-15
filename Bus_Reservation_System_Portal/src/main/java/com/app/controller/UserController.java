package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.exceptions.UserException;
import com.app.model.User;
import com.app.service.UserService;



@RestController
public class UserController {
	
	@Autowired
	private UserService usi;
	
	@PostMapping("/user")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserException
	{
		User us = usi.addAUser(user);
		
		return new ResponseEntity<User>(us,HttpStatus.CREATED);
	}
	
	@PutMapping("/user/{key}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user,@PathVariable("key") String key) throws UserException
	{
		User us = usi.updateUser(user, key);
		
		return new ResponseEntity<User>(us,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/user/{id}/{key}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id,@PathVariable("key") String key) throws UserException
	{
		
        User us = usi.deleteUser(id, key);
		
		return new ResponseEntity<User>(us,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}/{key}")
	public ResponseEntity<User> viewUser(@PathVariable("id") Integer id,@PathVariable("key") String key) throws UserException
	{
		
        User us = usi.viewUserById(id, key);
		
		return new ResponseEntity<User>(us,HttpStatus.OK);
	}
	
	
	@GetMapping("/user/{key}")
	public ResponseEntity<List<User>> viewAllUser(@PathVariable("key") String key) throws UserException
	{
		
         List<User> list = usi.viewAllUsers(key);
		
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	

}
