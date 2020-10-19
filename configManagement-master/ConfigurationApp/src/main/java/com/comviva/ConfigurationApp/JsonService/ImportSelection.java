package com.comviva.ConfigurationApp.JsonService;

import com.comviva.ConfigurationApp.ConfigurationAppApplication;
import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.SelectionDrag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ImportSelection {

    private static final Logger logger = LogManager.getLogger(ConfigurationAppApplication.class);


	public SelectionDrag[] importSelection(int useCaseId) {
		
		List<SelectionDrag> sendSelection =  new ArrayList<SelectionDrag>();
		
String path="D:\\SeleniumSoftware\\configManagement-master\\configManagement-master\\ConfigurationApp\\uploads";
		
		File folder = new File(path);
		
		JSONParser parser = new JSONParser();
		
		List<UseCase> usecases = new ArrayList<UseCase>(); 
		
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles) {
			
		    if (file.isFile()) {
		    	
		    	try {
					Object obj = parser.parse(new FileReader(file));
					JSONObject jsonObject = (JSONObject)obj;
					
					JSONArray selection = (JSONArray)jsonObject.get("selectionMethod");

					if(selection==null) {
						return null;
					}
					else if(selection.size()==0) {
						logger.info("selection size is zero");
					}
					else {
					

					for(int i=0;i<selection.size();i++) {
						
					
					JSONObject selection1 = (JSONObject)selection.get(i);
					
					String selectionName = (String) selection1.get("selectionName");
					
					sendSelection.add(new SelectionDrag(useCaseId,selectionName));
					
					}
					
				}
					
		    	} catch (FileNotFoundException e) {
		    		logger.debug("file not found/created");
				} catch (IOException e) {
					logger.debug("Io exception");
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
	
		    }
		}
			
		SelectionDrag[] arraySelection = sendSelection.toArray(new SelectionDrag[sendSelection.size()]);
		
		
		return arraySelection;
		
		
		
	}

}
