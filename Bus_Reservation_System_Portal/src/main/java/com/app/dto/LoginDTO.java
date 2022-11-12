package com.app.dto;



import javax.validation.constraints.Size;

public class LoginDTO {
	
	
	
	private Long contact;
	
	
	@Size(min = 6,max = 12,message = "size should be between 6 to 12 characters..")
	private String password;
	
	
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "LoginDTO [contact=" + contact + ", password=" + password + "]";
	}
	
	
	public LoginDTO(Long contact, String password) {
		super();
		this.contact = contact;
		this.password = password;
	}
	
	
	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
