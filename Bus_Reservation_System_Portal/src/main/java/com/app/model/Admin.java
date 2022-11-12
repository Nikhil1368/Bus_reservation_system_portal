package com.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Admin {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@NotNull(message = "This Field can not be null..")
	@NotBlank(message = "This Field can not be blank..")
	@NotEmpty(message = "This Field can not be empty..")
	private String adminUserName;
	
	@NotNull(message = "This Field can not be null..")
	@NotBlank(message = "This Field can not be blank..")
	@NotEmpty(message = "This Field can not be empty..")
	private String adminPassword;
	
	
	

	
	public Integer getAdminId() {
		return adminId;
	}





	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}





	public String getAdminUserName() {
		return adminUserName;
	}





	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}





	public String getAdminPassword() {
		return adminPassword;
	}





	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}





	public Admin() {
		// TODO Auto-generated constructor stub
	}





	public Admin(Integer adminId,
			@NotNull(message = "This Field can not be null..") @NotBlank(message = "This Field can not be blank..") @NotEmpty(message = "This Field can not be empty..") String adminUserName,
			@NotNull(message = "This Field can not be null..") @NotBlank(message = "This Field can not be blank..") @NotEmpty(message = "This Field can not be empty..") String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}
	
	

}
