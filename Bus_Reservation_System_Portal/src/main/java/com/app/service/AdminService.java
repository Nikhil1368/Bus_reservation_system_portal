package com.app.service;

import com.app.exceptions.AdminException;
import com.app.model.Admin;

public interface AdminService {
	
	public Admin addAdmin(Admin admin)throws AdminException;

}
