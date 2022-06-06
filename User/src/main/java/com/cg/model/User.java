package com.cg.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {
	
	
	private String fullName;
	
	private String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String fullName, String mobileNumber, String email, String password) {
		super();
	
		this.fullName = fullName;
		
		this.password = password;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", password=" + password + "]";
	}
	
	

}
