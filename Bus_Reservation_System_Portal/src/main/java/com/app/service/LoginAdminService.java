package com.app.service;

import com.app.dto.AdminDTO;
import com.app.exceptions.LoginException;

public interface LoginAdminService {
	
	public String loginAdmin(AdminDTO dto)throws LoginException;
	
	public String logoutAdmin(String key) throws LoginException;

}
