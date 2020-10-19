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
import com.comviva.ConfigurationApp.model.SelectionLib;
import com.comviva.ConfigurationApp.response.OfferDrag;
import com.comviva.ConfigurationApp.response.SelectionDrag;
import com.comviva.ConfigurationApp.service.SelectionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class SelectionController {
	private static final Logger logger = LogManager.getLogger(ConfigurationAppApplication.class);

	@Autowired
	private SelectionService selectionService;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getSelection") 
	public List<SelectionLib> getSelection() {
		
		
		return selectionService.getSelection();
		
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/saveSelection")
	public void saveSelection(@RequestBody SelectionDrag[] selectionDrag) {
		
			logger.debug("in save: Selection");
		
//logger.info(selectionDrag.length);
		
		
		
		selectionService.saveSelection(selectionDrag);
		
		
		
		
	}
	

}
