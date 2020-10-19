package com.comviva.ConfigurationApp.dao;

import java.util.List;

import com.comviva.ConfigurationApp.model.User;

public interface UserDAO {

	
	

	public User fetchUserByEmailAndPassword(String userEmail, String password);
}
