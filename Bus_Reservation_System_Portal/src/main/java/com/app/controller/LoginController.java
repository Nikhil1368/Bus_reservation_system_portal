package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDTO;
import com.app.exceptions.LoginException;
import com.app.service.LoginService;




@RestController
public class LoginController {
	
	@Autowired
	private LoginService lsi;
	
	
	@PostMapping("/loginuser")
	public ResponseEntity<String> loginUser(@Valid @RequestBody LoginDTO dto) throws LoginException
	{
		String str = lsi.logInIntoAccount(dto);
		
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	@PostMapping("/logoutuser/{key}")
	public ResponseEntity<String> logoutUser(@PathVariable("key") String key) throws LoginException
	{
		String mssg = lsi.LogOutFromAccount(key);
		
		return new ResponseEntity<String>(mssg,HttpStatus.OK);
	}

}
