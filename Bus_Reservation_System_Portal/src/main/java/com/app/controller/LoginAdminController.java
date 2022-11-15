package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AdminDTO;
import com.app.exceptions.LoginException;
import com.app.service.LoginAdminService;
import com.app.service.LoginAdminServiceImpl;




@RestController
public class LoginAdminController {
	
	@Autowired
	private LoginAdminService lasi;
	
	
	@PostMapping("/loginadmin")
	public ResponseEntity<String> loginUser(@Valid @RequestBody AdminDTO dto) throws LoginException
	{
		String str = lasi.loginAdmin(dto);
		
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	@PostMapping("/logoutadmin/{key}")
	public ResponseEntity<String> logoutUser(@PathVariable("key") String key) throws LoginException
	{
		String mssg = lasi.logoutAdmin(key);
		
		return new ResponseEntity<String>(mssg,HttpStatus.OK);
	}
	
	
	

}
