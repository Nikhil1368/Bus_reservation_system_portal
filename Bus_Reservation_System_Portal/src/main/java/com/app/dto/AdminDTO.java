package com.app.dto;


import javax.validation.constraints.Size;

public class AdminDTO {
	
	
	@Size(min = 6,max = 12,message = "size should be between 6 to 12 characters..")
	private String username;
	

	@Size(min = 6,max = 12,message = "size should be between 6 to 12 characters..")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminDTO [username=" + username + ", password=" + password + "]";
	}

	
	
	
	public AdminDTO(@Size(min = 6, max = 12, message = "size should be between 6 to 12 characters..") String username,
			@Size(min = 6, max = 12, message = "size should be between 6 to 12 characters..") String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public AdminDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

}
