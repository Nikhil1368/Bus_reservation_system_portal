package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
	@NotNull(message = "password can not be null..")
	@NotBlank(message = "password can not be blank..")
	@NotEmpty(message = "password can not be empty..")
	private String password;
	
	@NotNull(message = "firstName can not be null..")
	@NotBlank(message = "firstName can not be blank..")
	@NotEmpty(message = "firstName can not be empty..")
	private String firstName;
	
	private String lastName;
	
	@Min(value = 10,message = "contact can not be less than 10 numbers")
	@Max(value = 13,message = "contact can not be more than 13 numbers")
	@NotNull(message = "contact can not be null..")
	@NotBlank(message = "contact can not be blank..")
	@NotEmpty(message = "contact can not be empty..")
	private long contact;
	
	@NotNull(message = "email can not be null..")
	@NotBlank(message = "email can not be blank..")
	@NotEmpty(message = "email can not be empty..")
	private String email;
	
	@OneToOne
	private Reservation reservation;
	
	
	@Override
	public String toString() {
		return "User [userLoginId=" + userLoginId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", contact=" + contact + ", email=" + email + ", reservation="
				+ reservation + "]";
	}
	public User(Integer userLoginId, String userName, String password, String firstName, String lastName, long contact,
			String email, Reservation reservation) {
		super();
		this.userLoginId = userLoginId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.reservation = reservation;
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
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

}
