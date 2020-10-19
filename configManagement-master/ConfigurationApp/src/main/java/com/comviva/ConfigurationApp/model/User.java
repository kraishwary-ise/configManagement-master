package com.comviva.ConfigurationApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_user")
public class User {
	
	@Id
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="password")
	private String password;
	
	public User() {
		
	}

	public User(String userEmail, String password) {
	
		this.userEmail = userEmail;
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User  userEmail=" + userEmail + ", password=" + password + "]";
	}
	
	
	

}
