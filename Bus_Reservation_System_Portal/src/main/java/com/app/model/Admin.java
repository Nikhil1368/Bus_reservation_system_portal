package com.app.model;

import java.util.List;

import javax.persistence.OneToMany;

public class Admin {
	
	private Integer adminId;
	private String adminUserName;
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
