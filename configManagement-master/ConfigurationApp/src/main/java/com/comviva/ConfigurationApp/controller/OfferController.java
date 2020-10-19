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
import com.comviva.ConfigurationApp.model.OfferLib;
import com.comviva.ConfigurationApp.response.OfferDrag;
import com.comviva.ConfigurationApp.service.OfferService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class OfferController {
	private static final Logger logger = LogManager.getLogger(ConfigurationAppApplication.class);

	@Autowired
	private OfferService offerService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getOffer") 
	public List<OfferLib> getTrigger() {
		
		
		return offerService.getOffer();
		
		
	}
	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/saveOffer")
	public void saveOffer(@RequestBody OfferDrag[] offerDrag) {
		
	logger.debug("in save:offers");
		
	logger.debug(offerDrag.length);
		
		
		
		
		offerService.saveOffer(offerDrag);
		
		
		
		
	}
	
	
	

}
