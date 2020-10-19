package com.comviva.ConfigurationApp.JsonService;

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

import com.comviva.ConfigurationApp.ConfigurationAppApplication;
import com.comviva.ConfigurationApp.model.Trigger;
import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.TriggerDrag;

public class ImportTrigger {
	

    private static final Logger logger = LogManager.getLogger(ConfigurationAppApplication.class);

	
	public TriggerDrag[] importTrigger(int useCaseId)  {
		
		
		List<TriggerDrag> sendTrigger  =  new ArrayList<TriggerDrag>();

		
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
					
					JSONArray triggers = (JSONArray)jsonObject.get("triggers");
					
					if(triggers==null) {
						return null;
					}
					else if(triggers.size()==0) {
						logger.info("trigger size is zero");
					}
					else {
					

					for(int i=0;i<triggers.size();i++) {
						
					
					JSONObject trigger1 = (JSONObject)triggers.get(i);
					
					String triggerName = (String) trigger1.get("triggerName");
					
					sendTrigger.add(new TriggerDrag(useCaseId,triggerName));
					
					}
					
				}
					
		    	} catch (FileNotFoundException e) {
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
	
		    }
		}
			
		TriggerDrag[] arrayTrigger = sendTrigger.toArray(new TriggerDrag[sendTrigger.size()]);
		
		
		return arrayTrigger;
		
}

}