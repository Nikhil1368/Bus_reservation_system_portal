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
	
	@OneToMany
	private List<Bus> bus;
	
	@OneToMany
	private List<User> user;

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminUserName=" + adminUserName + ", adminPassword=" + adminPassword
				+ ", bus=" + bus + ", user=" + user + "]";
	}

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

	public List<Bus> getBus() {
		return bus;
	}

	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Admin(Integer adminId, String adminUserName, String adminPassword, List<Bus> bus, List<User> user) {
		super();
		this.adminId = adminId;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		this.bus = bus;
		this.user = user;
	}
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	

}
