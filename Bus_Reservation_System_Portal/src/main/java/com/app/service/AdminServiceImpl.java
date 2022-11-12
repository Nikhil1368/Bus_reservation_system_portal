package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.AdminException;
import com.app.model.Admin;
import com.app.repository.AdminRepo;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo ar;

	@Override
	public Admin addAdmin(Admin admin)throws AdminException {
		
		 Admin adm = ar.findByAdminUserNameAndAdminPassword(admin.getAdminUserName(),admin.getAdminPassword());
		 
		 if(adm!=null)
		 {
			 throw  new AdminException("Admin Already Exists..");
		 }
		 else
		 {
			 return ar.save(admin);
		 }
//		return ar.save(admin);
		
	}
	
	

}
