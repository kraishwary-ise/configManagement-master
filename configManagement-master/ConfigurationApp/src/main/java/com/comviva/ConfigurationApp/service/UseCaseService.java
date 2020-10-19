package com.comviva.ConfigurationApp.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comviva.ConfigurationApp.controller.UseCaseController;
import com.comviva.ConfigurationApp.dao.UseCaseDao;
import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.StringResponse;
import com.comviva.ConfigurationApp.response.UseCaseResponse;

@Service
public class UseCaseService {
	
    private static final Logger logger = LogManager.getLogger(UseCaseController.class);

	
	
	@Autowired
	private UseCaseDao userCaseDao;
	
	
	public StringResponse saveUseCase(UseCase useCase) {
		
		
		return userCaseDao.saveUseCase(useCase);
		
		
		
	}


	public List<UseCaseResponse> getUseCase() {
		
		return userCaseDao.getUseCase();
		
	}


	public void deleteUseCase(int id) {
		
		userCaseDao.deleteUseCase(id);
		
	}


	public int fetchIdByName(String name) {
		return userCaseDao.fetchIdByName(name);
	}
	


}
