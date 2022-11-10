package com.app.service;

import com.app.dto.LoginDTO;
import com.app.exceptions.LoginException;

public interface LoginService {
	
	
	public String logInIntoAccount(LoginDTO dto)throws LoginException;
	
	public String LogOutFromAccount(String key)throws LoginException;

}
