package com.comviva.ConfigurationApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.ConfigurationApp.dao.UserDAO;
import com.comviva.ConfigurationApp.model.User;

@Service
public class UserService {
	
	
	@Autowired
	private UserDAO userDao;
	
	
	public User fetchUserByEmailAndPassword(String userEmail,String password) {
		
		return userDao.fetchUserByEmailAndPassword(userEmail,password);
		
	}

}
