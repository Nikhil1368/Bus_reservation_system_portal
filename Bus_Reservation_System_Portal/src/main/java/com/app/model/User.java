package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userLoginId;
	
	
	@NotNull(message = "username can not be null..")
	@NotBlank(message = "username can not be blank..")
	@NotEmpty(message = "username can not be empty..")
	private String userName;
	
	@Size(min = 6,max = 12,message = "password should be between 6 to 12 characters")
	private String password;
	
	
	@NotNull(message = "firstName can not be null..")
	@NotBlank(message = "firstName can not be blank..")
	@NotEmpty(message = "firstName can not be empty..")
	private String firstName;
	
	private String lastName;
	
	private Long contact;
	
	@NotNull(message = "email can not be null..")
	@NotBlank(message = "email can not be blank..")
	@NotEmpty(message = "email can not be empty..")
	private String email;
	
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
//	private List<Reservation> rervation = new ArrayList<>();
	

	
	



	

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer userLoginId,
		@NotNull(message = "username can not be null..") @NotBlank(message = "username can not be blank..") @NotEmpty(message = "username can not be empty..") String userName,
		@Size(min = 6, max = 12, message = "password should be between 6 to 12 characters") String password,
		@NotNull(message = "firstName can not be null..") @NotBlank(message = "firstName can not be blank..") @NotEmpty(message = "firstName can not be empty..") String firstName,
		String lastName, Long contact,
		@NotNull(message = "email can not be null..") @NotBlank(message = "email can not be blank..") @NotEmpty(message = "email can not be empty..") String email) {
	super();
	this.userLoginId = userLoginId;
	this.userName = userName;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.contact = contact;
	this.email = email;
}

	public Integer getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(Integer userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
}