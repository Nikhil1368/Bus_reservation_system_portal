package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.exceptions.UserException;
import com.app.model.User;
import com.app.model.CurrentUserSession;
import com.app.repository.SessionRepo;
import com.app.repository.UserRepo;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo ur;
	@Autowired
	private SessionRepo sr;

	@Override
	public User addAUser(User user) throws UserException {
		
		User  exuser = ur.findByContact(user.getContact());
		if(exuser!=null)
			throw new UserException("User Already Exist...");
		
		return ur.save(user);
	}

	@Override
	public User updateUser(User user, String key) throws UserException {
		
		CurrentUserSession loggedInUser = sr.findByUuid(key);
		
		if(loggedInUser==null)
			throw new UserException("User not Logged In...");
		
		if(user.getUserLoginId() == loggedInUser.getUserId())
		{
			return ur.save(user);
		}
		else
		{
		  throw new UserException("Please Fill right credentials...");
		}
	}

	@Override
	public User deleteUser(Integer userId, String key) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User viewUserById(Integer userId, String key) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> viewAllUsers(String key) throws UserException {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	

}
