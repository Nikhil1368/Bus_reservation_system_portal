package com.app.service;

import java.util.List;

import com.app.exceptions.UserException;
import com.app.model.User;


public interface UserService {

	public User addAUser(User user)throws UserException;
	
	public User updateUser(User user,String key)throws UserException;
	
	public User deleteUser(Integer userId,String key) throws UserException;
	
	public User viewUserById(Integer userId, String key) throws UserException;
	
	public List<User> viewAllUsers(String key) throws UserException;

}
