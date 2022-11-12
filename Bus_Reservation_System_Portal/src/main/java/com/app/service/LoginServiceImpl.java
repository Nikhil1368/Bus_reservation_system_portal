package com.app.service;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.LoginDTO;
import com.app.exceptions.LoginException;
import com.app.model.CurrentUserSession;
import com.app.model.User;
import com.app.repository.SessionRepo;
import com.app.repository.UserRepo;

import net.bytebuddy.utility.RandomString;


@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private SessionRepo sr;
	
	@Autowired
	private UserRepo ur;

	@Override
	public String logInIntoAccount(LoginDTO dto) throws LoginException {
		
		 User existingUser = ur.findByContact(dto.getContact());
		 
		 if(existingUser==null)
		 {
			 throw new LoginException("Please Enter A Valid Contact Detail..");
		 }
		 
		 Optional<CurrentUserSession> validCustomerSessionOpt =  sr.findById(existingUser.getUserLoginId());
		 
		 if(validCustomerSessionOpt.isPresent())
		 {
			 throw new LoginException("User Already Logged In with this Id..");
		 }
		 
		if(existingUser.getPassword().equals(dto.getPassword()))
		{
			String key = RandomString.make(6);
			
			CurrentUserSession cus = new CurrentUserSession(existingUser.getUserLoginId(), key, LocalDateTime.now());
			
			sr.save(cus);
			
			return cus.toString();
			
		}
		 
		else
		{
			throw new LoginException("Please enter valid password..");
		}
		
	}

	@Override
	public String LogOutFromAccount(String key) throws LoginException {
		
		CurrentUserSession cus = sr.findByUuid(key);
		
		if(cus == null)
		{
			throw new LoginException("User not Logged In with this key..");
		}
		
		sr.delete(cus);
		
		return "USER LOGGED OUT..";
		
	}

}
