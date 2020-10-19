package com.comviva.ConfigurationApp.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.ConfigurationApp.ConfigurationAppApplication;
import com.comviva.ConfigurationApp.model.User;
import com.comviva.ConfigurationApp.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LogManager.getLogger(ConfigurationAppApplication.class);
@Autowired
private UserService userService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/LoginUsers")
	public User loginUser(@RequestBody User user) throws Exception 	{
		
		String tempEmailId = user.getUserEmail();
		logger.info(tempEmailId);
	//	logger.debug(tempEmailId);
		
		String tempPassword = user.getPassword();
		User userObj = null;
		if(tempEmailId!=null&&tempPassword!=null) {
			userObj = userService.fetchUserByEmailAndPassword(tempEmailId,tempPassword);
			
		}
		
		if(userObj==null) {
			logger.error("invalid attemp "+tempEmailId);
			throw new Exception("Bad credentials");
		}
		else {
			logger.info(tempEmailId+" logged in Sucessfully");
		}
		return userObj;
	}

}
