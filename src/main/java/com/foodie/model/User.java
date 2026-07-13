package com.foodie.model;

import java.time.LocalDateTime;

public class User {
	
	//we declare here veriable
	private String Name;
	private long Phone;
	private String Email;
	private String Address;
	private String password;
	private String UserName;
	private int User_Id;
	private String Role;
	private LocalDateTime CreatedDateTime;
	private LocalDateTime LastLogin;
	
	//create a zero parameterize constructor
	public User() 
	{
	}
	
	
	//create a parameterize constructor
	public User(String Name, long Phone, String Email, String Address, String password, String UserName, int User_Id,String Role,LocalDateTime CreatedDateTime,LocalDateTime LastLogin) 
	{
		this.Name=Name;
		this.Phone=Phone;
		this.Email=Email;
		this.Address=Address;
		this.password=password;
		this.UserName=UserName;
		this.User_Id=User_Id;
		this.Role=Role;
		this.CreatedDateTime=CreatedDateTime;
		this.LastLogin=LastLogin;
		
	}
	
	
	// create setters and getters
	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getPhone() {
		return Phone;
	}
	public void setPhone(long phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}


	public LocalDateTime getCreatedDateTime() {
		return CreatedDateTime;
	}


	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		CreatedDateTime = createdDateTime;
	}


	public LocalDateTime getLastLogin() {
		return LastLogin;
	}


	public void setLastLogin(LocalDateTime lastLogin) {
		LastLogin = lastLogin;
	}
	
	
 
}
