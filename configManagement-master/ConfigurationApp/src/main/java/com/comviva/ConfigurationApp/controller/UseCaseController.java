package com.comviva.ConfigurationApp.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.ConfigurationApp.ConfigurationAppApplication;
import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.StringResponse;
import com.comviva.ConfigurationApp.response.UseCaseResponse;
import com.comviva.ConfigurationApp.service.UseCaseService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class UseCaseController {
	
    private static final Logger logger = LogManager.getLogger(ConfigurationAppApplication.class);

	
	@Autowired
	private UseCaseService useCaseService;
		

	@PostMapping("/usecase")
	public StringResponse  saveUseCase(@RequestBody UseCase useCase) {
		
		
		logger.debug("print usecase" + useCase.toString());
		
		
		StringResponse res = useCaseService.saveUseCase(useCase);
		
		return res;
}
	
	@GetMapping("/dashboard")
	public List<UseCaseResponse> getUseCase() {
		
		
		return useCaseService.getUseCase();
		
		
		
	}
	
	@PostMapping("/delete")
	public void  deleteUseCase(@RequestBody int id) {
		logger.info("deleting usecase id "+id);
		useCaseService.deleteUseCase(id);
		
		

		
		
		
	}
	
}
